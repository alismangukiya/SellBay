package com.motorheaven.add_remove_cars_request.rental.dto;

import java.sql.ResultSet;
import java.util.List;

import com.motorheaven.add_remove_cars_request.rental.model.GetRentCarDataModel;

public interface IAddCarRentalPageDTO {
	public void addRentalCar(String email,GetRentCarDataModel carModel);
	public ResultSet getrentalCar() throws Exception;
	public List<GetRentCarDataModel> getSingleRentalCars(String email) throws Exception;
	public void removeCar(String id);
	
}
