package beams.service;

import beams.entity.Car;
import beams.entity.Customer;
import beams.entity.Reservation;
import beams.exception.BusinessException;
import beams.repository.CarRepository;
import beams.repository.CustomerRepository;
import beams.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;

    public void saveReservation(Reservation reservation) {
        Customer customer  = customerRepository.findById(reservation.getCustomer().getId()).orElseThrow(
                () -> new RuntimeException("Customer don't found")

   );

        Car car  = carRepository.findById(reservation.getCar().getId()).orElseThrow(
                () -> new BusinessException("Car don't found")
        );

        reservation.getCar().setId(car.getId());
        reservation.getCustomer().setId(car.getId());

        reservationRepository.save(reservation);
    }
}
