package com.motorheaven.authentication.dealer.dto;

import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.motorheaven.authentication.mainmodel.IUserModel;

public class DealerMockDB implements IDealerDTO{

    @Override
    public Boolean registerDealer(IUserModel newDealer) {
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
    public Boolean loginAuthDealer(IUserModel authUser) {
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
