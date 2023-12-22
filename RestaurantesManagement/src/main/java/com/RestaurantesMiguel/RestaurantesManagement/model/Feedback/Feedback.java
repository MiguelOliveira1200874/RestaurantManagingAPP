package com.RestaurantesMiguel.RestaurantesManagement.model.Feedback;

import com.RestaurantesMiguel.RestaurantesManagement.model.Customer.Customer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private LocalDateTime date;
    @Embedded
    private FeedbackComments comments;
    @Embedded
    private FeedbackRating  rating;

    // Default constructor
    public Feedback() {}

    // Constructor with parameters
    public Feedback(Customer customer, LocalDateTime date, FeedbackComments comments, FeedbackRating rating) {
        this.customer = customer;
        this.date = date;
        this.comments = comments;
        this.rating = rating;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public FeedbackComments getComments() {
        return comments;
    }

    public FeedbackRating getRating() {
        return rating;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setComments(FeedbackComments comments) {
        this.comments = comments;
    }

    public void setRating(FeedbackRating rating) {
        this.rating = rating;
    }

    // Override equals and hashCode based on the 'id' field if necessary
    // ...
}
