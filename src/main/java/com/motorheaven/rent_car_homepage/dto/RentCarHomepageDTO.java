package com.motorheaven.rent_car_homepage.dto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import com.motorheaven.rent_car_homepage.model.RentCarHomepageModel;
import com.motorheaven.utility.DatabaseConnection;

public class RentCarHomepageDTO implements IRentCarHomeDTO{

    Connection dbconnect =  DatabaseConnection.Instance().getDatabaseObject();

    public List<RentCarHomepageModel> getCars(){
        try{
        List<RentCarHomepageModel> rentList = new ArrayList<RentCarHomepageModel>();
        Statement viewStatement = dbconnect.createStatement();
        String sql = "select rentcarID, model, price, conditions, imageUrl from rentalcar";
        ResultSet selectResult = viewStatement.executeQuery(sql);
        rentList = resultToObject(selectResult);
        return rentList;
        }catch(SQLException e){
            System.out.println("Error is "+ e );
            return null;
        }
    }

    public List<RentCarHomepageModel> resultToObject(ResultSet queryResult){
        try{
        List<RentCarHomepageModel> rentcar = new ArrayList<RentCarHomepageModel>();
        while(queryResult.next()){
            RentCarHomepageModel rentcarmodel = new RentCarHomepageModel();
            rentcarmodel.setCarID(queryResult.getInt("rentcarID"));
            rentcarmodel.setModel(queryResult.getString("model"));
            rentcarmodel.setPrice(queryResult.getFloat("price"));
            rentcarmodel.setCondition(queryResult.getString("conditions"));
            rentcarmodel.setImageUrl(queryResult.getString("imageUrl"));
            rentcar.add(rentcarmodel);
        } return rentcar;
        }catch(SQLException e){
            System.out.println("Error faced: "+ e);
            return null;
        }
    }
    
}
