package sda.travelagency.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class AboutUsController {
    @RequestMapping("/about-us")
    public String index() {
        return "about-us/index";
    }
}
