package sda.travelagency.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sda.travelagency.service.CountryService;
import sda.travelagency.model.Country;

public class CountryController {
    private CountryService countryService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return "home/index";
    }

    @GetMapping("/showNewCountryForm")
    public String showNewPackageForm(Model model) {
        // create model attribute to bind form data
        Country country= new Country();
        model.addAttribute("country", country);
        return "new_country";
    }

    @PostMapping("/saveCountry")
    public String saveCountry(@ModelAttribute("country") Country country) {
        // save employee to database
       countryService.saveCountry(country);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") String id, Model model) {

        // get employee from the service
        Country country = countryService.getCountryById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("country", country);
        return "update_country";
    }

    @GetMapping("/deleteCountry/{id}")
    public String deleteCountry(@PathVariable (value = "id") String id) {

        // call delete employee method
        this.countryService.deleteCountryById(id);
        return "redirect:/";
    }
}


