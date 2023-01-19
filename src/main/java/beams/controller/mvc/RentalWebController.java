package beams.controller.mvc;

import beams.model.rental.RentalRequest;
import beams.service.BranchService;
import beams.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RentalWebController {
    private final RentalService rentalService;
    private final BranchService branchService;

    @GetMapping("/rentPage")
    public String rentPage() {
        return "rentPage";
    }

    @GetMapping("/rentPage/allRentalPage")
    public String goToAllRental(Model model) {
        model.addAttribute("rentals", rentalService.allRental());
        return "allRentalPage";
    }

    @PostMapping("/rentPage/createRent")
    public String createRent(@ModelAttribute(value = "createRent")
                             RentalRequest request,
                             Model model) {
        RentalRequest rentalRequest = RentalRequest.builder()
                .internetDomain(request.getInternetDomain())
                .nameRental(request.getNameRental())
                .contactAddress(request.getContactAddress())
                .owner(request.getOwner())
                .logoType(request.getLogoType())
                .build();
        rentalService.addRental(rentalRequest);

        model.addAttribute("rentals", rentalService.allRental());
        return "allRentalPage";
    }

    @PostMapping("/deleteRent")
    public String deleteRent(@ModelAttribute("deleteRequest")
                             RentalRequest rentalRequest,
                             Model model) {

        rentalService.deleteRental(rentalRequest.getId());
        model.addAttribute("rentals", rentalService.allRental());
        return "allRentalPage";
    }
}