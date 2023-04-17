package com.motorheaven.authentication.user.dto;

import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.motorheaven.authentication.mainmodel.IUserModel;

import org.mockito.Mockito;

public class UserMockDB implements IUserDTO {

    @Override
    public Boolean registerUser(IUserModel newUser) {
        ResultSet result = Mockito.mock(ResultSet.class);
        try {
            when(result.getString("email")).thenReturn("abc@gmail.com");
            when(result.getString("password")).thenReturn("111");
            when(result.getString("password1")).thenReturn("111");
            when(result.getString("phoneNum")).thenReturn("9999999999");
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }

    @Override
    public Boolean loginAuthUser(IUserModel authUser) {
        ResultSet result = Mockito.mock(ResultSet.class);
        try {
            when(result.getString("email")).thenReturn("abc@gmail.com");
            when(result.getString("password")).thenReturn("111");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
