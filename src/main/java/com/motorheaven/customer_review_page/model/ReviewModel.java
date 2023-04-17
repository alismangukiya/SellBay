package com.motorheaven.customer_review_page.model;

public class ReviewModel {
    private int reviewID, rating;
    private String reviewerName, reviewtext;
    private float averageRating;

    public int getReviewID() {
        return reviewID;
    }
    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }
    public String getReviewerName() {
        return reviewerName;
    }
    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }
    public String getReviewtext() {
        return reviewtext;
    }
    public void setReviewtext(String reviewtext) {
        this.reviewtext = reviewtext;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public float getAverageRating() {
        return averageRating;
    }
    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }
}
