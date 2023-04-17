package com.motorheaven.appointment_page.MockDB;

import java.util.ArrayList;
import java.util.List;

import com.motorheaven.appointment_page.dto.IAppointmentDTO;
import com.motorheaven.appointment_page.model.Appointment;

public class AppointmentMockDB implements IAppointmentDTO {
    private List<Appointment> appointments = new ArrayList<>();

    @Override
    public boolean saveAppointment(Appointment appointment) {
        if(appointment==null){
            return false;
        }
        appointments.add(appointment);
        return true;
    
    }
 
}
