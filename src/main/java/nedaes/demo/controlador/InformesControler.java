package nedaes.demo.controlador;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Librerias para paso de XML a PDF
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.xmlgraphics.util.MimeConstants;
import nedaes.demo.util.Constantes;

@Controller
public class InformesControler {

	private static final Logger LOGGER = LoggerFactory.getLogger(InformesControler.class);

	@GetMapping("/Informes/{ninforme}")
	public void Informes(HttpServletResponse response, @PathVariable("ninforme") int ninforme) throws IOException {
		
		try {
			LOGGER.debug("Generando PDF");
			String plantilla;
			String xml;
			plantilla = Constantes.RUTA_GRAL + "xls/reporte.xsl";
			xml = Constantes.RUTA_GRAL + "xml/reporte.xml";
			
			switch(ninforme) {
				case 1 :			// Informe SSn1
					plantilla = Constantes.RUTA_GRAL + "xls/SSn1.xsl";
					xml = Constantes.RUTA_GRAL + "xml/SSn1.xml";
		    	  	break; 
				case 2:				// Informe PAn2
					plantilla = Constantes.RUTA_GRAL + "xls/PAn2.xsl";
					xml = Constantes.RUTA_GRAL + "xml/PAn2.xml";
					break;
				case 3:				// Informe Reporte
					plantilla = Constantes.RUTA_GRAL + "xls/reporte.xsl";
					xml = Constantes.RUTA_GRAL + "xml/reporte.xml";					
    		}
    
			String varxml= ObtenerXML();
			
			     		File xsltFile = new File(plantilla);
			// Archivo XML que proveerá de datos
   		    ServletOutputStream out = null;								  // para verlo en pantalla	
  		    
   		    
   //		    StreamSource xmlSource = new StreamSource(varxml);
   			StreamSource xmlSource = new StreamSource(new File(xml));
			FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
			FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
			// Archivo PDF
			Fop fop;
			out = response.getOutputStream();					      // para verlo en pantalla
 		    fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
 			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));
			Result res = new SAXResult(fop.getDefaultHandler());
		
			transformer.transform(xmlSource, res);
			LOGGER.debug("PDF Generado");	 		
	      	out.close();					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@GetMapping("/InformesMasivo/{ninforme}/{nelemen}")
	public String InformesMasivo(HttpServletResponse response, @PathVariable("ninforme") int ninforme, @PathVariable(value = "nelemen", required = false) String nelemen
	) throws IOException {
		int i = 1;
		int nelementos = 1;
		
		if (nelemen != null) nelementos = Integer.parseInt(nelemen); 
		try {
		  while (i <=nelementos) {
                	
			LOGGER.debug("Generando PDF");
			String plantilla;
			String xml;
			plantilla = Constantes.RUTA_GRAL + "xls/reporte.xsl";
			xml = Constantes.RUTA_GRAL + "xml/reporte.xml";
			
			switch(ninforme) {
				case 1 :			// Informe SSn1
					plantilla = Constantes.RUTA_GRAL + "xls/SSn1.xsl";
					xml = Constantes.RUTA_GRAL + "xml/SSn1" + i + ".xml";
		    	  	break; 
				case 2:				// Informe PAn2
					plantilla = Constantes.RUTA_GRAL + "xls/PAn2.xsl";
					xml = Constantes.RUTA_GRAL + "xml/PAn2.xml";
					break;
				case 3:				// Informe Reporte
					plantilla = Constantes.RUTA_GRAL + "xls/reporte.xsl";
					xml = Constantes.RUTA_GRAL + "xml/reporte.xml";
					
    		}
    
     		File xsltFile = new File(plantilla);
			// Archivo XML que proveerá de datos
   		    OutputStream outFile = null;										  // para dejarlo en un directorio del servidor
  		    
		    StreamSource xmlSource = new StreamSource(new File(xml));
			FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
			FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
			// Archivo PDF
			Fop fop;
			outFile = new FileOutputStream(Constantes.RUTA_GRAL + "pdf/SSn1" + i + ".pdf");    // para dejarlo en un directorio del servidor
			fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, outFile);
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));
			Result res = new SAXResult(fop.getDefaultHandler());
			transformer.transform(xmlSource, res);
			LOGGER.debug("PDF Generado");	 		
	      	i++;
	      	outFile.close();
          }                		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ResultadoInformesMasivo";  	
	}
	

	private String ObtenerXML() {
		String xml ;
		xml = "<?xml version=\"1.0\"?>" +
		 
		 "<informePan2> " +
"      		  <dgenerales> " +
"		    <campo1>TIPO DE PERSONAL</campo1> " +
"		    <campo2>SECRETARIO GENERAL</campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4> " +
"		  </dgenerales> " +
"		  <dgenerales> " +
"		    <campo1>MINISTERIO</campo1> " +
"		    <campo2>MINISTERIO DE POLITICA TERRITORIAL Y ADMINISTRACION PUBLICA</campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4> " +
"		  </dgenerales> " +
"		   <dgenerales> " +
"		    <campo1>CENTRO DIRECTIVO</campo1> " +
"		    <campo2>D.G. DE ORGANIZACION E INSPECCION DE SERVICIOS</campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4> " +
"		  </dgenerales> " +
"		   <dgenerales> " +
"		    <campo1>PUESTO DE TRABAJO</campo1> " +
"		    <campo2>SECRETARIO GENERAL</campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4> " +
"		  </dgenerales> " +
"		   <dgenerales> " +
"		    <campo1>LOCALIDAD</campo1> " +
"		    <campo2>MADRID</campo2> " +
"		    <campo3>PROVINCIA :</campo3> " +
"		    <campo4>MADRID</campo4> " +
"		  </dgenerales> " +
		 
		 
"		  <cabecera> " +
"		    <campo1>Ministerio/Organismo</campo1> " +
"		    <campo2>HABILITACION PARA DEMOS Y CURSOS</campo2> " +
"		  </cabecera>  " +
"		  <cabecera> " +
"		    <campo1>Habilitacion</campo1> " +
"		    <campo2>MINISTERIO DE PRUEBA</campo2> " +
"		  </cabecera>  " +
"		  <cabecera> " +
"		    <campo1>Clase de nomina</campo1> " +
"		    <campo2>ALTOS CARGOS</campo2> " +
"		  </cabecera>  " +
"		  <cabecera> " +
"		    <campo1>Numero de nomina</campo1> " +
"		    <campo2>NOMINA ORDINARIA DEL MES</campo2> " +
"		  </cabecera> " +
"		  <cabecera> " +
"		    <campo1>Periodo de liquidacion</campo1> " +
"		    <campo2>01/03/22 a 31/03/22</campo2> " +
"		  </cabecera>  " +
"		  <cabecera> " +
"		    <campo1>Fecha de pago</campo1> " +
"		    <campo2>31/03/22</campo2> " +
"		  </cabecera>  " +
"		  <cabecera> " +
"		    <campo1>Referencia</campo1> " +
"		    <campo2>DEM.01.01.03/22-25 C00018546 P00018547</campo2> " +
"		  </cabecera>  " +
"		"+    
"		  <cabeceraDer> " +
"		    <campo1>A.R.</campo1> " +
"		    <campo2>DEMO</campo2> " +
"		  </cabeceraDer>  " +
"		  <cabeceraDer> " +
"		    <campo1>DNI.</campo1> " +
"		    <campo2>987</campo2> " +
"		  </cabeceraDer> " +
		  
"		  <titular> " +
"		    <campo1>Sr. D.</campo1> " +
"		    <campo2>(DEMO)</campo2> " +
"		  </titular> " +
"		  <titular> " +
"		    <campo1>JOSE MARIA PADILLA GARCIA</campo1> " +
"		    <campo2></campo2> " +
"		  </titular> " +
"		  <titular> " +
"		    <campo1>SECRETARIO GENERAL</campo1> " +
"		    <campo2></campo2> " +
"		  </titular> " +
"		  <titular> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		  </titular> " +
"		  <titular> " +
"		    <campo1>D.G. DE ORGANIZACION E INSPECCION DE SERVICIOS</campo1> " +
"		    <campo2></campo2> " +
"		  </titular> " +
"		  <titular> " +
"		    <campo1>CASTELLANA,3</campo1> " +
"		    <campo2></campo2> " +
"		  </titular> " +
"		  " +
"		  <headirpf> " +
"		    <campo1>N. I. F.</campo1> " +
"		    <campo2>SITUACION FAMILIAR</campo2> " +
"		    <campo3>NUMERO HIJOS</campo3> " +
"		    <campo4>PORCENTAJE RETENCION</campo4> " +    
"		  </headirpf> " +
"		  <irpf> " +
"		    <campo1>987K</campo1> " +
"		    <campo2>3</campo2> " +
"		    <campo3>1</campo3> " +
"		    <campo4>17.84</campo4> " +    
"		  </irpf> " +
		  
"		  <headrgss> " +
"		    <campo1>NUMERO DE AFILIACION</campo1> " +
"		    <campo2>COD. CTA. COTIZACION</campo2> " +
"		    <campo3>GR. COT.</campo3> " +
"		    <campo4>COD. ACT. ECONOM</campo4> " +    
"		    <campo5>OCUP.</campo5> " +
"		  </headrgss> " +
"		  <rgss> " +
"		    <campo1>28/12457899/32</campo1> " +
"		    <campo2>28/1111111/67</campo2> " +
"		    <campo3>01</campo3> " +
"		    <campo4>8411</campo4>   " +  
"		    <campo5></campo5> " +
"		  </rgss>  " +
		  
"		  <headafil> " +
"		    <campo1>NUMERO DE AFILIACION</campo1> " +
"		    <campo2>BASE PARA DEDUCCION MENSUAL</campo2> " +
"		    <campo3>PORCENTAJE APLICADO</campo3> " +
"		  </headafil> " +
"		  <afil> " +
"		    <campo1></campo1> " +
"		    <campo2>3.889,97</campo2> " +
"		    <campo3>17,8400</campo3>    " +
"		  </afil> " +
"		  <afil> " +
"		    <campo1>28/12457899/32</campo1> " +
"		    <campo2>3.889,97</campo2> " +
"		    <campo3>4,7000</campo3>    " +
"		  </afil> " +
"		  <afil> " +
"		    <campo1>28/12457899/32</campo1> " +
"		    <campo2>3.889,97</campo2> " +
"		    <campo3>0,1000</campo3>    " +
"		  </afil> " +
"		  <retribucion>3.889,97</retribucion> " +
"		  <retribuciones> " +
"		    <campo1>01</campo1> " +
"		    <campo2>SUELDO</campo2> " +
"		    <campo3>1.191,21</campo3> " +
"		    <campo4></campo4>     " +
"		    <campo5></campo5> " +
"		    <campo6>1.191,21</campo6> " +
"		   </retribuciones> " +
"		   <retribuciones> " +
"		    <campo1>021</campo1> " +
"		    <campo2>TRIENIOS A1 (3)</campo2> " +
"		    <campo3>140,22</campo3> " +
"		    <campo4></campo4>     " +
"		    <campo5></campo5> " +
"		    <campo6>140,22</campo6> " +
"		   </retribuciones>    " +
"		   <retribuciones> " +
"		    <campo1>026</campo1> " +
"		    <campo2>TRIENIOS E</campo2> " +
"		    <campo3>1.000,00</campo3> " +
"		    <campo4></campo4>     " +
"		    <campo5></campo5> " +
"		    <campo6>1.000,00</campo6> " +
"		   </retribuciones> " +   
"		   <retribuciones> " +
"		    <campo1>04</campo1> " +
"		    <campo2>COMPLEMENTO DE DESTINO</campo2> " +
"		    <campo3>1.558,54</campo3> " +
"		    <campo4></campo4>     " +
"		    <campo5></campo5> " +
"		    <campo6>1.558,54</campo6> " +
"		   </retribuciones>    " +
"		   <retribuciones> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4>     " +
"		    <campo5></campo5> " +
"		    <campo6></campo6> " +
"		   </retribuciones> " +
"		   <retribuciones> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4>     " +
"		    <campo5></campo5> " +
"		    <campo6></campo6> " +
"		   </retribuciones>    " +
"		   <retribuciones> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4>     " +
"		    <campo5></campo5> " +
"		    <campo6></campo6> " +
"		   </retribuciones> " +
"		   <retribuciones> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4>     " +
"		    <campo5></campo5> " +
"		    <campo6></campo6> " +
"		   </retribuciones>   " +
"		   <retribuciones> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4>     " +
"		    <campo5></campo5> " +
"		    <campo6></campo6> " +
"		   </retribuciones> " +
"		   <retribuciones> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4>     " +
"		    <campo5></campo5> " +
"		    <campo6></campo6> " +
"		   </retribuciones>  " +
"		   <retribuciones> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4>     " +
"		    <campo5></campo5> " +
"		    <campo6></campo6> " +
"		   </retribuciones> " +
"		   <retribuciones> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4>     " +
"		    <campo5></campo5> " +
"		    <campo6></campo6> " +
"		   </retribuciones>    " +
"		   <retribuciones> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4>     " +
"		    <campo5></campo5> " +
"		    <campo6></campo6> " +
"		   </retribuciones> " +
"		   <retribuciones> " +
"		    <campo1></campo1>" +
"		    <campo2></campo2>" +
"		    <campo3></campo3> " +
"		    <campo4></campo4>     " +
"		    <campo5></campo5> " +
"		    <campo6></campo6> " +
"		   </retribuciones>   " +
"		   <retribuciones> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4>     " +
"		    <campo5></campo5> " +
"		    <campo6></campo6> " +
"		   </retribuciones> " +
"		   <retribuciones> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4>    " +
"		    <campo5></campo5> " +
"		    <campo6></campo6> " +
"		   </retribuciones>  " +
"		   <deduccion>880,69</deduccion> " + 
"		   <deducciones> " +
"		    <campo1>01</campo1> " +
"		    <campo2>I.R.P.F.</campo2> " +
"		    <campo3>693,97</campo3> " +
"		    <campo4></campo4>   " +
"		    <campo5></campo5> " +
"		    <campo6>693,97</campo6> " +
"		   </deducciones> " +
"		   <deducciones> " +
"		    <campo1>091</campo1> " +
"		    <campo2>R.G.S.S. GENERAL - CONTINGENCIAS COMUNES</campo2> " +
"		    <campo3>182,83</campo3> " +
"		    <campo4></campo4> " +
"		    <campo5></campo5> " +
"		    <campo6>182,83</campo6> " +
"		   </deducciones> " +
"		   <deducciones> " +
"		    <campo1>092</campo1> " +
"		    <campo2>R.G.S.S. FORMACION PROF. Y DESEMPLEO</campo2> " +
"		    <campo3>3,89</campo3> " +
"		    <campo4></campo4> " +
"		    <campo5></campo5> " +
"		    <campo6>3,89</campo6> " +
"		   </deducciones> " +
"		   <deducciones> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4> " +
"		    <campo5></campo5> " +
"		    <campo6></campo6> " +
"		   </deducciones> " +
"		   <deducciones> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4> " +
"		    <campo5></campo5> " +
"		    <campo6></campo6> " +
"		   </deducciones> " +
"		   <deducciones> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4>  " +
"		    <campo5></campo5> " +
"		    <campo6></campo6> " +
"		   </deducciones> " +
"		   <deducciones> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4>     " +
"		    <campo5></campo5> " +
"		    <campo6></campo6> " +
"		   </deducciones> " +
"		   <deducciones> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4> " +
"		    <campo5></campo5> " +
"		    <campo6></campo6> " +
"		   </deducciones> " +
"		   <deducciones> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4> " +
"		    <campo5></campo5> " +
"		    <campo6></campo6> " +
"		   </deducciones> " +
"		   <deducciones> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4> " +
"		    <campo5></campo5> " +
"		    <campo6></campo6> " +
"		   </deducciones> " +
"		   <deducciones> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4> " +
"		    <campo5></campo5> " +
"		    <campo6></campo6> " +
"		   </deducciones> " +
"		   <liquidacion>3.009,28</liquidacion> " + 
"		   <pago>3.009,28</pago>  " +
"		   <bancopago>BANCO DEL COMERCIO MADRID CASTELLANA,108</bancopago> " + 
"		   <iban>ES30 0050 9997 4101 5975 3557</iban>  " +
"		   <formapago>No disponible</formapago>  " +
"		   <headcotiz> " +
"		    <campo1>C O N C E P T O</campo1> " +
"		    <campo2>IMPORTE</campo2> " +
"		    <campo3>BASE</campo3> " +
"		    <campo4>TIPO</campo4> " +
"		    <campo5>APORTACION EMPRESA</campo5> " +
"		   </headcotiz> " +
"		   <cotiz> " +
"		    <campo1>1. CONTINGENCIAS COMUNES</campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4> " +
"		    <campo5></campo5> " +
"		   </cotiz> " +
"		   <cotiz> " +
"		    <campo1>IMPORTE REMUNERACION MENSUAL</campo1> " +
"		    <campo2>3.889,97</campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4> " +
"		    <campo5></campo5> " +
"		   </cotiz> " +
"		   <cotiz> " +
"		    <campo1>IMPORTE PRORRATA PAGA EXTRAORDINARIAS</campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4> " +
"		    <campo5></campo5> " +
"		   </cotiz> " +
"		   <cotiz> " +
"		    <campo1>OTROS IMPORTES PRORRATEADOS</campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4> " +
"		    <campo5></campo5> " +
"		   </cotiz> " +
"		   <cotiz> " +
"		    <campo1>T O T A L</campo1> " +
"		    <campo2>3.889,97</campo2> " +
"		    <campo3>3.889,97</campo3> " +
"		    <campo4>23,6000</campo4>  " +
"		    <campo5>918,03</campo5> " +
"		   <cotiz> " +
"		    <campo1></campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4> " +
"		    <campo5></campo5> " +
"		   </cotiz> " +
"		   <cotiz> " +
"		    <campo1>2. CONTINGENCIAS PROF. Y CPTOS DE RECAUDACION CONJUNTA</campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4> " +
"		    <campo5></campo5> " +
"		   </cotiz> " +
"		   <cotiz> " +
"		    <campo1>A.T. y E.P.</campo1> " +
"		    <campo2></campo2> " +
"		    <campo3>3.889,97</campo3> " +
"		    <campo4>1,6500</campo4> " +
"		    <campo5>64,18</campo5> " +
"		   </cotiz> " +
"		   <cotiz> " +
"		    <campo1>DESEMPLEO</campo1> " +
"		    <campo2></campo2> " +
"		    <campo3>3.889,97</campo3> " +
"		    <campo4>0,0000</campo4> " +
"		    <campo5>0,00</campo5> " +
"		   </cotiz> " +
"		   <cotiz> " +
"		    <campo1>FORMACION PROFESIONAL</campo1> " +
"		    <campo2></campo2> " +
"		    <campo3>3.889,97</campo3> " +
"		    <campo4>0,6000</campo4> " +
"		    <campo5>23,34</campo5> " +
"		   </cotiz> " +
"		   <cotiz> " +
"		    <campo1>FON \" +DO GARANTIA SALARIAL</campo1> " +
"		    <campo2></campo2> " +
"		    <campo3>3.889,97</campo3> " +
"		    <campo4>0,0000</campo4> " +
"		    <campo5>0,00</campo5> " +
"		   </cotiz> " +
"		   <cotiz> " +
"		    <campo1>3. COTIZACION ADICIONAL HORAS EXTRAORDINARIAS</campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4> " +
"		    <campo5></campo5> " +
"		   </cotiz> " +
"		   <cotiz> " +
"		    <campo1>HORAS EXTRAORDINARIAS ESTRUCTURALES</campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4> " +
"		    <campo5></campo5> " +
"		   </cotiz> " +
"		   <cotiz> " +
"		    <campo1>HORAS EXTRAORDINARIAS NO ESTRUCTURALES</campo1> " +
"		    <campo2></campo2> " +
"		    <campo3></campo3> " +
"		    <campo4></campo4> " +
"		    <campo5></campo5> " +
"		   </cotiz> " +
"		   <cotiz> " +
"		    <campo1>4. BASE SUJETA A RETENCION DEL IRPF</campo1> " +
"		    <campo2></campo2> " +
"		    <campo3>3.889,97</campo3> " +
"		    <campo4>17,8400</campo4> " +
"		    <campo5></campo5> " +
"		   </cotiz> " +
"		   <cotizpie>31</cotizpie> " +   
"		</informePan2>"; 
		
		return xml;
		
	}
	
}
