package com.motorheaven.customer_review_page.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.motorheaven.customer_review_page.model.ReviewModel;
import com.motorheaven.utility.DatabaseConnection;

public class ReviewDTO implements IReviewDTO{
    Connection dbconnect =  DatabaseConnection.Instance().getDatabaseObject();

    @Override
    public List<ReviewModel> getAverageRating(String carID){
    	List<ReviewModel> avgRating = null;
        try {
            avgRating = new ArrayList<ReviewModel>();
            Statement viewStatement = dbconnect.createStatement();
            String reviewSql = "select avg(rating) from reviews where carID =" + carID;
            ResultSet selecResult = viewStatement.executeQuery(reviewSql);
            avgRating = ratingResultToObject(selecResult);
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
            Statement viewStatement = dbconnect.createStatement();
            String reviewSql = "select * from reviews where carID =" + carID + " order by rand()";
            ResultSet selecResult = viewStatement.executeQuery(reviewSql);
            reviewList = reviewResultToObject(selecResult);
            return reviewList;
            
        } catch (SQLException e) {
             System.out.println("Error is "+ e );
        }
        return reviewList;

    }

    @Override
    public void storeNewReview(String reviewerName, int rating, String reviewText, int carID){
        try {
            String insertReviewQuery = "insert into reviews(reviewerName, rating, reviewText, carID) values(?,?,?,?)";
            PreparedStatement reviewResult = dbconnect.prepareStatement(insertReviewQuery);
            reviewResult.setString(1, reviewerName);
            reviewResult.setInt(2, rating);
            reviewResult.setString(3, reviewText);
            reviewResult.setInt(4, carID);
            reviewResult.execute();
            System.out.println("New Review Inserted in the database");
        } catch (SQLException e) {
            System.out.println("Error is "+ e );
        }
        
    }

    @Override
    public List<ReviewModel> reviewResultToObject(ResultSet queryResult){
        try{
        List<ReviewModel> reviewcar = new ArrayList<ReviewModel>();
        while(queryResult.next()){
            ReviewModel reviewmodel = new ReviewModel();
            reviewmodel.setReviewID(queryResult.getInt("reviewID"));
            reviewmodel.setReviewerName(queryResult.getString("reviewerName"));
            reviewmodel.setRating(queryResult.getInt("rating"));
            reviewmodel.setReviewtext(queryResult.getString("reviewText"));
            reviewcar.add(reviewmodel);
        } return reviewcar;
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
        while(queryResult.next()){
            ReviewModel reviewmodel = new ReviewModel();
            float rating = Float.valueOf(df.format(queryResult.getFloat(1)));
            reviewmodel.setAverageRating(rating);
            reviewcar.add(reviewmodel);
        } return reviewcar;
        }catch(SQLException e){
            System.out.println("Error is "+ e );
            return null;
        }
    }
}
