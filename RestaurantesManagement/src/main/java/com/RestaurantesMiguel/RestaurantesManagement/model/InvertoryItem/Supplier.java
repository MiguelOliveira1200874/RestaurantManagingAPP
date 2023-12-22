package com.RestaurantesMiguel.RestaurantesManagement.model.InvertoryItem;

import javax.persistence.Embeddable;

@Embeddable
public class Supplier {

    private String supplierName;
    private String contactDetails;
    // Include other relevant fields, like address, email, etc.

    protected Supplier() {}

    public Supplier(String supplierName, String contactDetails) {
        this.supplierName = supplierName;
        this.contactDetails = contactDetails;
        // Additional validation can be added here
    }

    // Getters
    public String getSupplierName() {
        return supplierName;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    // No setters for immutability
}
