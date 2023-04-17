package com.motorheaven.authentication.loginvalidation;
import java.sql.ResultSet;
import com.motorheaven.authentication.mainmodel.IUserModel;

public abstract class ValidationChainBuilder implements IUserValidator{
private IUserValidator nextBuilder;
public ValidationChainBuilder(IUserValidator builder) {
	this.nextBuilder=nextBuilder;
}

@Override
public Boolean Validate(IUserModel user,ResultSet rs) {
	if(nextBuilder!=null) {
		nextBuilder.Validate(user,rs);
	}
	return true;
}

}
