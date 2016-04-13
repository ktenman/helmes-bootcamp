package ee.helmes.bootcamp.resource.asm;

import ee.helmes.bootcamp.controller.RestaurantTableController;
import ee.helmes.bootcamp.resource.RestaurantTableListResource;
import ee.helmes.bootcamp.resource.RestaurantTableResource;
import ee.helmes.bootcamp.service.util.RestaurantTableList;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

/**
 * Created by Konstantin on 02.04.2016.
 */
public class RestaurantTableListResourceAsm extends ResourceAssemblerSupport<RestaurantTableList, RestaurantTableListResource> {

    public RestaurantTableListResourceAsm() {
        super(RestaurantTableController.class, RestaurantTableListResource.class);
    }

    @Override
    public RestaurantTableListResource toResource(RestaurantTableList list) {
        List<RestaurantTableResource> resources = new RestaurantTableResourceAsm().toResources(list.getRestaurantTableList());
        RestaurantTableListResource listResource = new RestaurantTableListResource();
        listResource.setRestaurantTableResourceList(resources);
        return listResource;
    }
}
