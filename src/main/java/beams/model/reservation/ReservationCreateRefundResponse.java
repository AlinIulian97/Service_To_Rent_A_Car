package beams.model.reservation;

import lombok.Data;

import java.sql.Date;

@Data
public class ReservationCreateRefundResponse {

    private Integer id;
    private double amount;
    private Date dateTo;

}
