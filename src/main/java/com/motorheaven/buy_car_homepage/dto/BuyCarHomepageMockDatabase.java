package com.motorheaven.buy_car_homepage.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;
import com.motorheaven.buy_car_homepage.model.BuyCarHomepageModel;

import static org.mockito.Mockito.when;

public class BuyCarHomepageMockDatabase implements IBuyCarHomeDTO{

    @Override
    public List<BuyCarHomepageModel> getCars() {
        try {
            List<BuyCarHomepageModel> buyList = new ArrayList<BuyCarHomepageModel>();
            ResultSet result = Mockito.mock(ResultSet.class);
            when(result.getInt("newcarID")).thenReturn(101);
            when(result.getString("model")).thenReturn("XXZV");
            when(result.getFloat("price")).thenReturn(10100f); 
            when(result.getString("imageUrl")).thenReturn("httpd://random.com/img201"); 
            buyList = resultToObject(result);
            return buyList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
    }

    @Override
    public List<BuyCarHomepageModel> resultToObject(ResultSet result) {
        List<BuyCarHomepageModel> buycar = new ArrayList<BuyCarHomepageModel>();
        BuyCarHomepageModel buycarmodel = new BuyCarHomepageModel();
        try {
            buycarmodel.setCarID(result.getInt("newcarID"));
            buycarmodel.setModel(result.getString("model"));
            buycarmodel.setPrice(result.getFloat("price"));
            buycarmodel.setImageUrl(result.getString("imageUrl"));
            buycar.add(buycarmodel);
            return buycar;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
}
