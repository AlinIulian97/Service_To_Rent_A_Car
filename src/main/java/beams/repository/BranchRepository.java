package beams.repository;

import beams.entity.Branch;
import beams.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BranchRepository extends JpaRepository<Branch,Integer> {
}
