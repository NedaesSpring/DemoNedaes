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
@Table(name="BPERSONA")
public class Perceptor implements Serializable{
	private static final long serialVersionUID = -2517851941873251683L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDBPERSONA")
	private Integer idPerceptor ;
		
	@Column(name="DSNOMBRE", length=14)
	private String nombre;

	@Column(name="DSAPELL1", length=22)
	private String dsapell1;
	
	@Column(name="DSAPELL2", length=22)
	private String dsapell2;
	
	@Column(name="CDDNI", length=9)
	private String dni ;

	@Column(name="CDCLASNM", length=2)
	private String cn;
	
	@Column(name="CDDUP", length=1)
	private String dup;

	@Column(name="CDHABIL", length=3)
	private String hab;

	@Column(name="CDPROV", length=2)
	private String cdprov ;
	
	@Column(name="CDSEXO", length=1)
	private String cdsexo ;

	@Column(name="CDDOMNOT", length=1)
	private String cddomnot;

	@Column(name="CDFORPAG", length=1)
	private String cdforpag;

	@Column(name="CDNUMERO", length=5)
	private String cdnumero;

	@Column(name="DSVIAPUB", length=30)
	private String dsviapub;

	@Column(name="CDSIGLAS", length=2)	
	private String cdsiglas;
	
	@Column(name="IDTCLASNOM")	
	private Integer idtclasnom;
	
	@Column(name="IDTPROVINC")	
	private Integer idtprovinc;
	
	@Column(name="IDTHABILIT")	
	private Integer idthabilit;
	
//	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TCLASNOM_BPERSONA"), value = {@JoinColumn(name = "IDTCLASNOM", referencedColumnName = "IDTCLASNOM") })	
//	@NotNull(message = "El campo clase nomina no pueden estar vacío.")
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TCLASNOM2_BPERSONA"), value = {@JoinColumn(name = "CDCLASNM", referencedColumnName = "CDCLASNM", nullable = false, insertable = false, updatable = false)})	
	private Clasenomina clasenomina;

//	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TPROVINC_BPERSONA"), value = {@JoinColumn(name = "IDTPROVINC", referencedColumnName = "IDTPROVINC") })
	@NotNull(message = "El campo Provincia no puede estar vacío.")
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(foreignKey = @ForeignKey(name = "SYS_C00730760"), value = {@JoinColumn(name = "CDPROV", referencedColumnName = "CDPROV", nullable = false, insertable = false, updatable = false)})	
	private Provinc	 provincia;

//	@JoinColumns(foreignKey = @ForeignKey(name = "FK_THABILIT_BPERSONA"), value = {@JoinColumn(name = "IDTHABILIT", referencedColumnName = "IDTHABILIT") })	
	@NotNull(message = "El campo Habilitacion no puede estar vacío.")
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_THABILIT2_BPERSONA"), value = {@JoinColumn(name = "CDHABIL", referencedColumnName = "CDHABIL", nullable = false, insertable = false, updatable = false)})	
	private HabilitacionInicial habilitacion;

	
//	@NotNull(message = "El campo NIF no puede estar vacío.")
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_BPERADM_BPERSONA"), value = {@JoinColumn(name = "IDBPERADM", referencedColumnName = "IDBPERADM") })
/*	@JoinColumns(foreignKey = @ForeignKey(name = "FK_BPERADM2_BPERSONA"), value = {
			  @JoinColumn(name = "CDHABIL", referencedColumnName = "CDHABIL", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDCLASNM", referencedColumnName = "CDCLASNM", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDDNI", referencedColumnName = "CDDNI", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDDUP", referencedColumnName = "CDDUP", nullable = false, insertable = false, updatable = false)})
*/	
	private Bperadm bperadm;
	
//	@JoinColumns(foreignKey = @ForeignKey(name = "FK_BPERBAN_BPERSONA"), value = {@JoinColumn(name = "IDBPERBAN", referencedColumnName = "IDBPERBAN") })
//	@NotNull(message = "El campo Banco no puede estar vacío.")
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_BPERBAN_BPERSONA"), value = {@JoinColumn(name = "IDBPERBAN", referencedColumnName = "IDBPERBAN") })
/*	@JoinColumns(foreignKey = @ForeignKey(name = "FK_BPERBAN2_BPERSONA"), value = {
			  @JoinColumn(name = "CDHABIL", referencedColumnName = "CDHABIL", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDCLASNM", referencedColumnName = "CDCLASNM", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDDNI", referencedColumnName = "CDDNI", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDDUP", referencedColumnName = "CDDUP", nullable = false, insertable = false, updatable = false)})
*/	
	private Bperban bperban;
    
	//foreign key q relaciona cdsiglas de habilitacion con cdsiglas de la tabla sigdom
//	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TSIGDOM_HABILIT"), value = { @JoinColumn(name = "IDTSIGDOM", referencedColumnName = "IDTSIGDOM") })	
	@NotNull(message="El tipo vía no puede estar vacía")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TSIGDOM2_BPERSONA"), value = { @JoinColumn(name = "CDSIGLAS", referencedColumnName = "CDSIGLAS", nullable = false, insertable = false, updatable = false ) })	
	private Sigdom sigdom;
    
	public Perceptor() {
		super();
	}

	public Perceptor(Integer idPerceptor, String nombre, String dsapell1, String dsapell2, String dni, String cn,
			String dup, String hab, String cdprov, String cdsexo, String cddomnot, String cdforpag, String cdnumero,
			String dsviapub, String cdsiglas, Integer idtclasnom, Integer idtprovinc, Integer idthabilit,
			Clasenomina clasenomina, @NotNull(message = "El campo Provincia no puede estar vacío.") Provinc provincia,
			@NotNull(message = "El campo Habilitacion no puede estar vacío.") HabilitacionInicial habilitacion,
			Bperadm bperadm, Bperban bperban, @NotNull(message = "El tipo vía no puede estar vacía") Sigdom sigdom) {
		super();
		this.idPerceptor = idPerceptor;
		this.nombre = nombre;
		this.dsapell1 = dsapell1;
		this.dsapell2 = dsapell2;
		this.dni = dni;
		this.cn = cn;
		this.dup = dup;
		this.hab = hab;
		this.cdprov = cdprov;
		this.cdsexo = cdsexo;
		this.cddomnot = cddomnot;
		this.cdforpag = cdforpag;
		this.cdnumero = cdnumero;
		this.dsviapub = dsviapub;
		this.cdsiglas = cdsiglas;
		this.idtclasnom = idtclasnom;
		this.idtprovinc = idtprovinc;
		this.idthabilit = idthabilit;
		this.clasenomina = clasenomina;
		this.provincia = provincia;
		this.habilitacion = habilitacion;
		this.bperadm = bperadm;
		this.bperban = bperban;
		this.sigdom = sigdom;
	}

	public Integer getIdPerceptor() {
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

	public String getDsapell1() {
		return dsapell1;
	}

	public void setDsapell1(String dsapell1) {
		this.dsapell1 = dsapell1;
	}

	public String getDsapell2() {
		return dsapell2;
	}

	public void setDsapell2(String dsapell2) {
		this.dsapell2 = dsapell2;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getDup() {
		return dup;
	}

	public void setDup(String dup) {
		this.dup = dup;
	}

	public String getHab() {
		return hab;
	}

    public void setHab(String hab) {
		this.hab = hab;
 	}

	public Clasenomina getClasenomina() {
		return clasenomina;
	}

	public void setClasenomina(Clasenomina clasenomina) {
		this.clasenomina = clasenomina;
	}

	public Provinc getProvincia() {
		return provincia;
	}

	public void setProvincia(Provinc provincia) {
		this.provincia = provincia;
	}

	public HabilitacionInicial getHabilitacion() {
		return habilitacion;
	}

	public void setHabilitacion(HabilitacionInicial habilitacion) {
		this.habilitacion = habilitacion;
	}

	public Bperban getBperban() {
		return bperban;
	}

	public void setBperban(Bperban bperban) {
		this.bperban = bperban;
	}

	
	public Bperadm getBperadm() {
		return bperadm;
	}

	public void setBperadm(Bperadm bperadm) {
		this.bperadm = bperadm;
	}

	public String getDescripcionProvinciaPlano() {
		if (provincia == null) {
			return "";
		} else {
			return provincia.getDsprov();
	    } 
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

     public String getCbbanco() {
  		if (bperban == null) {
  			return "";
  		} else {
  			return bperban.getCdbanco();
  	    } 
     }
      
     public void setCdbanco(String cdbanco) {
   		if (this.bperban != null) {
   			this.bperban.setCdbanco(cdbanco);
   	    } 
       }
       
     
     public String getSit() {
  		if (bperadm == null) {
  			return "";
  		} else {
  			return bperadm.getCdsitnom();
  	    } 
     }
      
     public void setSit(String sit) {
   		if (this.bperadm != null) {
   			this.bperadm.setCdsitnom(sit);
   	    } 
       }

	public String getCdprov() {
		return cdprov;
	}

	public void setCdprov(String cdprov) {
		this.cdprov = cdprov;
	}

	public String getCdsexo() {
		return cdsexo;
	}

	public void setCdsexo(String cdsexo) {
		this.cdsexo = cdsexo;
	}

	public String getCddomnot() {
		return cddomnot;
	}

	public void setCddomnot(String cddomnot) {
		this.cddomnot = cddomnot;
	}

	public String getCdforpag() {
		return cdforpag;
	}

	public void setCdforpag(String cdforpag) {
		this.cdforpag = cdforpag;
	}

	public String getCdnumero() {
		return cdnumero;
	}

	public void setCdnumero(String cdnumero) {
		this.cdnumero = cdnumero;
	}

	public String getDsviapub() {
		return dsviapub;
	}

	public void setDsviapub(String dsviapub) {
		this.dsviapub = dsviapub;
	}

	public String getCdsiglas() {
		return cdsiglas;
	}

	public void setCdsiglas(String cdsiglas) {
		this.cdsiglas = cdsiglas;
	}

	public Sigdom getSigdom() {
		return sigdom;
	}

	public void setSigdom(Sigdom sigdom) {
		this.sigdom = sigdom;
	}

	public Integer getIdtclasnom() {
		return idtclasnom;
	}

	public void setIdtclasnom(Integer idtclasnom) {
		this.idtclasnom = idtclasnom;
	}

	public Integer getIdtprovinc() {
		return idtprovinc;
	}

	public void setIdtprovinc(Integer idtprovinc) {
		this.idtprovinc = idtprovinc;
	}

	public Integer getIdthabilit() {
		return idthabilit;
	}

	public void setIdthabilit(Integer idthabilit) {
		this.idthabilit = idthabilit;
	}

	@Override
	public String toString() {
		return "Perceptor [idPerceptor=" + idPerceptor + ", nombre=" + nombre + ", dsapell1=" + dsapell1
				+ ", dsapell2=" + dsapell2 + ", dni=" + dni + ", cn=" + cn + ", dup=" + dup + ", hab=" + hab
				+ ", cdprov=" + cdprov + ", cdsexo=" + cdsexo + ", cddomnot=" + cddomnot + ", cdforpag=" + cdforpag
				+ ", cdnumero=" + cdnumero + ", dsviapub=" + dsviapub + ", cdsiglas=" + cdsiglas + ", idtclasnom="
				+ idtclasnom + ", idtprovinc=" + idtprovinc + ", idthabilit=" + idthabilit + ", clasenomina="
				+ clasenomina + ", provincia=" + provincia + ", habilitacion=" + habilitacion + ", bperadm=" + bperadm
				+ ", bperban=" + bperban + ", sigdom=" + sigdom + "]";
	}
}
