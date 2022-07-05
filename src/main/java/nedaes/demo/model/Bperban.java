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
@Table(name="BPERBAN")
public class Bperban implements Serializable{
	private static final long serialVersionUID = -2517851941873251695L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDBPERBAN")
	private Integer idbperban ;
		
	@Column(name="CDHABIL", length=3)
	private String cdhabil;
	
	@Column(name="CDCLASNM", length=2)
	private String cdclasnm;
	
	@Column(name="CDDNI", length=9)
	private String cddni ;

	@Column(name="CDDUP", length=1)
	private String cddup ;
	
	@Column(name="CDBANCO", length=1)
	private String cdbanco ;
	
	@Column(name="CDSUCUR", length=1)
	private String cdsucur ;
	
	public Bperban() {
		super();
	}

//	@JoinColumns(foreignKey = @ForeignKey(name = "SYS_C00730931FK_TBANCOS1_BPERBAN"), value = {@JoinColumn(name = "CDBANCO", referencedColumnName = "CDBANCO", nullable = false, insertable = false, updatable = false )})	
	@NotNull(message="El campo cdBanco no puede estar vacío")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns(foreignKey = @ForeignKey(name = "SYS_C00730931"), value = {@JoinColumn(name = "CDBANCO", referencedColumnName = "CDBANCO", nullable = false, insertable = false, updatable = false )})	
	private Banco banco;

	public Bperban(Integer idbperban, String cdhabil, String cdclasnm, String cddni, String cddup, String cdbanco,
			String cdsucur, @NotNull(message = "El campo cdBanco no puede estar vacío") Banco banco) {
		super();
		this.idbperban = idbperban;
		this.cdhabil = cdhabil;
		this.cdclasnm = cdclasnm;
		this.cddni = cddni;
		this.cddup = cddup;
		this.cdbanco = cdbanco;
		this.cdsucur = cdsucur;
		this.banco = banco;
	}


	public Integer getIdbperban() {
		return idbperban;
	}


	public void setIdbperban(Integer idbperban) {
		this.idbperban = idbperban;
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


	public String getCdbanco() {
		return cdbanco;
	}


	public void setCdbanco(String cdbanco) {
		this.cdbanco = cdbanco;
	}


	public String getCdsucur() {
		return cdsucur;
	}


	public void setCdsucur(String cdsucur) {
		this.cdsucur = cdsucur;
	}

	public Banco getBanco() {
		return banco;
	}


	public void setBanco(Banco banco) {
		this.banco = banco;
	}


	@Override
	public String toString() {
		return "Bperban [idbperban=" + idbperban + ", cdhabil=" + cdhabil + ", cdclasnm=" + cdclasnm + ", cddni="
				+ cddni + ", cddup=" + cddup + ", cdbanco=" + cdbanco + ", cdsucur=" + cdsucur + "]";
	}
	
}

