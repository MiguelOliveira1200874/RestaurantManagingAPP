package com.RestaurantesMiguel.RestaurantesManagement.model.Feedback;

import javax.persistence.Embeddable;

@Embeddable
public class FeedbackRating {

    private int rating;

    protected FeedbackRating() {}

    public FeedbackRating(int rating) {
        // Validation logic can go here
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    // No setters for immutability
}
