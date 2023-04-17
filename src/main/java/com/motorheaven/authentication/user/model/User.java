package com.motorheaven.authentication.user.model;

import com.motorheaven.authentication.mainmodel.IUserModel;

public class User implements IUserModel{

	Integer id;
	String email;
	String password;
	String password1;
	String phoneNum;
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", password1=" + password1
				+ ", phoneNum=" + phoneNum + "]";
	}

}
