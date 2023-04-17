package com.motorheaven.add_remove_cars_request.rental.model;

import java.util.List;

import com.motorheaven.add_remove_cars_request.rental.dto.AddCarRentalPageDTO;

public class GetRentCarDataModel {
    private int carID;
    private String model, imageUrl, company, fuelType, mileage, transmission, conditions, status, postedOn;
    private float price;

    AddCarRentalPageDTO carDTO = new AddCarRentalPageDTO();

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(String postedOn) {
        this.postedOn = postedOn;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public List<GetRentCarDataModel> getHomepageCars(String email){
        try {
			return carDTO.getSingleRentalCars(email);
		} catch (Exception e) {
			return null;
		}
    }
}
