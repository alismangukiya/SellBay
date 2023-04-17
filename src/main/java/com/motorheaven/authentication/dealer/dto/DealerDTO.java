package com.motorheaven.authentication.dealer.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.motorheaven.authentication.dealer.model.DealerModel;
import com.motorheaven.authentication.loginvalidation.Chain;
import com.motorheaven.authentication.mainmodel.IUserModel;
import com.motorheaven.utility.DatabaseConnection;
import com.motorheaven.utility.SecurityUtility;;

public class DealerDTO implements IDealerDTO{

	Connection con = DatabaseConnection.Instance().getDatabaseObject();

	private SecurityUtility securityUtil = new SecurityUtility();

	public Boolean registerDealer(IUserModel newDealer) {
		String email = newDealer.getEmail();
		String password = newDealer.getPassword();
		String password1 = newDealer.getPassword1();
		String phoneNum = newDealer.getphoneNum();
		try {
			if(email!=null && password!=null) {
				if(password.equals(password1)) {
					String emailList = "select email,password from Dealer";
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
					
					String query = "create table if not exists Dealer(email varchar(100) , password varchar(100), PhoneNumber varchar(100))";
					PreparedStatement result = this.con.prepareStatement(query);
					result.execute();					
					String queryInsert = "insert into Dealer(email,password, PhoneNumber) values(?,?,?)";
					String hashPass=securityUtil.getHashedString(password);
					
					PreparedStatement result1 = this.con.prepareStatement(queryInsert);
					result1.setString(1,email);
					result1.setString(2,hashPass);
					result1.setString(3,phoneNum);
					result1.execute();
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				return false;
			}		
	}

	public Boolean loginAuthDealer(IUserModel authUser) {
		String email = authUser.getEmail();
		try 
		{
			String queryInsert = "select email, password from Dealer where email=?";
			PreparedStatement  result1 = this.con.prepareStatement(queryInsert);
			result1.setString(1,email);
			ResultSet rs = result1.executeQuery();
			System.out.println(rs);
			Chain chain = new Chain();
			return chain.Validate(authUser, rs);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return false;
	}

}
