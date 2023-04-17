package com.motorheaven.authentication.renter.model;

import com.motorheaven.authentication.mainmodel.IUserModel;

public class RentalModel implements IUserModel{
	Integer id;
	String email;
	String password;
	String password1;
	String phoneNum;
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "RentalModel [id=" + id + ", email=" + email + ", password=" + password + ", password1=" + password1
				+ ", phoneNum=" + phoneNum + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getphoneNum() {
		return phoneNum;
	}

	public void setphoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

}
