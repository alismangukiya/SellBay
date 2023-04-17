package com.motorheaven.authentication.mainmodel;

public interface IUserModel {
	public Integer getId();
		public void setId(Integer id);
	
		public String toString();
	
		public String getEmail();
		
		public void setEmail(String email);
	
		public String getPassword();
	
		public void setPassword(String password);
	
		public String getPassword1();
	
		public void setPassword1(String password1);
	
		public String getphoneNum();
	
		public void setphoneNum(String phoneNum);
}
