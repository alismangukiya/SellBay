package com.motorheaven.buy_car_request.dto;
import com.motorheaven.buy_car_request.model.NewCar;
import com.motorheaven.utility.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NewCarDTO implements INewCarDTO{

    public NewCar getCarById(int id){
        Connection connection = DatabaseConnection.Instance().getDatabaseObject();
        NewCar car = new NewCar();
        try{
            String sql = "select * from CSCI5308_7_DEVINT.newcar where newcarID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,String.valueOf(id));
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                car.setId(id);
                car.setModel(rs.getString("model"));
                car.setCompany(rs.getString("company"));
                car.setPrice(rs.getDouble("price"));
                car.setMileage(rs.getString("mileage"));
                car.setStatus(rs.getString("status"));
                car.setFuelType(rs.getString("fuelType"));
                car.setTransmission(rs.getString("transmission"));
                car.setPostedOn(rs.getDate("postedOn"));
                car.setImageUrl(rs.getString("imageUrl"));
            }
        } 
        catch (Exception e){
            e.printStackTrace();
        }
        return car;
    }

}
