package beams.mapper;

import beams.entity.Refund;
import beams.model.refund.RefundRequest;
import beams.model.refund.RefundResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@Mapper(uses = EmployeeMapper.class)
public interface RefundMapper {

    Refund map(RefundRequest refundRequest);

    @Mapping(target = "employeeId", source = "employee.id")
    @Mapping(target ="reservationId" , source = "reservation.id")
    RefundResponse map(Refund refund);

    List<RefundResponse> map(List<Refund> refund);

}
