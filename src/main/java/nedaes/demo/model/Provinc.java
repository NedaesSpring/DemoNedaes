package nedaes.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="TPROVINC")
public class Provinc implements Serializable{
	private static final long serialVersionUID = -2517851941873251682L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDTPROVINC")
	private Integer idProvincia;
		
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CDPROV", length=2)
	private Integer cdprov ;
	
	@Column(name="DSPROV", length=100)
	private String dsprov ;


	public Provinc() {
		super();
	}

	public Provinc(Integer idProvincia, Integer cdprov, String dsprov) {
		super();
		this.idProvincia = idProvincia;
		this.cdprov = cdprov;
		this.dsprov = dsprov;
	}

	public Integer getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
	}

	public Integer getCdprov() {
		return cdprov;
	}

	public void setCdprov(Integer cdprov) {
		this.cdprov = cdprov;
	}

	public String getDsprov() {
		return dsprov;
	}

	public void setDsprov(String dsprov) {
		this.dsprov = dsprov;
	}

	@Override
	public String toString() {
		return "Provinc ["
//				+ "idProvincia=" + idProvincia + ", "
				+ "cdprov=" + cdprov + ", dsprov=" + dsprov + "]";
	}

	
}
