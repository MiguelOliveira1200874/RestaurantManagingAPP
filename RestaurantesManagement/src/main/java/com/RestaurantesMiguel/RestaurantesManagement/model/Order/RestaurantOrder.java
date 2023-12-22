package com.RestaurantesMiguel.RestaurantesManagement.model.Order;

import com.RestaurantesMiguel.RestaurantesManagement.model.Table.RestaurantTable;
import com.RestaurantesMiguel.RestaurantesManagement.model.MenuItem.MenuItem;

import javax.persistence.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`order`")
public class RestaurantOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_table_id")
    private RestaurantTable table;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "order_menu_item",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_item_id")
    )
    private List<MenuItem> items = new ArrayList<>();
    public enum OrderStatus {
        PENDING,
        CONFIRMED,
        PREPARING,
        SERVED,
        COMPLETED
    }

    private OrderStatus status;


    private LocalDateTime orderTime;


    // Default constructor
    public RestaurantOrder() {}

    // Constructor with parameters
    public RestaurantOrder(RestaurantTable restaurantTable, List<MenuItem> items, LocalDateTime orderTime, OrderStatus status) {
        this.table = table;
        this.items = items;
        this.orderTime = orderTime;
        this.status = status;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public RestaurantTable getTable() {
        return table;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTable(RestaurantTable restaurantTable) {
        this.table = table;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    // Helper methods
    public void addItem(MenuItem item) {
        this.items.add(item);
    }

    public void removeItem(MenuItem item) {
        this.items.remove(item);
    }

    // Override equals and hashCode based on the 'id' field if necessary
    // ...
}
