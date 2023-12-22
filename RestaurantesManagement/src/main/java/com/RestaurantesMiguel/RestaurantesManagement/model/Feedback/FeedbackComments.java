package com.RestaurantesMiguel.RestaurantesManagement.model.Feedback;

import javax.persistence.Embeddable;


@Embeddable
public class FeedbackComments {

    private String comments;

    protected FeedbackComments() {}

    public FeedbackComments(String comments) {
        // Validation logic can go here
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    // No setters for immutability
}
