package com.motorheaven.user_history.dto;

import com.motorheaven.appointment_page.model.Appointment;
import com.motorheaven.reservation_page.model.Reservation;
import java.util.List;

public interface IViewHistoryDTO {
    List<Appointment> getAppointment(String email);
    List<Reservation> getReservation(String email);
}
