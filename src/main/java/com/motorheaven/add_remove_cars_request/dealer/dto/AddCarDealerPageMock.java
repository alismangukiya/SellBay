package com.motorheaven.add_remove_cars_request.dealer.dto;

import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;

import com.motorheaven.add_remove_cars_request.dealer.model.GetNewCarDataModel;
import com.motorheaven.buy_car_homepage.model.BuyCarHomepageModel;

public class AddCarDealerPageMock implements IAddCarDealerPageDTO {



	@Override
	public ResultSet getdealerCar() {
	    try {
            ResultSet result = Mockito.mock(ResultSet.class);
            when(result.getInt("newcarID")).thenReturn(101);
            when(result.getString("model")).thenReturn("XXZV");
            when(result.getFloat("price")).thenReturn(10100f); 
            when(result.getString("imageUrl")).thenReturn("httpd://random.com/img201"); 
            
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    
	}

	@Override
	public List<GetNewCarDataModel> getDealerCars(String email) {
		try {
            List<GetNewCarDataModel> carList = new ArrayList<GetNewCarDataModel>();
            ResultSet result = Mockito.mock(ResultSet.class);
            when(result.getInt("newcarID")).thenReturn(101);
            when(result.getString("model")).thenReturn("XXZV");
            when(result.getFloat("price")).thenReturn(10100f); 
            when(result.getString("imageUrl")).thenReturn("httpd://random.com/img201"); 
            carList = resultToObject(result);
            return carList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
	}
	
    public List<GetNewCarDataModel> resultToObject(ResultSet result) {
        List<GetNewCarDataModel> newcar = new ArrayList<GetNewCarDataModel>();
        GetNewCarDataModel newcarmodel = new GetNewCarDataModel();
        try {
            newcarmodel.setCarID(result.getInt("newcarID"));
            newcarmodel.setModel(result.getString("model"));
            newcarmodel.setPrice(result.getFloat("price"));
            newcarmodel.setImageUrl(result.getString("imageUrl"));
            newcar.add(newcarmodel);
            return newcar;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

	@Override
	public void removeDealerCar(String id) {
	}

	@Override
	public void addDealerCar(String string, GetNewCarDataModel carModel) {
	}

	



}
