package com.motorheaven.authentication.loginvalidation;
import java.sql.ResultSet;
import com.motorheaven.authentication.mainmodel.IUserModel;

public class NotNullValidator extends ValidationChainBuilder {

	public NotNullValidator(IUserValidator nextBuilder) {
		super(nextBuilder);
	}
	public Boolean Validate(IUserModel user, ResultSet rs) {
		
		String email = user.getEmail();
		String password = user.getPassword();
		if(email==null || password==null) {
			return false;
		}
		else {
		return true;
		}
	}

}
