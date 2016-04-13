package ee.helmes.bootcamp.controller;

import ee.helmes.bootcamp.exceptions.NotFoundException;
import ee.helmes.bootcamp.model.Restaurant;
import ee.helmes.bootcamp.model.RestaurantTable;
import ee.helmes.bootcamp.resource.RestaurantTableListResource;
import ee.helmes.bootcamp.resource.asm.RestaurantTableListResourceAsm;
import ee.helmes.bootcamp.service.RestaurantService;
import ee.helmes.bootcamp.service.RestaurantTableService;
import ee.helmes.bootcamp.service.util.RestaurantTableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/restaurant/table")
public class RestaurantTableController {

    private final RestaurantTableService restaurantTableService;
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantTableController(RestaurantTableService restaurantTableService, RestaurantService restaurantService) {
        this.restaurantTableService = restaurantTableService;
        this.restaurantService = restaurantService;
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String addRestaurantTable(@PathVariable Long id, Model model) {
        Restaurant restaurant = restaurantService.getRestaurant(id);
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("restaurantTable", new RestaurantTable());
        List<RestaurantTable> restaurantTableList = restaurantService.getRestaurantTableList(restaurant);
        model.addAttribute("restaurantTables", restaurantTableList);
        return "newRestaurantTable";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
    public String addRestaurantTableAction(Model model,
                                           @PathVariable(value = "id") Long restaurantId,
                                           @RequestParam(value = "RestaurantTableNumber") int restaurantTableNumber,
                                           @RequestParam(value = "RestaurantTableCount") int restaurantTableCount
    ) {

        String message = "<h1 style=\"color:green;\">Table with number " + restaurantTableNumber + " added successfully.</h1>";
        RestaurantTable restaurantTable = new RestaurantTable();
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
        List<RestaurantTable> restaurantTableList = restaurantService.getRestaurantTableList(restaurant);
        model.addAttribute("restaurantTables", restaurantTableList);
        model.addAttribute("restaurant", restaurant);

        if (notValidRequestArguments(restaurantTableNumber, restaurantTableCount)) {
            message = "<h1 style=\"color:red;\">Wrong input arguments.</h1>";
            model.addAttribute("message", message);
            return "newRestaurantTable";
        }

        for (RestaurantTable r : restaurantTableList) {
            if (r.getNumber() == restaurantTableNumber) {
                message = "<h1 style=\"color:red;\">Table with number " + restaurantTableNumber + " already exists.</h1>";
                model.addAttribute("message", message);
                return "newRestaurantTable";
            }
        }

        restaurantTable.setRestaurant(restaurantService.getRestaurant(restaurantId));
        restaurantTable.setNumber(restaurantTableNumber);
        restaurantTable.setCount(restaurantTableCount);
        restaurantTableService.addRestaurantTable(restaurantTable);
        restaurantTableList.add(restaurantTable);
        model.addAttribute("restaurantTables", restaurantTableList);
        model.addAttribute("message", message);

        return "newRestaurantTable";
    }

    private boolean notValidRequestArguments(int restaurantTableNumber, int restaurantTableCount) {
        boolean validRestaurantTableNumber = restaurantTableNumber >= 1 && restaurantTableNumber <= 30;
        boolean validRestaurantTableCount = restaurantTableCount >= 1 && restaurantTableCount <= 50;
        return !validRestaurantTableNumber || !validRestaurantTableCount;
    }

    @RequestMapping(value = "/delete/{id}/{restaurantId}", method = RequestMethod.GET)
    public String deleteRestaurantTableFromRestaurant(@PathVariable Long id, @PathVariable Long restaurantId, Model model) {
        restaurantTableService.deleteRestaurantTable(id);
        model.addAttribute("restaurant", restaurantService.getRestaurant(restaurantId));
        return "redirect:/restaurant/table/add/" + restaurantId;
    }

//    @RequestMapping(value="/{blogId}/blog-entries")
//    public ResponseEntity<BlogEntryListResource> findAllBlogEntries(
//            @PathVariable Long blogId)
//    {
//        try {
//            BlogEntryList list = blogService.findAllBlogEntries(blogId);
//            BlogEntryListResource res = new BlogEntryListResourceAsm().toResource(list);
//            return new ResponseEntity<BlogEntryListResource>(res, HttpStatus.OK);
//        } catch(BlogNotFoundException exception)
//        {
//            throw new NotFoundException(exception);
//        }
//    }

    @RequestMapping(value = "/all"
            //, headers="Accept=application/json", method=RequestMethod.GET
    )
    public ResponseEntity<RestaurantTableListResource> findAllRestaurantTables() {
        try {
            RestaurantTableList list = restaurantTableService.findAllTables();
            RestaurantTableListResource res = new RestaurantTableListResourceAsm().toResource(list);
            return new ResponseEntity<RestaurantTableListResource>(res, HttpStatus.OK);
        } catch (Exception exception) {
            throw new NotFoundException(exception);
        }
    }

}
