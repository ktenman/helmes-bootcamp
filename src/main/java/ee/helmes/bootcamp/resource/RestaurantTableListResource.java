package ee.helmes.bootcamp.resource;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by Konstantin on 02.04.2016.
 */
public class RestaurantTableListResource extends ResourceSupport {

    private List<RestaurantTableResource> restaurantTableResourceList;

    public List<RestaurantTableResource> getRestaurantTableResourceList() {
        return restaurantTableResourceList;
    }

    public void setRestaurantTableResourceList(List<RestaurantTableResource> restaurantTableResourceList) {
        this.restaurantTableResourceList = restaurantTableResourceList;
    }
}
