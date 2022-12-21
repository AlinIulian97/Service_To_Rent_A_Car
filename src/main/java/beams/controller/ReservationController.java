package beams.controller;

import beams.model.reservation.ReservationRequest;
import beams.model.reservation.ReservationResponse;
import beams.model.reservation.ReservationUpdateResponse;
import beams.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/save")
    public ReservationResponse saveReservation(@RequestBody ReservationRequest reservationRequest) {
        return reservationService.saveReservation(reservationRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Integer id) {
        reservationService.deleteReservation(id);
    }

    @GetMapping("/{id}")
    public ReservationResponse findById(@PathVariable Integer id) {
        return reservationService.findById(id);
    }

    @PatchMapping({"{id}"})
    public void updateReservation(@PathVariable Integer id , @RequestBody ReservationUpdateResponse reservationUpdateResponse){
        reservationService.updateReservation(id, reservationUpdateResponse);
    }
}
