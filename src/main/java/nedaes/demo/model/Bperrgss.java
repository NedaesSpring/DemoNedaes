package nedaes.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="BPERRGSS")
public class Bperrgss implements Serializable{
	private static final long serialVersionUID = -2517851941873251694L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDBPERRGSS")
	private Integer idbperrgss;
		
	@Column(name="CDHABIL", length=3)
	private String cdhabil;
	
	@Column(name="CDCLASNM", length=2)
	private String cdclasnm;
	
	@Column(name="CDDNI", length=9)
	private String cddni ;

	@Column(name="CDDUP", length=1)
	private String cddup ;
	
	@Column(name="CDALFACLAVE", length=14)
	private String cdalfaclave ;

	public Bperrgss() {
		super();
	}

	public Bperrgss(Integer idbperrgss, String cdhabil, String cdclasnm, String cddni, String cddup,
			String cdalfaclave) {
		super();
		this.idbperrgss = idbperrgss;
		this.cdhabil = cdhabil;
		this.cdclasnm = cdclasnm;
		this.cddni = cddni;
		this.cddup = cddup;
		this.cdalfaclave = cdalfaclave;
	}

	public Integer getIdbperrgss() {
		return idbperrgss;
	}

	public void setIdbperrgss(Integer idbperrgss) {
		this.idbperrgss = idbperrgss;
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

	public String getCdalfaclave() {
		return cdalfaclave;
	}

	public void setCdalfaclave(String cdalfaclave) {
		this.cdalfaclave = cdalfaclave;
	}

	@Override
	public String toString() {
		return "Bperrgss [idbperrgss=" + idbperrgss + ", cdhabil=" + cdhabil + ", cdclasnm=" + cdclasnm + ", cddni="
				+ cddni + ", cddup=" + cddup + ", cdalfaclave=" + cdalfaclave + "]";
	}
	
}
