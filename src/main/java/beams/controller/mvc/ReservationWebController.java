package beams.controller.mvc;

import beams.model.reservation.ReservationRequest;
import beams.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ReservationWebController {
    private final ReservationService reservationService;

    @GetMapping("/reservationPage")
    public String goToReservationPage() {
        return "reservationPage";
    }

    @GetMapping("/listReservation")
    public String getAllReservation(Model model) {
        model.addAttribute("reservations", reservationService.reservations());
        return "allReservationPage";
    }

    @PostMapping("/createReservation")
    public String createReservation(@ModelAttribute ReservationRequest request,
                                    Model model) {

        ReservationRequest reservationRequest = ReservationRequest.builder()
                .dateOfReservation(request.getDateOfReservation())
                .carId(request.getCarId())
                .amount(request.getAmount())
                .customerId(request.getCustomerId())
                .dateFrom(request.getDateFrom())
                .dateTo(request.getDateTo())
                .build();
        reservationService.saveReservation(reservationRequest);
        model.addAttribute("reservations", reservationService.reservations());

        return "allReservationPage";
    }


}
