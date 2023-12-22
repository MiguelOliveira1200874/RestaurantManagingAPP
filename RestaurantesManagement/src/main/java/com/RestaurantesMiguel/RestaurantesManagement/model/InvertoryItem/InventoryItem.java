package com.RestaurantesMiguel.RestaurantesManagement.model.InvertoryItem;

import javax.persistence.*;

@Entity
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int quantity;

    @Embedded
    private Supplier supplier;

    private int reorderLevel;

    // Default constructor
    public InventoryItem() {}

    // Constructor with parameters
    public InventoryItem(String name, int quantity, Supplier supplier, int reorderLevel) {
        this.name = name;
        this.quantity = quantity;
        this.supplier = supplier;
        this.reorderLevel = reorderLevel;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    // Override equals and hashCode based on the 'id' field if necessary
    // ...
}
