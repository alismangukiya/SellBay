package com.motorheaven.authentication.renter.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.motorheaven.utility.SecurityUtility;
import com.motorheaven.authentication.loginvalidation.Chain;
import com.motorheaven.authentication.mainmodel.IUserModel;
import com.motorheaven.utility.DatabaseConnection;


	public class RentalDTO implements IRentalDTO{

		private Connection con = DatabaseConnection.Instance().getDatabaseObject();

		private SecurityUtility securityUtil = new SecurityUtility();
		
		public Boolean registerRental(IUserModel newRental) {
			String email = newRental.getEmail();
			String password = newRental.getPassword();
			String password1 = newRental.getPassword1();
			String phoneNum = newRental.getphoneNum();
			try {
				if(email!=null && password!=null) {
					if(password.equals(password1)) {						
						String emailList = "select email,password from Rental";
						PreparedStatement  emailResult = this.con.prepareStatement(emailList);
						ResultSet emailValidate = emailResult.executeQuery();
						  	while(emailValidate.next()){
					            if (email.equals(emailValidate.getString("email"))) {
					                return false;
					            }
					            if (password.equals(emailValidate.getString("password"))) {
					                return false;
					            }
					        }
						
						String query = "create table if not exists Rental(email varchar(100) , password varchar(100), PhoneNumber varchar(100))";
						PreparedStatement result = this.con.prepareStatement(query);
						result.execute();						
						String queryInsert = "insert into Rental(email,password, PhoneNumber) values(?,?,?)";
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

		public Boolean loginAuthRental(IUserModel authRental) {
			String email = authRental.getEmail();
			try {
				String querySelect = "select email, password from Rental where email=?";
				PreparedStatement  result1 = this.con.prepareStatement(querySelect);
				result1.setString(1,email);
				ResultSet rs = result1.executeQuery();
				Chain chain = new Chain();
				return chain.Validate(authRental, rs);
				}
			catch(Exception e){
				System.out.println(e);
				return false;
			}
		}
}
