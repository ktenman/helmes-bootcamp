package ee.helmes.bootcamp.resource;

import ee.helmes.bootcamp.model.Restaurant;
import ee.helmes.bootcamp.model.RestaurantTable;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Konstantin on 02.04.2016.
 */
public class RestaurantTableResource extends ResourceSupport {

    private Restaurant restaurant;
    private int number;
    private int count;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public RestaurantTable toRestaurantTable() {

        RestaurantTable restaurantTable = new RestaurantTable();
        restaurantTable.setRestaurant(restaurant);
        restaurantTable.setNumber(number);
        restaurantTable.setCount(count);
        return restaurantTable;

    }
}
