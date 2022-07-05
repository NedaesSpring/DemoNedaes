package nedaes.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nedaes.demo.model.Clasenomina;

@Repository
public interface IClasenominaRepository extends JpaRepository<Clasenomina,Integer>{

}