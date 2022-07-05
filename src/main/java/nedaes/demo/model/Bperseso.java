package nedaes.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="BPERSESO")
public class Bperseso implements Serializable{
	private static final long serialVersionUID = -2517851941873251693L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDBPERSESO")
	private Integer idbperseso ;
		
	@Column(name="CDHABIL", length=3)
	private String cdhabil;
	
	@Column(name="CDCLASNM", length=2)
	private String cdclasnm;
	
	@Column(name="CDDNI", length=9)
	private String cddni ;

	@Column(name="CDDUP", length=1)
	private String cddup ;

	public Bperseso() {
		super();
	}

	public Bperseso(Integer idbperseso, String cdhabil, String cdclasnm, String cddni, String cddup) {
		super();
		this.idbperseso = idbperseso;
		this.cdhabil = cdhabil;
		this.cdclasnm = cdclasnm;
		this.cddni = cddni;
		this.cddup = cddup;
	}

	public Integer getIdbperseso() {
		return idbperseso;
	}

	public void setIdbperseso(Integer idbperseso) {
		this.idbperseso = idbperseso;
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

	@Override
	public String toString() {
		return "Bperseso [idbperseso=" + idbperseso + ", cdhabil=" + cdhabil + ", cdclasnm=" + cdclasnm + ", cddni="
				+ cddni + ", cddup=" + cddup + "]";
	}
}


