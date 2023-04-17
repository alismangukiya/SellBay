package com.motorheaven.appointment_page.dto;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.motorheaven.appointment_page.model.Appointment;

public class AppointmentDTOProxy implements IAppointmentDTO{
    private IAppointmentDTO appointmentDTO;
    private HttpServletRequest request;

    public AppointmentDTOProxy(HttpServletRequest request){
            this.request = request;
    }

    @Override
    public boolean saveAppointment(Appointment appointment){
        if(request.getSession().getAttribute("userid") == null){
            System.out.println("User not logged in!!!");
            return false;
        }else{
                appointmentDTO = new AppointmentDTO();            
                appointmentDTO.saveAppointment(appointment);
                return true;
        }
    }

    public String getValidUrl(Integer carid){
        if(request.getSession().getAttribute("userid") == null){
            return "login.html";
        }else{
            return "redirect:/viewNewCar/" + carid.toString();
        }

    }

    public String getUserEmail(){
        if(request.getSession().getAttribute("userid") == null){
            return "Not Available";
        }else{
        List<String> emails = (List<String>) request.getSession().getAttribute("userid");
        return emails.get(0);
        }
    }
    
}
