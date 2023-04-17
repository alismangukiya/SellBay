package com.motorheaven.rent_car_request.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.motorheaven.rent_car_request.model.RentCar;
import com.motorheaven.utility.DatabaseConnection;
import org.springframework.stereotype.Repository;

@Repository
public class RentCarDTO implements IRentCarDTO{

    public RentCar getCarById(int id){
        Connection connection = DatabaseConnection.Instance().getDatabaseObject();
        RentCar car = new RentCar();
        try{
            String sql = "select * from CSCI5308_7_DEVINT.rentalcar where rentcarID = ?";
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
                car.setCondition(rs.getString("conditions"));
                car.setImageUrl(rs.getString("imageUrl"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return car;
    }

}
