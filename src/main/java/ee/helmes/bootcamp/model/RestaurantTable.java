package ee.helmes.bootcamp.model;

import javax.persistence.*;

@Entity
@Table(name = "restaurant_table")
public class RestaurantTable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(name = "number")
    private int number;

    @Column(name = "count")
    private int count;

    public RestaurantTable(Restaurant restaurant, int number, int count) {
        this.restaurant = restaurant;
        this.number = number;
        this.count = count;
    }

    public RestaurantTable() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "RestaurantTable{" +
                "id=" + id +
                ", restaurant=" + restaurant +
                ", number=" + number +
                ", count=" + count +
                '}';
    }
}
