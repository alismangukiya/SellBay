package com.motorheaven.add_remove_cars_request.dealer.dto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.motorheaven.add_remove_cars_request.dealer.model.GetNewCarDataModel;
import com.motorheaven.utility.DatabaseConnection;

public class AddCarDealerPageDTO implements IAddCarDealerPageDTO{
	
	private Connection con = DatabaseConnection.Instance().getDatabaseObject();

	public void addDealerCar(String email, GetNewCarDataModel carModel) {
		String model = carModel.getModel();
		String company = carModel.getCompany();
		String fuelType = carModel.getFuelType();
		String imgUrl = carModel.getImageUrl();
		String mileage = carModel.getMileage();
		Float price = carModel.getPrice();
		String transmission = carModel.getTransmission();
		String status = carModel.getStatus();
		
		try {
			String queryInsert = "insert into newcar(model,company,price,fuelType,mileage,transmission,status,postedOn,imageUrl,email) values(?,?,?,?,?,?,?,?,?,?)";
			java.util.Date date=new java.util.Date();
			java.sql.Date sqlDate=new java.sql.Date(date.getTime());
			PreparedStatement result1 = this.con.prepareStatement(queryInsert);
			result1.setString(1,model);
			result1.setString(2,company);
			result1.setFloat(3,price);
			result1.setString(4,fuelType);
			result1.setString(5,mileage);
			result1.setString(6,transmission);
			result1.setString(7,status);
			result1.setString(8, String.valueOf(sqlDate));
			result1.setString(9,imgUrl);
			result1.setString(10, email);
			result1.execute();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ResultSet getdealerCar() {
		try {
			String query = "select * from newcar";
			PreparedStatement  result1 = this.con.prepareStatement(query);
			ResultSet rs = result1.executeQuery();
			return rs;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<GetNewCarDataModel> getDealerCars(String email){
		try{
			List<GetNewCarDataModel> buyList = new ArrayList<GetNewCarDataModel>();
			Statement viewStatement = con.createStatement();
			String sql = "select * from newcar where email='"+ email +"'";
			ResultSet selecResult = viewStatement.executeQuery(sql);
			try {
				buyList = resultToObject(selecResult);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return buyList;
		}
		catch(SQLException e){
			System.out.println("Error is "+ e );
			return null;
		}
	}

	public List<GetNewCarDataModel> resultToObject(ResultSet queryResult) throws Exception{
		try{
			List<GetNewCarDataModel> buycar = new ArrayList<GetNewCarDataModel>();
			while(queryResult.next()){
				GetNewCarDataModel buycarmodel = new GetNewCarDataModel();
				buycarmodel.setCarID(queryResult.getInt("newcarID"));
				buycarmodel.setModel(queryResult.getString("model"));
				buycarmodel.setPrice(queryResult.getFloat("price"));
				buycarmodel.setImageUrl(queryResult.getString("imageUrl"));
				buycarmodel.setCompany(queryResult.getString("company"));
				buycarmodel.setFuelType(queryResult.getString("fuelType"));
				buycarmodel.setMileage(queryResult.getString("mileage"));
				buycarmodel.setPostedOn(queryResult.getString("postedOn"));
				buycarmodel.setStatus(queryResult.getString("status"));
				buycarmodel.setTransmission(queryResult.getString("transmission"));
				buycar.add(buycarmodel);
			} 
			return buycar;
		}
		catch(SQLException e){
			System.out.println("Error is "+ e );
			throw new Exception("Error");
		}
	}

	public void removeDealerCar(String id){
		try{
			String queryInsert = "delete from newcar where newcarID = ?";
			PreparedStatement result1 = this.con.prepareStatement(queryInsert);
			result1.setString(1,id);
			result1.execute();
		}catch(SQLException e){
			System.out.println("Error is "+ e );
		}
	}
}
