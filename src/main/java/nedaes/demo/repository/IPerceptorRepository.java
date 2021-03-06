package nedaes.demo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nedaes.demo.model.Perceptor;

@Repository
public interface IPerceptorRepository extends JpaRepository<Perceptor,Integer> {

	@Query("SELECT p FROM Perceptor p WHERE (:nombre is null or p.nombre like %:nombre%) and (:dsapell1 is null or p.dsapell1 like %:dsapell1%)  and (:dsapell2 is null or p.dsapell2 like %:dsapell2%) and (:dni is null or p.dni = :dni) and (:dup is null or p.dup = :dup) and (:cn is null or p.cn = :cn) and (:hab is null or p.hab = :hab) "
			+ "and (:idbperadm is null or  p.bperadm.idbperadm = :idbperadm) "
			+ "and (:idProvincia is null or  provincia.idProvincia = :idProvincia) and "
			+ "(:idClasenomina is null or clasenomina.idClasenomina = :idClasenomina) and (:idHabilitacion is null or habilitacion.idHabilitacion = :idHabilitacion) "
			+ "and (:idbperban is null or  p.bperban.idbperban = :idbperban) and p.bperban.idbperban is not null")	
	List<Perceptor> buscarPerceptoresPorFiltro(@Param("nombre") String nombre, @Param("dsapell1") String dsapell1, @Param("dsapell2") String dsapell2, @Param("dni") String dni, @Param("dup") String dup, @Param("cn") String cn, @Param("hab") String hab, 
			@Param("idbperadm") Integer idbperadm, Integer idProvincia, Integer idClasenomina, Integer idHabilitacion, @Param("idbperban") Integer idbperban);
                
	@Query("SELECT p FROM Perceptor p WHERE (:nombre is null or p.nombre like %:nombre%) and (:dsapell1 is null or p.dsapell1 like %:dsapell1%)  and (:dsapell2 is null or p.dsapell2 like %:dsapell2%) and (:dni is null or p.dni = :dni) and (:dup is null or p.dup = :dup) and (:cn is null or p.cn = :cn) and (:hab is null or p.hab = :hab) "
			+ "and (:idbperadm is null or  p.bperadm.idbperadm = :idbperadm) "
			+ "and (:idProvincia is null or  provincia.idProvincia = :idProvincia) and "
			+ "(:idClasenomina is null or clasenomina.idClasenomina = :idClasenomina) and (:idHabilitacion is null or habilitacion.idHabilitacion = :idHabilitacion) "
			+ "and (:idbperban is null or  p.bperban.idbperban = :idbperban) and p.bperban.idbperban is not null")	
	Page<Perceptor> buscarPerceptoresPorFiltroPageable(@Param("nombre") String nombre, @Param("dsapell1") String dsapell1,  @Param("dsapell2") String dsapell2, @Param("dni") String dni, @Param("dup") String dup, @Param("cn") String cn, @Param("hab") String hab, 
			@Param("idbperadm") Integer idbperadm, Integer idProvincia, Integer idClasenomina, Integer idHabilitacion, @Param("idbperban") Integer idbperban, Pageable pageable);

	@Query("SELECT p FROM Perceptor p WHERE (:idPerceptor is null or p.idPerceptor = :idPerceptor) and (p.provincia.idProvincia = :idProvincia) and (p.nombre= :nombre) and (p.dsapell1= :dsapell1) and (p.dsapell2= :dsapell2)")
	Page<Perceptor> findByParameters(@Param("idPerceptor") Integer idPerceptor, @Param("idProvincia") Integer idProvincia, @Param("nombre") String nombre, @Param("dsapell1") String dsapell1,  @Param("dsapell2") String dsapell2, Pageable pageable);

	@Query("SELECT p FROM Perceptor p WHERE (UPPER(p.nombre) = UPPER(:nombre)) and (UPPER(p.dsapell1) = UPPER(:dsapell1)) and (UPPER(p.dsapell2) = UPPER(:dsapell2))")
	Perceptor existePerceptor(@Param("nombre") String nombre, @Param("dsapell1") String dsapell1, @Param("dsapell2") String dsapell2);

	@Transactional
    @Modifying
    @Query("UPDATE Perceptor p SET p.nombre = :nombre, p.dsapell1 = :dsapell1, p.dsapell2 = :dsapell2, p.cdsexo = :cdsexo, p.cddomnot = :cddomnot, p.cdforpag = :cdforpag, p.cdnumero = :cdnumero, p.dsviapub = :dsviapub, p.cdsiglas = :cdsiglas "
    // " , p.cdprov = :cdprov " 
    		+ " where p.idPerceptor = :idPerceptor")
    int actualizarPerceptor(@Param("nombre") String nombre, @Param("dsapell1") String dsapell1, @Param("dsapell2") String dsapell2, @Param("cdsexo") String cdsexo, @Param("cddomnot") String cddomnot, @Param("cdforpag") String cdforpag, @Param("cdnumero") String cdnumero, @Param("dsviapub") String dsviapub,@Param("cdsiglas") String cdsiglas,	
//    		@Param("idProvincia") Integer idProvincia,  @Param("cdprov") String cdprov,	
		@Param("idPerceptor") Integer idPerceptor);	
	
	@Query("SELECT COUNT(p) FROM Perceptor p WHERE (UPPER(p.nombre) = UPPER(:nombre)) and (UPPER(p.dsapell1) = UPPER(:dsapell1)) and (UPPER(p.dsapell2) = UPPER(:dsapell2))")
	Integer existePerceptorCount(@Param("nombre") String nombre, @Param("dsapell1") String dsapell1, @Param("dsapell2") String dsapell2);
	
	@Query("SELECT p FROM Perceptor p WHERE (:idProvincia is null or p.provincia.idProvincia = :idProvincia)")
	List<Perceptor> buscarProvinciaPorPerceptor(@Param("idProvincia") Integer idProvincia);
	
	@Query("SELECT p FROM Perceptor p WHERE (:idbperban is null or p.bperban.idbperban = :idbperban)")
	List<Perceptor> buscarBancoPorPerceptor(@Param("idbperban") Integer idbperban);

	@Query("SELECT p FROM Perceptor p WHERE (UPPER(p.nombre) = UPPER(:nombre)) and (UPPER(p.dsapell1) = UPPER(:dsapell1)) and (UPPER(p.dsapell2) = UPPER(:dsapell2))")
	Perceptor findByNombre(@Param("nombre") String nombre, @Param("dsapell1") String dsapell1, @Param("dsapell2") String dsapell2);

	@Query("SELECT p FROM Perceptor p WHERE (:idbanco is null  or p.bperban.banco.idbanco = :idbanco ) ")	
	Page<Perceptor> buscarPerceptoresPorIdbanco(@Param("idbanco") Integer idbanco, Pageable pageable);	
}