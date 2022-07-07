package nedaes.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nedaes.demo.model.Bperrgss;

@Repository
public interface IBperrgsRepository extends JpaRepository<Bperrgss,Integer> {
	@Transactional
    @Modifying
    @Query("UPDATE Bperrgss p SET p.cddni = :cddni where p.idbperrgss = :idbperrgss")
    int actualizarBperrgss(@Param("cddni") String cddni, @Param("idbperrgss") Integer idbperrgss);		
}