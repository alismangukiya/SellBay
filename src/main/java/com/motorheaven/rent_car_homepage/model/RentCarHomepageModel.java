package com.motorheaven.rent_car_homepage.model;

import java.util.List;

import com.motorheaven.rent_car_homepage.dto.IRentCarHomeDTO;
import com.motorheaven.rent_car_homepage.dto.RentCarHomepageDTO;

public class RentCarHomepageModel {
    private int rentcarID;
    private String model, imageUrl, condition;
    private float price;

    IRentCarHomeDTO rentcarDTO = new RentCarHomepageDTO();

    public int getCarID() {
        return rentcarID;
    }
    public void setCarID(int rentcarID) {
        this.rentcarID = rentcarID;
    }

    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
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
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public List<RentCarHomepageModel> getRentHomepageCars(){
        return rentcarDTO.getCars();
    }
}
