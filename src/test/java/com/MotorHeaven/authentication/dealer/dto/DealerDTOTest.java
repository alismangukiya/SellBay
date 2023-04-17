package com.MotorHeaven.authentication.dealer.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.motorheaven.authentication.dealer.dto.DealerMockDB;
import com.motorheaven.authentication.dealer.model.DealerModel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
public class DealerDTOTest {

    public DealerModel newDealer;
    public DealerMockDB dealerMockDB;
    
    @BeforeEach
	public void setup(){
		newDealer = new DealerModel();
        dealerMockDB = new DealerMockDB();
	}

    @Test
    public void registerDealerTest(){
        newDealer.setEmail("abc@gmail.com");
        newDealer.setPassword("111");
        newDealer.setPassword1("111");
        newDealer.setphoneNum("9999999999");
        Assertions.assertEquals(false, dealerMockDB.registerDealer(newDealer));
    }

    @Test
    public void loginAuthDealerTest(){
        newDealer.setEmail("abc@gmail.com");
        newDealer.setPassword("111");
        Assertions.assertEquals(true, dealerMockDB.loginAuthDealer(newDealer));
    }

    @AfterEach
    public void endTest(){
        newDealer = null;
        dealerMockDB = null;
    }
}
