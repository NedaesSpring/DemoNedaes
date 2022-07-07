package nedaes.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nedaes.demo.model.Delhac;

@Repository
public interface IDelhacRepository extends JpaRepository<Delhac,Integer> {

	
}