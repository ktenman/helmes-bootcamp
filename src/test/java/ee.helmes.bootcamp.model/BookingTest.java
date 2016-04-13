package ee.helmes.bootcamp.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookingTest {

    private SessionFactory sessionFactory;
    private SecureRandom random = new SecureRandom();

    @Before
    public void setup() {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void createBooking() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Booking booking = new Booking();
        List<Restaurant> restaurantList = restaurantList();
        for (Restaurant r : restaurantList) {
            System.out.println(r);
        }
        Random random = new Random();
        booking.setRestaurant(restaurantList.get(random.nextInt(restaurantList.size())));
        booking.setDate(getRandomDate());
        booking.setDuration(new BigDecimal(random.nextInt(500) / 10.0));
        booking.setCount(random.nextInt(49) + 1);
        booking.setContactName(convertNumbers(getRandomString(64)) + " " + convertNumbers(getRandomString(64)));
        String[] arr = {"email", "muu", "telefon"};
        booking.setContactMethod(arr[random.nextInt(arr.length)]);
        if (random.nextInt(2) == 1) {
            booking.setContactPhoneNumber(new BigInteger(32, new Random()) + "");
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (random.nextInt(3) == 1) {
            for (int i = 0; i < random.nextInt(15); i++) {
                stringBuilder.append(getRandomString(32)).append(" ");
            }
            booking.setComments(stringBuilder.toString());
        }
        session.save(booking);
        transaction.commit();
    }

    private String convertNumbers(String string) {
        string = string.replaceAll("[^A-Za-z]", "");
        return string.toUpperCase().charAt(0) + string.substring(1);
    }

    private Date getRandomDate() {
        return new Date((long) 1000 * (random.nextInt(5184000) + ((new Date().getTime() - 86400000) / 1000)));
    }

    @Test
    public void repeat() {
        for (int i = 0; i < 59; i++) {
            createBooking();
        }
    }

    private String getRandomString(int value) {
        return new BigInteger(value, random).toString(32);
    }


    private List restaurantList() {
        Session session = sessionFactory.openSession();
        return session.createCriteria(Restaurant.class).list();
    }

    @After
    public void close() {
        sessionFactory.close();
    }
}
