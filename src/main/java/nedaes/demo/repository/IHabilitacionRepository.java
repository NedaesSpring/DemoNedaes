package nedaes.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nedaes.demo.model.Habilitacion;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IHabilitacionRepository extends JpaRepository<Habilitacion, Integer> {

	@Query("SELECT h FROM Habilitacion h WHERE (:cdhabil is null or h.cdhabil like %:cdhabil%) and (:dsorg is null or h.dsorg like %:dsorg%) and (:dscentro is null or h.dscentro like %:dscentro%)" 
			   + " and (:cdprov is null or h.provinc.cdprov = :cdprov) and (:cddelhac is null or h.delhac.cddelhac = :cddelhac) and (:idsigdom is null or h.sigdom.idsigdom = :idsigdom)"
			   + " and (:idbanco is null or h.banco.idbanco = :idbanco) and (:idlocalid is null or h.localid.idlocalid = :idlocalid) and (:idsucurba is null or h.sucurba.idsucurba = :idsucurba) ")
	List<Habilitacion> buscarHabilitacionesPorFiltro(@Param("cdhabil") String cdhabil, @Param("dsorg") String dsorg, @Param("dscentro") String dscentro, @Param("cdprov") Integer cdprov, @Param("cddelhac") Integer cddelhac, @Param("idsigdom") Integer idsigdom,  @Param("idbanco") Integer idbanco, @Param("idlocalid") Integer idlocalid, @Param("idsucurba") Integer idsucurba);

	@Query("SELECT h FROM Habilitacion h WHERE (:cdhabil is null or h.cdhabil like %:cdhabil%) and (:dsorg is null or h.dsorg like %:dsorg%) and (:dscentro is null or h.dscentro like %:dscentro%)" 
			   + " and (:cdprov is null or h.provinc.cdprov = :cdprov) and (:cddelhac is null or h.delhac.cddelhac = :cddelhac) and (:idsigdom is null or h.sigdom.idsigdom = :idsigdom)"
			   + " and (:idbanco is null or h.banco.idbanco = :idbanco) and (:idlocalid is null or h.localid.idlocalid = :idlocalid) and (:idsucurba is null or h.sucurba.idsucurba = :idsucurba) ")
	Page<Habilitacion> buscarHabilitacionesPorFiltroPageable(@Param("cdhabil") String cdhabil, @Param("dsorg") String dsorg, @Param("dscentro") String dscentro, @Param("cdprov") Integer cdprov, @Param("cddelhac") Integer cddelhac, @Param("idsigdom") Integer idsigdom,  @Param("idbanco") Integer idbanco, @Param("idlocalid") Integer idlocalid, @Param("idsucurba") Integer idsucurba, Pageable pageable);

	@Query("SELECT h FROM Habilitacion h WHERE (:idHabilitacion is null or h.idHabilitacion = :idHabilitacion) and (h.provinc.cdprov = :cdprov) and (h.cdhabil= :cdhabil) and (h.dsorg= :dsorg)")
	Page<Habilitacion> findByParameters(@Param("idHabilitacion") Integer idHabilitacion, @Param("cdhabil") String cdhabil,	@Param("dsorg") String dsorg, @Param("cdprov") Integer cdprov, Pageable pageable);

	@Query("SELECT h FROM Habilitacion h WHERE (UPPER(h.cdhabil) = UPPER(:cdhabil))")
	Habilitacion existeHabilitacion(@Param("cdhabil") String cdhabil);
	
	@Query("SELECT COUNT(h) FROM Habilitacion h WHERE (UPPER(h.cdhabil) = UPPER(:cdhabil)) and (UPPER(h.dsorg) = UPPER(:dsorg))")
	Integer existeHabilitacionCount(@Param("cdhabil") String cdhabil, @Param("dsorg") String dsorg);

	@Query("SELECT h FROM Habilitacion h WHERE (UPPER(h.cdhabil) = UPPER(:cdhabil)) and (UPPER(h.dsorg) = UPPER(:dsorg))")
	Habilitacion findByNombre(@Param("cdhabil") String cdhabil, @Param("dsorg") String dsorg);

	@Query("SELECT h FROM Habilitacion h order by h.cdhabil")
	Page<Habilitacion> BuscarTodasPageable(Pageable pageable);
	
	@Transactional
	@Modifying
	@Query("UPDATE Habilitacion h SET "
			+ "h.cdhabil = :cdhabil, "
			+ "h.dscentro = :dscentro, "
			+ "h.dsorg = :dsorg, h.dsorgext = :dsorgext, "
			+ "h.delhac.cddelhac = :cddelhac, h.provinc.cdprov = :cdprov, h.sigdom.idsigdom = :idsigdom, h.banco.idbanco = :idbanco, h.localid.idlocalid = :idlocalid, h.sucurba.idsucurba = :idsucurba,"
			+ "h.cdsiglas = :cdsiglas, h.cdsucur = :cdsucur, h.cdloc = :cdloc, h.cdbanco = :cdbanco, h.dscalle = :dscalle, h.dsnumero = :dsnumero, h.cdpostal = :cdpostal, h.dshabil = :dshabil, h.dssuplen = :dssuplen, h.nomcert = :nomcert, h.nombre = :nombre, "
			+ "h.apellido1 = :apellido1, h.apellido2 = :apellido2, h.carcert = :carcert, h.nmtelefcert = :nmtelefcert, h.nmfaxcert = :nmfaxcert, h.cddnom = :cddnom, h.cddvar = :cddvar, h.cddrec = :cddrec, "
			+ "h.otcon10 = :otcon10, h.otc10_rdl202012 = :otc10_rdl202012, h.otpacepro = :otpacepro, h.cdraapp = :cdraapp, h.cdssperso = :cdssperso, h.nmmaxanxaapp = :nmmaxanxaapp, h.nmaappanx = :nmaappanx, h.nmmaxanxdes = :nmmaxanxdes, "
			+ "h.ottelcon1 = :ottelcon1, h.otrecibi = :otrecibi, h.cddnisigp = :cddnisigp, h.cdususigp = :cdususigp, "
			
+ "h.cdident = :cdident, "
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
+ "h.cddirdesfunciona = :cddirdesfunciona, "		

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

			
			+ "where h.idHabilitacion = :idHabilitacion")
	int actualizarHabilitacion(@Param("idHabilitacion") Integer idHabilitacion,
			@Param("cdhabil") String cdhabil, @Param("dsorg") String dsorg, @Param("dsorgext") String dsorgext, @Param("dscentro") String dscentro, @Param("cddelhac") Integer cddelhac, @Param("cdprov") Integer cdprov, @Param("idsigdom") Integer idsigdom,  @Param("idbanco") Integer idbanco, @Param("idlocalid") Integer idlocalid, @Param("idsucurba") Integer idsucurba,
			@Param("cdsiglas") String cdsiglas, @Param("cdsucur") String cdsucur, @Param("cdloc") String cdloc, @Param("cdbanco") String cdbanco, 
			@Param("dscalle") String dscalle, @Param("dsnumero") String dsnumero,  @Param("cdpostal") String cdpostal, @Param("dshabil") String dshabil, @Param("dssuplen") String dssuplen, @Param("nomcert") String nomcert, @Param("nombre") String nombre, 
			@Param("apellido1") String apellido1,  @Param("apellido2") String apellido2, @Param("carcert") String carcert, @Param("nmtelefcert") String nmtelefcert, @Param("nmfaxcert") String nmfaxcert, 
			@Param("cddnom") Integer cddnom, @Param("cddvar") Integer cddvar, @Param("cddrec") Integer cddrec,
			@Param("otcon10") String otcon10, @Param("otc10_rdl202012") String otc10_rdl202012, @Param("otpacepro") String otpacepro,
			@Param("cdraapp") String cdraapp, @Param("cdssperso") String cdssperso, @Param("nmmaxanxaapp") Integer nmmaxanxaapp,
			@Param("nmaappanx") Integer nmaappanx, @Param("nmmaxanxdes") Integer nmmaxanxdes, @Param("ottelcon1") String ottelcon1,
			@Param("otrecibi") String otrecibi, @Param("cddnisigp") String cddnisigp,
			@Param("cdususigp") String cdususigp,
			
			@Param("cdident") String cdident, @Param("cdcuenta") String cdcuenta, @Param ("cdcodee") String cdcodee, @Param ("cdbic") String cdbic,			
			@Param ("otchetra") String otchetra, @Param ("otorden") String  otorden, 
			@Param ("cdgastos") Integer cdgastos , @Param ("suford") String suford , @Param ("otidentinst") String otidentinst,
			@Param ("cdpropct") String cdpropct , @Param ("cdcargo") String cdcargo , @Param ("cdemisorbde") Integer cdemisorbde, @Param ("dsmsgidxml") String dsmsgidxml,
			@Param ("cdinstrprty") String cdinstrprty, @Param ("cddlvrymtd") String cddlvrymtd,	@Param ("cdcruzado") String cdcruzado, @Param ("cdemicarta") String cdemicarta,
			@Param ("cdhacien") String cdhacien, @Param ("cdadmon") String cdadmon , @Param ("nmtelef") String nmtelef, 
			@Param ("dsmunic") String  dsmunic, @Param ("nmlicen") String nmlicen,	@Param ("cdemailhab") String  cdemailhab, @Param ("cengest") String cengest, 
			@Param ("cendir") String cendir, @Param ("cengestesoro") String cengestesoro, @Param("otfictesoro") String otfictesoro, @Param("cdipfunciona") String cdipfunciona,
			@Param ("cdusufunciona") String cdusufunciona, @Param ("cdpasswdfunciona") String cdpasswdfunciona, 
			@Param ("cddirdesfunciona") String cddirdesfunciona,
			
			
			@Param("cdidmuf") String cdidmuf, @Param("cdorgmuf") String cdorgmuf, @Param("cdordmuf") String cdordmuf, @Param("cdistipadm") String cdistipadm,
			@Param("dsisretap1") String dsisretap1, @Param("dsisretap2") String dsisretap2, @Param("dsisretnom") String dsisretnom,
			@Param("dsisordap1") String dsisordap1, @Param("dsisordap2") String dsisordap2, @Param("dsisordnom") String dsisordnom,
			@Param("cdmujorg") String cdmujorg, @Param("dsmujorg") String dsmujorg, @Param("cdmujger") String cdmujger,
			@Param("dsmujger") String dsmujger, @Param("cdautoriz") Integer cdautoriz, @Param("feautoriz") Integer feautoriz,
			@Param("dsautoriz") String dsautoriz, @Param("txtc11") String txtc11, @Param("txtc12") String txtc12,
			@Param("txtc13") String txtc13, @Param("txtc14") String txtc14
			);
}


