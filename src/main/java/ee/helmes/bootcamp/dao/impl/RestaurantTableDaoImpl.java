package ee.helmes.bootcamp.dao.impl;

import ee.helmes.bootcamp.dao.RestaurantTableDao;
import ee.helmes.bootcamp.model.RestaurantTable;
import ee.helmes.bootcamp.service.util.RestaurantTableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class RestaurantTableDaoImpl implements RestaurantTableDao {

    private static final Logger logger = LoggerFactory.getLogger(RestaurantTableDaoImpl.class);

    @Resource(name = "localSessionFactoryBean")
    private SessionFactory sessionFactory;

    @Override
    public void addRestaurantTable(RestaurantTable restaurantTable) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(restaurantTable);
        logger.info("Restaurant's table record saved successfully");
    }

    @Override
    public void updateRestaurantTable(RestaurantTable restaurantTable) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(restaurantTable);
        logger.info("Restaurant's table record update successfully," +
                "Restaurant Details=" + restaurantTable);

    }

    @Override
    public List<RestaurantTable> getRestaurantTables() {
        Session session = this.sessionFactory.getCurrentSession();
        List<RestaurantTable> restaurantTableList = session.createCriteria(RestaurantTable.class).list();
        for (RestaurantTable restaurantTable : restaurantTableList) {
            logger.info("RestaurantTableList::" + restaurantTable);
        }
        return restaurantTableList;
    }

    @Override
    public RestaurantTable getRestaurantTable(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        RestaurantTable restaurantTable = (RestaurantTable) session.load(RestaurantTable.class, id);
        logger.info("Restaurant loaded successfully, Restaurant's table details=" + restaurantTable);
        return restaurantTable;
    }

    @Override
    public void deleteRestaurantTable(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        RestaurantTable restaurantTable = (RestaurantTable) session.load(RestaurantTable.class, id);
        if (null != restaurantTable) {
            session.delete(restaurantTable);
        }
        logger.info("Restaurant's table deleted successfully, Restaurant's table details=" + restaurantTable);
    }

    @Override
    public RestaurantTableList findAllTables() {
        Session session = this.sessionFactory.getCurrentSession();
        List<RestaurantTable> restaurantTableList = session.createCriteria(RestaurantTable.class).list();
        return new RestaurantTableList(restaurantTableList);
    }

}
