package sda.travelagency.Service;

import sda.travelagency.model.Country;

import java.util.List;

public interface ICountryService {

    List<Country> getAllCountry();
    void saveCountry(Country country);
    Country getCountryById(long id);
    void deleteCountryById(long id);

}
