package com.motorheaven.appointment_page.dto;
import com.motorheaven.appointment_page.model.Appointment;
import com.motorheaven.utility.DatabaseConnection;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class AppointmentDTO implements IAppointmentDTO{
    
    Connection connection = DatabaseConnection.Instance().getDatabaseObject();

    public boolean saveAppointment(Appointment appointment){
        try {
            String sql = "insert into CSCI5308_7_DEVINT.appointment(carid,firstname,lastname,number,time,date,email) values(?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,String.valueOf(appointment.getCarId()));
            statement.setString(2, appointment.getFirstName());
            statement.setString(3, appointment.getLastName());
            statement.setString(4,appointment.getContactNumber());
            statement.setString(5,appointment.getTime());
            statement.setString(6,String.valueOf(appointment.getDate()));
            statement.setString(7,appointment.getEmail());
            statement.execute();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
