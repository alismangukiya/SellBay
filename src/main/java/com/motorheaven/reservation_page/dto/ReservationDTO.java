package com.motorheaven.reservation_page.dto;

import com.motorheaven.reservation_page.model.Reservation;
import com.motorheaven.utility.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class ReservationDTO implements IReservationDTO{
    public boolean saveReservation(Reservation reservation){
        Connection connection = DatabaseConnection.Instance().getDatabaseObject();
        try {
            String sql = "insert into CSCI5308_7_DEVINT.reservation(carid,firstname,lastname,number,date,email) values(?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,String.valueOf(reservation.getCarId()));
            statement.setString(2, reservation.getFirstName());
            statement.setString(3, reservation.getLastName());
            statement.setString(4,reservation.getContactNumber());
            statement.setString(5,String.valueOf(reservation.getDate()));
            statement.setString(6, reservation.getEmail());
            statement.execute();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
