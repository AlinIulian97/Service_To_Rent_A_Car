package beams.mapper;

import beams.entity.Reservation;
import beams.model.reservation.ReservationRequest;
import beams.model.reservation.ReservationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@Mapper(componentModel = "spring")
@ComponentScan
public interface ReservationMapper {

    Reservation map(ReservationRequest reservationRequest);

    @Mapping(target = "carId", source = "car.id")
    @Mapping(target = "customerId", source = "customer.id")
    ReservationResponse map(Reservation reservation);

    List<ReservationResponse> map(List<Reservation> reservations);

}
