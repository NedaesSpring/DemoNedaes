package nedaes.demo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TCLASNOM")
public class Clasenomina implements Serializable{
	private static final long serialVersionUID = -2517851941873251691L;

	@Id
	@GeneratedValue(generator="TCLASNOM_SEQ") 
	@SequenceGenerator(name="TCLASNOM_SEQ",sequenceName="TCLASNOM_SEQ", allocationSize=1)
	@Column(name="IDTCLASNOM")
	private Integer idClasenomina;

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CDCLASNM", length=2)
	private String cdclasnm;
	
	@Column(name="DSCLASNM", length=100)
	private String dsclasnm;

	@Column(name="CDCLAPER", length=1)
	private String cdclaper;
	
	@Column(name="CDSSPERS2", length=1)
	private String cdsspers2 ;
	
	@Column(name="DIASNAT", length=1)
	private String diasnat;

	@Column(name="CDCLAPLE", length=2)
	private String cdclaple;
	
	@Column(name="OTVARAGR", length=1)
	private String otvaragr;

	public Clasenomina(
			Integer idClasenomina, 
			String cdclasnm, String dsclasnm, String cdclaper, String cdsspers2,
			String diasnat, String cdclaple, String otvaragr) {
		super();
		this.idClasenomina = idClasenomina;
		this.cdclasnm = cdclasnm;
		this.dsclasnm = dsclasnm;
		this.cdclaper = cdclaper;
		this.cdsspers2 = cdsspers2;
		this.diasnat = diasnat;
		this.cdclaple = cdclaple;
		this.otvaragr = otvaragr;
	}

	public Clasenomina() {
		super();
	}

	public Integer getIdClasenomina() {
		return idClasenomina;
	}

	public void setIdClasenomina(Integer idClasenomina) {
		this.idClasenomina = idClasenomina;
	}

	public String getCdclasnm() {
		return cdclasnm;
	}

	public void setCdclasnm(String cdclasnm) {
		this.cdclasnm = cdclasnm;
	}

	public String getDsclasnm() {
		return dsclasnm;
	}

	public void setDsclasnm(String dsclasnm) {
		this.dsclasnm = dsclasnm;
	}

	public String getCdclaper() {
		return cdclaper;
	}

	public void setCdclaper(String cdclaper) {
		this.cdclaper = cdclaper;
	}

	public String getCdsspers2() {
		return cdsspers2;
	}

	public void setCdsspers2(String cdsspers2) {
		this.cdsspers2 = cdsspers2;
	}

	public String getDiasnat() {
		return diasnat;
	}

	public void setDiasnat(String diasnat) {
		this.diasnat = diasnat;
	}

	public String getCdclaple() {
		return cdclaple;
	}

	public void setCdclaple(String cdclaple) {
		this.cdclaple = cdclaple;
	}

	public String getOtvaragr() {
		return otvaragr;
	}

	public void setOtvaragr(String otvaragr) {
		this.otvaragr = otvaragr;
	}

	@Override
	public String toString() {
		return "Clasenomina ["
				+ "idClasenomina=" + idClasenomina + "," 
				+ "cdclasnm=" + cdclasnm + ", dsclasnm=" + dsclasnm
				+ ", cdclaper=" + cdclaper + ", cdsspers2=" + cdsspers2 + ", diasnat=" + diasnat + ", cdclaple="
				+ cdclaple + ", otvaragr=" + otvaragr + "]";
	}


}

	
	
	