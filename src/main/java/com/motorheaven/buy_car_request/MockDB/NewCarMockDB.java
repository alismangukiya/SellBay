package com.motorheaven.buy_car_request.MockDB;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.motorheaven.buy_car_request.dto.INewCarDTO;
import com.motorheaven.buy_car_request.model.NewCar;

public class NewCarMockDB implements INewCarDTO {

    List<NewCar> cars;

    public NewCarMockDB(){
        NewCar car = new NewCar();
        cars = new ArrayList<NewCar>();
        car.setId(100);
        car.setModel("ZJNN");
        car.setCompany("autorac");
        car.setPrice(11202.2);
        car.setFuelType("Diseal");
        car.setMileage("12 mph");
        car.setTransmission("Automatic");
        car.setStatus("On sale");
        car.setPostedOn(Date.valueOf("2021-05-05"));
        car.setImageUrl("abc");
        cars.add(car);
    }

    @Override
    public NewCar getCarById(int id) {
        if(id == 100){
            return cars.get(0); 
        }
        return null;
    }
    
}
