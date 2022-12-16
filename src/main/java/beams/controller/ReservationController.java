package beams.controller;

import beams.model.reservation.ReservationRequest;
import beams.model.reservation.ReservationResponse;
import beams.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/saveReservation")
    public ReservationResponse saveReservation(@RequestBody ReservationRequest reservationRequest) {
        return reservationService.saveReservation(reservationRequest);
    }

    @DeleteMapping("deleteReservation/{id}")
    public void deleteReservation(@PathVariable Integer id){
        reservationService.deleteReservation(id);
    }
}
