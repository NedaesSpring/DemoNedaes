///*******

package nedaes.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nedaes.demo.model.HabilitacionMutua;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IHabilitacionMutuaRepository extends JpaRepository<HabilitacionMutua, Integer> {
	@Query("SELECT h FROM HabilitacionMutua h WHERE (UPPER(h.cdhabil) = UPPER(:cdhabil))")
	HabilitacionMutua existeHabilitacion(@Param("cdhabil") String cdhabil);
	
	@Transactional
	@Modifying
	@Query("UPDATE HabilitacionMutua h SET "
			+ "h.cdidmuf = :cdidmuf, "
			+ "h.cdorgmuf = :cdorgmuf, "
			+ "h.cdordmuf = :cdordmuf, "
			+ "h.cdistipadm = :cdistipadm, "
			+ "h.dsisretap1 = :dsisretap1, "
			+ "h.dsisretap2 = :dsisretap2, "
			+ "h.dsisretnom = :dsisretnom, "
			+ "h.dsisordap1 = :dsisordap1, "
			+ "h.dsisordap2 = :dsisordap2, "
			+ "h.dsisordnom = :dsisordnom, "
			+ "h.cdmujorg = :cdmujorg, "
			+ "h.dsmujorg = :dsmujorg, "
			+ "h.cdmujger = :cdmujger, "
			+ "h.dsmujger = :dsmujger, "
			+ "h.cdautoriz = :cdautoriz, "
			+ "h.feautoriz = :feautoriz, "
			+ "h.dsautoriz = :dsautoriz, "
			+ "h.txtc11 = :txtc11, "
			+ "h.txtc12 = :txtc12, "
			+ "h.txtc13 = :txtc13, "
			+ "h.txtc14 = :txtc14 "	
			+ " where h.idHabilitacion = :idHabilitacion")
	int actualizarHabilitacion(@Param("idHabilitacion") Integer idHabilitacion, 
			@Param("cdidmuf") String cdidmuf, @Param("cdorgmuf") String cdorgmuf, @Param("cdordmuf") String cdordmuf, @Param("cdistipadm") String cdistipadm,
			@Param("dsisretap1") String dsisretap1, @Param("dsisretap2") String dsisretap2, @Param("dsisretnom") String dsisretnom,
			@Param("dsisordap1") String dsisordap1, @Param("dsisordap2") String dsisordap2, @Param("dsisordnom") String dsisordnom,
			@Param("cdmujorg") String cdmujorg, @Param("dsmujorg") String dsmujorg, @Param("cdmujger") String cdmujger,
			@Param("dsmujger") String dsmujger, @Param("cdautoriz") Integer cdautoriz, @Param("feautoriz") Integer feautoriz,
			@Param("dsautoriz") String dsautoriz, @Param("txtc11") String txtc11, @Param("txtc12") String txtc12,
			@Param("txtc13") String txtc13, @Param("txtc14") String txtc14);
}