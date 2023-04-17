package com.MotorHeaven.rent_car_homepage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.motorheaven.rent_car_homepage.dto.RentCarHomepageMockDatabase;

@DisplayName("RentCarHomepageDTO class test")
public class RentCarHomepageDTOTest {
    @Test
    @DisplayName("Checks get rental cars function for the homepage Int type")
    public void getCarsTestCase1(){
        RentCarHomepageMockDatabase rentcarhome = new RentCarHomepageMockDatabase();
        Assertions.assertEquals(503, rentcarhome.getCars().get(0).getCarID());
    }

    @Test
    @DisplayName("Checks get rental cars cars function for the homepage String type")
    public void getCarsTestCase2(){
        RentCarHomepageMockDatabase rentcarhome = new RentCarHomepageMockDatabase();
        Assertions.assertNotEquals("JEZM", rentcarhome.getCars().get(0).getModel());
    }

    @Test
    @DisplayName("Checks get rental cars cars function for the homepage String type case 2")
    public void getCarsTestCase3(){
        RentCarHomepageMockDatabase rentcarhome = new RentCarHomepageMockDatabase();
        Assertions.assertEquals("Poor", rentcarhome.getCars().get(0).getCondition());
    }
}
