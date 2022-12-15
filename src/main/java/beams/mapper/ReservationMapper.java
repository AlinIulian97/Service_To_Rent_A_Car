package beams.mapper;

import beams.entity.Reservation;
import beams.model.reservation.ReservationRequest;
import beams.model.reservation.ReservationResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

@Mapper(componentModel = "spring")
@ComponentScan
public interface ReservationMapper {

    Reservation map(ReservationRequest reservationRequest);

    ReservationResponse map(Reservation reservation);

}
