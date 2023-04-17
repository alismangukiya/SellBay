package com.MotorHeaven.appointment_page;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.motorheaven.appointment_page.MockDB.AppointmentMockDB;
import com.motorheaven.appointment_page.dto.IAppointmentDTO;
import com.motorheaven.appointment_page.model.Appointment;

public class AppointmentDTOTest {
    IAppointmentDTO appointmentMock = new AppointmentMockDB();
    Appointment appointment;

    @Test
    public void saveAppointmentTestNull(){
        Assertions.assertEquals(false, appointmentMock.saveAppointment(appointment));
    }

    @Test
    public void saveAppointmentTest(){
        appointment = new Appointment();
        appointment.setCarId(100);
        appointment.setFirstName("Raj");
        appointment.setLastName("Patel");
        appointment.setEmail("abc@gmail.com");
        appointment.setDate("12/1/2022");
        appointment.setTime("9:00");
        Assertions.assertEquals(true,appointmentMock.saveAppointment(appointment));
    }
}
