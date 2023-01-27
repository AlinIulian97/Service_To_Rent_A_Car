package beams.model.reservation;

import beams.model.car.CarResponseForReservation;
import beams.model.customer.CustomerResponseForReservation;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ReservationResponse {

    private Integer id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate dateOfReservation;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate dateFrom;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate dateTo;

    private Double amount;
    private Integer carId;
    private Integer customerId;

    private CarResponseForReservation car;
    private CustomerResponseForReservation customer;
}
