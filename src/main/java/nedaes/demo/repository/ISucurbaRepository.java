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
import nedaes.demo.model.Sucurba;

@Repository
public interface ISucurbaRepository extends JpaRepository<Sucurba,Integer> {

	@Query("SELECT s FROM Sucurba s WHERE (s.banco.idbanco =:idbanco) order by cdsucur")
	List<Sucurba> buscarSucurbaBanco(@Param("idbanco") Integer idbanco);

	@Query("SELECT s FROM Sucurba s WHERE (:idbanco is null or s.banco.idbanco = :idbanco) and (:cdbanco is null or s.banco.cdbanco = :cdbanco) and (:cdsucur is null or s.cdsucur = :cdsucur) order by cdsucur")
	Page<Sucurba> buscarSucurbasPorFiltroPageable(Pageable pageable, @Param("idbanco") Integer idbanco, @Param("cdbanco") String cdbanco, @Param("cdsucur") String cdsucur);
	
	@Query("SELECT s FROM Sucurba s WHERE (UPPER(s.cdsucur) = UPPER(:cdsucur)) and (UPPER(s.cdbanco) = UPPER(:cdbanco))")
	Sucurba existeSucurba(@Param("cdsucur") String cdsucur, @Param("cdbanco") String cdbanco);
	
	@Transactional
    @Modifying
    @Query("UPDATE Sucurba s  SET s.cdsucur = :cdsucur, s.cdbic = :cdbic, s.dsdomic = :dsdomic, s.dsplaza = :dsplaza, s.cdprov = :cdprov, s.cdnacion = :cdnacion, s.dsresto = :dsresto "
     		+ " where s.idsucurba = :idsucurba")
    int actualizarSucurba(@Param("cdsucur") String cdsucur, @Param("cdbic") String cdbic,  @Param("dsdomic") String dsdomic, @Param("dsplaza") String dsplaza, @Param("cdprov") String cdprov,
    		@Param("cdnacion") String cdnacion, @Param("dsresto") String dsresto, @Param("idsucurba") Integer idsucurba);	
}