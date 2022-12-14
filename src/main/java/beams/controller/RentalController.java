package beams.controller;

import beams.model.rental.RentalRequest;
import beams.model.rental.RentalResponse;
import beams.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;
    @PostMapping("/saveRental")
    public RentalResponse saveRental(@RequestBody RentalRequest rentalRequest){
        return  rentalService.addRental(rentalRequest);
    }

}
