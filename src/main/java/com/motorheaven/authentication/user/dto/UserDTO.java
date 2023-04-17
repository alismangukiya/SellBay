package com.motorheaven.authentication.user.dto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.motorheaven.authentication.loginvalidation.Chain;
import com.motorheaven.authentication.user.model.User;
import com.motorheaven.authentication.mainmodel.*;
import com.motorheaven.utility.*;
import com.motorheaven.utility.SecurityUtility;

public class UserDTO implements IUserDTO{

	Connection con = DatabaseConnection.Instance().getDatabaseObject();
	
	private SecurityUtility securityUtil=new SecurityUtility(); 
	
	public Boolean registerUser(IUserModel newUser) {
	try {
		String email = newUser.getEmail();
		String password = newUser.getPassword();
		String password1 = newUser.getPassword1();
		String phoneNum = newUser.getphoneNum();
		if(email!=null && password!=null) {
			if(password.equals(password1)) {
				
				String emailList = "select email,password from User";
				PreparedStatement  emailResult = this.con.prepareStatement(emailList);
				ResultSet emailRs = emailResult.executeQuery();
				  while(emailRs.next()){
			            if (email.equals(emailRs.getString("email"))) {
			                System.out.println("Email Already Exists");
			                return false;
			            }
			            if (password.equals(emailRs.getString("password"))) {
			                System.out.println("Password Already Exists");
			                return false;
			            }
			        }
				
				 String query = "create table if not exists User(email varchar(100) , password varchar(100), PhoneNumber varchar(100))";
				 PreparedStatement result = this.con.prepareStatement(query);
				 result.execute();
				
				String queryInsert = "insert into User(email,password, PhoneNumber) values(?,?,?)";
				String hashPass=securityUtil.getHashedString(password);
				
				PreparedStatement result1 = this.con.prepareStatement(queryInsert);
				result1.setString(1,email);
				result1.setString(2,hashPass);
				result1.setString(3,phoneNum);
				result1.execute();
				return true;
			}
		}
	}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}
	
	public Boolean loginAuthUser(IUserModel authUser) {
		
		String email = authUser.getEmail();
		try 
		{
		String querySelect = "select email, password from User where email=?";
		PreparedStatement  result1 = this.con.prepareStatement(querySelect);
		result1.setString(1,email);
		ResultSet rs = result1.executeQuery();
		System.out.println(rs);
		//Chain of Responsiblity pattern used and there is adherence of Single Responsibility and Open/Closed Principle
		Chain chain = new Chain();
		return chain.Validate(authUser, rs);
	
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
		}
	
}

