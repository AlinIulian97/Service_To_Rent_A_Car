package beams.model.reservation;

import beams.model.car.CarResponseForReservation;
import beams.model.customer.CustomerResponseForReservation;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ReservationResponse {

    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDate dateOfReservation;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDate dateFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDate dateTo;

    private Double amount;
    private CarResponseForReservation car;
    private CustomerResponseForReservation customer;
}
