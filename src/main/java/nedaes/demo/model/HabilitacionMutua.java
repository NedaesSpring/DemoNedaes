package nedaes.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Table(name = "THABILIT")
public class HabilitacionMutua implements Serializable{
	private static final long serialVersionUID = -2517851941873251686L;

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

	// DATOS MUFACE//
	////////////////
	@Pattern(regexp = "[0-9]{8}([A-Z]|[a-z]){1}", message = "Debe introducir un NIF con formato correcto")
	@NotNull(message="El campo nif habilitadono puede estar vacío")
	@Column(name="cdidmuf", nullable = true, length=9)	
	private String cdidmuf;
	
	@Column(name="cdorgmuf", nullable = true, length=9)	
	private String cdorgmuf;
	
	@Column(name="cdordmuf", nullable = true, length=9)	
	private String cdordmuf;
	
	
	//DATOS ISFAS//
	///////////////
	@Column(name="cdistipadm", nullable = true, length=1)	
	private String cdistipadm;
	
	@Column(name="dsisretap1", nullable = true, length=25)	
	private String dsisretap1;
	
	@Column(name="dsisretap2", nullable = true, length=25)	
	private String dsisretap2;
	
	@Column(name="dsisretnom", nullable = true, length=20)	
	private String dsisretnom;
				
	@Column(name="dsisordap1", nullable = true, length=25)	
	private String dsisordap1;
	
	@Column(name="dsisordap2", nullable = true, length=25)	
	private String dsisordap2;
	
	@Column(name="dsisordnom", nullable = true, length=20)	
	private String dsisordnom;
	
	
	//DATOS MUGEJU//
	////////////////
	@Column(name="cdmujorg", nullable = true, length=2)	
	private String cdmujorg;

	@Column(name="dsmujorg", nullable = true, length=42)	
	private String dsmujorg;

	@Column(name="cdmujger",nullable = true,  length=2)	
	private String cdmujger;

	@Column(name="dsmujger",nullable = true,  length=20)	
	private String dsmujger;
	
	
	//DATOS RGSS//
	//////////////
	@Column(name="cdautoriz", nullable = true, length=8)	
	private Integer cdautoriz;
	

	@Column(name="feautoriz", nullable = true, length=7)	
	private Integer feautoriz;
	
	              //cdc...... " Código Emisor de Empresa (NIB)" //
	
	@Column(name="dsautoriz", nullable = true, length=60)	
	private String dsautoriz;
	
	              // checkbox ...... " Ded. Cont. Exc. MUNPAL en TC-1 Empresa"  //
	
	@Column(name="txtc11", nullable = true, length=18)	
	private String txtc11;

	@Column(name="txtc12", nullable = true, length=18)	
	private String txtc12;

	@Column(name="txtc13", nullable = true, length=18)	
	private String txtc13;

	@Column(name="txtc14", nullable = true, length=18)	
	private String txtc14;

	public HabilitacionMutua() {
		super();
	}

	public Integer getIdHabilitacion() {
		return idHabilitacion;
	}

	public void setIdHabilitacion(Integer idHabilitacion) {
		this.idHabilitacion = idHabilitacion;
	}

	public String getCdidmuf() {
		return cdidmuf;
	}

	public void setCdidmuf(String cdidmuf) {
		this.cdidmuf = cdidmuf;
	}

	public String getCdorgmuf() {
		return cdorgmuf;
	}

	public void setCdorgmuf(String cdorgmuf) {
		this.cdorgmuf = cdorgmuf;
	}

	public String getCdordmuf() {
		return cdordmuf;
	}

	public void setCdordmuf(String cdordmuf) {
		this.cdordmuf = cdordmuf;
	}

	public String getCdistipadm() {
		return cdistipadm;
	}

	public void setCdistipadm(String cdistipadm) {
		this.cdistipadm = cdistipadm;
	}

	public String getDsisretap1() {
		return dsisretap1;
	}

	public void setDsisretap1(String dsisretap1) {
		this.dsisretap1 = dsisretap1;
	}

	public String getDsisretap2() {
		return dsisretap2;
	}

	public void setDsisretap2(String dsisretap2) {
		this.dsisretap2 = dsisretap2;
	}

	public String getDsisretnom() {
		return dsisretnom;
	}

	public void setDsisretnom(String dsisretnom) {
		this.dsisretnom = dsisretnom;
	}

	public String getDsisordap1() {
		return dsisordap1;
	}

	public void setDsisordap1(String dsisordap1) {
		this.dsisordap1 = dsisordap1;
	}

	public String getDsisordap2() {
		return dsisordap2;
	}

	public void setDsisordap2(String dsisordap2) {
		this.dsisordap2 = dsisordap2;
	}

	public String getDsisordnom() {
		return dsisordnom;
	}

	public void setDsisordnom(String dsisordnom) {
		this.dsisordnom = dsisordnom;
	}

	public String getCdmujorg() {
		return cdmujorg;
	}

	public void setCdmujorg(String cdmujorg) {
		this.cdmujorg = cdmujorg;
	}

	public String getDsmujorg() {
		return dsmujorg;
	}

	public void setDsmujorg(String dsmujorg) {
		this.dsmujorg = dsmujorg;
	}

	public String getCdmujger() {
		return cdmujger;
	}

	public void setCdmujger(String cdmujger) {
		this.cdmujger = cdmujger;
	}

	public String getDsmujger() {
		return dsmujger;
	}

	public void setDsmujger(String dsmujger) {
		this.dsmujger = dsmujger;
	}

	public Integer getCdautoriz() {
		return cdautoriz;
	}

	public void setCdautoriz(Integer cdautoriz) {
		this.cdautoriz = cdautoriz;
	}

	public Integer getFeautoriz() {
		return feautoriz;
	}

	public void setFeautoriz(Integer feautoriz) {
		this.feautoriz = feautoriz;
	}

	public String getDsautoriz() {
		return dsautoriz;
	}

	public void setDsautoriz(String dsautoriz) {
		this.dsautoriz = dsautoriz;
	}

	public String getTxtc11() {
		return txtc11;
	}

	public void setTxtc11(String txtc11) {
		this.txtc11 = txtc11;
	}

	public String getTxtc12() {
		return txtc12;
	}

	public void setTxtc12(String txtc12) {
		this.txtc12 = txtc12;
	}

	public String getTxtc13() {
		return txtc13;
	}

	public void setTxtc13(String txtc13) {
		this.txtc13 = txtc13;
	}

	public String getTxtc14() {
		return txtc14;
	}

	public void setTxtc14(String txtc14) {
		this.txtc14 = txtc14;
	}

	public String getCdhabil() {
		return cdhabil;
	}

	public void setCdhabil(String cdhabil) {
		this.cdhabil = cdhabil;
	}

	
	
	public HabilitacionMutua(Integer idHabilitacion, String cdhabil,
			@Pattern(regexp = "[0-9]{8}([A-Z]|[a-z]){1}", message = "Debe introducir un NIF con formato correcto") @NotNull(message = "El campo nif habilitadono puede estar vacío") String cdidmuf,
			String cdorgmuf, String cdordmuf, String cdistipadm, String dsisretap1, String dsisretap2,
			String dsisretnom, String dsisordap1, String dsisordap2, String dsisordnom, String cdmujorg,
			String dsmujorg, String cdmujger, String dsmujger, Integer cdautoriz, Integer feautoriz, String dsautoriz,
			String txtc11, String txtc12, String txtc13, String txtc14) {
		super();
		this.idHabilitacion = idHabilitacion;
		this.cdhabil = cdhabil;
		this.cdidmuf = cdidmuf;
		this.cdorgmuf = cdorgmuf;
		this.cdordmuf = cdordmuf;
		this.cdistipadm = cdistipadm;
		this.dsisretap1 = dsisretap1;
		this.dsisretap2 = dsisretap2;
		this.dsisretnom = dsisretnom;
		this.dsisordap1 = dsisordap1;
		this.dsisordap2 = dsisordap2;
		this.dsisordnom = dsisordnom;
		this.cdmujorg = cdmujorg;
		this.dsmujorg = dsmujorg;
		this.cdmujger = cdmujger;
		this.dsmujger = dsmujger;
		this.cdautoriz = cdautoriz;
		this.feautoriz = feautoriz;
		this.dsautoriz = dsautoriz;
		this.txtc11 = txtc11;
		this.txtc12 = txtc12;
		this.txtc13 = txtc13;
		this.txtc14 = txtc14;
	}

	@Override
	public String toString() {
		return "HabilitacionMutua [idHabilitacion=" + idHabilitacion + ", cdhabil=" + cdhabil + ", cdidmuf=" + cdidmuf
				+ ", cdorgmuf=" + cdorgmuf + ", cdordmuf=" + cdordmuf + ", cdistipadm=" + cdistipadm + ", dsisretap1="
				+ dsisretap1 + ", dsisretap2=" + dsisretap2 + ", dsisretnom=" + dsisretnom + ", dsisordap1="
				+ dsisordap1 + ", dsisordap2=" + dsisordap2 + ", dsisordnom=" + dsisordnom + ", cdmujorg=" + cdmujorg
				+ ", dsmujorg=" + dsmujorg + ", cdmujger=" + cdmujger + ", dsmujger=" + dsmujger + ", cdautoriz="
				+ cdautoriz + ", feautoriz=" + feautoriz + ", dsautoriz=" + dsautoriz + ", txtc11=" + txtc11
				+ ", txtc12=" + txtc12 + ", txtc13=" + txtc13 + ", txtc14=" + txtc14 + "]";
	}
}
