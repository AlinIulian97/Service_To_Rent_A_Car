package beams.mapper;

import beams.entity.Refund;
import beams.model.refund.RefundRequest;
import beams.model.refund.RefundResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(uses = EmployeeMapper.class)
public interface RefundMapper {

    Refund map(RefundRequest refundRequest);

    @Mapping(target = "employeeId", source = "employee.id")
    RefundResponse map(Refund refund);

}
