package sda.travelagency.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sda.travelagency.model.Reservations;
import sda.travelagency.repository.ReservationsRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationsService implements IReservationsService{


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
            throw new RuntimeException("Resevation not found :: " + id);
        }
        return reservation;
    }

    @Override
    public void deleteReservationById(long id) {
        this.reservationsRepository.deleteById(id);
    }
}
