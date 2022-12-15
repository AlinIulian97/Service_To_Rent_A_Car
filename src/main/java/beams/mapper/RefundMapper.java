package beams.mapper;

import beams.entity.Refund;
import beams.model.refund.RefundRequest;
import beams.model.refund.RefundResponse;
import beams.model.revenue.RevenueResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@Mapper(componentModel = "spring")
public interface RefundMapper {

    Refund map(RefundRequest refundRequest);

    RefundResponse map(Refund refund);


}
