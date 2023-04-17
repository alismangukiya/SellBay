package com.motorheaven.customer_review_page.dto;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;
import com.motorheaven.customer_review_page.model.ReviewModel;;

public class ReviewMockDatabase implements IReviewDTO{

    @Override
    public List<ReviewModel> getAverageRating(String carID){
        List<ReviewModel> avgRating = null;
        try {
            avgRating = new ArrayList<ReviewModel>();
            ResultSet result = Mockito.mock(ResultSet.class);
            when(result.getFloat("avg(rating)")).thenReturn(4.33f);
            avgRating = ratingResultToObject(result);
            return avgRating;
        } catch (SQLException e) {
             System.out.println("Error is "+ e );
        }
        return avgRating;
    }

    @Override
    public List<ReviewModel> getReviews(String carID){
        List<ReviewModel> reviewList = null;
        try {
        reviewList = new ArrayList<ReviewModel>();
        ResultSet result = Mockito.mock(ResultSet.class);
        when(result.getInt("reviewID")).thenReturn(103);
        when(result.getString("reviewerName")).thenReturn("Test Person");
        when(result.getInt("rating")).thenReturn(4); 
        when(result.getString("reviewText")).thenReturn("This is a test case!!!!!"); 
        reviewList = reviewResultToObject(result);
        return reviewList;
        } catch (SQLException e) {
        System.out.println("Error is "+ e );
        return reviewList;
    }
    }

    @Override
    public void storeNewReview(String reviewerName, int rating, String reviewText, int carID){
        System.out.println("Case is not created for this function as It is just insert operation release");
    }

    @Override
    public List<ReviewModel> reviewResultToObject(ResultSet queryResult){
        try{
            List<ReviewModel> reviewcar = new ArrayList<ReviewModel>();
            ReviewModel reviewmodel = new ReviewModel();
            reviewmodel.setReviewID(queryResult.getInt("reviewID"));
            reviewmodel.setReviewerName(queryResult.getString("reviewerName"));
            reviewmodel.setRating(queryResult.getInt("rating"));
            reviewmodel.setReviewtext(queryResult.getString("reviewText"));
            reviewcar.add(reviewmodel);
            return reviewcar;
            }catch(SQLException e){
                System.out.println("Error is "+ e );
                return null;
            }
    }
    
    @Override
    public List<ReviewModel> ratingResultToObject(ResultSet queryResult){
        try{
            List<ReviewModel> reviewcar = new ArrayList<ReviewModel>();
            DecimalFormat df = new DecimalFormat("#.##");
            ReviewModel reviewmodel = new ReviewModel();
            float rating = Float.valueOf(df.format(queryResult.getFloat("avg(rating)")));
            reviewmodel.setAverageRating(rating);
            reviewcar.add(reviewmodel);
            return reviewcar;
            }catch(SQLException e){
                System.out.println("Error is "+ e );
                return null;
            }
        }
    }
