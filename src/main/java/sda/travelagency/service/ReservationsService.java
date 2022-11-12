package sda.travelagency.service;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import sda.travelagency.dto.ServiceResponse;
import sda.travelagency.model.Package;
import sda.travelagency.model.Reservation;
import sda.travelagency.repository.PackagesRepository;
import sda.travelagency.repository.ReservationsRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ReservationsService implements IReservationsService{


    private ReservationsRepository reservationsRepository;
    private PackagesRepository packagesRepository;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationsRepository.findAll();
    }

    @Override
    public void saveReservation(Reservation reservation) {
        this.reservationsRepository.save(reservation);
    }

    @Override
    public Reservation getReservationById(String id) {
        Optional<Reservation> optional = reservationsRepository.findById(UUID.fromString(id));
        Reservation reservation = null;
        if (optional.isPresent()) {
            reservation = optional.get();
        } else {
            throw new RuntimeException("Resevation not found :: " + id);
        }
        return reservation;
    }

    @Override
    public void deleteReservationById(String id) {
        this.reservationsRepository.deleteById(UUID.fromString(id));
    }

    @Override
    public ServiceResponse book(Reservation model) {
        if (model == null)
            return ServiceResponse.error("Vendosni informacionet e kerkuara!");

        if (StringUtils.isEmpty(model.getFirstName()))
            return ServiceResponse.error("Emri eshte i kerkuar!");

        if (StringUtils.isEmpty(model.getLastName()))
            return ServiceResponse.error("Mbiemri eshte i kerkuar!");

        if (StringUtils.isEmpty(model.getEmail()))
            return ServiceResponse.error("Email eshte i kerkuar!");


        if (StringUtils.isEmpty(model.getPhone()))
            return ServiceResponse.error("Kontrakti telefoni eshte i kerkuar!");

        if (model.getNrAdults() < 1)
            return ServiceResponse.error("Numri i personave te rritur duhet te jete me i madh se 1!");

        if (model.getNrChildren() < 0)
            return ServiceResponse.error("Numri i personave te rritur duhet te jete 0 ose me i madh!");

        if (model.getPackageId() == null)
            return ServiceResponse.error("Per te prenotuar duhet te zgjidhni nje pakete!");

       model.setTotalPrice( calculateTotalPrice(model));
        reservationsRepository.save(model);

        return ServiceResponse.success("Rezervimi perfundoi me sukses. Do te kontaktoheni nga agjenti jone i shitjeve! " +
                "Totali i rezervimit eshte  "+ model.getTotalPrice()+" $");
    }

    @Override
    public float calculateTotalPrice(Reservation model) {
        int nrAdults=model.getNrAdults();
        int nrChildren=model.getNrChildren();

        String pckgId=model.getPackageId();
        Package packg;
        float packgPrice=0f;
        Optional<Package> packageModel=packagesRepository.findById(UUID.fromString(pckgId));
        if (packageModel.isPresent()){
          packg=  packageModel.get();
          packgPrice=packg.getPrice();
        }

        return (nrAdults*packgPrice)+(nrChildren*(packgPrice/2));
    }
}
