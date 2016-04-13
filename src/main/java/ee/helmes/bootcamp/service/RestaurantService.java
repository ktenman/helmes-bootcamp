package ee.helmes.bootcamp.service;

import ee.helmes.bootcamp.model.Restaurant;
import ee.helmes.bootcamp.model.RestaurantTable;

import java.util.List;

/**
 * Created by Konstantin on 26.03.2016.
 */
public interface RestaurantService {
    void addRestaurant(Restaurant restaurant);

    void updateRestaurant(Restaurant restaurant);

    List<Restaurant> getRestaurants();

    Restaurant getRestaurant(Long id);

    void deleteRestaurant(Long id);

    List<RestaurantTable> getRestaurantTableList(Restaurant restaurant);
}
