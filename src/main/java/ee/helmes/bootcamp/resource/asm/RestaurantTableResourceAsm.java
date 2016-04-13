package ee.helmes.bootcamp.resource.asm;

import ee.helmes.bootcamp.controller.RestaurantTableController;
import ee.helmes.bootcamp.model.RestaurantTable;
import ee.helmes.bootcamp.resource.RestaurantTableResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 * Created by Konstantin on 02.04.2016.
 */
public class RestaurantTableResourceAsm extends ResourceAssemblerSupport<RestaurantTable, RestaurantTableResource> {

    public RestaurantTableResourceAsm() {
        super(RestaurantTableController.class, RestaurantTableResource.class);
    }

    @Override
    public RestaurantTableResource toResource(RestaurantTable restaurantTable) {
        RestaurantTableResource res = new RestaurantTableResource();
        res.setRestaurant(restaurantTable.getRestaurant());
        res.setNumber(restaurantTable.getNumber());
        res.setCount(restaurantTable.getCount());
        return res;
    }
}
