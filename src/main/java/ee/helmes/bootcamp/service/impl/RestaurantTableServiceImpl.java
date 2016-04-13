package ee.helmes.bootcamp.service.impl;

import ee.helmes.bootcamp.dao.RestaurantTableDao;
import ee.helmes.bootcamp.model.RestaurantTable;
import ee.helmes.bootcamp.service.RestaurantTableService;
import ee.helmes.bootcamp.service.util.RestaurantTableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RestaurantTableServiceImpl implements RestaurantTableService {

    @Autowired
    private RestaurantTableDao restaurantTableDao;

    @Override
    public void addRestaurantTable(RestaurantTable restaurantTable) {
        restaurantTableDao.addRestaurantTable(restaurantTable);
    }

    @Override
    public void updateRestaurantTable(RestaurantTable restaurantTable) {
        restaurantTableDao.updateRestaurantTable(restaurantTable);
    }

    @Override
    public List<RestaurantTable> getRestaurantTables() {
        return restaurantTableDao.getRestaurantTables();
    }

    @Override
    public RestaurantTable getRestaurantTable(Long id) {
        return restaurantTableDao.getRestaurantTable(id);
    }

    @Override
    public void deleteRestaurantTable(Long id) {
        restaurantTableDao.deleteRestaurantTable(id);
    }

    @Override
    public RestaurantTableList findAllTables() {
        return restaurantTableDao.findAllTables();
    }

}
