package nedaes.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="TSIGDOM")
public class Sigdom implements Serializable {
	private static final long serialVersionUID = -2517851941873251681L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDTSIGDOM")
	private Integer idsigdom;
		
	@Column(name="CDSIGLAS", length=2)
	private String cdsiglas;
	
	@Column(name="DSSIGLAS", length=100)
	private String dssiglas;
	
	public Sigdom() {
		super();
	}

	public Sigdom(Integer idsigdom,	String cdsiglas, String dssiglas) {
		super();
		this.idsigdom = idsigdom;
		this.cdsiglas = cdsiglas;
		this.dssiglas = dssiglas;
	}

	public Integer getIdsigdom() {
		return idsigdom;
	}

	public void setIdsigdom(Integer idsigdom) {
		this.idsigdom = idsigdom;
	}

	public String getCdsiglas() {
		return cdsiglas;
	}


	public void setCdsiglas(String cdsiglas) {
		this.cdsiglas = cdsiglas;
	}

	public String getDssiglas() {
		return dssiglas;
	}

	public void setDssiglas(String dssiglas) {
		this.dssiglas = dssiglas;
	}

	@Override
	public String toString() {
		return "Sigdom [idsigdom=" + idsigdom + ", cdsiglas=" + cdsiglas + ", dssiglas=" + dssiglas + "]";
	}
}
