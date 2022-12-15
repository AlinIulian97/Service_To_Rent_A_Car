package beams.model.reservation;

import beams.entity.Car;
import beams.entity.Customer;
import beams.entity.Refund;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ReservationRequest {


    private Integer id;

    private Date dateOfReservation;

    private Date dateFrom;

    private Date dateTo;

    private double amount;

    private Integer carId;

    private Integer customerId;

}
