package beams.service;

import beams.entity.Reservation;
import beams.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public void saveReservation(Reservation reservation){
        reservationRepository.save(reservation);
    }


}
