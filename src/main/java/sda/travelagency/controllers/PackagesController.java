package sda.travelagency.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sda.travelagency.model.Reservation;
import sda.travelagency.service.IPackagesService;
import sda.travelagency.service.PackagesService;
import sda.travelagency.dto.PackageFilter;
import sda.travelagency.model.Package;

@Controller
@AllArgsConstructor
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class PackagesController {
    protected IPackagesService packagesService;

    @RequestMapping("/paketat")
    public String index(@ModelAttribute PackageFilter filter, ModelMap map) {
        map.put("filter", filter);
        map.put("packages", packagesService.filter(filter));
        return "home/paketat";
    }

    @RequestMapping("/detajet/{id}")
    public String findPackageById(@PathVariable String id, ModelMap map) {
        map.put("package", packagesService.getPackageById(id));
        map.put("reservation", new Reservation());
        return "home/detajet";
    }

    @GetMapping("/showNewPackageForm")
    public String showNewPackageForm(Model model) {
        // create model attribute to bind form data
        Package pakete = new Package();
        model.addAttribute("package", pakete);
        return "new_package";
    }

    @PostMapping("/savePackage")
    public String savePackage(@ModelAttribute("pakete") Package pakete) {
        // save employee to database
        packagesService.savePackage(pakete);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") String id, Model model) {

        // get employee from the service
        Package pakete = packagesService.getPackageById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("pakete", pakete);
        return "update_pakete";
    }

    @GetMapping("/deletePackage/{id}")
    public String deletePackage(@PathVariable(value = "id") String id) {

        // call delete employee method
        this.packagesService.deletePackageById(id);
        return "redirect:/";
    }

}

