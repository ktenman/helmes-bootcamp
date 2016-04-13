package ee.helmes.bootcamp.service;

import ee.helmes.bootcamp.model.RestaurantTable;
import ee.helmes.bootcamp.service.util.RestaurantTableList;

import java.util.List;

public interface RestaurantTableService {
    void addRestaurantTable(RestaurantTable restaurantTable);

    void updateRestaurantTable(RestaurantTable restaurantTable);

    List<RestaurantTable> getRestaurantTables();

    RestaurantTable getRestaurantTable(Long id);

    void deleteRestaurantTable(Long id);

    RestaurantTableList findAllTables();
}
