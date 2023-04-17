package com.motorheaven.add_remove_cars_request.rental.dto;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;

import com.motorheaven.add_remove_cars_request.rental.model.GetRentCarDataModel;

public class AddCarRentalPageMockDatabase implements IAddCarRentalPageDTO {

    @Override
    public void addRentalCar(String email, GetRentCarDataModel carModel) {
        // TODO Auto-generated method stub
        System.out.println("No Test Required");
        
    }

    @Override
    public ResultSet getrentalCar() throws Exception {
        // TODO Auto-generated method stub
        ResultSet result = Mockito.mock(ResultSet.class);
        return result;
    }

    @Override
    public List<GetRentCarDataModel> getSingleRentalCars(String email) throws Exception {
        // TODO Auto-generated method stub
        List<GetRentCarDataModel> car = new ArrayList<GetRentCarDataModel>();
        GetRentCarDataModel rentCarModel = new GetRentCarDataModel();
        rentCarModel.setCarID(100);
        rentCarModel.setCompany("com");
        rentCarModel.setConditions("good");
        rentCarModel.setFuelType("fuel");
        rentCarModel.setMileage("4 mph");
        rentCarModel.setPostedOn("11/11/2022");
        rentCarModel.setImageUrl("www.rtss.com");
        car.add(rentCarModel);
        return car;
    }

    @Override
    public void removeCar(String id) {
        // TODO Auto-generated method stub
        System.out.println("No Test Required");
    }
    
    
}
