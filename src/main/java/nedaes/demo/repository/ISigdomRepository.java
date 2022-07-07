package nedaes.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nedaes.demo.model.Sigdom;

@Repository
public interface ISigdomRepository extends JpaRepository<Sigdom,Integer> {

	
}