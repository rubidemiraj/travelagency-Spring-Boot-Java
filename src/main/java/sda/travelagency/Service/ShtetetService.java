package sda.travelagency.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.travelagency.model.Package;
import sda.travelagency.model.Shtet;
import sda.travelagency.repository.PackagesRepository;
import sda.travelagency.repository.ShtetetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShtetetService implements IShtetetService{

    @Autowired
    private ShtetetRepository shtetetRepository;

    @Override
    public List<Shtet> getAllShtetet() {
        return shtetetRepository.findAll();
    }

    @Override
    public void saveShtet(Shtet shtet) {
        this.shtetetRepository.save(shtet);
    }

    @Override
    public Shtet getShtetById(long id) {
        Optional<Shtet> optional = shtetetRepository.findById(id);
        Shtet shtet = null;
        if (optional.isPresent()) {
            shtet = optional.get();
        } else {
            throw new RuntimeException(" Shteti kerkuar nuk u gjet :: " + id);
        }
        return shtet;
    }

    @Override
    public void deleteShtetById(long id) {
        this.shtetetRepository.deleteById(id);
    }
}
