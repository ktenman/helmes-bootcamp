package ee.helmes.bootcamp.dao;

import ee.helmes.bootcamp.model.Restaurant;
import ee.helmes.bootcamp.model.RestaurantTable;

import java.util.List;

public interface RestaurantDao {
    void addRestaurant(Restaurant restaurant);

    void updateRestaurant(Restaurant restaurant);

    List<Restaurant> getRestaurants();

    Restaurant getRestaurant(Long id);

    void deleteRestaurant(Long id);

    List<RestaurantTable> getRestaurantTableList(Restaurant restaurant);
}
