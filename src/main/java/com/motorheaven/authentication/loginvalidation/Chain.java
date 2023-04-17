package com.motorheaven.authentication.loginvalidation;

import java.sql.ResultSet;

import com.motorheaven.authentication.mainmodel.IUserModel;

public class Chain {
	ValidationChainBuilder chain;
	  
	public Chain(){
	    buildChain();
	}
	  
	private void buildChain(){
	    chain = new PasswordMatchValidator(new EmailCheckValidator(new NotNullValidator(null)));
	}
	  
	public Boolean Validate(IUserModel user,ResultSet rs) {
	    Boolean finalResult = chain.Validate(user,rs);
	    return finalResult;
	}
}
