package com.motorheaven.customer_review_page.dto;

import java.sql.ResultSet;
import java.util.List;
import com.motorheaven.customer_review_page.model.ReviewModel;

public interface IReviewDTO {
    List<ReviewModel> getAverageRating(String carID);
    List<ReviewModel> getReviews(String carID);
    void storeNewReview(String reviewerName, int rating, String reviewText, int carID);
    List<ReviewModel> reviewResultToObject(ResultSet queryResult);
    List<ReviewModel> ratingResultToObject(ResultSet queryResult);
}
