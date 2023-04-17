package com.motorheaven.rent_car_request.MockDB;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.motorheaven.rent_car_request.dto.IRentCarDTO;
import com.motorheaven.rent_car_request.model.RentCar;

public class RentCarMockDB implements IRentCarDTO{
    List<RentCar> cars;

    public RentCarMockDB(){
        RentCar car = new RentCar();
        cars = new ArrayList<RentCar>();
        car.setId(501);
        car.setModel("JEZM");
        car.setCompany("autoten");
        car.setPrice(622.26);
        car.setFuelType("Diseal");
        car.setMileage("7 mph");
        car.setTransmission("Manual");
        car.setStatus("Available");
        car.setCondition("Available");
        car.setPostedOn(Date.valueOf("2021-05-05"));
        car.setImageUrl("abc");
        cars.add(car);
    }

    @Override
    public RentCar getCarById(int id) {
        if(id == 501){
            return cars.get(0);
        }
        return null;
    }
    
}
