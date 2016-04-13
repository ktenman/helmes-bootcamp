package ee.helmes.bootcamp.controller;

import ee.helmes.bootcamp.model.Restaurant;
import ee.helmes.bootcamp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createRestaurant(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "newRestaurant";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createRestaurantAction(Restaurant restaurant) {
        restaurantService.addRestaurant(restaurant);
        return "redirect:/restaurant/all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String bookings(Model model) {
        List<Restaurant> restaurantList = restaurantService.getRestaurants();
        model.addAttribute("restaurants", restaurantList);
        return "restaurants";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editRestaurant(@PathVariable Long id, Model model) {
        Restaurant restaurant = restaurantService.getRestaurant(id);
        model.addAttribute("restaurant", restaurant);
        return "editRestaurant";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editRestaurantAction(Restaurant restaurant) {
        restaurantService.updateRestaurant(restaurant);
        return "redirect:/restaurant/all";
    }

}
