package com.motorheaven.authentication.renter.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import com.motorheaven.authentication.mainmodel.IUserModel;

public class RentalMockDB implements IRentalDTO{

    @Override
    public Boolean registerRental(IUserModel newRental) {
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
    public Boolean loginAuthRental(IUserModel authRental) {
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
