
package com.RestaurantesMiguel.RestaurantesManagement.model.Customer;

import javax.persistence.Embeddable;

@Embeddable
public class CustomerName {

    private String firstName;
    private String lastName;
    // Add other name components if needed, like middleName

    // Default constructor for JPA
    protected CustomerName() {}

    // Constructor with validation logic if necessary
    public CustomerName(String firstName, String lastName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name must not be empty");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name must not be empty");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Since Name is a Value Object, it should be immutable, hence no setters

    // You might also override equals and hashCode methods

    // Other domain-specific methods, like fullName()
    public String fullName() {
        return firstName + " " + lastName;
    }
}
