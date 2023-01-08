package beams.model.reservation;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationCreateRefundResponse {

    private Integer id;
    private Double amount;
    private LocalDate dateTo;

}
