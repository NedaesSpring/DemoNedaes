package nedaes.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="BPERADM")
public class Bperadm implements Serializable{
		private static final long serialVersionUID = -2517851941873251696L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDBPERADM")
	private Integer idbperadm ;
		
	@Column(name="CDHABIL", length=3)
	private String cdhabil;
	
	@Column(name="CDCLASNM", length=2)
	private String cdclasnm;
	
	@Column(name="CDDNI", length=9)
	private String cddni ;

	@Column(name="CDDUP", length=1)
	private String cddup ;
	
	@Column(name="NMREGPER", length=21)
	private String nmregper;

	@Column(name="CDPROV", length=2)
	private String cdprov ;

	@Column(name="CDSITNOM", length=21)
	private String cdsitnom;

	@Column(name="CDAGRUPN", length=6)
	private String cdagrupn;
	
	@Column(name="CDAGRUPR", length=6)
	private String cdagrupr;

	@Column(name="FEALTANO", length=7)
	private Integer fealtano;
	
	@Column(name="CDMOTIVA", length=3)
	private String cdmotiva;

	@Column(name="FEEFECOA", length=7)
	private Integer feefecoa;

	@Column(name="CDLOC", length=3)
	private String cdloc;

	@Column(name="CDPAIS", length=3)
	private String cdpais;

	@Column(name="CDDOMI", length=3)
	private String cddomi;
	
	@Column(name="CDSECCIO", length=2)
	private String cdseccio;	

	@Column(name="CDUNDIR", length=6)
	private String cdundir;
	
	@Column(name="CDUNMIN", length=6)
	private String cdunmin;
	
	@Column(name="CDUNDORG", length=6)
	private String cdundorg;
		
	@Column(name="CDPROG", length=5)
	private String cdprog;
			
	@Column(name="CDSERVI", length=4)
	private String cdservi;
			
	@Column(name="CDORGAN", length=3)
	private String cdorgan;

	
	public Bperadm() {
		super();
	}


	

	public Bperadm(Integer idbperadm, String cdhabil, String cdclasnm, String cddni, String cddup, String nmregper,
			String cdprov, String cdsitnom, String cdagrupn, String cdagrupr, Integer fealtano, String cdmotiva,
			Integer feefecoa, String cdloc, String cdpais, String cddomi, String cdseccio, String cdundir,
			String cdunmin, String cdundorg, String cdprog, String cdservi, String cdorgan) {
		super();
		this.idbperadm = idbperadm;
		this.cdhabil = cdhabil;
		this.cdclasnm = cdclasnm;
		this.cddni = cddni;
		this.cddup = cddup;
		this.nmregper = nmregper;
		this.cdprov = cdprov;
		this.cdsitnom = cdsitnom;
		this.cdagrupn = cdagrupn;
		this.cdagrupr = cdagrupr;
		this.fealtano = fealtano;
		this.cdmotiva = cdmotiva;
		this.feefecoa = feefecoa;
		this.cdloc = cdloc;
		this.cdpais = cdpais;
		this.cddomi = cddomi;
		this.cdseccio = cdseccio;
		this.cdundir = cdundir;
		this.cdunmin = cdunmin;
		this.cdundorg = cdundorg;
		this.cdprog = cdprog;
		this.cdservi = cdservi;
		this.cdorgan = cdorgan;
	}




	public Integer getIdbperadm() {
		return idbperadm;
	}

	public void setIdbperadm(Integer idbperadm) {
		this.idbperadm = idbperadm;
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

	public String getNmregper() {
		return nmregper;
	}

	public void setNmregper(String nmregper) {
		this.nmregper = nmregper;
	}

	public String getCdsitnom() {
		return cdsitnom;
	}

	public void setCdsitnom(String cdsitnom) {
		this.cdsitnom = cdsitnom;
	}

	public String getCdagrupn() {
		return cdagrupn;
	}

	public void setCdagrupn(String cdagrupn) {
		this.cdagrupn = cdagrupn;
	}

	public String getCdagrupr() {
		return cdagrupr;
	}

	public void setCdagrupr(String cdagrupr) {
		this.cdagrupr = cdagrupr;
	}
	
	public Integer getFealtano() {
		return fealtano;
	}

	public void setFealtano(Integer fealtano) {
		this.fealtano = fealtano;
	}

	public String getCdmotiva() {
		return cdmotiva;
	}

	public void setCdmotiva(String cdmotiva) {
		this.cdmotiva = cdmotiva;
	}

	public Integer getFeefecoa() {
		return feefecoa;
	}

	public void setFeefecoa(Integer feefecoa) {
		this.feefecoa = feefecoa;
	}

	public String getCdprov() {
		return cdprov;
	}

	public void setCdprov(String cdprov) {
		this.cdprov = cdprov;
	}

	public String getCdloc() {
		return cdloc;
	}

	public void setCdloc(String cdloc) {
		this.cdloc = cdloc;
	}


	public String getCdpais() {
		return cdpais;
	}


	public void setCdpais(String cdpais) {
		this.cdpais = cdpais;
	}

	public String getCddomi() {
		return cddomi;
	}


	public void setCddomi(String cddomi) {
		this.cddomi = cddomi;
	}


	public String getCdseccio() {
		return cdseccio;
	}


	public void setCdseccio(String cdseccio) {
		this.cdseccio = cdseccio;
	}




	public String getCdundir() {
		return cdundir;
	}




	public void setCdundir(String cdundir) {
		this.cdundir = cdundir;
	}




	public String getCdunmin() {
		return cdunmin;
	}




	public void setCdunmin(String cdunmin) {
		this.cdunmin = cdunmin;
	}




	public String getCdundorg() {
		return cdundorg;
	}




	public void setCdundorg(String cdundorg) {
		this.cdundorg = cdundorg;
	}




	public String getCdprog() {
		return cdprog;
	}




	public void setCdprog(String cdprog) {
		this.cdprog = cdprog;
	}




	public String getCdservi() {
		return cdservi;
	}




	public void setCdservi(String cdservi) {
		this.cdservi = cdservi;
	}




	public String getCdorgan() {
		return cdorgan;
	}




	public void setCdorgan(String cdorgan) {
		this.cdorgan = cdorgan;
	}




	@Override
	public String toString() {
		return "Bperadm [idbperadm=" + idbperadm + ", cdhabil=" + cdhabil + ", cdclasnm=" + cdclasnm + ", cddni="
				+ cddni + ", cddup=" + cddup + ", nmregper=" + nmregper + ", cdprov=" + cdprov + ", cdsitnom="
				+ cdsitnom + ", cdagrupn=" + cdagrupn + ", cdagrupr=" + cdagrupr + ", fealtano=" + fealtano
				+ ", cdmotiva=" + cdmotiva + ", feefecoa=" + feefecoa + ", cdloc=" + cdloc + ", cdpais=" + cdpais
				+ ", cddomi=" + cddomi + ", cdseccio=" + cdseccio + ", cdundir=" + cdundir + ", cdunmin=" + cdunmin
				+ ", cdundorg=" + cdundorg + ", cdprog=" + cdprog + ", cdservi=" + cdservi + ", cdorgan=" + cdorgan
				+ "]";
	}

	
	
}

