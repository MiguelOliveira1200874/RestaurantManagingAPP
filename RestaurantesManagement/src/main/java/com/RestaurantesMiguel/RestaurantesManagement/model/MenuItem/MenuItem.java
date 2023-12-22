package com.RestaurantesMiguel.RestaurantesManagement.model.MenuItem;

import com.RestaurantesMiguel.RestaurantesManagement.model.Menu.Menu;

import javax.persistence.*;

@Entity
@Table(name = "menu_items")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    private String category; // For example: "Appetizer", "Main Course", "Dessert"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    // Default constructor
    public MenuItem() {}

    // Constructor with parameters
    public MenuItem(String name, String description, double price, String category, Menu menu) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.menu = menu;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public Menu getMenu() {
        return menu;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    // Override equals and hashCode based on the 'id' field if necessary
    // ...
}
