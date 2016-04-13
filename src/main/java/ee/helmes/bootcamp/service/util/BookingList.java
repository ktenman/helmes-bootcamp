package ee.helmes.bootcamp.service.util;

import ee.helmes.bootcamp.model.Booking;
import ee.helmes.bootcamp.model.Restaurant;
import org.apache.commons.lang3.time.DateUtils;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Konstantin on 02.04.2016.
 */
public class BookingList {
    private List<Booking> bookingList = new ArrayList<Booking>();
    private int weekId;

    public BookingList(List<Booking> bookingList, int weekId) {
        this.bookingList = bookingList;
        this.weekId = weekId;
    }

    public String getWeekId() {
        return String.valueOf(weekId);
    }

    public int getBookingCountByWeekDay(String weekDay, Restaurant restaurant) {
        int count = 0;
        List<Booking> filteredBookingList = new ArrayList<Booking>();

        for (Booking booking : bookingList) {

            Date weekStart = getWeekStart(weekId);
            Date weekEnd = getWeekEnd(weekId);

            if (booking.getRestaurant().getId().equals(restaurant.getId())) {
                if (booking.getDate().after(weekStart) && booking.getDate().before(weekEnd)) {
                    filteredBookingList.add(booking);
                }
            }
        }

        for (Booking booking : filteredBookingList) {
            String bookingDay = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(booking.getDate());
            if (weekDay.equalsIgnoreCase(bookingDay)) {
                count += 1;
            }
        }
        return count;
    }

    public Date getWeekStart(int weekId) {
        Calendar calendar = getCalendar(weekId);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date weekStart = calendar.getTime();
        return weekStart;
    }

    public Date getWeekEnd(int weekId) {
        Calendar calendar = getCalendar(weekId);
        calendar.add(Calendar.DAY_OF_MONTH, 6);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date weekEnd = calendar.getTime();
        return weekEnd;
    }

    @NotNull
    private Calendar getCalendar(int weekId) {
        Date date = new Date();
        date = DateUtils.addWeeks(date, weekId);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - calendar.getFirstDayOfWeek();
        calendar.add(Calendar.DAY_OF_MONTH, -dayOfWeek);
        return calendar;
    }

    public String dateToString(Date date) {
        return new SimpleDateFormat("dd-MM-yyyy HH:mm").format(date);
    }
}
