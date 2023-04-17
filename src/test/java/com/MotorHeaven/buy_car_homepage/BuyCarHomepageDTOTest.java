package com.MotorHeaven.buy_car_homepage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.motorheaven.buy_car_homepage.dto.BuyCarHomepageMockDatabase;

@DisplayName("BuyCarHomepageDTO class test")
public class BuyCarHomepageDTOTest {
    
    @Test
    @DisplayName("Checks get cars function for the homepage Int type")
    public void getCarsTestCase1(){
        BuyCarHomepageMockDatabase buycarhome = new BuyCarHomepageMockDatabase();
        Assertions.assertEquals(101, buycarhome.getCars().get(0).getCarID());
    }

    @Test
    @DisplayName("Checks get cars function for the homepage String type")
    public void getCarsTestCase2(){
        BuyCarHomepageMockDatabase buycarhome = new BuyCarHomepageMockDatabase();
        Assertions.assertEquals("XXZV", buycarhome.getCars().get(0).getModel());
    }
    
}
