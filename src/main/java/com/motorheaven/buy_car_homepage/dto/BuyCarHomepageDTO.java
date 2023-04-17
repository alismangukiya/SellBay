package com.motorheaven.buy_car_homepage.dto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import com.motorheaven.buy_car_homepage.model.BuyCarHomepageModel;
import com.motorheaven.utility.DatabaseConnection;

public class BuyCarHomepageDTO implements IBuyCarHomeDTO{

    Connection dbconnect =  DatabaseConnection.Instance().getDatabaseObject();

    @Override
    public List<BuyCarHomepageModel> getCars(){
        try{
        List<BuyCarHomepageModel> buyList = new ArrayList<BuyCarHomepageModel>();
        Statement viewStatement = dbconnect.createStatement();
        String sql = "select newcarId, model, price, imageUrl from newcar";
        ResultSet selecResult = viewStatement.executeQuery(sql);
        buyList = resultToObject(selecResult);
        return buyList;
        }catch(SQLException e){
            System.out.println("Error is "+ e );
            return null;
        }
    }

    @Override
    public List<BuyCarHomepageModel> resultToObject(ResultSet queryResult){
        try{
            List<BuyCarHomepageModel> buycar = new ArrayList<BuyCarHomepageModel>();
            while(queryResult.next()){
                BuyCarHomepageModel buycarmodel = new BuyCarHomepageModel();
                buycarmodel.setCarID(queryResult.getInt("newcarID"));
                buycarmodel.setModel(queryResult.getString("model"));
                buycarmodel.setPrice(queryResult.getFloat("price"));
                buycarmodel.setImageUrl(queryResult.getString("imageUrl"));
                buycar.add(buycarmodel);
            } 
            return buycar;
        }
        catch(SQLException e){
            System.out.println("Error is "+ e );
            return null;
        }
    }
    
}
