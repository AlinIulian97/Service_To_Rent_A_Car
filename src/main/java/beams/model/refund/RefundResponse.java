package beams.model.refund;

import beams.model.employee.EmployeeCreateRefundResponse;
import beams.model.reservation.ReservationCreateRefundResponse;
import lombok.Data;

import java.sql.Date;
@Data
public class RefundResponse {

    private Integer id;

    private Date returnDate;

    private double surcharge;

    private String comments;

    private ReservationCreateRefundResponse reservation;

    private EmployeeCreateRefundResponse employee;
}
