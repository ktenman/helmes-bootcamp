package ee.helmes.bootcamp.dao.impl;

import ee.helmes.bootcamp.dao.RestaurantDao;
import ee.helmes.bootcamp.model.Restaurant;
import ee.helmes.bootcamp.model.RestaurantTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Konstantin on 26.03.2016.
 */
@Repository
public class RestaurantDaoImpl implements RestaurantDao {

    private static final Logger logger = LoggerFactory.getLogger(RestaurantDaoImpl.class);

    @Resource(name = "localSessionFactoryBean")
    private SessionFactory sessionFactory;

    @Override
    public void addRestaurant(Restaurant restaurant) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(restaurant);
        logger.info("Restaurant record saved successfully");
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(restaurant);
        logger.info("Restaurant record update successfully," +
                "Restaurant Details=" + restaurant);

    }

    @Override
    public List<Restaurant> getRestaurants() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Restaurant> restaurantList = session.createCriteria(Restaurant.class).list();
        for (Restaurant restaurant : restaurantList) {
            logger.info("Restaurant List::" + restaurant);
        }
        return restaurantList;
    }

    @Override
    public Restaurant getRestaurant(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Restaurant restaurant = (Restaurant) session.load(Restaurant.class, id);
        logger.info("Restaurant loaded successfully, Restaurant details=" + restaurant);
        return restaurant;
    }

    @Override
    public void deleteRestaurant(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Restaurant restaurant = (Restaurant) session.load(Restaurant.class, id);
        if (null != restaurant) {
            session.delete(restaurant);
        }
        logger.info("Restaurant deleted successfully, restaurant details=" + restaurant);
    }

    @Override
    public List<RestaurantTable> getRestaurantTableList(Restaurant restaurant) {
        Session session = this.sessionFactory.getCurrentSession();
        List<RestaurantTable> restaurantTableList = session.createCriteria(RestaurantTable.class)
                .add(Restrictions.eq("restaurant", restaurant))
                .addOrder(Order.asc("number"))
                .list();
        return restaurantTableList;
    }
}
