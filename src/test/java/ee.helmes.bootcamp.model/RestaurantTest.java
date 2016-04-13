package ee.helmes.bootcamp.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Konstantin on 03.04.2016.
 */
public class RestaurantTest {
    private SessionFactory sessionFactory;

    @Before
    public void setUp() {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void createRestaurant() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for (int i = 0; i < 3; i++) {
            Restaurant restaurant = new Restaurant();
            restaurant.setName((String) UUID.randomUUID().toString().subSequence(0, 8));
            Random random = new Random();
            restaurant.setAadress((String) UUID.randomUUID().toString().subSequence(0, 8) + " " + random.nextInt(100) + 1);
            session.save(restaurant);
        }
        transaction.commit();
    }

    @After
    public void close() {
        sessionFactory.close();
    }
}
