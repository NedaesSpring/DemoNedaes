///*******

package nedaes.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nedaes.demo.model.HabilitacionBancaria;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IHabilitacionBancariaRepository extends JpaRepository<HabilitacionBancaria, Integer> {

	@Query("SELECT h FROM HabilitacionBancaria h WHERE (UPPER(h.cdhabil) = UPPER(:cdhabil))")
	HabilitacionBancaria existeHabilitacion(@Param("cdhabil") String cdhabil);
	
	@Transactional
	@Modifying
	@Query("UPDATE HabilitacionBancaria h SET "
			+ "h.cdhabil = :cdhabil, "
			+ "h.cdident = :cdident, "
//			+ "h.banco.idbanco = :idbanco, "
//			+ "h.sucurba.idsucurba = :idsucurba, "       
			+ "h.cdcuenta = :cdcuenta, " 
			+ "h.cdcodee = :cdcodee, "	
			+ "h.cdbic = :cdbic, " 
			+ "h.otchetra = :otchetra, "			
			+ "h.otorden = :otorden,   " 
			+ "h.cdgastos = :cdgastos, "
			+ "h.suford = :suford, "
			+ "h.otidentinst = :otidentinst, "
			+ "h.cdpropct = :cdpropct, "
			+ "h.cdcargo = :cdcargo, "
			+ "h.cdemisorbde = :cdemisorbde, "
			+ "h.dsmsgidxml = :dsmsgidxml, "
			+ "h.cdinstrprty = :cdinstrprty, "
			+ "h.cddlvrymtd = :cddlvrymtd, "
			+ "h.cdcruzado = :cdcruzado, "
			+ "h.cdemicarta = :cdemicarta, "
			+ "h.cdhacien = :cdhacien, "
			+ "h.delhac.cddelhac = :cddelhac, "    
			+ "h.cdadmon = :cdadmon, "
			+ "h.nmtelef = :nmtelef, "
			+ "h.dsmunic = :dsmunic, "
			+ "h.nmlicen = :nmlicen, "
			+ "h.cdemailhab = :cdemailhab, " 
			+ "h.cengest = :cengest, "
			+ "h.cendir = :cendir, "
			+ "h.cengestesoro = :cengestesoro, "
			+ "h.otfictesoro = :otfictesoro, "
			+ "h.cdipfunciona = :cdipfunciona, "
			+ "h.cdusufunciona = :cdusufunciona, "
			+ "h.cdpasswdfunciona = :cdpasswdfunciona, "
			+ "h.cddirdesfunciona = :cddirdesfunciona "			
			+ " where h.idHabilitacion = :idHabilitacion")
	int actualizarHabilitacion(@Param("idHabilitacion") Integer idHabilitacion, @Param("cdhabil") String cdhabil,
			@Param("cdident") String cdident, 
//			@Param("idbanco") Integer idbanco, @Param("idsucurba") Integer idsucurba,
			@Param("cdcuenta") String cdcuenta, @Param ("cdcodee") String cdcodee, @Param ("cdbic") String cdbic,			
			@Param ("otchetra") String otchetra, @Param ("otorden") String  otorden, 
			@Param ("cdgastos") Integer cdgastos , @Param ("suford") String suford , @Param ("otidentinst") String otidentinst,
			@Param ("cdpropct") String cdpropct , @Param ("cdcargo") String cdcargo , @Param ("cdemisorbde") Integer cdemisorbde, @Param ("dsmsgidxml") String dsmsgidxml,
			@Param ("cdinstrprty") String cdinstrprty, @Param ("cddlvrymtd") String cddlvrymtd,	@Param ("cdcruzado") String cdcruzado, @Param ("cdemicarta") String cdemicarta,
			@Param ("cdhacien") String cdhacien, @Param ("cddelhac") Integer cddelhac , @Param ("cdadmon") String cdadmon , @Param ("nmtelef") String nmtelef, 
			@Param ("dsmunic") String  dsmunic, @Param ("nmlicen") String nmlicen,	@Param ("cdemailhab") String  cdemailhab, @Param ("cengest") String cengest, 
			@Param ("cendir") String cendir, @Param ("cengestesoro") String cengestesoro, @Param("otfictesoro") String otfictesoro, @Param("cdipfunciona") String cdipfunciona,
			@Param ("cdusufunciona") String cdusufunciona, @Param ("cdpasswdfunciona") String cdpasswdfunciona, 
			@Param ("cddirdesfunciona") String cddirdesfunciona
			);
}