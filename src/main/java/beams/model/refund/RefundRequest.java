package beams.model.refund;

import beams.entity.Employee;
import beams.entity.Reservation;
import beams.model.employee.EmployeeCreateRefundResponse;
import beams.model.reservation.ReservationCreateRefundResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class RefundRequest {

    private Integer id;

    private Date returnDate;

    private double surcharge;

    private String comments;

    private Integer reservationId;

    private Integer employeeId;

    private Integer refundId;
}
