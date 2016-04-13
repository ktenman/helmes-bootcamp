package ee.helmes.bootcamp.controller;

import ee.helmes.bootcamp.model.Booking;
import ee.helmes.bootcamp.model.Restaurant;
import ee.helmes.bootcamp.service.BookingService;
import ee.helmes.bootcamp.service.RestaurantService;
import ee.helmes.bootcamp.service.util.BookingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping("/")

    public String main() {
        return "redirect:/bookings";
    }

    @RequestMapping(value = "bookings", method = RequestMethod.GET)
    public String bookings(Model model) {
        List<Booking> bookingList = bookingService.getBookings();
        model.addAttribute("bookings", bookingList);
        List<Restaurant> restaurantList = restaurantService.getRestaurants();
        model.addAttribute("restaurants", restaurantList);
        return "bookings";
    }

    @RequestMapping(value = "statistics/{weekId}", method = RequestMethod.GET)
    public String statistics(Model model, @PathVariable int weekId) {
        List<Booking> bookingList = bookingService.getBookings();
        List<Restaurant> restaurantList = restaurantService.getRestaurants();
        BookingList statisticsList = new BookingList(bookingList, weekId);
        model.addAttribute("back", weekId - 1);
        model.addAttribute("forward", weekId + 1);
        model.addAttribute("statistics", statisticsList);
        model.addAttribute("restaurants", restaurantList);
        return "statistics";
    }

    @RequestMapping(value = "booking/edit/{id}", method = RequestMethod.GET)
    public String editBooking(@PathVariable Long id, Model model) {
        Booking booking = bookingService.getBooking(id);
        List<Restaurant> restaurantList = restaurantService.getRestaurants();
        model.addAttribute("restaurants", restaurantList);
        model.addAttribute("booking", booking);
        return "editBooking";
    }

    @RequestMapping(value = "booking/edit/{id}", method = RequestMethod.POST)
    public String editBookingAction(    // HttpServletRequest request,
                                        @RequestParam(value = "id") Long id,
                                        @RequestParam(value = "restaurantId") Long restaurantId,
                                        @RequestParam(value = "date") String date,
                                        @RequestParam(value = "duration") String duration,
                                        @RequestParam(value = "count") String count,
                                        @RequestParam(value = "contactName") String contactName,
                                        @RequestParam(value = "contactMethod") String contactMethod,
                                        @RequestParam(value = "contactPhoneNumber", required = false) String contactPhoneNumber,
                                        @RequestParam(value = "comments", required = false) String comments,
                                        @RequestParam(value = "canceled", required = false) String canceled
    ) throws ParseException {
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
        Booking booking = bookingService.getBooking(id);
        booking.setRestaurant(restaurant);
        booking.setDate(new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(date));
        booking.setDuration(new BigDecimal(duration));
        booking.setCount(Integer.parseInt(count));
        booking.setContactName(contactName);
        booking.setContactMethod(contactMethod);
        if (!contactPhoneNumber.equals("")) {
            booking.setContactPhoneNumber(contactPhoneNumber);
        }
        if (!comments.equals("")) {
            booking.setComments(comments);
        }
        booking.setCanceled(0);
        if (canceled != null) {
            booking.setCanceled(1);
        }
        bookingService.updateBooking(booking);
        return "redirect:/bookings";
    }

    @RequestMapping(value = "booking/create", method = RequestMethod.GET)
    public String createBooking(Model model) {
        List<Restaurant> restaurantList = restaurantService.getRestaurants();
        model.addAttribute("restaurants", restaurantList);
        model.addAttribute("booking", new Booking());
        return "newBooking";
    }

    @RequestMapping(value = "booking/create", method = RequestMethod.POST)
    public String createBookingAction(
            @RequestParam(value = "restaurantId") Long restaurantId,
            @RequestParam(value = "date") String date,
            @RequestParam(value = "duration") String duration,
            @RequestParam(value = "count") String count,
            @RequestParam(value = "contactName") String contactName,
            @RequestParam(value = "contactMethod") String contactMethod,
            @RequestParam(value = "contactPhoneNumber", required = false) String contactPhoneNumber,
            @RequestParam(value = "comments", required = false) String comments
    ) throws ParseException {
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
        Booking booking = new Booking();
        booking.setRestaurant(restaurant);
        booking.setDate(new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(date));
        booking.setDuration(new BigDecimal(duration));
        booking.setCount(Integer.parseInt(count));
        booking.setContactName(contactName);
        booking.setContactMethod(contactMethod);
        if (!contactPhoneNumber.equals("")) {
            booking.setContactPhoneNumber(contactPhoneNumber);
        }
        if (!comments.equals("")) {
            booking.setComments(comments);
        }
        bookingService.addBooking(booking);
        return "redirect:/bookings";
    }

    @RequestMapping(value = "booking/details/{id}", method = RequestMethod.GET)
    public String bookingDetails(@PathVariable Long id, Model model) {
        Booking booking = bookingService.getBooking(id);
        model.addAttribute("booking", booking);
        return "bookingDetails";
    }

    @RequestMapping(value = "booking/cancel/{id}", method = RequestMethod.GET)
    public String cancelBooking(@PathVariable Long id, Model model) {
        Booking booking = bookingService.getBooking(id);
        model.addAttribute("booking", booking);
        return "cancelBooking";
    }

    @RequestMapping(value = "booking/cancel/{id}", method = RequestMethod.POST)
    public String cancelBookingAction(@PathVariable Long id) {
        bookingService.cancelBooking(id);
        return "redirect:/bookings";
    }

    @RequestMapping(value = "contact", method = RequestMethod.GET)
    public String contract() {
        return "contact";
    }

    public String decodeUrl(String string) throws UnsupportedEncodingException {
        return java.net.URLDecoder.decode(string, "UTF-8");
    }

}
