package sda.travelagency.Service;

import sda.travelagency.model.Package;
import sda.travelagency.model.Reservations;

import java.util.List;

public interface IReservationsService {

    List<Reservations> getAllReservations();
    void saveReservation(Reservations reservation);
    Reservations getReservationById(long id);
    void deleteReservationById(long id);

}
