package com.motorheaven.rent_car_homepage.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;
import com.motorheaven.rent_car_homepage.model.RentCarHomepageModel;

import static org.mockito.Mockito.when;

public class RentCarHomepageMockDatabase implements IRentCarHomeDTO{

    @Override
    public List<RentCarHomepageModel> getCars() {
        try {
            List<RentCarHomepageModel> rentList = new ArrayList<RentCarHomepageModel>();
            ResultSet result = Mockito.mock(ResultSet.class);
            when(result.getInt("rentcarID")).thenReturn(503);
            when(result.getString("model")).thenReturn("XKZV");
            when(result.getString("conditions")).thenReturn("Poor");
            when(result.getFloat("price")).thenReturn(10100f); 
            when(result.getString("imageUrl")).thenReturn("httpd://random.com/img201"); 
            rentList = resultToObject(result);
            return rentList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
    }

    @Override
    public List<RentCarHomepageModel> resultToObject(ResultSet result) {
        List<RentCarHomepageModel> rentcar = new ArrayList<RentCarHomepageModel>();
        RentCarHomepageModel rentcarmodel = new RentCarHomepageModel();
        try {
            rentcarmodel.setCarID(result.getInt("rentcarID"));
            rentcarmodel.setModel(result.getString("model"));
            rentcarmodel.setPrice(result.getFloat("price"));
            rentcarmodel.setCondition(result.getString("conditions"));
            rentcarmodel.setImageUrl(result.getString("imageUrl"));
            rentcar.add(rentcarmodel);
            return rentcar;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
