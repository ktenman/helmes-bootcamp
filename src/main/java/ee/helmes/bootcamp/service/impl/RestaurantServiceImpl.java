package ee.helmes.bootcamp.service.impl;

import ee.helmes.bootcamp.dao.RestaurantDao;
import ee.helmes.bootcamp.model.Restaurant;
import ee.helmes.bootcamp.model.RestaurantTable;
import ee.helmes.bootcamp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Konstantin on 26.03.2016.
 */
@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantDao restaurantDao;

    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurantDao.addRestaurant(restaurant);
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        restaurantDao.updateRestaurant(restaurant);
    }

    @Override
    public List<Restaurant> getRestaurants() {
        return restaurantDao.getRestaurants();
    }

    @Override
    public Restaurant getRestaurant(Long id) {
        return restaurantDao.getRestaurant(id);
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantDao.deleteRestaurant(id);
    }

    @Override
    public List<RestaurantTable> getRestaurantTableList(Restaurant restaurant) {
        return restaurantDao.getRestaurantTableList(restaurant);
    }
}
