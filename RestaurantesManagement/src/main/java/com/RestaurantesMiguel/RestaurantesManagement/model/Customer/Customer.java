package com.RestaurantesMiguel.RestaurantesManagement.model.Customer;

import com.RestaurantesMiguel.RestaurantesManagement.model.Reservation.Reservation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private CustomerName name;
    private ContactDetails contactDetails;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    // Default constructor
    public Customer() {}

    // Additional constructor to set fields upon creating a new instance
    public Customer(CustomerName name, ContactDetails contactDetails) {
        this.name = name;
        this.contactDetails = contactDetails;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public CustomerName getName() {
        return name;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(CustomerName name) {
        this.name = name;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    // Helper methods
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        reservation.setCustomer(this);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
        reservation.setCustomer(null);
    }

    // Override equals and hashCode based on the 'id' field if necessary
    // ...

}
