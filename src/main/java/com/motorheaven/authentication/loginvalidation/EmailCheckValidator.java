package com.motorheaven.authentication.loginvalidation;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.motorheaven.authentication.mainmodel.IUserModel;


public class EmailCheckValidator extends ValidationChainBuilder {

	EmailCheckValidator(IUserValidator nextBuilder){
		super(nextBuilder);
	}
	
	public Boolean Validate(IUserModel user, ResultSet rs) {
		
		String email = user.getEmail();
		try {
			while(rs.next()){
			    if (email.equals(rs.getString("email"))) {
			        return true;
			    }
}
		} catch (SQLException e) {
			return false;
		}
		return false;

		
	}

}
