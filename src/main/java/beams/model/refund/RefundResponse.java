package beams.model.refund;

import beams.model.employee.EmployeeCreateRefundResponse;
import beams.model.reservation.ReservationCreateRefundResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class RefundResponse {

    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDate returnDate;

    private Double surcharge;
    private String comments;
    private ReservationCreateRefundResponse reservation;
    private EmployeeCreateRefundResponse employee;
    private Integer employeeId;
    private Integer reservationId;

}
