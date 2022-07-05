package nedaes.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nedaes.demo.model.HabilitacionPersonal;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IHabilitacionPersonalRepository extends JpaRepository<HabilitacionPersonal, Integer> {
	@Query("SELECT h FROM HabilitacionPersonal h WHERE (UPPER(h.cdhabil) = UPPER(:cdhabil))")
	HabilitacionPersonal existeHabilitacion(@Param("cdhabil") String cdhabil);
	
	@Transactional
	@Modifying
	@Query("UPDATE HabilitacionPersonal h SET "
			+ "h.cdhabil = :cdhabil, "
			+ "h.dscentro = :dscentro, "
			+ "h.dsorg = :dsorg, h.dsorgext = :dsorgext, "
			+ "h.delhac.cddelhac = :cddelhac, h.provinc.cdprov = :cdprov, h.sigdom.idsigdom = :idsigdom, h.banco.idbanco = :idbanco, h.localid.idlocalid = :idlocalid, h.sucurba.idsucurba = :idsucurba,"
			+ "h.cdsiglas = :cdsiglas, h.cdsucur = :cdsucur, h.cdloc = :cdloc, h.cdbanco = :cdbanco, h.dscalle = :dscalle, h.dsnumero = :dsnumero, h.cdpostal = :cdpostal, h.dshabil = :dshabil, h.dssuplen = :dssuplen, h.nomcert = :nomcert, h.nombre = :nombre, "
			+ "h.apellido1 = :apellido1, h.apellido2 = :apellido2, h.carcert = :carcert, h.nmtelefcert = :nmtelefcert, h.nmfaxcert = :nmfaxcert, h.cddnom = :cddnom, h.cddvar = :cddvar, h.cddrec = :cddrec, "
			+ "h.otcon10 = :otcon10, h.otc10_rdl202012 = :otc10_rdl202012, h.otpacepro = :otpacepro, h.cdraapp = :cdraapp, h.cdssperso = :cdssperso, h.nmmaxanxaapp = :nmmaxanxaapp, h.nmaappanx = :nmaappanx, h.nmmaxanxdes = :nmmaxanxdes, "
			+ "h.ottelcon1 = :ottelcon1, h.otrecibi = :otrecibi, h.cddnisigp = :cddnisigp, h.cdususigp = :cdususigp "
			+ "where h.idHabilitacion = :idHabilitacion")
	int actualizarHabilitacionPersonal(@Param("idHabilitacion") Integer idHabilitacion,
			@Param("cdhabil") String cdhabil, @Param("dsorg") String dsorg, @Param("dsorgext") String dsorgext, @Param("dscentro") String dscentro, @Param("cddelhac") Integer cddelhac, @Param("cdprov") Integer cdprov, @Param("idsigdom") Integer idsigdom,  @Param("idbanco") Integer idbanco, @Param("idlocalid") Integer idlocalid, @Param("idsucurba") Integer idsucurba,
			@Param("cdsiglas") String cdsiglas, @Param("cdsucur") String cdsucur, @Param("cdloc") String cdloc, @Param("cdbanco") String cdbanco, 
			@Param("dscalle") String dscalle, @Param("dsnumero") String dsnumero,  @Param("cdpostal") String cdpostal, @Param("dshabil") String dshabil, @Param("dssuplen") String dssuplen, @Param("nomcert") String nomcert, @Param("nombre") String nombre, 
			@Param("apellido1") String apellido1,  @Param("apellido2") String apellido2, @Param("carcert") String carcert, @Param("nmtelefcert") String nmtelefcert, @Param("nmfaxcert") String nmfaxcert, 
			@Param("cddnom") Integer cddnom, @Param("cddvar") Integer cddvar, @Param("cddrec") Integer cddrec,
			@Param("otcon10") String otcon10, @Param("otc10_rdl202012") String otc10_rdl202012, @Param("otpacepro") String otpacepro,
			@Param("cdraapp") String cdraapp, @Param("cdssperso") String cdssperso, @Param("nmmaxanxaapp") Integer nmmaxanxaapp,
			@Param("nmaappanx") Integer nmaappanx, @Param("nmmaxanxdes") Integer nmmaxanxdes, @Param("ottelcon1") String ottelcon1,
			@Param("otrecibi") String otrecibi, @Param("cddnisigp") String cddnisigp,
			@Param("cdususigp") String cdususigp
			);
}


