package beams.mapper;

import beams.entity.Revenue;
import beams.model.revenue.RevenueRequest;
import beams.model.revenue.RevenueResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@Mapper(componentModel = "spring")
public interface RevenueMapper {

    Revenue map(RevenueRequest revenueRequest);

    RevenueResponse map(Revenue revenue);

}
