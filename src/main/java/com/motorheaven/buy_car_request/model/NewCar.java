package com.motorheaven.buy_car_request.model;

import java.util.Date;

public class NewCar {
    
    Integer id;
    String model;
    String company;
    Double price;
    String fuelType;
    String mileage;
    String transmission;
    String status;
    Date postedOn;
    String imageUrl;

    public Integer getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getCompany() {
        return company;
    }

    public Double getPrice() {
        return price;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getMileage() {
        return mileage;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getStatus() {
        return status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Date getPostedOn() {
        return postedOn;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
    @Override
    public String toString() {
        return "NewCar{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                ", fuelType='" + fuelType + '\'' +
                ", mileage='" + mileage + '\'' +
                ", transmission='" + transmission + '\'' +
                ", status='" + status + '\'' +
                ", postedOn=" + postedOn +
                '}';
    }

}
