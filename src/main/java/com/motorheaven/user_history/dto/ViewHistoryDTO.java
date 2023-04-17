package com.motorheaven.user_history.dto;

import com.motorheaven.reservation_page.model.Reservation;
import com.motorheaven.appointment_page.model.Appointment;
import com.motorheaven.utility.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ViewHistoryDTO implements IViewHistoryDTO{

    Connection connection = DatabaseConnection.Instance().getDatabaseObject();

    public List<Appointment> getAppointment(String email){
        List<Appointment> appointments = new ArrayList<Appointment>();
        try {
            String sql = "select * from appointment where email = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,email);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Appointment appointment = new Appointment();
                appointment.setCarId(rs.getInt("carid"));
                appointment.setFirstName(rs.getString("firstname"));
                appointment.setLastName(rs.getString("lastname"));
                appointment.setContactNumber(rs.getString("number"));
                appointment.setTime(rs.getString("time"));
                appointment.setDate(rs.getString("date"));
                appointments.add(appointment);
            }
        }catch (Exception e){

        }
        return appointments;
    }

    public List<Reservation> getReservation(String email){
        List<Reservation> reservations = new ArrayList<Reservation>();
        try {
            String sql = "select * from reservation where email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,email);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Reservation reservation = new Reservation();
                reservation.setCarId(rs.getInt("carid"));
                reservation.setFirstName(rs.getString("firstname"));
                reservation.setLastName(rs.getString("lastname"));
                reservation.setContactNumber(rs.getString("number"));
                reservation.setDate(rs.getString("date"));
                reservations.add(reservation);
            }
        }catch (Exception e){

        }
        return reservations;
    }
}
