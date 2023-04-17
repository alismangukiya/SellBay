package com.motorheaven.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class DatabaseConnection{
    private static DatabaseConnection instance = null;

	// Singleton class instance
	public static DatabaseConnection Instance() {
		if (instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}

    public Connection getDatabaseObject(){
        Connection motorHeavenDB = null;
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl ="jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_7_DEVINT";
            String dbUser="CSCI5308_7_DEVINT_USER";
            String dbPassword="Sx5TczRmtp";
            motorHeavenDB = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            if(Objects.nonNull(motorHeavenDB)){
                return motorHeavenDB;
            }else{
                System.out.println("Database Connection Failure");
                return null;
            }
    }catch (SQLException | ClassNotFoundException e){
        System.out.println("Connected Failed due to " + e);
        return null;
    }    
}
}
