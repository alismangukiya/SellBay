package com.motorheaven.authentication.loginvalidation;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.motorheaven.authentication.mainmodel.IUserModel;
import com.motorheaven.utility.SecurityUtility;

public class PasswordMatchValidator extends ValidationChainBuilder {

	PasswordMatchValidator(IUserValidator nextBuilder){
		super(nextBuilder);
	}
	
	public Boolean Validate(IUserModel user,ResultSet rs) {
		
		SecurityUtility securityUtil=new SecurityUtility();
		
		String password = user.getPassword();
		String hashPass=securityUtil.getHashedString(password);
		try {
			while(rs.next()){
			    if (hashPass.equals(rs.getString("password"))) {
			        return true;
			    }
}
		} catch (SQLException e) {
			return false;
		}
		return false;

}
}
