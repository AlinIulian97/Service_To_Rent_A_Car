package beams.model.reservation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ReservationRequest {

    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDate dateOfReservation;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDate dateFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDate dateTo;

    private Double amount;
    private Integer carId;
    private Integer customerId;

}
