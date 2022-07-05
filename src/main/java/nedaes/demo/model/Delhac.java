package nedaes.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="TDELHAC")
public class Delhac implements Serializable{
	private static final long serialVersionUID = -2517851941873251690L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDTDELHAC")
	private Integer iddelhac;

	@Column(name="CDDELHAC")
	private Integer cddelhac;
	
	@Column(name="DSDELHAC", length=100)
	private String dsdelhac;

	public Delhac() {
		super();
	}


	public Delhac(Integer cddelhac, String dsdelhac) {
		super();
		this.cddelhac = cddelhac;
		this.dsdelhac = dsdelhac;
	}

	public Integer getCddelhac() {
		return cddelhac;
	}


	public void setCddelhac(Integer cddelhac) {
		this.cddelhac = cddelhac;
	}


	public String getDsdelhac() {
		return dsdelhac;
	}


	public void setDsdelhac(String dsdelhac) {
		this.dsdelhac = dsdelhac;
	}


	public Delhac(Integer iddelhac, Integer cddelhac, String dsdelhac) {
		super();
		this.iddelhac = iddelhac;
		this.cddelhac = cddelhac;
		this.dsdelhac = dsdelhac;
	}


}
