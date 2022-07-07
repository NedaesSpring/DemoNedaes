package nedaes.demo.model;

import java.io.Serializable;
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

@Entity
@Table(name="BPERSONA")
public class Bpersona implements Serializable{ 
	private static final long serialVersionUID = -2517851941873251692L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDBPERSONA")
	private Integer idbpersona;
		
	@Column(name="CDHABIL", length=3)
	private String cdhabil;
	
	@Column(name="CDCLASNM", length=2)
	private String cdclasnm;
	
	@Column(name="CDDNI", length=9)
	private String cddni ;

	@Column(name="CDDUP", length=1)
	private String cddup ;
	
	@Column(name="DSAPELL1", length=22)
	private String dsapell1;
	
	@Column(name="DSAPELLI2", length=22)
	private String dsapell2;
	
	@Column(name="DSNOMBRE", length=14)
	private String dsnombre;

	//Claves foráneas:
	/*
	id_claaenomina
	id_bperadm int ,
    id_bperrgss int,
    id_bpierpfn int,
    id_bpersesomuface int,
    id_bpersesomugeju int,
    id_bpersesoisfas int,
	*/	
	
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TCLASNOM_BPERSONA"), value = {@JoinColumn(name = "IDTCLASNOM", referencedColumnName = "IDTCLASNOM", nullable = false, insertable = false, updatable = false) })	
//	@NotNull(message = "El campo clase nomina no pueden estar vacío.")
    @ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TCLASNOM2_BPERSONA"), value = {@JoinColumn(name = "CDCLASNM", referencedColumnName = "CDCLASNM", nullable = false, insertable = false, updatable = false)})	
	private Clasenomina clasenomina;
	
    //, nullable = false, insertable = false, updatable = false
		
//	@NotNull(message = "El campo NUM. REG. PERSONAL no puede estar vacío.")
    @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumns(foreignKey = @ForeignKey(name = "FK_BPERADM_BPERSONA"), value = {@JoinColumn(name = "IDBPERADM", referencedColumnName = "IDBPERADM", nullable = false, insertable = false, updatable = false) })	
/*	@JoinColumns(foreignKey = @ForeignKey(name = "FK_BPERADM2_BPERSONA"), value = {
	  @JoinColumn(name = "CDHABIL", referencedColumnName = "CDHABIL", nullable = false, insertable = false, updatable = false),
	  @JoinColumn(name = "CDCLASNM", referencedColumnName = "CDCLASNM", nullable = false, insertable = false, updatable = false),
	  @JoinColumn(name = "CDDNI", referencedColumnName = "CDDNI", nullable = false, insertable = false, updatable = false),
	  @JoinColumn(name = "CDDUP", referencedColumnName = "CDDUP", nullable = false, insertable = false, updatable = false)})
	  */	
	private Bperadm bperadm;
    
//	@NotNull(message = "El campo RGSS ALFACLAVE no puede estar vacío.")
    @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumns(foreignKey = @ForeignKey(name = "FK_BPERRGSS_BPERSONA"), value = {@JoinColumn(name = "IDBPERRGSS", referencedColumnName = "IDBPERRGSS", nullable = false, insertable = false, updatable = false) })	
/*	@JoinColumns(foreignKey = @ForeignKey(name = "FK_BPERRGSS2_BPERSONA"), value = {
			  @JoinColumn(name = "CDHABIL", referencedColumnName = "CDHABIL", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDCLASNM", referencedColumnName = "CDCLASNM", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDDNI", referencedColumnName = "CDDNI", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDDUP", referencedColumnName = "CDDUP", nullable = false, insertable = false, updatable = false)})
*/	
	private Bperrgss bperrgss;

    
//	@NotNull(message = "Los campos del NIF no pueden estar vacíos.")
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_BPEIRPFN_BPERSONA"), value = {@JoinColumn(name = "IDBPEIRPFN", referencedColumnName = "IDBPEIRPFN", nullable = false, insertable = false, updatable = false) })	
/*	@JoinColumns(foreignKey = @ForeignKey(name = "FK_BPEIRPFN2_BPERSONA"), value = {
			  @JoinColumn(name = "CDHABIL", referencedColumnName = "CDHABIL", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDCLASNM", referencedColumnName = "CDCLASNM", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDDNI", referencedColumnName = "CDDNI", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDDUP", referencedColumnName = "CDDUP", nullable = false, insertable = false, updatable = false)})
*/			  	
	private Bpeirpfn bpeirpfn;
    
    
//	@NotNull(message = "El campo  ???  no puede estar vacío.")
    @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumns(foreignKey = @ForeignKey(name = "FK_BPERBAN_BPERSONA"), value = {@JoinColumn(name = "IDBPERBAN", referencedColumnName = "IDBPERBAN", nullable = false, insertable = false, updatable = false) })	
/*	@JoinColumns(foreignKey = @ForeignKey(name = "FK_BPERBAN3_BPERSONA"), value = {
			  @JoinColumn(name = "CDHABIL", referencedColumnName = "CDHABIL", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDCLASNM", referencedColumnName = "CDCLASNM", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDDNI", referencedColumnName = "CDDNI", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDDUP", referencedColumnName = "CDDUP", nullable = false, insertable = false, updatable = false)})
			  */	
    private Bperban bperban;

    //	@NotNull(message = "El campo  ???  no puede estar vacío.")
    @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumns(foreignKey = @ForeignKey(name = "FK_BPERSESOMUFACE_BPERSONA"), value = {@JoinColumn(name = "IDBPERSESOMUFACE", referencedColumnName = "IDBPERSESO", nullable = false, insertable = false, updatable = false) })
/*	@JoinColumns(foreignKey = @ForeignKey(name = "FK_BPERSESOMUFACE2_BPERSONA"), value = {
			  @JoinColumn(name = "CDHABIL", referencedColumnName = "CDHABIL", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDCLASNM", referencedColumnName = "CDCLASNM", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDDNI", referencedColumnName = "CDDNI", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDDUP", referencedColumnName = "CDDUP", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "IDBPERSESOMUFACE", referencedColumnName = "IDBPERSESO", nullable = false, insertable = false, updatable = false)})
*/
	private Bperseso bpersesomuface;
    
//	@NotNull(message = "El campo  ???  no puede estar vacío.")
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_BPERSESOMUGEJU_BPERSONA"), value = {@JoinColumn(name = "IDBPERSESOMUGEJU", referencedColumnName = "IDBPERSESO", nullable = false, insertable = false, updatable = false) })	
/*	@JoinColumns(foreignKey = @ForeignKey(name = "FK_BPERSESOMUGEJU2_BPERSONA"), value = {
			  @JoinColumn(name = "CDHABIL", referencedColumnName = "CDHABIL", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDCLASNM", referencedColumnName = "CDCLASNM", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDDNI", referencedColumnName = "CDDNI", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDDUP", referencedColumnName = "CDDUP", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "IDBPERSESOMUGEJU", referencedColumnName = "IDBPERSESO", nullable = false, insertable = false, updatable = false)})
*/
	private Bperseso bpersesomugeju;
    
//	@NotNull(message = "El campo  ???  no puede estar vacío.")
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_BPERSESOISFAS_BPERSONA"), value = {@JoinColumn(name = "IDBPERSESOISFAS", referencedColumnName = "IDBPERSESO", nullable = false, insertable = false, updatable = false) })	
/*    @JoinColumns(foreignKey = @ForeignKey(name = "FK_BPERSESOISFAS2_BPERSONA"), value = {
			  @JoinColumn(name = "CDHABIL", referencedColumnName = "CDHABIL", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDCLASNM", referencedColumnName = "CDCLASNM", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDDNI", referencedColumnName = "CDDNI", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "CDDUP", referencedColumnName = "CDDUP", nullable = false, insertable = false, updatable = false),
			  @JoinColumn(name = "IDBPERSESOISFAS", referencedColumnName = "IDBPERSESO", nullable = false, insertable = false, updatable = false)})
*/
	private Bperseso bpersesoisfas;
	
	
    public Bpersona() {
		super();
	}

    public Bpersona(Integer idbpersona, String cdhabil, String cddni, 
    		String cdclasnm, 
    		String cddup, String dsapell1,
		String dsapell2, String dsnombre,
		@NotNull(message = "El campo clase nomina no pueden estar vacío.") Clasenomina clasenomina, Bperadm bperadm,
		Bperrgss bperrgss, Bpeirpfn bpeirpfn, Bperseso bpersesomuface, Bperseso bpersesomugeju,
		Bperseso bpersesoisfas
//		,  Bperban bperban
		)	{
	super();
	this.idbpersona = idbpersona;
	this.cdhabil = cdhabil;
	this.cdclasnm = cdclasnm;
	this.cddni = cddni;
	this.cddup = cddup;
	this.dsapell1 = dsapell1;
	this.dsapell2 = dsapell2;
	this.dsnombre = dsnombre;
	this.clasenomina = clasenomina;
	this.bperadm = bperadm;
	this.bperrgss = bperrgss;
	this.bpeirpfn = bpeirpfn;
	this.bpersesomuface = bpersesomuface;
	this.bpersesomugeju = bpersesomugeju;
	this.bpersesoisfas = bpersesoisfas;
//	this.bperban = bperban;
	
}

	public Integer getIdbpersona() {
		return idbpersona;
	}

	public void setIdbpersona(Integer idbpersona) {
		this.idbpersona = idbpersona;
	}

	public String getCdhabil() {
		return cdhabil;
	}

	public void setCdhabil(String cdhabil) {
		this.cdhabil = cdhabil;
	}
	
	public String getCdclasnm() {
		return cdclasnm;
	}

	public void setCdclasnm(String cdclasnm) {
		this.cdclasnm = cdclasnm;
	}

	public String getCddni() {
		return cddni;
	}	
	
	public void setCddni(String cddni) {
		this.cddni = cddni;
	}

	public String getCddup() {
		return cddup;
	}

	public void setCddup(String cddup) {
		this.cddup = cddup;
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

	public String getDsnombre() {
		return dsnombre;
	}

	public void setDsnombre(String dsnombre) {
		this.dsnombre = dsnombre;
	}

	
	public Clasenomina getClasenomina() {
		return clasenomina;
	}

	public void setClasenomina(Clasenomina clasenomina) {
		this.clasenomina = clasenomina;
	}

	public Bperadm getBperadm() {
		return bperadm;
	}

	public void setBperadm(Bperadm bperadm) {
		this.bperadm = bperadm;
	}

	public Bperrgss getBperrgss() {
		return bperrgss;
	}

	public void setBperrgss(Bperrgss bperrgss) {
		this.bperrgss = bperrgss;
	}

	public Bpeirpfn getBpeirpfn() {
		return bpeirpfn;
	}

	public void setBpeirpfn(Bpeirpfn bpeirpfn) {
		this.bpeirpfn = bpeirpfn;
	}

	public Bperseso getBpersesomuface() {
		return bpersesomuface;
	}

	public void setBpersesomuface(Bperseso bpersesomuface) {
		this.bpersesomuface = bpersesomuface;
	}

	public Bperseso getBpersesomugeju() {
		return bpersesomugeju;
	}

	public void setBpersesomugeju(Bperseso bpersesomugeju) {
		this.bpersesomugeju = bpersesomugeju;
	}

	public Bperseso getBpersesoisfas() {
		return bpersesoisfas;
	}

	public void setBpersesoisfas(Bperseso bpersesoisfas) {
		this.bpersesoisfas = bpersesoisfas;
	}

/*	
	
	public Bperban getBperban() {
		return bperban;
	}

	public void setBperban(Bperban bperban) {
		this.bperban = bperban;
	}
*/
	@Override
	public String toString() {
		return "Bpersona [idbpersona=" + idbpersona + ", cdhabil=" + cdhabil + 
				", cdclasnm=" + cdclasnm + 
				", cddni="
				+ cddni + ", cddup=" + cddup + ", dsapell1=" + dsapell1 + ", dsapell2=" + dsapell2 + ", dsnombre="
				+ dsnombre + ", clasenomina=" + clasenomina + ", bperadm=" + bperadm + ", bperrgss=" + bperrgss
				+ ", bpeirpfn=" + bpeirpfn + ", bpersesomuface=" + bpersesomuface + ", bpersesomugeju=" + bpersesomugeju
				+ ", bpersesoisfas=" + bpersesoisfas + "]";
	}
}
