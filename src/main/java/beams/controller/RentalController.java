package beams.controller;

import beams.model.rental.RentalRequest;
import beams.model.rental.RentalResponse;
import beams.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;
    @PostMapping("/saveRental")
    public RentalResponse saveRental(@RequestBody RentalRequest rentalRequest){
        return  rentalService.addRental(rentalRequest);
    }
    @DeleteMapping("deleteRental/{id}")
    public void deleteRental(@PathVariable Integer id){
        rentalService.deleteRental(id);
    }

}
