package com.RestaurantesMiguel.RestaurantesManagement.model.Menu;

import com.RestaurantesMiguel.RestaurantesManagement.model.MenuItem.MenuItem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuItem> items = new ArrayList<>();

    // Default constructor
    public Menu() {}

    // Constructor with parameters
    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
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

    public List<MenuItem> getItems() {
        return items;
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

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    // Helper methods to manage the relationship with MenuItem
    public void addItem(MenuItem item) {
        items.add(item);
        item.setMenu(this);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
        item.setMenu(null);
    }

    // Override equals and hashCode based on the 'id' field if necessary
    // ...
}
