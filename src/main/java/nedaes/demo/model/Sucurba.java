package nedaes.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.ForeignKey;
import java.io.Serializable;

@Entity
@Table(name="TSUCURBA")
public class Sucurba implements Serializable{
	private static final long serialVersionUID = -2517851941873251680L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDTSUCURBA")
	private Integer idsucurba;
	
//	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TBANCOS_TSUCURBA"), value = {@JoinColumn(name = "IDTBANCOS", referencedColumnName = "IDTBANCOS", nullable = false, insertable = false, updatable = false )})	
	@NotNull(message="El campo cdBanco no puede estar vacío")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns(foreignKey = @ForeignKey(name = "FK_TBANCOS2_TSUCURBA"), value = {@JoinColumn(name = "CDBANCO", referencedColumnName = "CDBANCO", nullable = false, insertable = false, updatable = false )})	
	private Banco banco;
	
    @Column(name="idtbancos", length=10)
	private Integer idbanco;
	
	@Column(name="CDBANCO", length=4)
	private String cdbanco;
	
	@Column(name="CDSUCUR", length=4)
	private String cdsucur;
	
	@Column(name="DSDOMIC", length=40)
	private String dsdomic;
	
	@Column(name="DSPLAZA", length=40)
	private String dsplaza;
	
	@Column(name="CDPROV", length=2)
	private String cdprov;
	
	@Column(name="DSRESTO", length=195)
	private String dsresto;
	
	@Column(name="CDNACION", length=3)
	private String cdnacion;
	
	@Column(name="CDBIC", length=11)
	private String cdbic;

	
	
	public Sucurba() {
		super();
	}

	

	public Sucurba(Integer idsucurba, @NotNull(message = "El campo cdBanco no puede estar vacío") Banco banco,
			String cdbanco, String cdsucur, String dsdomic, String dsplaza, String cdprov, String dsresto,
			String cdnacion, String cdbic) {
		super();
		this.idsucurba = idsucurba;
		this.banco = banco;
		this.cdbanco = cdbanco;
		this.cdsucur = cdsucur;
		this.dsdomic = dsdomic;
		this.dsplaza = dsplaza;
		this.cdprov = cdprov;
		this.dsresto = dsresto;
		this.cdnacion = cdnacion;
		this.cdbic = cdbic;
	}



	public Integer getIdsucurba() {
		return idsucurba;
	}

	public void setIdsucurba(Integer idsucurba) {
		this.idsucurba = idsucurba;
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

	public String getDsdomic() {
		return dsdomic;
	}

	public void setDsdomic(String dsdomic) {
		this.dsdomic = dsdomic;
	}

	public String getDsplaza() {
		return dsplaza;
	}

	public void setDsplaza(String dsplaza) {
		this.dsplaza = dsplaza;
	}

	public String getCdprov() {
		return cdprov;
	}

	public void setCdprov(String cdprov) {
		this.cdprov = cdprov;
	}

	public String getDsresto() {
		return dsresto;
	}

	public void setDsresto(String dsresto) {
		this.dsresto = dsresto;
	}

	public String getCdnacion() {
		return cdnacion;
	}

	public void setCdnacion(String cdnacion) {
		this.cdnacion = cdnacion;
	}

	public String getCdbic() {
		return cdbic;
	}

	public void setCdbic(String cdbic) {
		this.cdbic = cdbic;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

    public String getBancoPlano() {
 		if (banco == null) {
 			return "";
 		} else {
 			return banco.getDsbanco();
 	    } 
    }

 
	@Override
	public String toString() {
		return "Sucurba [idsucurba=" + idsucurba + ", banco=" + banco + ", cdbanco=" + cdbanco + ", cdsucur=" + cdsucur
				+ ", dsdomic=" + dsdomic + ", dsplaza=" + dsplaza + ", cdprov=" + cdprov + ", dsresto=" + dsresto
				+ ", cdnacion=" + cdnacion + ", cdbic=" + cdbic + "]";
	}
}
