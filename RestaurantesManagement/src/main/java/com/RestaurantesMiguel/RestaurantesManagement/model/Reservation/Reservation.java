package com.RestaurantesMiguel.RestaurantesManagement.model.Reservation;

import com.RestaurantesMiguel.RestaurantesManagement.model.Customer.Customer;
import com.RestaurantesMiguel.RestaurantesManagement.model.Table.RestaurantTable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id")
    private RestaurantTable restaurantTable;

    private LocalDateTime reservationTime;
    private int numberOfGuests;
    private String specialRequests;
    // Default constructor
    public Reservation() {}

    // Additional constructor for convenience
    public Reservation(Customer customer, RestaurantTable restaurantTable, LocalDateTime reservationTime, int numberOfGuests, String specialRequests) {
        this.customer = customer;
        this.restaurantTable = restaurantTable;
        this.reservationTime = reservationTime;
        this.numberOfGuests = numberOfGuests;
        this.specialRequests = specialRequests;
    }



    // Getters
    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public RestaurantTable getTable() {
        return restaurantTable;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }

    // Override equals and hashCode based on the 'id' field if necessary
    // ...

}
