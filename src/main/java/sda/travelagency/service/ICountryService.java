package sda.travelagency.service;

import sda.travelagency.model.Country;

import java.util.List;

public interface ICountryService {

    List<Country> getAllCountry();
    void saveCountry(Country country);
    Country getCountryById(String id);
    void deleteCountryById(String id);

}
