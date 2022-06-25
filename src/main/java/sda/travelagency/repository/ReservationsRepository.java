package sda.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.travelagency.model.Package;
import sda.travelagency.model.Reservations;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservations,Long> {

}
