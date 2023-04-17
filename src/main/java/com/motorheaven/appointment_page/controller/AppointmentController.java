package com.motorheaven.appointment_page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.motorheaven.appointment_page.dto.AppointmentDTOProxy;
import com.motorheaven.appointment_page.model.Appointment;

@Controller
public class AppointmentController {
    AppointmentDTOProxy appointmentService;
    @GetMapping("/bookAppointment/{id}")
    public String bookAppointment(Model model, @PathVariable String id){
        model.addAttribute("ID",id);
        return "bookAppointment.html";
    }

    @PostMapping("/addappointment")
    public String addappointment(@RequestParam("carid") Integer carid, @RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName, @RequestParam("number") String number, @RequestParam("time") String time, @RequestParam("date") String date, HttpServletRequest request){
        appointmentService = new AppointmentDTOProxy(request);
        Appointment appointment = new Appointment();
        appointment.setEmail(appointmentService.getUserEmail());
        appointment.setCarId(carid);
        appointment.setFirstName(firstName);
        appointment.setLastName(lastName);
        appointment.setContactNumber(number);
        appointment.setTime(time);
        appointment.setDate(date);
        appointmentService.saveAppointment(appointment);
        String url = appointmentService.getValidUrl(carid);
        return url;
    }
}
