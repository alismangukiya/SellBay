package com.motorheaven.reservation_page.dto;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.motorheaven.reservation_page.model.Reservation;

public class ReservationDTOProxy implements IReservationDTO {
    private IReservationDTO reserveDTO;
    private HttpServletRequest request;

    public ReservationDTOProxy(HttpServletRequest request){
            this.request = request;
    }

    @Override
    public boolean saveReservation(Reservation reservation) {
        if(request.getSession().getAttribute("userid") == null){
            System.out.println("User not logged in!!!");
            return false;
        }else{
                reserveDTO = new ReservationDTO();
                return reserveDTO.saveReservation(reservation);
        }
    }

    public String getValidUrl(Integer carid){
        if(request.getSession().getAttribute("userid") == null){
            return "login.html";
        }else{
            return "redirect:/viewRentCar/" + carid.toString();
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
