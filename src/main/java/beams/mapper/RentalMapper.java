package beams.mapper;

import beams.entity.Rental;
import beams.model.rental.RentalRequest;
import beams.model.rental.RentalResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@Mapper(componentModel = "spring")
public interface  RentalMapper {

    Rental map(RentalRequest rentalRequest);

    RentalResponse map(Rental rental);

}
