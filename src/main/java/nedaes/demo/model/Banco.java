package nedaes.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="TBANCOS")
public class Banco implements Serializable{
	private static final long serialVersionUID = -2517851941873251698L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDTBANCOS")
	private Integer idbanco;
		
	@Column(name="CDBANCO", length=4)
	private String cdbanco;

	@Column(name="DSBANCO", length=100)
	private String dsbanco;
	
	@Column(name="OTBANEX", length=1)
	private String otbanex;

	@Column(name="CDBIC", nullable = true, length=11)
	private String cdbic;

	public Banco() {
		super();
	}

	public Banco(Integer idbanco, String dsbanco, String cdbanco, String otbanex, String cdbic) {
		super();
		this.idbanco = idbanco;
		this.dsbanco = dsbanco;
		this.cdbanco = cdbanco;
		this.otbanex = otbanex;
		this.cdbic = cdbic;
	}

	public Integer getIdbanco() {
		return idbanco;
	}

	public void setIdbanco(Integer idbanco) {
		this.idbanco = idbanco;
	}

	public String getDsbanco() {
		return dsbanco;
	}

	public void setDsbanco(String dsbanco) {
		this.dsbanco = dsbanco;
	}

	public String getCdbanco() {
		return cdbanco;
	}

	public void setCdbanco(String cdbanco) {
		this.cdbanco = cdbanco;
	}

	public String getOtbanex() {
		return otbanex;
	}

	public void setOtbanex(String otbanex) {
		this.otbanex = otbanex;
	}

	public String getCdbic() {
		return cdbic;
	}

	public void setCdbic(String cdbic) {
		this.cdbic = cdbic;
	}

	@Override
	public String toString() {
		return "Bancos [idbanco=" + idbanco + ", dsbanco=" + dsbanco + ", cdbanco=" + cdbanco + ", otbanex=" + otbanex + ", cdbic=" + cdbic + "]";
	}

}
