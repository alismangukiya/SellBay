package com.MotorHeaven.rent_car_request;

import com.motorheaven.rent_car_request.MockDB.RentCarMockDB;
import com.motorheaven.rent_car_request.dto.IRentCarDTO;
import com.motorheaven.rent_car_request.dto.RentCarDTO;
import com.motorheaven.rent_car_request.model.RentCar;
import java.sql.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RentCarDTOTest{

    IRentCarDTO rentCarMockDB = new RentCarMockDB();
    RentCar car = new RentCar();

    @Test
    public void getCarByIdTest(){
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
        Assertions.assertEquals(car.toString(), rentCarMockDB.getCarById(501).toString());    

    }

    @Test
    public void getCarByIdTest1(){
        Assertions.assertEquals(null, rentCarMockDB.getCarById(101));
    }
    
}
