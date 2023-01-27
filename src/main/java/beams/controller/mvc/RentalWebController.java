package beams.controller.mvc;

import beams.entity.Rental;
import beams.exception.BusinessException;
import beams.mapper.RentalMapper;
import beams.model.rental.RentalRequest;
import beams.model.rental.RentalResponse;
import beams.model.rental.RentalUpdateResponse;
import beams.repository.RentalRepository;
import beams.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor

public class RentalWebController {
    private final RentalService rentalService;
    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;

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

    @GetMapping("/rental/goToUpdateRental")
    public String goToUpdateRental(@ModelAttribute(value = "updateRequest") RentalRequest request, Model model) {
        model.addAttribute("rentalId", request.getId());
        model.addAttribute("owner", request.getOwner());
        model.addAttribute("servicesFromDB", rentalService.allRental());
        return "updateRentalPage";
    }

    @PostMapping("/rental/update-rental")
    public String updateRental(@ModelAttribute RentalUpdateResponse request,
                               Model model) {
        rentalService.updateRental(request.getId(),  request);
        model.addAttribute("rentals", rentalService.allRental());
        return "allRentalPage";
    }

}


