package beams.service;

import beams.entity.Car;
import beams.entity.Customer;
import beams.entity.Reservation;
import beams.exception.BusinessException;
import beams.mapper.ReservationMapper;
import beams.model.car.CarResponseForReservation;
import beams.model.customer.CustomerResponseForReservation;
import beams.model.reservation.ReservationRequest;
import beams.model.reservation.ReservationResponse;
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
    private final ReservationMapper reservationMapper;


    public ReservationResponse saveReservation(ReservationRequest reservationRequest) {

        Reservation reservationToSave = reservationMapper.map(reservationRequest);

        reservationToSave.setCar(carRepository.findById(reservationRequest.getCarId()).orElseThrow(
                () -> new BusinessException("Car not found")));

        Customer customer = customerRepository.findById(reservationRequest.getCustomerId()).orElseThrow(
                () -> new BusinessException("Customer not found"));
        reservationToSave.setCustomer(customer);

        reservationRepository.save(reservationToSave);

        ReservationResponse reservationForResponse = new ReservationResponse();

        reservationForResponse.setId(reservationToSave.getId());
        reservationForResponse.setDateFrom(reservationToSave.getDateFrom());
        reservationForResponse.setDateOfReservation(reservationToSave.getDateOfReservation());
        reservationForResponse.setDateTo(reservationToSave.getDateTo());
        reservationForResponse.setAmount(reservationToSave.getAmount());

        CarResponseForReservation carResponse = new CarResponseForReservation();
        carResponse.setId(reservationToSave.getCar().getId());
        carResponse.setCarName(reservationToSave.getCar().getCarName());
        carResponse.setStatus(reservationToSave.getCar().getStatus());

        CustomerResponseForReservation customerResponse = new CustomerResponseForReservation();
        customerResponse.setId(reservationToSave.getCustomer().getId());
        customerResponse.setName((reservationToSave.getCustomer().getName()));
        customerResponse.setFirstName(reservationToSave.getCustomer().getFirstName());

        reservationForResponse.setCar(carResponse);
        reservationForResponse.setCustomer(customerResponse);

        return reservationForResponse;
    }

    public void deleteReservation(Integer id) {
        Reservation reservationToDelete = reservationRepository.findById(id).orElseThrow(
                () -> new BusinessException("Reservation not found")
        );
        reservationRepository.delete(reservationToDelete);
    }

    public ReservationResponse findById(Integer id) {
    return reservationMapper.map(reservationRepository.findById(id).orElseThrow(
            ()-> new BusinessException("Reservation not found")
    ));
    }
}