package sda.travelagency.service;

import sda.travelagency.dto.ServiceResponse;
import sda.travelagency.model.Reservation;

import java.util.List;

public interface IReservationsService {

    List<Reservation> getAllReservations();
    void saveReservation(Reservation reservation);
    Reservation getReservationById(String id);
    void deleteReservationById(String id);
    ServiceResponse book(Reservation model);
    float calculateTotalPrice(Reservation model);
}
