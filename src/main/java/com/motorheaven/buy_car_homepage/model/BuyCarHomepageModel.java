package com.motorheaven.buy_car_homepage.model;

import java.util.List;

import com.motorheaven.buy_car_homepage.dto.BuyCarHomepageDTO;
import com.motorheaven.buy_car_homepage.dto.IBuyCarHomeDTO;

public class BuyCarHomepageModel {
    private int carID;
    private String model, imageUrl;
    private float price;
    
    IBuyCarHomeDTO carDTO = new BuyCarHomepageDTO();

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<BuyCarHomepageModel> getHomepageCars(){
        return carDTO.getCars();
    }
    
}
