package nedaes.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nedaes.demo.model.Provinc;

@Repository
public interface IProvincRepository extends JpaRepository<Provinc,Integer> {
 

	@Query("SELECT p FROM Provinc p WHERE (:dsprov is null or p.dsprov like %:dsprov%) and (:cdprov is null or p.cdprov =:cdprov)")
	List<Provinc> buscarProvinciasPorFiltro(@Param("cdprov") Integer cdprov, @Param("dsprov") String dsprov);
	
	@Query("SELECT p FROM Provinc p WHERE (:dsprov is null or p.dsprov like %:dsprov%) and (:cdprov is null or p.cdprov =:cdprov)")
	Page<Provinc> buscarProvinciasPorFiltroPageable(Pageable pageable, @Param("cdprov") Integer cdprov, @Param("dsprov") String dsprov);

	@Query("SELECT p FROM Provinc p WHERE (UPPER(p.dsprov) = UPPER(:dsprov)) and p.cdprov = :cdprov")
	Provinc existeProvincia(@Param("dsprov") String dsprov, @Param("cdprov") Integer cdprov);
	
	@Transactional
    @Modifying
    @Query("UPDATE Provinc p SET p.dsprov = :dsprov, p.cdprov = :cdprov where p.idProvincia = :idProvincia")
    int actualizarProvincia(@Param("cdprov") Integer cdprov, @Param("dsprov") String dsprov, @Param("idProvincia")Integer idProvincia);	
		
	@Query("SELECT COUNT(p) FROM Provinc p WHERE (UPPER(p.dsprov) = UPPER(:dsprov)) and p.cdprov = :cdprov")
	Integer existeProvinciaCount(@Param("cdprov") Integer cdprov, @Param("dsprov") String dsprov);
	
	@Query("SELECT p FROM Provinc p WHERE"
			+ " (:idProvincia is null or p.idProvincia = :idProvincia)"
			+ " AND (:dsprov is null or p.dsprov = :dsprov)"
			+ " AND (:cdprov is null or p.cdprov = :cdprov)"
			)
	Page<Provinc> findByParameters(Integer idProvincia, Integer cdprov, String dsprov, Pageable pageable);

	@Query("SELECT p from Provinc p WHERE p.dsprov = :dsprov")
	Provinc findByDsprov(@Param("dsprov") String dsprov);
	
}