package com.MotorHeaven.reservation_page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.motorheaven.reservation_page.MockDB.ReservationMockDB;
import com.motorheaven.reservation_page.dto.IReservationDTO;
import com.motorheaven.reservation_page.model.Reservation;


public class ReservationDTOTest {
    IReservationDTO reservationMock = new ReservationMockDB();
    Reservation reservation;

    @Test
    public void saveReservationTestNull(){
        Assertions.assertEquals(false, reservationMock.saveReservation(reservation));
    }

    @Test
    public void saveReservationTest(){
        reservation = new Reservation();
        reservation.setCarId(100);
        reservation.setFirstName("Raj");
        reservation.setLastName("Patel");
        reservation.setEmail("abc@gmail.com");
        reservation.setDate("12/1/2022");
        Assertions.assertEquals(true, reservationMock.saveReservation(reservation));
    }    
}
