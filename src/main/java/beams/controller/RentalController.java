package beams.controller;

import beams.model.rental.RentalRequest;
import beams.model.rental.RentalResponse;
import beams.model.rental.RentalUpdateResponse;
import beams.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("rental")
public class RentalController {

    private final RentalService rentalService;

    @PostMapping("/save")
    public RentalResponse saveRental(@RequestBody RentalRequest rentalRequest) {
        return rentalService.addRental(rentalRequest);
    }

    @DeleteMapping({"/{id}"})
    public void deleteRental(@PathVariable Integer id) {
        rentalService.deleteRental(id);
    }

    @GetMapping("/{id}")
    public RentalResponse findById(@PathVariable Integer id) {
        return rentalService.findById(id);
    }

    @PatchMapping("{id}")
    public void updateRental(@PathVariable Integer id , @RequestBody  RentalUpdateResponse rentalUpdateResponse){
        rentalService.updateRental(id , rentalUpdateResponse);
    }

}
