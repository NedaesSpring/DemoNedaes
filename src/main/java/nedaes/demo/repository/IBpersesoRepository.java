package nedaes.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nedaes.demo.model.Bperseso;

@Repository
public interface IBpersesoRepository extends JpaRepository<Bperseso,Integer> {

	@Transactional
    @Modifying
    @Query("UPDATE Bperseso p SET p.cddni = :cddni where p.idbperseso = :idbperseso")
    int actualizarBperseso(@Param("cddni") String cddni, @Param("idbperseso") Integer idbperseso);	
}