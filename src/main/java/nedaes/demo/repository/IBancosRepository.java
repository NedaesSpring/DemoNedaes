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

import nedaes.demo.model.Banco;

@Repository
public interface IBancosRepository extends JpaRepository<Banco,Integer> {

	@Query("SELECT p FROM Banco p WHERE (:dsbanco is null or p.dsbanco like %:dsbanco%) and (:cdbanco is null or p.cdbanco =:cdbanco)")
	List<Banco> buscarBancosPorFiltro(@Param("dsbanco") String dsbanco, @Param("cdbanco") String cdbanco);
	
	@Query("SELECT p FROM Banco p WHERE (:dsbanco is null or p.dsbanco like %:dsbanco%) and (:cdbanco is null or p.cdbanco =:cdbanco)")
	Page<Banco> buscarBancosPorFiltroPageable(Pageable pageable, @Param("dsbanco") String dsbanco, @Param("cdbanco") String cdbanco);

	@Query("SELECT p FROM Banco p WHERE (UPPER(p.dsbanco) = UPPER(:dsbanco)) and p.cdbanco = :cdbanco")
	Banco existeBanco(@Param("dsbanco") String dsbanco, @Param("cdbanco") String cdbanco);

	@Transactional
    @Modifying
    @Query("UPDATE Banco p SET p.dsbanco = :dsbanco, p.cdbanco = :cdbanco, p.otbanex = :otbanex, p.cdbic = :cdbic where p.idbanco = :idbanco")
    int actualizarBanco(@Param("dsbanco") String dsbanco, @Param("cdbanco") String cdbanco, @Param("otbanex") String otbanex, @Param("cdbic") String cdbic, @Param("idbanco")Integer idbanco);	
		
	@Query("SELECT COUNT(p) FROM Banco p WHERE (UPPER(p.dsbanco) = UPPER(:dsbanco)) and p.cdbanco = :cdbanco")
	Integer existeBancoCount(@Param("dsbanco") String dsbanco, @Param("cdbanco") String cdbanco);
	
	@Query("SELECT p FROM Banco p WHERE"
			+ " (:idbanco is null or p.idbanco = :ibBanco)"
			+ " AND (:dsbanco is null or p.dsbanco = :dsbanco)"
			+ " AND (:cdbanco is null or p.cdbanco =  :cdbanco)"
			)
	Page<Banco> findByParameters(Integer idbanco, String dsbanco, String cdbanco, Pageable pageable);

	@Query("SELECT p from Banco p WHERE p.dsbanco = :dsbanco")
	Banco findByBancoNombre(@Param("dsbanco") String dsbanco);	
	
	
}