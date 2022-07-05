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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
/*
@Entity
@Table(name="BPERSONA")
*/
public class Perceptor2 
{
	/*

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDBPERSONA")
	private Integer idperceptor ;
		
	@Column(name="CDHABIL", length=3)
	private String cdhabil;
	
	@Column(name="CDCLASNM", length=2)
	private String cn;
	
	@Column(name="CDDNI", length=9)
	private String dni ;

	@Column(name="CDDUP", length=1)
	private String dup ;
	
	@Column(name="DSAPELL1", length=22)
	private String apellidos;
	
	@Column(name="DSAPELLI2", length=22)
	private String dsapell2;
	
	@Column(name="DSNOMBRE", length=14)
	private String nombre;

	private String sit;
	
	@NotNull(message = "El campo clase nomina no pueden estar vacío.")
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TCLASNOM_BPERSONA"), value = { @JoinColumn })
	@JoinColumn(name="IDTCLASNOM")
	private Clasenomina clasenomina;

	*/
/*
	@NotNull(message = "El campo Habilitacion no puede estar vacío.")
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_PERCEPTOR_THABILIT"), value = { @JoinColumn })
	@JoinColumn(name="IDTHABILIT")
	private HabilitacionInicial habilitacion;
	*/
//	@Column(name="hab", length=3)
	
/*
	private String hab;

	
	@NotNull(message = "El campo Provincia no puede estar vacío.")
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TPROVINC_BPERSONA"), value = { @JoinColumn })
	@JoinColumn(name="IDTPROVINC")
	private Provinc provincia;

//	@NotNull(message = "El campo Banco no puede estar vacío.")
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_BPERBAN_BPERSONA"), value = { @JoinColumn })
	@JoinColumn(name="IDBPERBAN")
	private Banco banco;

    public Perceptor(Integer idperceptor, String cdhabil, String cn, String dni, String dup, String apellidos,
		String dsapell2, String nombre, String sit,
		@NotNull(message = "El campo clase nomina no pueden estar vacío.") Clasenomina clasenomina, String hab,
		@NotNull(message = "El campo Provincia no puede estar vacío.") Provinc provincia, Banco banco) {
	super();
	this.idperceptor = idperceptor;
	this.cdhabil = cdhabil;
	this.cn = cn;
	this.dni = dni;
	this.dup = dup;
	this.apellidos = apellidos;
	this.dsapell2 = dsapell2;
	this.nombre = nombre;
	this.sit = sit;
	this.clasenomina = clasenomina;
	this.hab = hab;
	this.provincia = provincia;
	this.banco = banco;
    }

	public Integer getIdperceptor() {
		return idperceptor;
	}

	public void setIdperceptor(Integer idperceptor) {
		this.idperceptor = idperceptor;
	}

	public String getCdhabil() {
		return cdhabil;
	}

	public void setCdhabil(String cdhabil) {
		this.cdhabil = cdhabil;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDup() {
		return dup;
	}

	public void setDup(String dup) {
		this.dup = dup;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDsapell2() {
		return dsapell2;
	}

	public void setDsapell2(String dsapell2) {
		this.dsapell2 = dsapell2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSit() {
		return sit;
	}

	public void setSit(String sit) {
		this.sit = sit;
	}

	public Clasenomina getClasenomina() {
		return clasenomina;
	}

	public void setClasenomina(Clasenomina clasenomina) {
		this.clasenomina = clasenomina;
	}

	public String getHab() {
		return hab;
	}

	public void setHab(String hab) {
		this.hab = hab;
	}

	public Provinc getProvincia() {
		return provincia;
	}

	public void setProvincia(Provinc provincia) {
		this.provincia = provincia;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
    
    
*/	    
}
