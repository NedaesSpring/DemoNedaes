package nedaes.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nedaes.demo.model.Bperban;

@Repository
public interface IBperbanRepository extends JpaRepository<Bperban,Integer> 
 
 {
 
	
	@Query("SELECT p FROM Bperban p WHERE (:idbperban is null or p.idbperban = :idbperban)")
	List<Bperban> buscarBancoPorPerceptor(@Param("idbperban") Integer idbperban);

	@Query("SELECT b FROM Bperban b WHERE (:cdhabil is null or b.cdhabil = :cdhabil) and (:cdclasnm  is null or b.cdclasnm = :cdclasnm) and (:cddni is null or b.cddni = :cddni)  and (:cddup is null or b.cddup = :cddup)")
    Optional<Bperban> buscarPorAK(@Param("cdhabil") String cdhabil, @Param("cdclasnm") String cdclasnm, @Param("cddni") String cddni, @Param("cddup") String cddup);
	
    @Query("UPDATE Bperban b SET b.cdbanco = :cdbanco,  b.banco.idbanco = :idbanco where b.idbperban = :idbperban")
    int actualizarBperban( @Param("idbperban") Integer idbperban, @Param("cdbanco") String cdbanco, @Param("idbanco") Integer idbanco);	


}