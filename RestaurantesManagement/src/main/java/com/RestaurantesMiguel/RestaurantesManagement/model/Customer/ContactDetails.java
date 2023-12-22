package com.RestaurantesMiguel.RestaurantesManagement.model.Customer;

import javax.persistence.Embeddable;

@Embeddable
public class ContactDetails{

    private String phoneNumber;
    private String emailAddress;

    // Default constructor for JPA
    protected ContactDetails() {}

    public ContactDetails(String phoneNumber, String emailAddress) {
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        // Additional validation could be added here
    }

    // Getters only for immutability
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    // No setters, to maintain immutability
}

