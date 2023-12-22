package com.RestaurantesMiguel.RestaurantesManagement.model.Table;

import com.RestaurantesMiguel.RestaurantesManagement.model.Reservation.Reservation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "RestaurantTable")
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int capacity;
    private boolean isOccupied;

    private String locationDescription;

    @OneToMany(mappedBy = "restaurantTable", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();


    // Default constructor
    public RestaurantTable() {}

    // Constructor with parameters
    public RestaurantTable(int capacity, String locationDescription, boolean isOccupied) {
        this.capacity = capacity;
        this.locationDescription = locationDescription;
        this.isOccupied = isOccupied;
    }


    // Getter and Setter for isOccupied
    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    // Helper methods for managing reservations
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        reservation.setTable(this);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
        reservation.setTable(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RestaurantTable)) return false;
        RestaurantTable that = (RestaurantTable) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
