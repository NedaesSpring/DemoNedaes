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
@Table(name="temp_percep")
*/
public class Perceptor3 {

/*
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_perceptor")
	private Integer idPerceptor;

	@Column(name="nombre", length=35)
	private String nombre;
	
	@Column(name="apellidos", length=35)
	private String apellidos;

	@Column(name="dni", length=10)
	private String dni;
	
	@Column(name="sit")
	private String sit;
	
	@Column(name="dup", length=1)
	private String dup;

	@Column(name="cn", length=2)
	private String cn;
	
	@NotNull(message = "El campo Clase Nomina no puede estar vacío.")
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_PERCEPTOR_CLASENOMINA"), value = { @JoinColumn })
	@JoinColumn(name="idclasenomina")
	private Clasenomina clasenomina;

	
	@NotNull(message = "El campo Habilitacion no puede estar vacío.")
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_PERCEPTOR_HABILITACION"), value = { @JoinColumn })
	@JoinColumn(name="id_habilitacion")
	private HabilitacionInicial habilitacion;
	
	@Column(name="hab", length=3)
	private String hab;

	
	@NotNull(message = "El campo Provincia no puede estar vacío.")
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(foreignKey = @ForeignKey(name = " FK_PERCEPTOR_PROVINCIA"), value = { @JoinColumn })
	@JoinColumn(name="IDTPROVINC")
	private Provinc	 provincia;

	@NotNull(message = "El campo Provincia no puede estar vacío.")
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(foreignKey = @ForeignKey(name = " FK_PERCEPTOR_BANCO"), value = { @JoinColumn })
	@JoinColumn(name="IDBANCO")
	private Banco banco;

	

	public Perceptor3(Integer idPerceptor, String nombre, String apellidos, String dni, String sit, String dup,
			String cn, @NotNull(message = "El campo Clase Nomina no puede estar vacío.") Clasenomina clasenomina,
			@NotNull(message = "El campo Habilitacion no puede estar vacío.") HabilitacionInicial habilitacion,
			String hab, @NotNull(message = "El campo Provincia no puede estar vacío.") Provinc provincia,
			@NotNull(message = "El campo Provincia no puede estar vacío.") Banco banco) {
		super();
		this.idPerceptor = idPerceptor;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sit = sit;
		this.dup = dup;
		this.cn = cn;
		this.clasenomina = clasenomina;
		this.habilitacion = habilitacion;
		this.hab = hab;
		this.provincia = provincia;
		this.banco = banco;
	}


	public Perceptor3() {
		super();
		this.idPerceptor = 0;
		this.nombre = null;
		this.apellidos = null;
		this.dni = null;
		this.sit = null;
		this.dup = null;
		this.cn = null;
		this.hab = null;
		this.provincia = new Provinc();
		this.clasenomina = new Clasenomina();
		this.habilitacion = new HabilitacionInicial();
		this.banco = new Banco();
	}
	
	
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getIdPerceptor() {
		return idPerceptor;
	}

	public void setIdPerceptor(Integer idPerceptor) {
		this.idPerceptor = idPerceptor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getSit() {
		return sit;
	}

	public void setSit(String sit) {
		this.sit = sit;
	}

	public String getDup() {
		return dup;
	}

	public void setDup(String dup) {
		this.dup = dup;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
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
	
    public String getDescripcionProvinciaPlano() {
		if (provincia == null) {
			return "";
		} else {
			return provincia.getDsprov();
	    } 
    }

	public Clasenomina getClasenomina() {
		return clasenomina;
	}

	public void setClasenomina(Clasenomina clasenomina) {
		this.clasenomina = clasenomina;
	}

	public HabilitacionInicial getHabilitacion() {
		return habilitacion;
	}

	public void setHabilitacion(HabilitacionInicial habilitacion) {
		this.habilitacion = habilitacion;
	}
    
    public String getDescripcionClasenominaPlano() {
		if (clasenomina == null) {
			return "";
		} else {
			return clasenomina.getDsclasnm();
	    } 
    }
    
    public String getDescripcionHabilitacionPlano() {
		if (habilitacion == null) {
			return "";
		} else {
			return habilitacion.getCdhabil();
	    } 
    }


	public Banco getBanco() {
		return banco;
	}


	public void setBanco(Banco banco) {
		this.banco = banco;
	}
    
   */ 
    
}
