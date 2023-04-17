package com.motorheaven.reservation_page.controller;
import com.motorheaven.reservation_page.dto.ReservationDTOProxy;
import com.motorheaven.reservation_page.model.Reservation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ReservationController {

    ReservationDTOProxy reservationService;
    @GetMapping("makeReservation/{id}")
    public String makeReservation(Model model, @PathVariable String id){
        model.addAttribute("ID",id);
        return "makeReservation.html";
    }

    @PostMapping("/addReservation")
    public String addReservation(@RequestParam("carid") Integer  carid, @RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName, @RequestParam("number") String number, @RequestParam("date") String date, HttpServletRequest request) throws Exception{
        Reservation reservation = new Reservation();
        reservationService = new ReservationDTOProxy(request);
        reservation.setEmail(reservationService.getUserEmail());
        reservation.setCarId(carid);
        reservation.setFirstName(firstName);
        reservation.setLastName(lastName);
        reservation.setContactNumber(number);
        reservation.setDate(date);
        reservationService.saveReservation(reservation);
        String Url = reservationService.getValidUrl(carid);
        if(Url==null) {
        	throw new Exception("Error");
        }
        return Url;
    }
}
