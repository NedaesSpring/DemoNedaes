package nedaes.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nedaes.demo.model.Localid;

@Repository
public interface ILocalidRepository extends JpaRepository<Localid,Integer> {
	@Query("SELECT l FROM Localid l WHERE (l.provinc.cdprov =:cdprov) order by dsloc")
	List<Localid> buscarLocalidProvinc(@Param("cdprov") Integer cdprov);
}