package com.MotorHeaven.add_remove_cars_request.rental.dto;

import org.springframework.boot.test.context.SpringBootTest;

import com.motorheaven.add_remove_cars_request.rental.dto.AddCarRentalPageMockDatabase;
import com.motorheaven.add_remove_cars_request.rental.dto.IAddCarRentalPageDTO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
public class AddCarRentalPageDTOTest {
    
    IAddCarRentalPageDTO addCarRentalPage;

    @BeforeEach
    public void setupTest(){
        addCarRentalPage = new AddCarRentalPageMockDatabase();
    }
    
    @Test
    public void getrentalCarsTest(){
        try {
            Assertions.assertNotNull(addCarRentalPage.getrentalCar());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getRentalCarsTest(){
    
        try {
            Assertions.assertNotNull(addCarRentalPage.getSingleRentalCars("abc@gmail.com"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void endTest(){
        addCarRentalPage = null;
    }
    
}