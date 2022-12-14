package beams.service;


import beams.entity.Rental;
import beams.mapper.RentalMapper;
import beams.model.rental.RentalRequest;
import beams.model.rental.RentalResponse;
import beams.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;

    private final RentalMapper rentalMapper;



    public RentalResponse addRental(RentalRequest rentalRequest){
        Rental rental =rentalMapper.map(rentalRequest);
        return rentalMapper.map(rentalRepository.save(rental));
    }
}
