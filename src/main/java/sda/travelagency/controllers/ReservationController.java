package sda.travelagency.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sda.travelagency.model.Reservation;
import sda.travelagency.service.IPackagesService;
import sda.travelagency.service.IReservationsService;

@Controller
@AllArgsConstructor
public class ReservationController {
    protected IReservationsService reservationsService;
    protected IPackagesService packagesService;

    @PostMapping("/rezervimi/ruaj")
    public String savePackage(@ModelAttribute Reservation reservation, RedirectAttributes map) {
        map.addFlashAttribute("response", reservationsService.book(reservation));

        return "redirect:/detajet/" + reservation.getPackageId();
    }
}
