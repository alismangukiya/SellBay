package com.motorheaven.add_remove_cars_request.rental.dto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.motorheaven.add_remove_cars_request.rental.model.GetRentCarDataModel;
import com.motorheaven.utility.DatabaseConnection;

public class AddCarRentalPageDTO implements IAddCarRentalPageDTO{
	
	private Connection con = DatabaseConnection.Instance().getDatabaseObject();

	public void addRentalCar(String email,GetRentCarDataModel carModel) {
		String model = carModel.getModel();
		String company = carModel.getCompany();
		String condition = carModel.getConditions();
		String fuelType = carModel.getFuelType();
		String imgUrl = carModel.getImageUrl();
		String mileage = carModel.getMileage();
		Float price = carModel.getPrice();
		String transmission = carModel.getTransmission();
		String status = carModel.getStatus();
		try{
			String queryDelete = "insert into rentalcar(model,company,price,fuelType,mileage,transmission,conditions,status,postedOn,imageUrl,email) values(?,?,?,?,?,?,?,?,?,?,?)";
			java.util.Date date=new java.util.Date();
			java.sql.Date sqlDate=new java.sql.Date(date.getTime());
			PreparedStatement result1 = this.con.prepareStatement(queryDelete);
			result1.setString(1,model);
			result1.setString(2,company);
			result1.setFloat(3,price);
			result1.setString(4,fuelType);
			result1.setString(5,mileage);
			result1.setString(6,transmission);
			result1.setString(7,condition);
			result1.setString(8,status);
			result1.setString(9, String.valueOf(sqlDate));
			result1.setString(10,imgUrl);
			result1.setString(11,email);
			result1.execute();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ResultSet getrentalCar() throws Exception{
		try {
			String query = "select * from rentalcarmock";
			PreparedStatement  result1 = this.con.prepareStatement(query);
			ResultSet rs = result1.executeQuery();
			if(rs==null) {
				throw new Exception("Null value");
			}
			return rs;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			throw new Exception("Error");
		}
	}

	public List<GetRentCarDataModel> getSingleRentalCars(String email) throws Exception{
		try{
			List<GetRentCarDataModel> buyList = new ArrayList<GetRentCarDataModel>();
			Statement viewStatement = con.createStatement();
			String sql = "select * from rentalcar where email='"+ email +"'";
			ResultSet selecResult = viewStatement.executeQuery(sql);
			buyList = resultToObject(selecResult);
			return buyList;
		}catch(SQLException e){
			System.out.println("Error is "+ e );
			throw new Exception("Error");
		}
	}

	public List<GetRentCarDataModel> resultToObject(ResultSet queryResult) throws Exception{
		try{
			List<GetRentCarDataModel> rentCar = new ArrayList<GetRentCarDataModel>();
			while(queryResult.next()){
				GetRentCarDataModel rentCarModel = new GetRentCarDataModel();
				rentCarModel.setCarID(queryResult.getInt("rentcarID"));
				rentCarModel.setModel(queryResult.getString("model"));
				rentCarModel.setPrice(queryResult.getFloat("price"));
				rentCarModel.setImageUrl(queryResult.getString("imageUrl"));
				rentCarModel.setCompany(queryResult.getString("company"));
				rentCarModel.setFuelType(queryResult.getString("fuelType"));
				rentCarModel.setMileage(queryResult.getString("mileage"));
				rentCarModel.setPostedOn(queryResult.getString("postedOn"));
				rentCarModel.setStatus(queryResult.getString("status"));
				rentCarModel.setTransmission(queryResult.getString("transmission"));
				rentCarModel.setConditions(queryResult.getString("conditions"));

				rentCar.add(rentCarModel);
			} return rentCar;
		}catch(SQLException e){
			System.out.println("Error is "+ e );
			throw new Exception("Error");
		}
	}

	public void removeCar(String id){
		try{
			String queryDelete = "delete from rentalcar where rentcarID = ?";
			PreparedStatement result1 = this.con.prepareStatement(queryDelete);
			result1.setString(1,id);
			result1.execute();
		}catch(SQLException e){
			System.out.println("Error is "+ e );
		}
	}
}
