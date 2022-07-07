package nedaes.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nedaes.demo.model.HabilitacionInicial;

@Repository
public interface IHabilitacionInicialRepository extends JpaRepository<HabilitacionInicial,Integer> {

	@Query("SELECT h FROM HabilitacionInicial h order by h.cdhabil")
	List<HabilitacionInicial> BuscarTodas();
}