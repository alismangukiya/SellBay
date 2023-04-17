package com.MotorHeaven.add_remove_cars_request.dealer.dto;

import org.springframework.boot.test.context.SpringBootTest;

import com.motorheaven.add_remove_cars_request.dealer.dto.AddCarDealerPageDTO;
import com.motorheaven.add_remove_cars_request.dealer.dto.AddCarDealerPageMock;
import com.motorheaven.add_remove_cars_request.dealer.dto.IAddCarDealerPageDTO;
import com.motorheaven.buy_car_homepage.dto.BuyCarHomepageMockDatabase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
public class AddCarDealerPageDTOTest {
    
    IAddCarDealerPageDTO addCarDealerPageDTO;

    @BeforeEach
    public void setupTest(){
        addCarDealerPageDTO = new AddCarDealerPageDTO();
    }
    
    @Test
    public void getDealerCarstest(){
    	AddCarDealerPageMock newcarhome = new AddCarDealerPageMock();
        Assertions.assertEquals(101, newcarhome.getDealerCars("abc@gmail.com").get(0).getCarID());
    }

    @Test
    public void getDealerCarsTest1(){
    	AddCarDealerPageMock newcarhome = new AddCarDealerPageMock();
        Assertions.assertEquals("XXZV", newcarhome.getDealerCars("abc@gmail.com").get(0).getModel());
    }

    @AfterEach
    public void endTest(){
        addCarDealerPageDTO = null;
    }
}
