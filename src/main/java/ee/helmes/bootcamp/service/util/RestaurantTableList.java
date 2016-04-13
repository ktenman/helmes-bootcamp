package ee.helmes.bootcamp.service.util;

import ee.helmes.bootcamp.model.RestaurantTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konstantin on 02.04.2016.
 */
public class RestaurantTableList {
    private List<RestaurantTable> restaurantTableList = new ArrayList<RestaurantTable>();

    public RestaurantTableList(List<RestaurantTable> restaurantTableList) {
        this.restaurantTableList = restaurantTableList;
    }

    public List<RestaurantTable> getRestaurantTableList() {
        return restaurantTableList;
    }

    public void setRestaurantTableList(List<RestaurantTable> restaurantTableList) {
        this.restaurantTableList = restaurantTableList;
    }

}
