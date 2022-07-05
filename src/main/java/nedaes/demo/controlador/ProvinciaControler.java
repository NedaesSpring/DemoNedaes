package nedaes.demo.controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import nedaes.demo.export.CommonExporter;
import nedaes.demo.model.Provinc;
import nedaes.demo.service.IProvincService;

@Controller
public class ProvinciaControler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProvinciaControler.class);

	private SXSSFWorkbook workbook;
	private SXSSFSheet sheet;

	@Autowired
	private IProvincService provinciaService; 
	
	@GetMapping("/AltaProvincia")
	public String listar(@RequestParam(name="name", required=false, defaultValue="Provinc") String nombre, Model model) {
		
		Provinc p = new Provinc();
//		p.setIdProvincia(52);
		p.setDsprov("ProvinciaExtraña");
		p.setCdprov(52);
		provinciaService.insertarProvincia(p);
		
		model.addAttribute("nombre",nombre);
		return "listarProvincias";
		
	}
	
	@GetMapping("/listarProvincias")
	public String listarProvincias(@RequestParam(name="cabecera", required=false, defaultValue="Provincias") String name, Model model) {
		
		model.addAttribute("provincias", provinciaService.listarProvincias());
		model.addAttribute("cabecera", name);
		return "listarProvincias";
	}	

	
	@GetMapping("/provincias")
	public String customersPage(Model model, HttpServletRequest request) {

		return inicioProvincia(model, 1, request);
	}
	
	@GetMapping("/inicioProvincia/{pageNumber}")
	public String inicioProvincia(Model model, @PathVariable("pageNumber") int currentPage, HttpServletRequest request) {
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", currentPage);
		model.addAttribute("eppResultados", 10);
		
		limpiarCampos(model);
		return "ConsultaProvincia";
	}
	
	@GetMapping("/consultaProvincia")
	public String consultaProvincia(Model model, @Param("eppResultados") String eppResultados, HttpServletRequest request) {

		int capacidad;
		if (eppResultados == null)	capacidad = 10;
		else  						capacidad = Integer.parseInt(eppResultados);
		int currentPage = 1;

		Page<Provinc> pageProvincia = provinciaService.paginacion(currentPage, capacidad);

		List<Provinc> provincias = pageProvincia.getContent();

		model.addAttribute("listado", provincias);

		model.addAttribute("eppResultados", eppResultados);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", pageProvincia.getTotalPages());
		model.addAttribute("totalItems", pageProvincia.getTotalElements());
		model.addAttribute("totalItemsPage", pageProvincia.getNumberOfElements());

		return "ConsultaProvincia";
	}
	
	@GetMapping(value = "/consultaProvincia/{pageNumber}")
	public String consultaProvincia(Model model, @ModelAttribute Provinc provinciaBuscada, 
			@PathVariable("pageNumber") int currentPage, @Param("eppResultados") String eppResultados,
			HttpServletRequest request) {

		int capacidad;
		if (eppResultados == null)	capacidad = 10;
		else 						capacidad = Integer.parseInt(eppResultados);

		if (Objects.equals(null, provinciaBuscada.getCdprov())) {
			provinciaBuscada.setCdprov(null);
		}
		
		if (Objects.equals("", provinciaBuscada.getDsprov())) {
			provinciaBuscada.setDsprov(null);
		}
		
		Page<Provinc> listadoProvincias = provinciaService.buscarListadoPageable(provinciaBuscada, currentPage, capacidad);
		List<Provinc> provincias = listadoProvincias.getContent();
		model.addAttribute("listado", provincias);
		model.addAttribute("dsprov", provinciaBuscada.getDsprov());
		model.addAttribute("cdprov", provinciaBuscada.getCdprov());
		
		model.addAttribute("eppResultados", eppResultados);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", listadoProvincias.getTotalPages());
		model.addAttribute("totalItems", listadoProvincias.getTotalElements());
		model.addAttribute("totalItempsPage", listadoProvincias.getNumberOfElements());

		return "ConsultaProvincia";
	}
	
	@GetMapping(value = "/consultaTodasProvincias")
	public String consultaTodasProvincias(Model model, @Param("eppResultados") String eppResultados,
			HttpServletRequest request) {

		int capacidad;
		if (eppResultados == null)	capacidad = 10;
		else 						capacidad = Integer.parseInt(eppResultados);

		Page<Provinc> listadoProvincias = provinciaService.paginacion(1, capacidad);
		List<Provinc> provincias = listadoProvincias.getContent();
		model.addAttribute("listado", provincias);
		
		model.addAttribute("eppResultados", 10);
		model.addAttribute("currentPage", 1);
		model.addAttribute("totalPages", listadoProvincias.getTotalPages());
		model.addAttribute("totalItems", listadoProvincias.getTotalElements());
		model.addAttribute("totalItempsPage", listadoProvincias.getNumberOfElements());

		return "ConsultaProvincia";
	}

	@GetMapping("/provincia")
	public String nuevaProvincia(Model model, @ModelAttribute Provinc provincia, HttpServletRequest request) {
		model.addAttribute("provincia", new Provinc());

		model.addAttribute("aniadir", "si");
		return "Provincia";
	}
	
	@GetMapping("/insertarModificarProvincia")
	public String insertarModificarProvincia(Model model,@Valid @ModelAttribute Provinc provincia, @ModelAttribute String aniadir, BindingResult result, HttpServletRequest request) {
		
		LOGGER.debug("Entrando en insertarModificarProvincia.");			
		
		if (!result.hasErrors()) {
			// No existen errores en el formulario					
						
			if (Objects.isNull(provincia.getIdProvincia()) ||  Objects.equals(0, provincia.getIdProvincia())  ) {
				
				// Alta: Se comprueba si ya existe la provincia en BD
				Integer idProvincia = provinciaService.existeProvincia(provincia);
				
				if (!Objects.equals(0, idProvincia)) {
					// Provincia ya existe

					model.addAttribute("mensajeError", "La provincia ya existe. Por favor, introduzca otros valores");

					model.addAttribute("provinc", provincia);
				}else {
					// Provincia no existe
					Provinc pro = provinciaService.insertarProvincia(provincia);
					if (Objects.equals(0, pro.getIdProvincia())) {

						model.addAttribute("mensaje", "No se ha podido insertar/modificar la provincia");

					} else {
						model.addAttribute("idProvincia", pro.getIdProvincia());
						model.addAttribute("mensaje", "Éxito");
						model.addAttribute("provinciaNuevaModificada", pro);
						model.addAttribute("mostrarTabla", "si");
					}
				}
			}else {
				// Modificación
				Integer idProvincia = provinciaService.existeProvincia(provincia);
				
				
				if (Objects.equals(0, idProvincia)) {
					// Se está modificando el nombre de la provincia y/o codigo de provincia (por tanto la provincia a modificar existe en BD pero con otros nombres de provincia y/ codigo, 
					// el idProvincia devuelto es 0, pq no coinciden con el q ya existe). 
					int numero = provinciaService.editarProvincia(provincia);
					if (numero == 0) {
						
						model.addAttribute("mensaje", "No se ha podido modificar la provincia");
						
					}else {
						model.addAttribute("cdprov", provincia.getIdProvincia());
						model.addAttribute("mensaje", "Éxito");
						model.addAttribute("provinciaNuevaModificada", provincia);
						model.addAttribute("mostrarTabla", "si");
						
					}
				}else {
					// La provincia existe en BD, puede ser la misma provincia (pq en este caso el nombre de la provincia se mantiene y lo que se modifica es el codigo de provincia)
					if (Objects.equals(idProvincia,provincia.getCdprov())) {
						// Se modifica la propia provincia
						int numero = provinciaService.editarProvincia(provincia);
						if (numero == 0) {
							
							model.addAttribute("mensaje", "No se ha podido modificar la provincia");
							
						}else {
							model.addAttribute("cdprov", provincia.getIdProvincia());
							model.addAttribute("mensaje", "Éxito");
							model.addAttribute("provinciaNuevaModificada", provincia);
							model.addAttribute("mostrarTabla", "si");
							
						}
					}else {
						// Se está intentando modificar la provincia con un nombre de provincia y codigo que ya existe en BD
						model.addAttribute("mensajeError", "La provincia ya existe. Por favor, introduzca otros valores");
					}
				}

			}
		}

		model.addAttribute("aniadir", "si");
		return "Provincia";
	}

	@GetMapping("/borrarProvincia")
	public String borrarProvincia(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request) {

		LOGGER.debug("Entrando en borrarProvincia..");
		Provinc provincia = provinciaService.buscarProvinciaPorId(id);
		boolean borrado = false;
		if (provincia != null) {
			borrado = provinciaService.borrarProvincia(provincia.getIdProvincia());
		}
		if (!borrado) {
			model.addAttribute("mensaje", "No puede eliminar la provincia porque hay perceptores que dependen de ella.");
		} else {
			model.addAttribute("mensaje", "Se ha eliminado correctamente la provincia.");
		}
		return "ConsultaProvincia";
	}

	@GetMapping("/editarProvincia")
	public String editarProvincia(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request) {

		LOGGER.debug("Entrando en editarProvincia..");
		Provinc provincia = provinciaService.buscarProvinciaPorId(id);
		if (provincia != null) {
			model.addAttribute("provinc", provincia);
		}
		model.addAttribute("editar", "si");
		return "Provincia";
	}

	@GetMapping(path = "/visualizarProvincia")
	public String visualizarProvincia(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request) {

		LOGGER.debug("Entrando en visualizarProvincia..");
		Provinc provincia = provinciaService.buscarProvinciaPorId(id);
		model.addAttribute("provinc", provincia);
		model.addAttribute("consultar", "si");
		return "Provincia";
	}

	private void limpiarCampos(Model model) {
		model.addAttribute("idProvincia", null);		
		model.addAttribute("cdprov", null);
		model.addAttribute("dsprov", "");
	}

	// ************** provincia exportcsv

	@GetMapping("/exportProvincia")
	public void exportToExcelProvincia(HttpServletResponse response, @ModelAttribute Provinc provinciaBuscada)	throws IOException {

		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=provincia_" + currentDateTime + ".csv";
		response.setHeader(headerKey, headerValue);

		if (Objects.equals(0, provinciaBuscada.getIdProvincia())) {
			provinciaBuscada.setIdProvincia(null);
		}

		if (Objects.equals("", provinciaBuscada.getDsprov())) {
			provinciaBuscada.setDsprov(null);
		}

		if (Objects.equals("", provinciaBuscada.getCdprov())) {
			provinciaBuscada.setCdprov(null);
		}

		List<Provinc> listadoProvincias = provinciaService.buscarListado(provinciaBuscada);

		List<String> columnNames = new ArrayList<>();
		columnNames.add("ID");
		columnNames.add("CODIGO");
		columnNames.add("PROVINCIA");

		// parte cabecera
		workbook = new SXSSFWorkbook();
		sheet = workbook.createSheet("PROVINCIAS");
		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setBold(true);
		style.setFont(font);

		List<Cell> celdas = CommonExporter.writeHeaderLine(columnNames, "PROVINCIAS", style, row);

		// parte de datos
		int rowCount = 1;
		font.setBold(false);
		style.setFont(font);

		for (Provinc provincia : listadoProvincias) {
			row = sheet.createRow(rowCount++);
			int columnCount = 0;
			celdas.add(CommonExporter.createCell(row, columnCount++, provincia.getIdProvincia(), style));
			celdas.add(CommonExporter.createCell(row, columnCount++, provincia.getCdprov(), style));
			celdas.add(CommonExporter.createCell(row, columnCount++, provincia.getDsprov(), style));
		}
		CommonExporter.export(response, workbook);
	}

}
