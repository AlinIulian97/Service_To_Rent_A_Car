package beams.service;

import beams.model.car.CarResponseForReservation;
import beams.model.reservation.ReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor

public class StatisticService {
    private final ReservationService reservationService;

    public double popularCarPercentage() {
        int count = 0;
        int counted = 0;
        int mostRentCar = 0;
        List<ReservationResponse> list = reservationService.reservations();
        for (ReservationResponse r : list) {
            int idCar = r.getCarId();
            for (int i = 0; i < list.size(); i++) {
                if (idCar == list.get(i).getCarId()) {
                    count++;
                }
            }
            mostRentCar = Math.max(count, counted);
            if (count > counted) {
                counted = count;
            }
            count = 0;
        }
        return (double) (mostRentCar * 100) / list.size();
    }

    public CarResponseForReservation popularCar() {
        int count = 0;
        int counted = 0;
        int mostRentCar = 0;
       CarResponseForReservation car = null;
        List<ReservationResponse> list = reservationService.reservations();
        for (ReservationResponse r : list) {
            int idCar = r.getCarId();
            for (int i = 0; i < list.size(); i++) {
                if (idCar == list.get(i).getCarId()) {
                    count++;
                }
            }
            mostRentCar = Math.max(count, counted);
            if (count > counted) {
                car = r.getCar();
                counted = count;
            }
            count = 0;
        }
        return car;
    }

}
