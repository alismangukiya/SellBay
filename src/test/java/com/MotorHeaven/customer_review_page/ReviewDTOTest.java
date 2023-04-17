package com.MotorHeaven.customer_review_page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.motorheaven.customer_review_page.dto.ReviewMockDatabase;

@DisplayName("ReviewDTO class test")
public class ReviewDTOTest {

    @DisplayName("Check get average rating function for a car")
    @Test
    public void getAverageRatingTest(){
        ReviewMockDatabase review = new ReviewMockDatabase();
        Assertions.assertEquals(4.33f, review.getAverageRating("106").get(0).getAverageRating());
    }

    @DisplayName("Check get review function for a car")
    @Test
    public void getReviewTest(){
        ReviewMockDatabase review = new ReviewMockDatabase();
        Assertions.assertEquals(4, review.getReviews("103").get(0).getRating());
    }
    
}
