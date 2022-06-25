package sda.travelagency.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.travelagency.model.Package;
import sda.travelagency.model.Reservations;
import sda.travelagency.model.Shtet;
import sda.travelagency.repository.PackagesRepository;
import sda.travelagency.repository.ReservationsRepository;
import sda.travelagency.repository.ShtetetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationsService implements IReservationsService{

    @Autowired
    private ReservationsRepository reservationsRepository;

    @Override
    public List<Reservations> getAllReservations() {
        return reservationsRepository.findAll();
    }

    @Override
    public void saveReservation(Reservations reservation) {
        this.reservationsRepository.save(reservation);
    }

    @Override
    public Reservations getReservationById(long id) {
        Optional<Reservations> optional = reservationsRepository.findById(id);
        Reservations reservation = null;
        if (optional.isPresent()) {
            reservation = optional.get();
        } else {
            throw new RuntimeException(" Rezervimi nuk u gjet :: " + id);
        }
        return reservation;
    }

    @Override
    public void deleteReservationById(long id) {
        this.reservationsRepository.deleteById(id);
    }
}
