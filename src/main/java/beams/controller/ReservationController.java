package beams.controller;

import beams.entity.Reservation;
import beams.model.reservation.ReservationRequest;
import beams.model.reservation.ReservationResponse;
import beams.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/saveReservation")
    public ReservationResponse saveReservation(@RequestBody ReservationRequest reservationRequest) {
        return reservationService.saveReservation(reservationRequest);
    }
}
