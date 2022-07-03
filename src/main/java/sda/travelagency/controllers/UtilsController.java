package sda.travelagency.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.travelagency.service.IPackagesService;

@RestController
@AllArgsConstructor
public class UtilsController {
    protected IPackagesService packagesService;

    @RequestMapping("/utils/create-dummy-data")
    public String createDummyData() {
        packagesService.createDummyData();
        return "OK";
    }
}
