package beams.repository;

import beams.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RentalRepository extends JpaRepository<Rental,Integer> {
}
