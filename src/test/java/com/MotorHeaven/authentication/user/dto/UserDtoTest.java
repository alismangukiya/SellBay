package com.MotorHeaven.authentication.user.dto;
import org.springframework.boot.test.context.SpringBootTest;

import com.motorheaven.authentication.user.dto.IUserDTO;
import com.motorheaven.authentication.user.dto.UserMockDB;
import com.motorheaven.authentication.user.model.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
public class UserDtoTest {

	public User user;
	public IUserDTO userDTOMock;

	@BeforeEach
	public void setup(){
		user = new User();
		userDTOMock = new UserMockDB();
	}

	@Test
	void loginAuthUserTest() {
		user.setEmail("abc@gmail.com");
		user.setPassword("111");
		Assertions.assertEquals(true, userDTOMock.loginAuthUser(user));
	}	

	@Test
	void registerUserTest(){
		user.setEmail("abc@gmail.com");
		user.setPassword("111");
		user.setPassword1("111");
		user.setphoneNum("9999999999");
		Assertions.assertEquals(false,userDTOMock.registerUser(user));
	}

	@AfterEach
	public void endTest(){
		user = null;
		userDTOMock = null;
	}
}
