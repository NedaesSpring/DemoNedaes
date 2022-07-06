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
@Table(name="THABILIT")
public class Habilitacion implements Serializable{
	private static final long serialVersionUID = -2517851941873251689L;

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

	@NotNull(message="La denominacion extensa no puede estar vacía")
	@Column(name="DSORGEXT", length= 60)	
	private String dsorgext;

	@NotNull(message="La denominacion no puede estar vacía")
	@Column(name="DSORG", length=36)	
	private String dsorg;

	@NotNull(message="El centro no puede estar vacío")
	@Column(name="DSCENTRO", length=60)	
	private String dscentro;

	@Column(name="CDSIGLAS", length=2)	
	private String cdsiglas;
	
	@Column(name="CDBANCO", length=4)	
	private String cdbanco;

	@Column(name="CDSUCUR", length=4)	
	private String cdsucur;
	
	//foreign key q relaciona cdsiglas de habilitacion con cdsiglas de la tabla sigdom
//	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TSIGDOM_HABILIT"), value = { @JoinColumn(name = "IDTSIGDOM", referencedColumnName = "IDTSIGDOM") })	
	@NotNull(message="El tipo vía no puede estar vacía")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TSIGDOM2_THABILIT"), value = { @JoinColumn(name = "CDSIGLAS", referencedColumnName = "CDSIGLAS", nullable = false, insertable = false, updatable = false ) })	
	private Sigdom sigdom;


	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TLOCALID_THABILIT"), value = {@JoinColumn(name = "IDTLOCALID", referencedColumnName = "IDTLOCALID") })	
	@NotNull(message="La localidad no puede estar vacía")
	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TLOCALID2_THABILIT"), value = 
//      {@JoinColumn(name = "CDPROV", referencedColumnName = "CDPROV", nullable = false, insertable = false, updatable = false ),
//    	@JoinColumn(name = "CDLOC", referencedColumnName = "CDLOC", nullable = false, insertable = false, updatable = false )})	
	private Localid localid;
	
	
//	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TSUCURBA_HABILIT"), value ={@JoinColumn(name = "IDTSUCURBA", referencedColumnName = "IDTSUCURBA") })	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TSUCURBA2_THABILIT"), value = 
       {@JoinColumn(name = "CDBANCO", referencedColumnName = "CDBANCO", nullable = false, insertable = false, updatable = false),
    	@JoinColumn(name = "CDSUCUR", referencedColumnName = "CDSUCUR", nullable = false, insertable = false, updatable = false)})	
	private Sucurba sucurba;
	
    //fk q relaciona cdbancos de habilit con cdbancos de bancos
//	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TBANCOS_THABILIT"), value = {@JoinColumn(name = "IDTBANCOS", referencedColumnName = "IDTBANCOS") })	
//	@Column(name="cdbanco", length=4)	
	@NotNull(message="El banco no puede estar vacío")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TBANCOS2_THABILIT"), value = {@JoinColumn(name = "CDBANCO", referencedColumnName = "CDBANCO", nullable = false, insertable = false, updatable = false ) })	
	private Banco banco;

	//fk q relaciona cddelhac de habilitacion con cddelhac de la tabla delhac
//	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TDELHAC_THABILIT"), value = { @JoinColumn(name = "IDTDELHAC", referencedColumnName = "IDTDELHAC") })	
	@NotNull(message="el campo cddelhac no puede estar vacío")
	@ManyToOne(fetch =  FetchType.EAGER)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TDELHAC2_THABILIT"), value = { @JoinColumn(name = "CDDELHAC", referencedColumnName = "CDDELHAC", nullable = false, insertable = false, updatable = false ) })	
	private Delhac delhac;

//	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TPROVINC_THABILIT"), value = {@JoinColumn(name = "IDTPROVINC", referencedColumnName = "IDTPROVINC") })	
	@NotNull(message="La provincia no puede estar vacía")
	@ManyToOne(fetch =  FetchType.EAGER)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TPROVINC2_THABILIT"), value = {@JoinColumn(name = "CDPROV", referencedColumnName = "CDPROV", nullable = false, insertable = false, updatable = false ) })	
	private Provinc provinc;
	

	@Column(name="nomcert", length=60)	
	private String nomcert;


	@NotNull(message="La calle no puede estar vacía")
	@Column(name="dscalle", length=21)	
	private String dscalle;

	@Column(name="dsnumero",nullable = true, length=5)	
	private String dsnumero;

	@NotNull(message="El código postal no puede estar vacío")
	@Column(name="cdpostal", length=5)	
	private String cdpostal;

	@Column(name="cdloc", length=3)	
	private String cdloc;
	
	@NotNull(message="El campo habilitado no puede estar vacío")
	@Column(name="dshabil", length=60)	
	private String dshabil;

	@Column(name="dssuplen", length=60)	
	private String dssuplen;

	@NotNull(message="El nombre no puede estar vacío")
	@Column(name="nombre", nullable = true, length=15)	
	private String nombre;

	@NotNull(message="El apellido1 no puede estar vacío")
	@Column(name="apellido1", nullable = true, length=20)	
	private String apellido1;

	@NotNull(message="El apellido2 no puede estar vacío")
	@Column(name="apellido2", nullable = true, length=20)	
	private String apellido2;
	
	@NotNull(message="El cargo no puede estar vacío")
	@Column(name="carcert", length=30)	
	private String carcert;

	@Pattern(regexp = "[0-9]{9}", message = "Debe introducir un número de teléfono con formato correcto y sin espacios (999999999)")
	@Column(name="nmtelefcert", nullable = true, length=9)	
	private String nmtelefcert;

	@Pattern(regexp = "[0-9]{9}", message = "Debe introducir un número de teléfono con formato correcto y sin espacios (999999999)")
	@Column(name="nmfaxcert", nullable = true, length=9)	
	private String nmfaxcert;


	@NotNull(message="El campo nómina no puede estar vacío")
	@Column(name="cddnom", nullable = true,length=1)	
	private Integer cddnom;

	@NotNull(message="El campo variaciones no puede estar vacío")
	@Column(name="cddvar",nullable = true, length=1)	
	private Integer cddvar;

	@NotNull(message="El campo recibo no puede estar vacío")
	@Column(name="cddrec",nullable = true, length=1)	
	private Integer cddrec;

	@Column(name="otcon10", nullable = true, length=1)	
	private String otcon10;
	
	@Column(name="otc10_rdl202012", insertable = true,  length=1)	
	private String otc10_rdl202012;

	@Column(name="otpacepro", insertable = true, length=1)	
	private String otpacepro;
	
	@Column(name="cdraapp", nullable = true, length=1)	
	private String cdraapp;

	@Column(name="cdssperso", nullable = true, insertable = true, length=1)	
	private String cdssperso;

	@NotNull(message="El campo nº máximo de anexos no puede estar vacío")
	@Column(name="nmmaxanxaapp", length=3)	
	private Integer nmmaxanxaapp;

	@NotNull(message="El campo AAPP por anexo no puede estar vacío")
	@Column(name="nmaappanx", length=2)	
	private Integer nmaappanx;

	@NotNull(message="El campo máximo anexos descuentos no puede estar vacío")
	@Column(name="nmmaxanxdes", length=3)	
	private Integer nmmaxanxdes;

	@Column(name="otrecibi", nullable = true, length=1)	
	private String otrecibi;

	@Column(name="ottelcon1", insertable = true, length=1)	
	private String ottelcon1;

	@Pattern(regexp = "[0-9]{8}([A-Z]|[a-z]){1}", message = "Debe introducir un NIF con formato correcto")
	@Column(name="cddnisigp", nullable = true, length=9)	
	private String cddnisigp;

	@Column(name="cdususigp", nullable = true, length=8)	
	private String cdususigp;

	@Column(name="cdpasswsigp", nullable = true, length=16)	
	private String cdpasswsigp;

	@Column(name = "iban", length = 36)
	private String iban;

	@Pattern(regexp = "([A-Z]|[a-z]|[0-9]){1}[0-9]{7}([A-Z]|[a-z]){1}", message = "Debe introducir un CIF/NIF con formato correcto")
	@NotNull(message = "El CIF/NIF no puede estar vacío")
	@Column(name = "cdident", length = 10)
	private String cdident;

	@NotNull(message = "La Cuenta no puede estar vacía")
	@Column(name = "cdcuenta", length = 10)
	private String cdcuenta;

	@Column(name = "otchetra", length = 1)
	private String otchetra;

	@NotNull(message = "El CIF/NIF de la Delegacion de Hacienda no puede estar vacía")
	@Pattern(regexp = "([A-Z]|[a-z]|[0-9]){1}[0-9]{7}([A-Z]|[a-z]){1}", message = "Debe introducir un CIF/NIF con formato correcto")
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

	// DATOS MUFACE /
	/////////////////
	@Pattern(regexp = "[0-9]{8}([A-Z]|[a-z]){1}", message = "Debe introducir un NIF con formato correcto")
	@NotNull(message="El campo nif habilitadono puede estar vacío")
	@Column(name="cdidmuf", nullable = true, length=9)	
	private String cdidmuf;

	@Column(name="cdorgmuf", nullable = true, length=9)	
	private String cdorgmuf;

	@Column(name="cdordmuf", nullable = true, length=9)	
	private String cdordmuf;


	//DATOS ISFAS/
	//////////////
	@Column(name="cdistipadm", nullable = true, length=1)	
	private String cdistipadm;

	@Column(name="dsisretap1", nullable = true, length=25)	
	private String dsisretap1;

	@Column(name="dsisretap2", nullable = true, length=25)	
	private String dsisretap2;

	@Column(name="dsisretnom", nullable = true, length=20)	
	private String dsisretnom;
			
	@Column(name="dsisordap1", nullable = true, length=25)	
	private String dsisordap1;

	@Column(name="dsisordap2", nullable = true, length=25)	
	private String dsisordap2;

	@Column(name="dsisordnom", nullable = true, length=20)	
	private String dsisordnom;


	//DATOS MUGEJU/
	///////////////
	@Column(name="cdmujorg", nullable = true, length=2)	
	private String cdmujorg;

	@Column(name="dsmujorg", nullable = true, length=42)	
	private String dsmujorg;

	@Column(name="cdmujger",nullable = true,  length=2)	
	private String cdmujger;

	@Column(name="dsmujger",nullable = true,  length=20)	
	private String dsmujger;


	//DATOS RGSS
	/////////////
	@Column(name="cdautoriz", nullable = true, length=8)	
	private Integer cdautoriz;

	@Column(name="feautoriz", nullable = true, length=7)	
	private Integer feautoriz;

              // cdc...... " Código Emisor de Empresa (NIB)" /

	@Column(name="dsautoriz", nullable = true, length=60)	
	private String dsautoriz;

              // checkbox ...... " Ded. Cont. Exc. MUNPAL en TC-1 Empresa"  /

	@Column(name="txtc11", nullable = true, length=18)	
	private String txtc11;

	@Column(name="txtc12", nullable = true, length=18)	
	private String txtc12;

	@Column(name="txtc13", nullable = true, length=18)	
	private String txtc13;

	@Column(name="txtc14", nullable = true, length=18)	
	private String txtc14;

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

	public String getDsorgext() {
		return dsorgext;
	}

	public void setDsorgext(String dsorgext) {
		this.dsorgext = dsorgext;
	}

	public String getDsorg() {
		return dsorg;
	}

	public void setDsorg(String dsorg) {
		this.dsorg = dsorg;
	}

	public String getDscentro() {
		return dscentro;
	}

	public void setDscentro(String dscentro) {
		this.dscentro = dscentro;
	}

	public String getCdsiglas() {
		return cdsiglas;
	}

	public void setCdsiglas(String cdsiglas) {
		this.cdsiglas = cdsiglas;
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

	public Sigdom getSigdom() {
		return sigdom;
	}

	public void setSigdom(Sigdom sigdom) {
		this.sigdom = sigdom;
	}

	public Localid getLocalid() {
		return localid;
	}

	public void setLocalid(Localid localid) {
		this.localid = localid;
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

	public Provinc getProvinc() {
		return provinc;
	}

	public void setProvinc(Provinc provinc) {
		this.provinc = provinc;
	}

	public String getNomcert() {
		return nomcert;
	}

	public void setNomcert(String nomcert) {
		this.nomcert = nomcert;
	}

	public String getDscalle() {
		return dscalle;
	}

	public void setDscalle(String dscalle) {
		this.dscalle = dscalle;
	}

	public String getDsnumero() {
		return dsnumero;
	}

	public void setDsnumero(String dsnumero) {
		this.dsnumero = dsnumero;
	}

	public String getCdpostal() {
		return cdpostal;
	}

	public void setCdpostal(String cdpostal) {
		this.cdpostal = cdpostal;
	}

	public String getCdloc() {
		return cdloc;
	}

	public void setCdloc(String cdloc) {
		this.cdloc = cdloc;
	}

	public String getDshabil() {
		return dshabil;
	}

	public void setDshabil(String dshabil) {
		this.dshabil = dshabil;
	}

	public String getDssuplen() {
		return dssuplen;
	}

	public void setDssuplen(String dssuplen) {
		this.dssuplen = dssuplen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getCarcert() {
		return carcert;
	}

	public void setCarcert(String carcert) {
		this.carcert = carcert;
	}

	public String getNmtelefcert() {
		return nmtelefcert;
	}

	public void setNmtelefcert(String nmtelefcert) {
		this.nmtelefcert = nmtelefcert;
	}

	public String getNmfaxcert() {
		return nmfaxcert;
	}

	public void setNmfaxcert(String nmfaxcert) {
		this.nmfaxcert = nmfaxcert;
	}

	public Integer getCddnom() {
		return cddnom;
	}

	public void setCddnom(Integer cddnom) {
		this.cddnom = cddnom;
	}

	public Integer getCddvar() {
		return cddvar;
	}

	public void setCddvar(Integer cddvar) {
		this.cddvar = cddvar;
	}

	public Integer getCddrec() {
		return cddrec;
	}

	public void setCddrec(Integer cddrec) {
		this.cddrec = cddrec;
	}

	public String getOtcon10() {
		return otcon10;
	}

	public void setOtcon10(String otcon10) {
		this.otcon10 = otcon10;
	}

	public String getOtc10_rdl202012() {
		return otc10_rdl202012;
	}

	public void setOtc10_rdl202012(String otc10_rdl202012) {
		this.otc10_rdl202012 = otc10_rdl202012;
	}

	public String getOtpacepro() {
		return otpacepro;
	}

	public void setOtpacepro(String otpacepro) {
		this.otpacepro = otpacepro;
	}

	public String getCdraapp() {
		return cdraapp;
	}

	public void setCdraapp(String cdraapp) {
		this.cdraapp = cdraapp;
	}

	public String getCdssperso() {
		return cdssperso;
	}

	public void setCdssperso(String cdssperso) {
		this.cdssperso = cdssperso;
	}

	public Integer getNmmaxanxaapp() {
		return nmmaxanxaapp;
	}

	public void setNmmaxanxaapp(Integer nmmaxanxaapp) {
		this.nmmaxanxaapp = nmmaxanxaapp;
	}

	public Integer getNmaappanx() {
		return nmaappanx;
	}

	public void setNmaappanx(Integer nmaappanx) {
		this.nmaappanx = nmaappanx;
	}

	public Integer getNmmaxanxdes() {
		return nmmaxanxdes;
	}

	public void setNmmaxanxdes(Integer nmmaxanxdes) {
		this.nmmaxanxdes = nmmaxanxdes;
	}

	public String getOtrecibi() {
		return otrecibi;
	}

	public void setOtrecibi(String otrecibi) {
		this.otrecibi = otrecibi;
	}

	public String getOttelcon1() {
		return ottelcon1;
	}

	public void setOttelcon1(String ottelcon1) {
		this.ottelcon1 = ottelcon1;
	}

	public String getCddnisigp() {
		return cddnisigp;
	}

	public void setCddnisigp(String cddnisigp) {
		this.cddnisigp = cddnisigp;
	}

	public String getCdususigp() {
		return cdususigp;
	}

	public void setCdususigp(String cdususigp) {
		this.cdususigp = cdususigp;
	}

	public String getCdpasswsigp() {
		return cdpasswsigp;
	}

	public void setCdpasswsigp(String cdpasswsigp) {
		this.cdpasswsigp = cdpasswsigp;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
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

	public String getCdidmuf() {
		return cdidmuf;
	}

	public void setCdidmuf(String cdidmuf) {
		this.cdidmuf = cdidmuf;
	}

	public String getCdorgmuf() {
		return cdorgmuf;
	}

	public void setCdorgmuf(String cdorgmuf) {
		this.cdorgmuf = cdorgmuf;
	}

	public String getCdordmuf() {
		return cdordmuf;
	}

	public void setCdordmuf(String cdordmuf) {
		this.cdordmuf = cdordmuf;
	}

	public String getCdistipadm() {
		return cdistipadm;
	}

	public void setCdistipadm(String cdistipadm) {
		this.cdistipadm = cdistipadm;
	}

	public String getDsisretap1() {
		return dsisretap1;
	}

	public void setDsisretap1(String dsisretap1) {
		this.dsisretap1 = dsisretap1;
	}

	public String getDsisretap2() {
		return dsisretap2;
	}

	public void setDsisretap2(String dsisretap2) {
		this.dsisretap2 = dsisretap2;
	}

	public String getDsisretnom() {
		return dsisretnom;
	}

	public void setDsisretnom(String dsisretnom) {
		this.dsisretnom = dsisretnom;
	}

	public String getDsisordap1() {
		return dsisordap1;
	}

	public void setDsisordap1(String dsisordap1) {
		this.dsisordap1 = dsisordap1;
	}

	public String getDsisordap2() {
		return dsisordap2;
	}

	public void setDsisordap2(String dsisordap2) {
		this.dsisordap2 = dsisordap2;
	}

	public String getDsisordnom() {
		return dsisordnom;
	}

	public void setDsisordnom(String dsisordnom) {
		this.dsisordnom = dsisordnom;
	}

	public String getCdmujorg() {
		return cdmujorg;
	}

	public void setCdmujorg(String cdmujorg) {
		this.cdmujorg = cdmujorg;
	}

	public String getDsmujorg() {
		return dsmujorg;
	}

	public void setDsmujorg(String dsmujorg) {
		this.dsmujorg = dsmujorg;
	}

	public String getCdmujger() {
		return cdmujger;
	}

	public void setCdmujger(String cdmujger) {
		this.cdmujger = cdmujger;
	}

	public String getDsmujger() {
		return dsmujger;
	}

	public void setDsmujger(String dsmujger) {
		this.dsmujger = dsmujger;
	}

	public Integer getCdautoriz() {
		return cdautoriz;
	}

	public void setCdautoriz(Integer cdautoriz) {
		this.cdautoriz = cdautoriz;
	}

	public Integer getFeautoriz() {
		return feautoriz;
	}

	public void setFeautoriz(Integer feautoriz) {
		this.feautoriz = feautoriz;
	}

	public String getDsautoriz() {
		return dsautoriz;
	}

	public void setDsautoriz(String dsautoriz) {
		this.dsautoriz = dsautoriz;
	}

	public String getTxtc11() {
		return txtc11;
	}

	public void setTxtc11(String txtc11) {
		this.txtc11 = txtc11;
	}

	public String getTxtc12() {
		return txtc12;
	}

	public void setTxtc12(String txtc12) {
		this.txtc12 = txtc12;
	}

	public String getTxtc13() {
		return txtc13;
	}

	public void setTxtc13(String txtc13) {
		this.txtc13 = txtc13;
	}

	public String getTxtc14() {
		return txtc14;
	}

	public void setTxtc14(String txtc14) {
		this.txtc14 = txtc14;
	}

	public String getSucurbaPlano() {
		return this.getSucurba().getCdsucur();
	}

	public String getLocalidPlano() {
		return this.getLocalid().getDsloc();
	}
	
	public String getProvincPlano() {
		return this.getProvinc().getDsprov();
	}

	public String getBancoPlano() {
		return this.getBanco().getDsbanco();
	}
	
	public String getDelhacPlano() {
		return this.getDelhac().getDsdelhac();
	}
	
	public String getSigdomPlano() {
		return this.getSigdom().getDssiglas();
	}
	
	public Habilitacion(Integer idHabilitacion,
			@NotNull(message = "El codigo de hablitación no puede estar vacío") String cdhabil,
			@NotNull(message = "La denominacion extensa no puede estar vacía") String dsorgext,
			@NotNull(message = "La denominacion no puede estar vacía") String dsorg,
			@NotNull(message = "El centro no puede estar vacío") String dscentro, String cdsiglas, String cdbanco,
			String cdsucur, @NotNull(message = "El tipo vía no puede estar vacía") Sigdom sigdom,
			@NotNull(message = "La localidad no puede estar vacía") Localid localid, Sucurba sucurba,
			@NotNull(message = "El banco no puede estar vacío") Banco banco,
			@NotNull(message = "el campo cddelhac no puede estar vacío") Delhac delhac,
			@NotNull(message = "La provincia no puede estar vacía") Provinc provinc, String nomcert,
			@NotNull(message = "La calle no puede estar vacía") String dscalle, String dsnumero,
			@NotNull(message = "El código postal no puede estar vacío") String cdpostal, String cdloc,
			@NotNull(message = "El campo habilitado no puede estar vacío") String dshabil, String dssuplen,
			@NotNull(message = "El nombre no puede estar vacío") String nombre,
			@NotNull(message = "El apellido1 no puede estar vacío") String apellido1,
			@NotNull(message = "El apellido2 no puede estar vacío") String apellido2,
			@NotNull(message = "El cargo no puede estar vacío") String carcert,
			@Pattern(regexp = "[0-9]{9}", message = "Debe introducir un número de teléfono con formato correcto y sin espacios (999999999)") String nmtelefcert,
			@Pattern(regexp = "[0-9]{9}", message = "Debe introducir un número de teléfono con formato correcto y sin espacios (999999999)") String nmfaxcert,
			@NotNull(message = "El campo nómina no puede estar vacío") Integer cddnom,
			@NotNull(message = "El campo variaciones no puede estar vacío") Integer cddvar,
			@NotNull(message = "El campo recibo no puede estar vacío") Integer cddrec, String otcon10,
			String otc10_rdl202012, String otpacepro, String cdraapp, String cdssperso,
			@NotNull(message = "El campo nº máximo de anexos no puede estar vacío") Integer nmmaxanxaapp,
			@NotNull(message = "El campo AAPP por anexo no puede estar vacío") Integer nmaappanx,
			@NotNull(message = "El campo máximo anexos descuentos no puede estar vacío") Integer nmmaxanxdes,
			String otrecibi, String ottelcon1,
			@Pattern(regexp = "[0-9]{8}([A-Z]|[a-z]){1}", message = "Debe introducir un NIF con formato correcto") String cddnisigp,
			String cdususigp, String cdpasswsigp, String iban,
			@Pattern(regexp = "[0-9]{8}([A-Z]|[a-z]){1}", message = "Debe introducir un CIF/NIF con formato correcto") @NotNull(message = "El CIF/NIF no puede estar vacío") String cdident,
			@NotNull(message = "La Cuenta no puede estar vacía") String cdcuenta, String otchetra,
			@NotNull(message = "El CIF/NIF de la Delegacion de Hacienda no puede estar vacía") @Pattern(regexp = "[0-9]{8}([A-Z]|[a-z]){1}", message = "Debe introducir un CIF/NIF con formato correcto") String cdhacien,
			@NotNull(message = "El codigo de la Delegacion de Hacienda no puede estar vacía") String cdadmon,
			@NotNull(message = "El municipio no puede estar vacío") String dsmunic,
			@NotNull(message = "El número de contacto no puede estar vacío") @Pattern(regexp = "[0-9]{9}", message = "Debe introducir un número de teléfono con formato correcto y sin espacios (999999999)") String nmtelef,
			String nmlicen, String otorden, Integer cdgastos, String cengest, String cendir, String cdipfunciona,
			String cdusufunciona, String cdpasswdfunciona, String cddirdesfunciona, String cdbic, String cengestesoro,
			String otfictesoro, String suford, Integer cdemisorbde, String cdcargo, String otidentinst, String cdpropct,
			String dsmsgidxml, String cddlvrymtd, String cdinstrprty, String cdcruzado, String cdemicarta,
			String cdcodee,
			@Email(message = "Debe introducir una única dirección de correo electrónico con formato correcto (prueba@correo.com)") String cdemailhab,
			String cdprefijiban,
			@Pattern(regexp = "[0-9]{8}([A-Z]|[a-z]){1}", message = "Debe introducir un NIF con formato correcto") @NotNull(message = "El campo nif habilitadono puede estar vacío") String cdidmuf,
			String cdorgmuf, String cdordmuf, String cdistipadm, String dsisretap1, String dsisretap2,
			String dsisretnom, String dsisordap1, String dsisordap2, String dsisordnom, String cdmujorg,
			String dsmujorg, String cdmujger, String dsmujger, Integer cdautoriz, Integer feautoriz, String dsautoriz,
			String txtc11, String txtc12, String txtc13, String txtc14) {
		super();
		this.idHabilitacion = idHabilitacion;
		this.cdhabil = cdhabil;
		this.dsorgext = dsorgext;
		this.dsorg = dsorg;
		this.dscentro = dscentro;
		this.cdsiglas = cdsiglas;
		this.cdbanco = cdbanco;
		this.cdsucur = cdsucur;
		this.sigdom = sigdom;
		this.localid = localid;
		this.sucurba = sucurba;
		this.banco = banco;
		this.delhac = delhac;
		this.provinc = provinc;
		this.nomcert = nomcert;
		this.dscalle = dscalle;
		this.dsnumero = dsnumero;
		this.cdpostal = cdpostal;
		this.cdloc = cdloc;
		this.dshabil = dshabil;
		this.dssuplen = dssuplen;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.carcert = carcert;
		this.nmtelefcert = nmtelefcert;
		this.nmfaxcert = nmfaxcert;
		this.cddnom = cddnom;
		this.cddvar = cddvar;
		this.cddrec = cddrec;
		this.otcon10 = otcon10;
		this.otc10_rdl202012 = otc10_rdl202012;
		this.otpacepro = otpacepro;
		this.cdraapp = cdraapp;
		this.cdssperso = cdssperso;
		this.nmmaxanxaapp = nmmaxanxaapp;
		this.nmaappanx = nmaappanx;
		this.nmmaxanxdes = nmmaxanxdes;
		this.otrecibi = otrecibi;
		this.ottelcon1 = ottelcon1;
		this.cddnisigp = cddnisigp;
		this.cdususigp = cdususigp;
		this.cdpasswsigp = cdpasswsigp;
		this.iban = iban;
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
		this.cdidmuf = cdidmuf;
		this.cdorgmuf = cdorgmuf;
		this.cdordmuf = cdordmuf;
		this.cdistipadm = cdistipadm;
		this.dsisretap1 = dsisretap1;
		this.dsisretap2 = dsisretap2;
		this.dsisretnom = dsisretnom;
		this.dsisordap1 = dsisordap1;
		this.dsisordap2 = dsisordap2;
		this.dsisordnom = dsisordnom;
		this.cdmujorg = cdmujorg;
		this.dsmujorg = dsmujorg;
		this.cdmujger = cdmujger;
		this.dsmujger = dsmujger;
		this.cdautoriz = cdautoriz;
		this.feautoriz = feautoriz;
		this.dsautoriz = dsautoriz;
		this.txtc11 = txtc11;
		this.txtc12 = txtc12;
		this.txtc13 = txtc13;
		this.txtc14 = txtc14;
	}

	public Habilitacion() {
		super();
	}

	@Override
	public String toString() {
		return "Habilitacion [idHabilitacion=" + idHabilitacion + ", cdhabil=" + cdhabil + ", dsorgext=" + dsorgext
				+ ", dsorg=" + dsorg + ", dscentro=" + dscentro + ", cdsiglas=" + cdsiglas + ", cdbanco=" + cdbanco
				+ ", cdsucur=" + cdsucur + ", sigdom=" + sigdom + ", localid=" + localid + ", sucurba=" + sucurba
				+ ", banco=" + banco + ", delhac=" + delhac + ", provinc=" + provinc + ", nomcert=" + nomcert
				+ ", dscalle=" + dscalle + ", dsnumero=" + dsnumero + ", cdpostal=" + cdpostal + ", cdloc=" + cdloc
				+ ", dshabil=" + dshabil + ", dssuplen=" + dssuplen + ", nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", carcert=" + carcert + ", nmtelefcert=" + nmtelefcert + ", nmfaxcert="
				+ nmfaxcert + ", cddnom=" + cddnom + ", cddvar=" + cddvar + ", cddrec=" + cddrec + ", otcon10="
				+ otcon10 + ", otc10_rdl202012=" + otc10_rdl202012 + ", otpacepro=" + otpacepro + ", cdraapp=" + cdraapp
				+ ", cdssperso=" + cdssperso + ", nmmaxanxaapp=" + nmmaxanxaapp + ", nmaappanx=" + nmaappanx
				+ ", nmmaxanxdes=" + nmmaxanxdes + ", otrecibi=" + otrecibi + ", ottelcon1=" + ottelcon1
				+ ", cddnisigp=" + cddnisigp + ", cdususigp=" + cdususigp + ", cdpasswsigp=" + cdpasswsigp + ", iban="
				+ iban + ", cdident=" + cdident + ", cdcuenta=" + cdcuenta + ", otchetra=" + otchetra + ", cdhacien="
				+ cdhacien + ", cdadmon=" + cdadmon + ", dsmunic=" + dsmunic + ", nmtelef=" + nmtelef + ", nmlicen="
				+ nmlicen + ", otorden=" + otorden + ", cdgastos=" + cdgastos + ", cengest=" + cengest + ", cendir="
				+ cendir + ", cdipfunciona=" + cdipfunciona + ", cdusufunciona=" + cdusufunciona + ", cdpasswdfunciona="
				+ cdpasswdfunciona + ", cddirdesfunciona=" + cddirdesfunciona + ", cdbic=" + cdbic + ", cengestesoro="
				+ cengestesoro + ", otfictesoro=" + otfictesoro + ", suford=" + suford + ", cdemisorbde=" + cdemisorbde
				+ ", cdcargo=" + cdcargo + ", otidentinst=" + otidentinst + ", cdpropct=" + cdpropct + ", dsmsgidxml="
				+ dsmsgidxml + ", cddlvrymtd=" + cddlvrymtd + ", cdinstrprty=" + cdinstrprty + ", cdcruzado="
				+ cdcruzado + ", cdemicarta=" + cdemicarta + ", cdcodee=" + cdcodee + ", cdemailhab=" + cdemailhab
				+ ", cdprefijiban=" + cdprefijiban + ", cdidmuf=" + cdidmuf + ", cdorgmuf=" + cdorgmuf + ", cdordmuf="
				+ cdordmuf + ", cdistipadm=" + cdistipadm + ", dsisretap1=" + dsisretap1 + ", dsisretap2=" + dsisretap2
				+ ", dsisretnom=" + dsisretnom + ", dsisordap1=" + dsisordap1 + ", dsisordap2=" + dsisordap2
				+ ", dsisordnom=" + dsisordnom + ", cdmujorg=" + cdmujorg + ", dsmujorg=" + dsmujorg + ", cdmujger="
				+ cdmujger + ", dsmujger=" + dsmujger + ", cdautoriz=" + cdautoriz + ", feautoriz=" + feautoriz
				+ ", dsautoriz=" + dsautoriz + ", txtc11=" + txtc11 + ", txtc12=" + txtc12 + ", txtc13=" + txtc13
				+ ", txtc14=" + txtc14 + "]";
	}
}
