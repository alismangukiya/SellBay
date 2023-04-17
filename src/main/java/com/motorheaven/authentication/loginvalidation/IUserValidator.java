package com.motorheaven.authentication.loginvalidation;

import java.sql.ResultSet;

import com.motorheaven.authentication.mainmodel.IUserModel;


public interface IUserValidator {
	public Boolean Validate(IUserModel user,ResultSet rs);
}
