package sda.travelagency.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import sda.travelagency.dto.PackageFilter;
import sda.travelagency.service.IPackagesService;

@Controller
@AllArgsConstructor
public class HomeController {
    protected IPackagesService packagesService;
    @RequestMapping("/")
    public String index(ModelMap map) {
        map.put("filter", new PackageFilter());
        map.put("albPackages", packagesService.findByCountry("shqiperi"));
        return "home/index";
    }
}
