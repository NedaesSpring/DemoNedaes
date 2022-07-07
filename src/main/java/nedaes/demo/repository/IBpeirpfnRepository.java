package nedaes.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nedaes.demo.model.Bpeirpfn;

@Repository
public interface IBpeirpfnRepository extends JpaRepository<Bpeirpfn,Integer> {
	@Transactional
    @Modifying
    @Query("UPDATE Bpeirpfn p SET p.cddni = :cddni, cdnif = :cdnif where p.idbpeirpfn = :idbpeirpfn")
    int actualizarBpeirpfn(@Param("cddni") String cddni, @Param("cdnif") String cdnif, @Param("idbpeirpfn") Integer idbpeirpfn);		
}