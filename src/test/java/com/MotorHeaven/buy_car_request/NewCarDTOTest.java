package com.MotorHeaven.buy_car_request;

import java.sql.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.motorheaven.buy_car_request.MockDB.NewCarMockDB;
import com.motorheaven.buy_car_request.dto.INewCarDTO;
import com.motorheaven.buy_car_request.model.NewCar;

public class NewCarDTOTest {
    INewCarDTO newcarMoke = new NewCarMockDB();
    NewCar car = new NewCar();
    

    @Test
    public void getCarByIdTest(){
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
        Assertions.assertEquals(car.toString(), newcarMoke.getCarById(100).toString());        
    }

    @Test
    public void getCarByIdTest1(){
        Assertions.assertEquals(null, newcarMoke.getCarById(101));
    }
}
