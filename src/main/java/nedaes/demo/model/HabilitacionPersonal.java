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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Table(name="THABILIT")
public class HabilitacionPersonal implements Serializable{
	private static final long serialVersionUID = -2517851941873251685L;

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
	
//	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TSIGDOM_THABILIT"), value = {@JoinColumn(name = "IDTSIGDOM", referencedColumnName = "IDTSIGDOM") })	
	//foreign key q relaciona cdsiglas de habilitacion con cdsiglas de la tabla sigdom
	@NotNull(message="El tipo vía no puede estar vacía")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TSIGDOM2_THABILIT"), value = { @JoinColumn(name = "CDSIGLAS", referencedColumnName = "CDSIGLAS", nullable = false, insertable = false, updatable = false ) })	
	private Sigdom sigdom;


//	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TLOCALID_THABILIT"), value = {@JoinColumn(name = "IDTLOCALID", referencedColumnName = "IDTLOCALID") })
	@NotNull(message="La localidad no puede estar vacía")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TLOCALID2_THABILIT"), value = 
		{@JoinColumn(name = "CDPROV", referencedColumnName = "CDPROV", nullable = false, insertable = false, updatable = false ),
		 @JoinColumn(name = "CDLOC", referencedColumnName = "CDLOC", nullable = false, insertable = false, updatable = false )})	
	private Localid localid;
	
	
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

	
	public HabilitacionPersonal() {
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

	public String getNomcert() {
		return nomcert;
	}

	public void setNomcert(String nomcert) {
		this.nomcert = nomcert;
	}

	public HabilitacionPersonal(Integer idHabilitacion, String cdhabil, String dsorgext, String dsorg, String dscentro,
			String cdsiglas, String cdbanco, String cdsucur,
			@NotNull(message = "el campo cdsiglas no puede estar vacío") Sigdom sigdom, Localid localid,
			Sucurba sucurba, @NotNull(message = "el campo cdbanco no puede estar vacío") Banco banco,
			@NotNull(message = "el campo cddelhac no puede estar vacío") Delhac delhac,
			@NotNull(message = "el campo cdprov no puede estar vacío") Provinc provinc, String nomcert, String dscalle,
			String dsnumero, String cdpostal, String cdloc, String dshabil, String dssuplen, String nombre,
			String apellido1, String apellido2, String carcert,
			@Pattern(regexp = "[0-9]{9}", message = "Debe introducir un número de teléfono con formato correcto y sin espacios (999999999)") String nmtelefcert,
			@Pattern(regexp = "[0-9]{9}", message = "Debe introducir un número de teléfono con formato correcto y sin espacios (999999999)") String nmfaxcert,
			Integer cddnom, Integer cddvar, Integer cddrec, String otcon10, String otc10_rdl202012, String otpacepro,
			String cdraapp, String cdssperso, Integer nmmaxanxaapp, Integer nmaappanx, Integer nmmaxanxdes,
			String otrecibi, String ottelcon1, String cddnisigp, String cdususigp, String cdpasswsigp) {
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
	}

	@Override
	public String toString() {
		return "HabilitacionPersonal [idHabilitacion=" + idHabilitacion + ", cdhabil=" + cdhabil + ", dsorgext="
				+ dsorgext + ", dsorg=" + dsorg + ", dscentro=" + dscentro + ", cdsiglas=" + cdsiglas + ", cdbanco="
				+ cdbanco + ", cdsucur=" + cdsucur + ", sigdom=" + sigdom + ", localid=" + localid + ", sucurba="
				+ sucurba + ", banco=" + banco + ", delhac=" + delhac + ", provinc=" + provinc + ", nomcert=" + nomcert
				+ ", dscalle=" + dscalle + ", dsnumero=" + dsnumero + ", cdpostal=" + cdpostal + ", cdloc=" + cdloc
				+ ", dshabil=" + dshabil + ", dssuplen=" + dssuplen + ", nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", carcert=" + carcert + ", nmtelefcert=" + nmtelefcert + ", nmfaxcert="
				+ nmfaxcert + ", cddnom=" + cddnom + ", cddvar=" + cddvar + ", cddrec=" + cddrec + ", otcon10="
				+ otcon10 + ", otc10_rdl202012=" + otc10_rdl202012 + ", otpacepro=" + otpacepro + ", cdraapp=" + cdraapp
				+ ", cdssperso=" + cdssperso + ", nmmaxanxaapp=" + nmmaxanxaapp + ", nmaappanx=" + nmaappanx
				+ ", nmmaxanxdes=" + nmmaxanxdes + ", otrecibi=" + otrecibi + ", ottelcon1=" + ottelcon1
				+ ", cddnisigp=" + cddnisigp + ", cdususigp=" + cdususigp + ", cdpasswsigp=" + cdpasswsigp + "]";
	}

}
