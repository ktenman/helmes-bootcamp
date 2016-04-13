package ee.helmes.bootcamp.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestaurantTableTest {

    private SessionFactory sessionFactory;

    @Before
    public void setup() {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }


    @Test
    public void createRestaurantTable() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        RestaurantTable restaurantTable = new RestaurantTable();
        Random random = new Random();
        restaurantTable.setNumber(random.nextInt(30) + 1);
        restaurantTable.setCount(random.nextInt(50) + 1);
        List<Restaurant> restaurantList = restaurantList();
        restaurantTable.setRestaurant(restaurantList.get(random.nextInt(restaurantList.size())));
        if (tableNotInRestaurant(restaurantTable)) {
            session.save(restaurantTable);
            transaction.commit();
        } else {
            createRestaurantTable();
        }
    }

    private boolean tableNotInRestaurant(RestaurantTable restaurantTable) {
        List<RestaurantTable> tablesList = restaurantTableList();
        boolean tableNotInRestaurant = true;
        for (RestaurantTable r :
                tablesList) {
            if (r.getRestaurant().getId().equals(restaurantTable.getRestaurant().getId())) {
                if (r.getNumber() == restaurantTable.getNumber()) {
                    tableNotInRestaurant = false;
                    break;
                }
            }
        }
        return tableNotInRestaurant;
    }

    @Test
    public void repeateCreateRestaurantTable() {
        for (int i = 0; i < 19; i++) {
            createRestaurantTable();
        }
    }

    private List restaurantList() {
        Session session = sessionFactory.openSession();
        return session.createCriteria(Restaurant.class).list();
    }

    private List restaurantTableList() {
        Session session = sessionFactory.openSession();
        return session.createCriteria(RestaurantTable.class).list();
    }

    @After
    public void close() {
        sessionFactory.close();
    }

}
