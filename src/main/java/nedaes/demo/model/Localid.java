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
import java.io.Serializable;

@Entity
@Table(name="TLOCALID")
public class Localid implements Serializable{
	private static final long serialVersionUID = -2517851941873251684L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDTLOCALID")
	private Integer idlocalid;
		
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TPROVINC_TLOCALID"), value = { @JoinColumn(name = "IDTPROVINC", referencedColumnName = "IDTPROVINC") })	
	@NotNull(message="El campo id_provincia no puede estar vacío")
	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TPROVINC2_TLOCALID"), value = { @JoinColumn(name = "CDPROV", referencedColumnName = "CDPROV", nullable = false, insertable = false, updatable = false ) })	
	private Provinc provinc;
	
	@Column(name="CDLOC", length=3)
	private String cdloc;
	
	@Column(name="DSLOC", length=100)
	private String dsloc;

    @Column(name="CDPROV", length=2)
	private Integer cdprov ;

	
	public Localid() {
		super();
	}


	public Localid(Integer idlocalid, @NotNull(message = "El campo cdprov no puede estar vacío") Provinc provinc, String cdloc, String dsloc) {
		super();
		this.idlocalid = idlocalid;
		this.provinc = provinc;
		this.cdloc = cdloc;
		this.dsloc = dsloc;
	}


	public Integer getIdlocalid() {
		return idlocalid;
	}

	public void setIdLocalid(Integer idlocalid) {
		this.idlocalid = idlocalid;
	}

	public Provinc getProvinc() {
		return provinc;
	}

	public void setProvinc(Provinc provinc) {
		this.provinc = provinc;
	}

	public String getCdloc() {
		return cdloc;
	}

	public void setCdloc(String cdloc) {
		this.cdloc = cdloc;
	}

	public String getDsloc() {
		return dsloc;
	}

	public void setDsloc(String dsloc) {
		this.dsloc = dsloc;
	}

	@Override
	public String toString() {
		return "Localidad [idlocalid=" + idlocalid + ", provinc=" + provinc	+ ", cdloc=" + cdloc + ", dsloc=" + dsloc + "]";
	}
}
