package sda.travelagency.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sda.travelagency.Service.PackagesService;
import sda.travelagency.model.Package;

@Controller
@AllArgsConstructor
public class PackagesController {
    @RequestMapping("/paketat")
    public String index() {
        return "home/paketat";
    }


    @RequestMapping("/detajet")
    public String detajet() {
        return "home/detajet";
    }


    private PackagesService packagesService;


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
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        Package pakete = packagesService.getPackageById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("pakete", pakete);
        return "update_pakete";
    }

    @GetMapping("/deletePackage/{id}")
    public String deletePackage(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.packagesService.deletePackageById(id);
        return "redirect:/";
    }

}

//    @GetMapping("/page/{pageNo}")
//    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
//                                @RequestParam("sortField") String sortField,
//                                @RequestParam("sortDir") String sortDir,
//                                Model model) {
//        int pageSize = 5;
//
//        Page<Employee> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
//        List<Employee> listEmployees = page.getContent();
//
//        model.addAttribute("currentPage", pageNo);
//        model.addAttribute("totalPages", page.getTotalPages());
//        model.addAttribute("totalItems", page.getTotalElements());
//
//        model.addAttribute("sortField", sortField);
//        model.addAttribute("sortDir", sortDir);
//        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
//
//        model.addAttribute("listEmployees", listEmployees);
//        return "index";
//    }


