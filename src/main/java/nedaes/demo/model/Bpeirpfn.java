package nedaes.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Table(name="BPEIRPFN")
public class Bpeirpfn implements Serializable{
	private static final long serialVersionUID = -2517851941873251697L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDBPEIRPFN ")
	private Integer idbpeirpfn  ;
		
	@Column(name="CDHABIL", length=3)
	private String cdhabil;
	
	@Column(name="CDCLASNM", length=2)
	private String cdclasnm;
	
	@Column(name="CDDNI", length=9)
	private String cddni ;

	@Column(name="CDDUP", length=1)
	private String cddup ;
	
	@Pattern(regexp = "[0-9]{8}([A-Z]|[a-z]){1}", message = "Debe introducir un NIF con formato correcto")
	@Column(name="cdnif", length=10)
	private String cdnif;


    public Bpeirpfn() {
	     super(); 
    }

	public Bpeirpfn(Integer idbpeirpfn, String cdhabil, String cdclasnm, String cddni, String cddup, String cdnif) {
		super();
		this.idbpeirpfn = idbpeirpfn;
		this.cdhabil = cdhabil;
		this.cdclasnm = cdclasnm;
		this.cddni = cddni;
		this.cddup = cddup;
		this.cdnif = cdnif;
	}

	public Integer getIdbpeirpfn() {
		return idbpeirpfn;
	}

	public void setIdbpeirpfn(Integer idbpeirpfn) {
		this.idbpeirpfn = idbpeirpfn;
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

	public String getCdnif() {
		return cdnif;
	}

	public void setCdnif(String cdnif) {
		this.cdnif = cdnif;
	}

	@Override
	public String toString() {
		return "Bpeirpfn [idbpeirpfn=" + idbpeirpfn + ", cdhabil=" + cdhabil + ", cdclasnm=" + cdclasnm + ", cddni="
				+ cddni + ", cddup=" + cddup + ", cdnif=" + cdnif + "]";
	}
}
