package nedaes.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name="THABILIT")
public class HabilitacionInicial implements Serializable{
	private static final long serialVersionUID = -2517851941873251687L;

	@Id
	@GeneratedValue(generator="THABILIT_SEQ") 
	@SequenceGenerator(name="THABILIT_SEQ",sequenceName="THABILIT_SEQ", allocationSize=1)
	@Column(name="IDTHABILIT")
	private Integer idHabilitacion;

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull(message="El codigo de hablitación no puede estar vacío")
	@Column(name="CDHABIL", length=3)	
	private String cdhabil;
	
	@Column(name="DSORGEXT", length=60)
	private String  dsorgext;   
	 
	@Column(name="DSORG", length=36)
	private String dsorg;
		 

	public Integer getIdHabilitacion() {
		return idHabilitacion;
	}

	public void setIdHabilitacion(Integer idHabilitacion) {
		this.idHabilitacion = idHabilitacion;
	}

	public String getCdhabil() {
		return cdhabil;
	}

	public void setCdhabil(String cdhabil) {
		this.cdhabil = cdhabil;
	}

	public String getDsorgext() {
		return dsorgext;
	}

	public void setDsorgext(String dsorgext) {
		this.dsorgext = dsorgext;
	}

	public String getDsorg() {
		return dsorg;
	}

	public void setDsorg(String dsorg) {
		this.dsorg = dsorg;
	}

	public HabilitacionInicial(Integer idHabilitacion, String cdhabil, String dsorgext, String dsorg) {
		super();
		this.idHabilitacion = idHabilitacion;
		this.cdhabil = cdhabil;
		this.dsorgext = dsorgext;
		this.dsorg = dsorg;
	}

	public HabilitacionInicial() {
		super();
	}
}

	
	
	