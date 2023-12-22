package com.RestaurantesMiguel.RestaurantesManagement.model.Staff;

import javax.persistence.*;

@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String role;

    // Default constructor
    public Staff() {}

    // Constructor with parameters
    public Staff(String name, String role) {
        this.name = name;
        this.role = role;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Override equals and hashCode based on the 'id' field if necessary
    // ...
}
