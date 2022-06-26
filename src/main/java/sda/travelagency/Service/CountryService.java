package sda.travelagency.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sda.travelagency.model.Country;
import sda.travelagency.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryService implements ICountryService {


    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountry() {
        return countryRepository.findAll();
    }

    @Override
    public void saveCountry(Country country) {
        this.countryRepository.save(country);
    }

    @Override
    public Country getCountryById(long id) {
        Optional<Country> optional = countryRepository.findById(id);
        Country country = null;
        if (optional.isPresent()) {
            country = optional.get();
        } else {
            throw new RuntimeException(" Country not found :: " + id);
        }
        return country;
    }

    @Override
    public void deleteCountryById(long id) {
        this.countryRepository.deleteById(id);
    }
}
