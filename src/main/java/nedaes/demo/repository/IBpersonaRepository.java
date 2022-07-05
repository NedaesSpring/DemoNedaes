package nedaes.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nedaes.demo.model.Bpersona;

@Repository
public interface IBpersonaRepository extends JpaRepository<Bpersona,Integer> 
{

	@Query("SELECT p FROM Bpersona p WHERE "
			+ "(:cdclasnm is null or p.cdclasnm like %:cdclasnm%) and "
			+ "(:cddni is null or p.cddni like %:cddni%)  and (:cddup is null or p.cddup = :cddup) and (:dsapell1 is null or p.dsapell1 = :dsapell1) and (:dsapell2 is null or p.dsapell2 = :dsapell2) and (:dsnombre is null or p.dsnombre = :dsnombre) "
	+ "and (:idClasenomina is null or p.clasenomina.idClasenomina= :idClasenomina)"
			)
	Page<Bpersona> buscarBpersonasPorFiltroPageable(
			@Param("cdclasnm") String cdclasnm, 
			@Param("cddni") String cddni, @Param("cddup") String cddup, @Param("dsapell1") String dsapell1, @Param("dsapell2") String dsapell2, @Param("dsnombre") String dsnombre,
			Integer idClasenomina, 
			Pageable pageable);

	@Query("SELECT p FROM Bpersona p WHERE (UPPER(p.cddni) = UPPER(:cddni)) and (UPPER(p.cddup) = UPPER(:cddup)) and (UPPER(p.cdhabil) = UPPER(:cdhabil)) "
			+ "and (UPPER(p.cdclasnm) = UPPER(:cdclasnm)) "
			)
	Bpersona existeBpersona(@Param("cddni") String cddni, @Param("cddup") String cddup, @Param("cdhabil") String cdhabil
			, @Param("cdclasnm") String cdclasnm
			);

	@Transactional
    @Modifying
    @Query("UPDATE Bpersona p SET p.cddni = :cddni where p.idbpersona = :idbpersona")
    int actualizarBpersona(@Param("cddni") String cddni, @Param("idbpersona") Integer idbpersona);	
}