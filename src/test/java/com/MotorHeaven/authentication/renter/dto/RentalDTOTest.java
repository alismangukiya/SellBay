package com.MotorHeaven.authentication.renter.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.motorheaven.authentication.renter.dto.RentalMockDB;
import com.motorheaven.authentication.renter.model.RentalModel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
public class RentalDTOTest {
    
    public RentalModel newRental;
    public RentalMockDB rentalMockDB;

    @BeforeEach
	public void setup(){
		newRental = new RentalModel();
        rentalMockDB = new RentalMockDB();
	}

    @Test
    public void registerDealerTest(){
        newRental.setEmail("abc@gmail.com");
        newRental.setPassword("111");
        newRental.setPassword1("111");
        newRental.setphoneNum("9999999999");
        Assertions.assertEquals(false, rentalMockDB.registerRental(newRental));
    }

    @Test
    public void loginAuthDealerTest(){
        newRental.setEmail("abc@gmail.com");
        newRental.setPassword("111");
        Assertions.assertEquals(true, rentalMockDB.loginAuthRental(newRental));
    }

    @AfterEach
    public void endTest(){
        newRental = null;
        rentalMockDB = null;
    }

}
