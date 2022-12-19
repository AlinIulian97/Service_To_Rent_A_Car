package beams.service;

import beams.entity.Refund;
import beams.exception.BusinessException;
import beams.mapper.RefundMapper;
import beams.model.employee.EmployeeCreateRefundResponse;
import beams.model.refund.RefundRequest;
import beams.model.refund.RefundResponse;
import beams.model.reservation.ReservationCreateRefundResponse;
import beams.repository.EmployeeRepository;
import beams.repository.RefundRepository;
import beams.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RefundService {

    private final RefundRepository refundRepository;
    private final EmployeeRepository employeeRepository;
    private final ReservationRepository reservationRepository;

    private final RefundMapper refundMapper;

    public RefundResponse saveRefund(RefundRequest refundRequest) {

        Refund refundToSave = refundMapper.map(refundRequest);

        refundToSave.setEmployee(employeeRepository.findById(refundRequest.getEmployeeId()).orElseThrow(
                () -> new BusinessException("Employee do not found")
        ));

        refundToSave.setReservation(reservationRepository.findById(refundRequest.getReservationId()).orElseThrow(
                () -> new BusinessException("Reservation do not found")
        ));


        refundRepository.save(refundToSave);

        RefundResponse refundResponse = new RefundResponse();
        refundResponse.setId(refundToSave.getId());
        refundResponse.setComments(refundToSave.getComments());
        refundResponse.setSurcharge(refundToSave.getSurcharge());
        refundResponse.setReturnDate(refundToSave.getReturnDate());


        ReservationCreateRefundResponse reservationCreateRefundResponse = new ReservationCreateRefundResponse();
        reservationCreateRefundResponse.setId(refundToSave.getReservation().getId());
        reservationCreateRefundResponse.setAmount(refundToSave.getReservation().getAmount());
        reservationCreateRefundResponse.setDateTo((refundToSave.getReservation().getDateTo()));


        EmployeeCreateRefundResponse employeeCreateRefundResponse = new EmployeeCreateRefundResponse();
        employeeCreateRefundResponse.setId(refundToSave.getEmployee().getId());
        employeeCreateRefundResponse.setFirstName(refundToSave.getEmployee().getFirstName());
        employeeCreateRefundResponse.setLastName(refundToSave.getEmployee().getLastName());


        refundResponse.setEmployee(employeeCreateRefundResponse);
        refundResponse.setReservation(reservationCreateRefundResponse);

        return refundResponse;
    }

    public void deleteRefund(Integer id ){
        Refund refundToDelete = refundRepository.findById(id).orElseThrow(
                ()-> new BusinessException("Refund not Found")
        );
        refundRepository.delete(refundToDelete);
    }

    public RefundResponse findById(Integer id){
        return refundMapper.map(refundRepository.findById(id).orElseThrow(
                ()-> new BusinessException("Refund not found")
        ));
    }

}
