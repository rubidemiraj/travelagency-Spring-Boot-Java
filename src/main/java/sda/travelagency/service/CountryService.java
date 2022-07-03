package sda.travelagency.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sda.travelagency.model.Country;
import sda.travelagency.repository.CountryRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public Country getCountryById(String id) {
        Optional<Country> optional = countryRepository.findById(UUID.fromString(id));
        Country country = null;
        if (optional.isPresent()) {
            country = optional.get();
        } else {
            throw new RuntimeException(" Country not found :: " + id);
        }
        return country;
    }

    @Override
    public void deleteCountryById(String id) {
        this.countryRepository.deleteById(UUID.fromString(id));
    }
}
