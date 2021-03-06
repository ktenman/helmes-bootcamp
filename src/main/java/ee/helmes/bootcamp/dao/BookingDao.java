package ee.helmes.bootcamp.dao;

import ee.helmes.bootcamp.model.Booking;

import java.util.List;

public interface BookingDao {
    void addBooking(Booking booking);

    void updateBooking(Booking booking);

    List<Booking> getBookings();

    Booking getBooking(Long id);

    void deleteBooking(Long id);

    void cancelBooking(Long id);
}
