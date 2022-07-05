package nedaes.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Table(name = "THABILIT")
public class HabilitacionBancaria implements Serializable{
	private static final long serialVersionUID = -2517851941873251688L;

	@Id
	@GeneratedValue(generator="THABILIT_SEQ") 
	@SequenceGenerator(name="THABILIT_SEQ",sequenceName="THABILIT_SEQ", allocationSize=1)
	@Column(name="IDTHABILIT")
	private Integer idHabilitacion;

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull(message="El codigo de hablitación no puede estar vacío")
	@Column(name="CDHABIL", length=3)	
	private String cdhabil;

	@Column(name="CDBANCO", length=4)	
	private String cdbanco;

	@Column(name="CDSUCUR", length=4)	
	private String cdsucur;
	
	@Column(name = "IBAN", length = 36)
	private String iban;
	
//	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TSUCURBA_HABILIT"), value ={@JoinColumn(name = "IDTSUCURBA", referencedColumnName = "IDTSUCURBA") })
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TSUCURBA2_THABILIT"), value = 
        {@JoinColumn(name = "CDBANCO", referencedColumnName = "CDBANCO", nullable = false, insertable = false, updatable = false),
		 @JoinColumn(name = "CDSUCUR", referencedColumnName = "CDSUCUR", nullable = false, insertable = false, updatable = false )})	
	private Sucurba sucurba;
	
    //fk q relaciona cdbancos de habilit con cdbancos de bancos
//	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TBANCOS_THABILIT"), value = {@JoinColumn(name = "IDTBANCOS", referencedColumnName = "IDTBANCOS", nullable = false, insertable = false, updatable = false ) })
	@NotNull(message="El banco no puede estar vacío")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TBANCOS2_THABILIT"), value = {@JoinColumn(name = "CDBANCO", referencedColumnName = "CDBANCO", nullable = false, insertable = false, updatable = false ) })	
	private Banco banco;

	//fk q relaciona cddelhac de habilitacion con cddelhac de la tabla delhac
//	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TDELHAC_THABILIT"), value = {@JoinColumn(name = "IDTDELHAC", referencedColumnName = "IDTDELHAC") })
	@NotNull(message="el campo cddelhac no puede estar vacío")
	@ManyToOne(fetch =  FetchType.EAGER)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TDELHAC2_THABILIT"), value = { @JoinColumn(name = "CDDELHAC", referencedColumnName = "CDDELHAC", nullable = false, insertable = false, updatable = false ) })	
	private Delhac delhac;

	@Pattern(regexp = "[0-9]{8}([A-Z]|[a-z]){1}", message = "Debe introducir un CIF/NIF con formato correcto")
	@NotNull(message = "El CIF/NIF no puede estar vacío")
	@Column(name = "cdident", length = 10)
	private String cdident;

	@NotNull(message = "La Cuenta no puede estar vacía")
	@Column(name = "cdcuenta", length = 10)
	private String cdcuenta;

	@Column(name = "otchetra", length = 1)
	private String otchetra;

	@NotNull(message = "El CIF/NIF de la Delegacion de Hacienda no puede estar vacía")
	@Pattern(regexp = "[0-9]{8}([A-Z]|[a-z]){1}", message = "Debe introducir un CIF/NIF con formato correcto")
	@Column(name = "cdhacien", length = 9)
	private String cdhacien;

	@NotNull(message = "El codigo de la Delegacion de Hacienda no puede estar vacía")
	@Column(name = "cdadmon", length = 3)
	private String cdadmon;

	@NotNull(message = "El municipio no puede estar vacío")
	@Column(name = "dsmunic", length = 12)
	private String dsmunic;

	@NotNull(message = "El número de contacto no puede estar vacío")
	@Pattern(regexp = "[0-9]{9}", message = "Debe introducir un número de teléfono con formato correcto y sin espacios (999999999)")
	@Column(name = "nmtelef", length = 9)
	private String nmtelef;

	@Column(name = "nmlicen", nullable = true, length = 6)
	private String nmlicen;

	@Column(name = "otorden", length = 1)
	private String otorden;

	@Column(name = "cdgastos", nullable = true, length = 1)
	private Integer cdgastos;

	@Column(name = "cengest", nullable = true, length = 5)
	private String cengest;

	@Column(name = "cendir", nullable = true, length = 1)
	private String cendir;

	@Column(name = "cdipfunciona", nullable = true, length = 15)
	private String cdipfunciona;

	@Column(name = "cdusufunciona", nullable = true, length = 8)
	private String cdusufunciona;

	@Column(name = "cdpasswdfunciona", nullable = true, length = 8)
	private String cdpasswdfunciona;

	@Column(name = "cddirdesfunciona", nullable = true, length = 50)
	private String cddirdesfunciona;

	@Column(name = "cdbic", nullable = true, length = 11)
	private String cdbic;

	@Column(name = "cengestesoro", nullable = true, length = 5)
	private String cengestesoro;

	@Column(name = "otfictesoro", insertable = true, length = 1)
	private String otfictesoro;

	@Column(name = "suford", insertable = true, length = 3)
	private String suford;

	@Column(name = "cdemisorbde", nullable = true, length = 5)
	private Integer cdemisorbde;

	@Column(name = "cdcargo", insertable = true, length = 1)
	private String cdcargo;

	@Column(name = "otidentinst", insertable = true, length = 1)
	private String otidentinst;

	@Column(name = "cdpropct", insertable = true, length = 1)
	private String cdpropct;

	@Column(name = "dsmsgidxml", insertable = true, length = 35)
	private String dsmsgidxml;

	@Column(name = "cddlvrymtd", nullable = true, length = 4)
	private String cddlvrymtd;

	@Column(name = "cdinstrprty", nullable = true, length = 4)
	private String cdinstrprty;

	@Column(name = "cdcruzado", nullable = true, length = 1)
	private String cdcruzado;

	@Column(name = "cdemicarta", nullable = true, length = 1)
	private String cdemicarta;

	@Column(name = "cdcodee", nullable = true, length = 2)
	private String cdcodee;

	@Email(message = "Debe introducir una única dirección de correo electrónico con formato correcto (prueba@correo.com)")
	@Column(name = "cdemailhab", nullable = true, length = 50)
	private String cdemailhab;

	@Column(name = "cdprefijiban", nullable = true, length = 4)
	private String cdprefijiban;

	public HabilitacionBancaria() {
		super();
	}

	public Integer getIdHabilitacion() {
		return idHabilitacion;
	}

	public void setIdHabilitacion(Integer idHabilitacion) {
		this.idHabilitacion = idHabilitacion;
	}

	public String getCdhabil() {
		return cdhabil;
	}

	public void setCdhabil(String cdhabil) {
		this.cdhabil = cdhabil;
	}

	public String getCdbanco() {
		return cdbanco;
	}

	public void setCdbanco(String cdbanco) {
		this.cdbanco = cdbanco;
	}

	public String getCdsucur() {
		return cdsucur;
	}

	public void setCdsucur(String cdsucur) {
		this.cdsucur = cdsucur;
	}

	public Sucurba getSucurba() {
		return sucurba;
	}

	public void setSucurba(Sucurba sucurba) {
		this.sucurba = sucurba;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Delhac getDelhac() {
		return delhac;
	}

	public void setDelhac(Delhac delhac) {
		this.delhac = delhac;
	}

	public String getCdident() {
		return cdident;
	}

	public void setCdident(String cdident) {
		this.cdident = cdident;
	}

	public String getCdcuenta() {
		return cdcuenta;
	}

	public void setCdcuenta(String cdcuenta) {
		this.cdcuenta = cdcuenta;
	}

	public String getOtchetra() {
		return otchetra;
	}

	public void setOtchetra(String otchetra) {
		this.otchetra = otchetra;
	}

	public String getCdhacien() {
		return cdhacien;
	}

	public void setCdhacien(String cdhacien) {
		this.cdhacien = cdhacien;
	}

	public String getCdadmon() {
		return cdadmon;
	}

	public void setCdadmon(String cdadmon) {
		this.cdadmon = cdadmon;
	}

	public String getDsmunic() {
		return dsmunic;
	}

	public void setDsmunic(String dsmunic) {
		this.dsmunic = dsmunic;
	}

	public String getNmtelef() {
		return nmtelef;
	}

	public void setNmtelef(String nmtelef) {
		this.nmtelef = nmtelef;
	}

	public String getNmlicen() {
		return nmlicen;
	}

	public void setNmlicen(String nmlicen) {
		this.nmlicen = nmlicen;
	}

	public String getOtorden() {
		return otorden;
	}

	public void setOtorden(String otorden) {
		this.otorden = otorden;
	}

	public Integer getCdgastos() {
		return cdgastos;
	}

	public void setCdgastos(Integer cdgastos) {
		this.cdgastos = cdgastos;
	}

	public String getCengest() {
		return cengest;
	}

	public void setCengest(String cengest) {
		this.cengest = cengest;
	}

	public String getCendir() {
		return cendir;
	}

	public void setCendir(String cendir) {
		this.cendir = cendir;
	}

	public String getCdipfunciona() {
		return cdipfunciona;
	}

	public void setCdipfunciona(String cdipfunciona) {
		this.cdipfunciona = cdipfunciona;
	}

	public String getCdusufunciona() {
		return cdusufunciona;
	}

	public void setCdusufunciona(String cdusufunciona) {
		this.cdusufunciona = cdusufunciona;
	}

	public String getCdpasswdfunciona() {
		return cdpasswdfunciona;
	}

	public void setCdpasswdfunciona(String cdpasswdfunciona) {
		this.cdpasswdfunciona = cdpasswdfunciona;
	}

	public String getCddirdesfunciona() {
		return cddirdesfunciona;
	}

	public void setCddirdesfunciona(String cddirdesfunciona) {
		this.cddirdesfunciona = cddirdesfunciona;
	}

	public String getCdbic() {
		return cdbic;
	}

	public void setCdbic(String cdbic) {
		this.cdbic = cdbic;
	}

	public String getCengestesoro() {
		return cengestesoro;
	}

	public void setCengestesoro(String cengestesoro) {
		this.cengestesoro = cengestesoro;
	}

	public String getOtfictesoro() {
		return otfictesoro;
	}

	public void setOtfictesoro(String otfictesoro) {
		this.otfictesoro = otfictesoro;
	}

	public String getSuford() {
		return suford;
	}

	public void setSuford(String suford) {
		this.suford = suford;
	}

	public Integer getCdemisorbde() {
		return cdemisorbde;
	}

	public void setCdemisorbde(Integer cdemisorbde) {
		this.cdemisorbde = cdemisorbde;
	}

	public String getCdcargo() {
		return cdcargo;
	}

	public void setCdcargo(String cdcargo) {
		this.cdcargo = cdcargo;
	}

	public String getOtidentinst() {
		return otidentinst;
	}

	public void setOtidentinst(String otidentinst) {
		this.otidentinst = otidentinst;
	}

	public String getCdpropct() {
		return cdpropct;
	}

	public void setCdpropct(String cdpropct) {
		this.cdpropct = cdpropct;
	}

	public String getDsmsgidxml() {
		return dsmsgidxml;
	}

	public void setDsmsgidxml(String dsmsgidxml) {
		this.dsmsgidxml = dsmsgidxml;
	}

	public String getCddlvrymtd() {
		return cddlvrymtd;
	}

	public void setCddlvrymtd(String cddlvrymtd) {
		this.cddlvrymtd = cddlvrymtd;
	}

	public String getCdinstrprty() {
		return cdinstrprty;
	}

	public void setCdinstrprty(String cdinstrprty) {
		this.cdinstrprty = cdinstrprty;
	}

	public String getCdcruzado() {
		return cdcruzado;
	}

	public void setCdcruzado(String cdcruzado) {
		this.cdcruzado = cdcruzado;
	}

	public String getCdemicarta() {
		return cdemicarta;
	}

	public void setCdemicarta(String cdemicarta) {
		this.cdemicarta = cdemicarta;
	}

	public String getCdcodee() {
		return cdcodee;
	}

	public void setCdcodee(String cdcodee) {
		this.cdcodee = cdcodee;
	}

	public String getCdemailhab() {
		return cdemailhab;
	}

	public void setCdemailhab(String cdemailhab) {
		this.cdemailhab = cdemailhab;
	}

	public String getCdprefijiban() {
		return cdprefijiban;
	}

	public void setCdprefijiban(String cdprefijiban) {
		this.cdprefijiban = cdprefijiban;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public HabilitacionBancaria(Integer idHabilitacion, String cdhabil, String cdbanco, String cdsucur, String iban,
			Sucurba sucurba, @NotNull(message = "el campo cdbanco no puede estar vacío") Banco banco,
			@NotNull(message = "el campo cddelhac no puede estar vacío") Delhac delhac,
			@Pattern(regexp = "[0-9]{8}([A-Z]|[a-z]){1}", message = "Debe introducir un CIF/NIF con formato correcto") String cdident,
			String cdcuenta, String otchetra,
			@Pattern(regexp = "[0-9]{8}([A-Z]|[a-z]){1}", message = "Debe introducir un CIF/NIF con formato correcto") String cdhacien,
			String cdadmon, String dsmunic, String nmtelef, String nmlicen, String otorden, Integer cdgastos,
			String cengest, String cendir, String cdipfunciona, String cdusufunciona, String cdpasswdfunciona,
			String cddirdesfunciona, String cdbic, String cengestesoro, String otfictesoro, String suford,
			Integer cdemisorbde, String cdcargo, String otidentinst, String cdpropct, String dsmsgidxml,
			String cddlvrymtd, String cdinstrprty, String cdcruzado, String cdemicarta, String cdcodee,
			@Email(message = "Debe introducir una única dirección de correo electrónico con formato correcto (prueba@correo.com)") String cdemailhab,
			String cdprefijiban) {
		super();
		this.idHabilitacion = idHabilitacion;
		this.cdhabil = cdhabil;
		this.cdbanco = cdbanco;
		this.cdsucur = cdsucur;
		this.iban = iban;
		this.sucurba = sucurba;
		this.banco = banco;
		this.delhac = delhac;
		this.cdident = cdident;
		this.cdcuenta = cdcuenta;
		this.otchetra = otchetra;
		this.cdhacien = cdhacien;
		this.cdadmon = cdadmon;
		this.dsmunic = dsmunic;
		this.nmtelef = nmtelef;
		this.nmlicen = nmlicen;
		this.otorden = otorden;
		this.cdgastos = cdgastos;
		this.cengest = cengest;
		this.cendir = cendir;
		this.cdipfunciona = cdipfunciona;
		this.cdusufunciona = cdusufunciona;
		this.cdpasswdfunciona = cdpasswdfunciona;
		this.cddirdesfunciona = cddirdesfunciona;
		this.cdbic = cdbic;
		this.cengestesoro = cengestesoro;
		this.otfictesoro = otfictesoro;
		this.suford = suford;
		this.cdemisorbde = cdemisorbde;
		this.cdcargo = cdcargo;
		this.otidentinst = otidentinst;
		this.cdpropct = cdpropct;
		this.dsmsgidxml = dsmsgidxml;
		this.cddlvrymtd = cddlvrymtd;
		this.cdinstrprty = cdinstrprty;
		this.cdcruzado = cdcruzado;
		this.cdemicarta = cdemicarta;
		this.cdcodee = cdcodee;
		this.cdemailhab = cdemailhab;
		this.cdprefijiban = cdprefijiban;
	}

	@Override
	public String toString() {
		return "HabilitacionBancaria [idHabilitacion=" + idHabilitacion + ", cdhabil=" + cdhabil + ", cdbanco="
				+ cdbanco + ", cdsucur=" + cdsucur + ", iban=" + iban + ", sucurba=" + sucurba + ", banco=" + banco
				+ ", delhac=" + delhac + ", cdident=" + cdident + ", cdcuenta=" + cdcuenta + ", otchetra=" + otchetra
				+ ", cdhacien=" + cdhacien + ", cdadmon=" + cdadmon + ", dsmunic=" + dsmunic + ", nmtelef=" + nmtelef
				+ ", nmlicen=" + nmlicen + ", otorden=" + otorden + ", cdgastos=" + cdgastos + ", cengest=" + cengest
				+ ", cendir=" + cendir + ", cdipfunciona=" + cdipfunciona + ", cdusufunciona=" + cdusufunciona
				+ ", cdpasswdfunciona=" + cdpasswdfunciona + ", cddirdesfunciona=" + cddirdesfunciona + ", cdbic="
				+ cdbic + ", cengestesoro=" + cengestesoro + ", otfictesoro=" + otfictesoro + ", suford=" + suford
				+ ", cdemisorbde=" + cdemisorbde + ", cdcargo=" + cdcargo + ", otidentinst=" + otidentinst
				+ ", cdpropct=" + cdpropct + ", dsmsgidxml=" + dsmsgidxml + ", cddlvrymtd=" + cddlvrymtd
				+ ", cdinstrprty=" + cdinstrprty + ", cdcruzado=" + cdcruzado + ", cdemicarta=" + cdemicarta
				+ ", cdcodee=" + cdcodee + ", cdemailhab=" + cdemailhab + ", cdprefijiban=" + cdprefijiban + "]";
	}
}
