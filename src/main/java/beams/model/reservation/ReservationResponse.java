package beams.model.reservation;

import beams.entity.Car;
import beams.entity.Customer;
import beams.model.car.CarResponseForReservation;
import beams.model.customer.CustomerResponseForReservation;
import lombok.Data;

import java.util.Date;

@Data
public class ReservationResponse {

    private Integer id;

    private Date dateOfReservation;

    private Date dateFrom;

    private Date dateTo;

    private double amount;

    private CarResponseForReservation car;

    private CustomerResponseForReservation customer;
}
