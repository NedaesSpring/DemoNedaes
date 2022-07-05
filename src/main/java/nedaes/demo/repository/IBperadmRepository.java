package nedaes.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nedaes.demo.model.Bperadm;
import nedaes.demo.model.Bperban;

@Repository
public interface IBperadmRepository extends JpaRepository<Bperadm,Integer> {

	@Transactional
    @Modifying
    @Query("UPDATE Bperadm p SET p.cddni = :cddni where p.idbperadm = :idbperadm")
    int actualizarBperadm(@Param("cddni") String cddni, @Param("idbperadm") Integer idbperadm);	
	
	
	@Query("SELECT b FROM Bperadm b WHERE (:cdhabil is null or b.cdhabil = :cdhabil) and (:cdclasnm  is null or b.cdclasnm = :cdclasnm) and (:cddni is null or b.cddni = :cddni)  and (:cddup is null or b.cddup = :cddup)")
    Optional<Bperadm> buscarPorAK(@Param("cdhabil") String cdhabil, @Param("cdclasnm") String cdclasnm, @Param("cddni") String cddni, @Param("cddup") String cddup);
	
    @Query("UPDATE Bperadm b SET b.cddni= :cddni, b.cddup= :cddup, b.cdclasnm = :cdclasnm , b.cdhabil = :cdhabil, b.cdsitnom = :cdsitnom where b.idbperadm = :idbperadm")
    int actualizarBperadm(@Param("idbperadm") Integer idbperadm, @Param("cdsitnom") String cdsitnom);	

		
}