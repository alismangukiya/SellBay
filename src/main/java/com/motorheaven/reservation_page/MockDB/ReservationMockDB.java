package com.motorheaven.reservation_page.MockDB;

import java.util.ArrayList;
import java.util.List;

import com.motorheaven.reservation_page.dto.IReservationDTO;
import com.motorheaven.reservation_page.model.Reservation;

public class ReservationMockDB implements IReservationDTO {

    private List<Reservation> reservations = new ArrayList<>();

    @Override
    public boolean saveReservation(Reservation reservation) {
        if(reservation==null){
            return false;
        }
        reservations.add(reservation);
        return true;
    }
    
}
