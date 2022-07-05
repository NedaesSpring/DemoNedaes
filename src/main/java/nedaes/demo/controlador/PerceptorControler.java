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
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.poi.xssf.streaming.SXSSFSheet;

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
import nedaes.demo.model.Banco;
import nedaes.demo.model.Bperadm;
import nedaes.demo.model.Bperban;
import nedaes.demo.model.Clasenomina;
import nedaes.demo.model.HabilitacionInicial;
import nedaes.demo.model.Perceptor;
import nedaes.demo.model.Provinc;
import nedaes.demo.service.IBancosService;
import nedaes.demo.service.IBperadmService;
import nedaes.demo.service.IBperbanService;
import nedaes.demo.service.IClasenominaService;
import nedaes.demo.service.IHabilitacionInicialService;
import nedaes.demo.service.IPerceptorService;
import nedaes.demo.service.IProvincService;

@Controller
public class PerceptorControler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PerceptorControler.class);

	private SXSSFWorkbook workbook;
	private SXSSFSheet sheet;
	
	@Autowired
	private IProvincService provinciaService; 

	@Autowired
	private IPerceptorService perceptorService; 
	
	@Autowired
	private IClasenominaService clasenominaService;

	@Autowired
	private IBperadmService bperadmService;

	@Autowired
	private IBperbanService bperbanService;

	@Autowired
	private IBancosService bancosService;

	@Autowired
	private IHabilitacionInicialService habilitacionService;
	
	@GetMapping("/listarPerceptores")
	public String listartodo(@RequestParam(name="cabecera", required=false, defaultValue="Perceptores de provincia") String name, Model model) {
		
		model.addAttribute("perceptores", perceptorService.listarPerceptores());
		model.addAttribute("cabecera", name);
		return "listarPerceptores";
	}
	
	@GetMapping("/perceptores")
	public String customersPage(Model model, HttpServletRequest request) {

		return inicioPerceptor(model, 1, request);
	}
	
	@GetMapping("/inicioPerceptor/{pageNumber}")
	public String inicioPerceptor(Model model, @PathVariable("pageNumber") int currentPage, HttpServletRequest request) {
		
		model.addAttribute("currentPage", currentPage);
		limpiarCampos(model);
		model.addAttribute("provincias", provinciaService.listarProvincias());
		model.addAttribute("clasenominas", clasenominaService.buscarTodas());
		model.addAttribute("habilitaciones", habilitacionService.buscarTodos());
		model.addAttribute("bancos", bancosService.buscarTodos());
//		model.addAttribute("bperadms", bperadmService.buscarTodos());
		
		
		model.addAttribute("eppResultados", "10");
		model.addAttribute("totalPages", currentPage);
		return "ConsultaPerceptor";
	}
	
	@GetMapping(value = "/listarPerceptoresProvincia")
	public String listarPerceptoresProvincia(Model model, @ModelAttribute Perceptor perceptorBuscado, 
			@RequestParam(value = "idProvincia") Integer idProvincia,
			@Param("eppResultados") String eppResultados,
				HttpServletRequest request) {

			int currentPage = 1;
			int capacidad;
			if (eppResultados == null)	capacidad = 10;
			else 						capacidad = Integer.parseInt(eppResultados);

			if (Objects.equals("", perceptorBuscado.getNombre())) {
				perceptorBuscado.setNombre(null);
			}

			if (Objects.equals("", perceptorBuscado.getApellidos())) {
				perceptorBuscado.setApellidos(null);
			}
			if (Objects.equals("", perceptorBuscado.getDni())) {
				perceptorBuscado.setDni(null);
			}
/*			
			if (Objects.equals("", perceptorBuscado.getSit())) {
				perceptorBuscado.setSit(null);
			}
*/			
			if (Objects.equals("", perceptorBuscado.getDup())) {
				perceptorBuscado.setDup(null);
			}
			Provinc provincia = new Provinc();
			provincia.setIdProvincia(idProvincia); 
			perceptorBuscado.setProvincia(provincia);
			
			Page<Perceptor> listadoPerceptores = perceptorService.buscarListadoPageable(perceptorBuscado, currentPage, capacidad);
			List<Perceptor> perceptores = listadoPerceptores.getContent();
			model.addAttribute("listado", perceptores);
			model.addAttribute("id", perceptorBuscado.getIdPerceptor());
			model.addAttribute("nombre", perceptorBuscado.getNombre());
			model.addAttribute("apellidos", perceptorBuscado.getApellidos());
			model.addAttribute("dni", perceptorBuscado.getDni());
//			model.addAttribute("sit", perceptorBuscado.getSit());
			model.addAttribute("dup", perceptorBuscado.getDup());
			if (Objects.equals(null, perceptorBuscado.getProvincia())){
				model.addAttribute("provincia", new Provinc());
			} else {
				model.addAttribute("provincia", perceptorBuscado.getProvincia());
			}
			
			if (Objects.equals(null, perceptorBuscado.getClasenomina())){
				model.addAttribute("clasenomina", new Clasenomina());
			} else {
				model.addAttribute("clasenomina", perceptorBuscado.getClasenomina());
			}
			
			if (Objects.equals(null, perceptorBuscado.getHabilitacion())){
				model.addAttribute("habilitacion", new HabilitacionInicial());
			} else {
				model.addAttribute("habilitacion", perceptorBuscado.getHabilitacion());
			}
			
			model.addAttribute("provincias", provinciaService.listarProvincias());
			model.addAttribute("clasenominas", clasenominaService.buscarTodas());
			model.addAttribute("habilitaciones", habilitacionService.buscarTodos());
			
			
			model.addAttribute("eppResultados", eppResultados);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("totalPages", listadoPerceptores.getTotalPages());
			model.addAttribute("totalItems", listadoPerceptores.getTotalElements());
			model.addAttribute("totalItemsPage", listadoPerceptores.getNumberOfElements());

			return "ConsultaPerceptor";
		
	}
	
	
	@GetMapping(value = "/listarPerceptoresBanco")
	public String listarPerceptoresBanco(Model model, @ModelAttribute Perceptor perceptorBuscado, @RequestParam(value = "idbanco") Integer idbanco,	@Param("eppResultados") String eppResultados,
				HttpServletRequest request) {

			int currentPage = 1;
			int capacidad;
			if (eppResultados == null)	capacidad = 10;
			else 						capacidad = Integer.parseInt(eppResultados);

			Page<Perceptor> listadoPerceptores = perceptorService.buscarPerceptoresPorIdbanco(idbanco, currentPage, capacidad);
			List<Perceptor> perceptores = listadoPerceptores.getContent();
			model.addAttribute("listado", perceptores);
			
			model.addAttribute("provincias", provinciaService.listarProvincias());
			model.addAttribute("clasenominas", clasenominaService.buscarTodas());
			model.addAttribute("habilitaciones", habilitacionService.buscarTodos());
			
			model.addAttribute("eppResultados", eppResultados);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("totalPages", listadoPerceptores.getTotalPages());
			model.addAttribute("totalItems", listadoPerceptores.getTotalElements());
			model.addAttribute("totalItemsPage", listadoPerceptores.getNumberOfElements());

			return "ConsultaPerceptor";
		
	}
	
	
	
	@GetMapping("/consultaPerceptor")
	public String paginarPerceptor(Model model, @Param("eppResultados") String eppResultados, HttpServletRequest request) {

		int capacidad;
		if (eppResultados == null)	capacidad = 10;
		else  						capacidad = Integer.parseInt(eppResultados);
		int currentPage = 1;

		Page<Perceptor> pagePerceptor = perceptorService.paginacion(currentPage, capacidad);

		List<Perceptor> perceptores = pagePerceptor.getContent();

		model.addAttribute("listado", perceptores);
		model.addAttribute("provincias", provinciaService.listarProvincias());
		model.addAttribute("provincia", new Provinc());
		model.addAttribute("claseNominas", clasenominaService.buscarTodas());
		model.addAttribute("clasenomina", new Clasenomina());
		model.addAttribute("habilitaciones", habilitacionService.buscarTodos());
		model.addAttribute("habilitacion", new HabilitacionInicial());
//		model.addAttribute("bperadms", bperadmService.buscarTodos());
		model.addAttribute("bperadm", new Bperadm());
		model.addAttribute("bancos", bancosService.buscarTodos());
		
		model.addAttribute("eppResultados", eppResultados);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", pagePerceptor.getTotalPages());
		model.addAttribute("totalItems", pagePerceptor.getTotalElements());
		model.addAttribute("totalItemsPage", pagePerceptor.getNumberOfElements());

		return "ConsultaPerceptor";
	}
	
	@GetMapping(value = "/consultaPerceptor/{pageNumber}")
	public String listarPerceptores(Model model, @ModelAttribute Perceptor perceptorBuscado, 
			@PathVariable("pageNumber") int currentPage, @Param("eppResultados") String eppResultados,
			HttpServletRequest request) {

		int capacidad;
		if (eppResultados == null)	capacidad = 10;
		else 						capacidad = Integer.parseInt(eppResultados);

		if (Objects.equals("", perceptorBuscado.getNombre())) {
			perceptorBuscado.setNombre(null);
		}

		if (Objects.equals("", perceptorBuscado.getApellidos())) {
			perceptorBuscado.setApellidos(null);
		}
		if (Objects.equals("", perceptorBuscado.getDni())) {
			perceptorBuscado.setDni(null);
		}
/*		
		if (Objects.equals("", perceptorBuscado.getSit())) {
			perceptorBuscado.setSit(null);
		}
*/		
		if (Objects.equals("", perceptorBuscado.getDup())) {
			perceptorBuscado.setDup(null);
		}
		if (Objects.equals(null, perceptorBuscado.getProvincia())) {
			perceptorBuscado.setProvincia(new Provinc());
		}
		if (Objects.equals(null, perceptorBuscado.getClasenomina())) {
			perceptorBuscado.setClasenomina(new Clasenomina());
		}
		if (Objects.equals(null, perceptorBuscado.getHabilitacion())) {
			perceptorBuscado.setHabilitacion(new HabilitacionInicial());
		}
		
		Page<Perceptor> listadoPerceptores = perceptorService.buscarListadoPageable(perceptorBuscado, currentPage, capacidad);
		List<Perceptor> perceptores = listadoPerceptores.getContent();
		model.addAttribute("listado", perceptores);
		model.addAttribute("id", perceptorBuscado.getIdPerceptor());
		model.addAttribute("nombre", perceptorBuscado.getNombre());
		model.addAttribute("apellidos", perceptorBuscado.getApellidos());
		model.addAttribute("dni", perceptorBuscado.getDni());
//		model.addAttribute("sit", perceptorBuscado.getSit());
		model.addAttribute("dup", perceptorBuscado.getDup());
		if (Objects.equals(null, perceptorBuscado.getProvincia())){
			model.addAttribute("provincia", new Provinc());
		} else {
			model.addAttribute("provincia", perceptorBuscado.getProvincia());
		}
		if (Objects.equals(null, perceptorBuscado.getClasenomina())){
			model.addAttribute("clasenomina", new Clasenomina());
		} else {
			model.addAttribute("clasenomina", perceptorBuscado.getClasenomina());
		}
		if (Objects.equals(null, perceptorBuscado.getHabilitacion())){
			model.addAttribute("habilitacion", new HabilitacionInicial());
		} else {
			model.addAttribute("habilitacion", perceptorBuscado.getHabilitacion());
		}
//		if (Objects.equals(null, perceptorBuscado.getBperadm())){
//			model.addAttribute("bperadm", new Bperadm());
//		} else {
//			model.addAttribute("bperadm", perceptorBuscado.getBperadm());
//		}
				
		model.addAttribute("provincias", provinciaService.listarProvincias());
		model.addAttribute("clasenominas", clasenominaService.buscarTodas());
		model.addAttribute("habilitaciones", habilitacionService.buscarTodos());
//		model.addAttribute("bperadms", bperadmService.buscarTodos());

		
		model.addAttribute("eppResultados", eppResultados);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", listadoPerceptores.getTotalPages());
		model.addAttribute("totalItems", listadoPerceptores.getTotalElements());
		model.addAttribute("totalItemsPage", listadoPerceptores.getNumberOfElements());

		return "ConsultaPerceptor";
	}

	
	@GetMapping("/consultaTodosPerceptores")
	public String consultaTodosPerceptores(Model model, @Param("eppResultados") String eppResultados, HttpServletRequest request) {

		int capacidad;
		if (eppResultados == null)	capacidad = 10;
		else  						capacidad = Integer.parseInt(eppResultados);
		int currentPage = 1;

		Page<Perceptor> pagePerceptor = perceptorService.paginacion(currentPage, capacidad);

		List<Perceptor> perceptores = pagePerceptor.getContent();

		model.addAttribute("listado", perceptores);
		model.addAttribute("provincias", provinciaService.listarProvincias());
		model.addAttribute("clasenominas", clasenominaService.buscarTodas());
		model.addAttribute("habilitaciones", habilitacionService.buscarTodos());
		
		model.addAttribute("eppResultados", 10);
		model.addAttribute("currentPage", 1);
		model.addAttribute("totalPages", pagePerceptor.getTotalPages());
		model.addAttribute("totalItems", pagePerceptor.getTotalElements());
		model.addAttribute("totalItemsPage", pagePerceptor.getNumberOfElements());

		return "ConsultaPerceptor";
	}
	
	
	@GetMapping("/perceptor")
	public String nuevaPerceptor(Model model, @ModelAttribute Perceptor perceptor, HttpServletRequest request) {
		model.addAttribute("perceptor", new Perceptor());
		model.addAttribute("provincias", provinciaService.listarProvincias());
		model.addAttribute("clasenominas", clasenominaService.buscarTodas());
		model.addAttribute("habilitaciones", habilitacionService.buscarTodos());
		model.addAttribute("bancos", bancosService.buscarTodos());

		model.addAttribute("aniadir", "si");
		return "Perceptor";
	}

	@GetMapping("/insertarModificarPerceptor")
	public String insertarModificarPerceptor(Model model,@Valid @ModelAttribute Perceptor perceptor, BindingResult result, HttpServletRequest request) {
		
		LOGGER.debug("Entrando en insertarModificarPerceptor..");			
		
		if (!result.hasErrors()) {
			// No existen errores en el formulario					
			
			if (Objects.isNull(perceptor.getIdPerceptor()) ||  Objects.equals(0, perceptor.getIdPerceptor())  ) {
						
				// Alta: Se comprueba si ya existe la Perceptor en BD
				Integer idPerceptor = perceptorService.existePerceptor(perceptor);
				
				if (!Objects.equals(0, idPerceptor)) {
					// Perceptor ya existe

					model.addAttribute("mensajeError", "El perceptor ya existe. Por favor, introduzca otros valores");

					model.addAttribute("perceptor", perceptor);
				}else {
					// Perceptor no existe
				 
				 if (!Objects.equals(0,perceptor.getProvincia().getIdProvincia())) {
				 	if (Objects.equals(null, perceptor.getProvincia())) {
						model.addAttribute("errorProvSel", "El campo Provincia no puede estar vacío");
						model.addAttribute("mensaje", "No se ha podido insertar/modificar el proveedor");
					} else if (Objects.equals(null, perceptor.getClasenomina())) {
						model.addAttribute("errorClaseNomSel", "El campo Clase Nomina no puede estar vacío");
						model.addAttribute("mensaje", "No se ha podido insertar/modificar el proveedor");
					} else 	if (Objects.equals(null, perceptor.getHabilitacion())) {
						model.addAttribute("errorHabSel", "El campo Habilitacion no puede estar vacío");
						model.addAttribute("mensaje", "No se ha podido insertar/modificar el proveedor");
					} else {
						model.addAttribute("erroreProvSel", null);
					
						Perceptor per = perceptorService.insertarPerceptor(perceptor);
						if (Objects.equals(null, per.getIdPerceptor())) {

							model.addAttribute("mensaje", "No se ha podido insertar/modificar el perceptor");

						} else {
							model.addAttribute("perceptor", per);
							model.addAttribute("idProvincia", per.getProvincia().getIdProvincia());
							model.addAttribute("provincias", provinciaService.listarProvincias());
							model.addAttribute("idClasenomina", per.getClasenomina().getIdClasenomina());
							model.addAttribute("clasenominas", clasenominaService.buscarTodas());		
							model.addAttribute("idHabilitacion", per.getHabilitacion().getIdHabilitacion());
							model.addAttribute("habilitaciones", habilitacionService.buscarTodos());
							model.addAttribute("bancos", bancosService.buscarTodos());
							model.addAttribute("idbanco", per.getBperban().getBanco().getIdbanco());
							model.addAttribute("mensaje", "Éxito");
							model.addAttribute("perceptorNuevoModificado", per);
							model.addAttribute("mostrarTabla", "si");
						}
				  	}
				  }
				}
			}else {
				// Modificación
				Integer idPerceptor = perceptorService.existePerceptor(perceptor);
				
				
				if (Objects.equals(0, idPerceptor)) {
					// Se está modificando el nombre del Perceptor y/o apellidos (por tanto el Perceptor a modificar existe en BD pero con otros nombres y apellidos, 
					// el idPerceptor devuelto es 0, pq no coinciden con el q ya existe). 
					int numero = perceptorService.editarPerceptor(perceptor);
					if (numero == 0) {
						
						model.addAttribute("mensaje", "No se ha podido modificar el perceptor");
						
					}else {
						model.addAttribute("perceptor", perceptor);
						model.addAttribute("idProvincia", perceptor.getProvincia().getIdProvincia());
						model.addAttribute("provincias", provinciaService.listarProvincias());
						model.addAttribute("idClasenomina", perceptor.getClasenomina().getIdClasenomina());
						model.addAttribute("clasenominas", clasenominaService.buscarTodas());		
						model.addAttribute("idHabilitacion", perceptor.getHabilitacion().getIdHabilitacion());
						model.addAttribute("habilitaciones", habilitacionService.buscarTodos());
						model.addAttribute("bancos", bancosService.buscarTodos());
						model.addAttribute("idbanco", perceptor.getBperban().getBanco().getIdbanco());
						model.addAttribute("mensaje", "Éxito");
						model.addAttribute("perceptorNuevoModificado", perceptor);
						model.addAttribute("mostrarTabla", "si");
						
					}
				}else {
					// El perceptor existe en BD, puede ser el mismo perceptor (pq en este caso el nombre y los apellidos de la provincia se mantienen)
					if (Objects.equals(idPerceptor,perceptor.getIdPerceptor())) {
						// Se modifica el propio Perceptor
						int numero = perceptorService.editarPerceptor(perceptor);
						if (numero == 0) {
							
							model.addAttribute("mensaje", "No se ha podido modificar el perceptor");
							
						}else {
							model.addAttribute("perceptor", perceptor);
							model.addAttribute("idProvincia", perceptor.getProvincia().getIdProvincia());
							model.addAttribute("provincias", provinciaService.listarProvincias());
							model.addAttribute("idClasenomina", perceptor.getClasenomina().getIdClasenomina());
							model.addAttribute("clasenominas", clasenominaService.buscarTodas());		
							model.addAttribute("idHabilitacion", perceptor.getHabilitacion().getIdHabilitacion());
							model.addAttribute("habilitaciones", habilitacionService.buscarTodos());
							model.addAttribute("bancos", bancosService.buscarTodos());
							model.addAttribute("idbanco", perceptor.getBperban().getBanco().getIdbanco());
							model.addAttribute("mensaje", "Éxito");
							model.addAttribute("perceptorNuevoModificado", perceptor);
							model.addAttribute("mostrarTabla", "si");
						}
					}else {
						// Se está intentando modificar el perceptor con un nombre de perceptor y apellidos que ya existe en BD
						model.addAttribute("mensajeError", "El perceptor ya existe. Por favor, introduzca otros valores");
					}
				}

			}
		}

		model.addAttribute("aniadir", "si");
		return "Perceptor";
	}

	@GetMapping("/borrarPerceptor")
	public String borrarPerceptor(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request) {

		LOGGER.debug("Entrando en borrarPerceptor..");
		Perceptor perceptor = perceptorService.buscarPerceptorPorId(id);
		boolean borrado = false;
		if (perceptor != null) {
			borrado = perceptorService.borrarPerceptor(perceptor.getIdPerceptor());
		}
		if (!borrado) {
			model.addAttribute("mensaje", "No puede eliminar el perceptor porque hay provincias que dependen de el.");
		} else {
			model.addAttribute("mensaje", "Se ha eliminado correctamente el perceptor.");
		}
		return "ConsultaPerceptor";
	}

	@GetMapping("/editarPerceptor")
	public String editarPerceptor(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request) {

		LOGGER.debug("Entrando en editarPerceptor..");
		Perceptor perceptor = perceptorService.buscarPerceptorPorId(id);
		if (perceptor != null) {
			model.addAttribute("perceptor", perceptor);
		}
		model.addAttribute("provincias", provinciaService.listarProvincias());
		model.addAttribute("clasenominas", clasenominaService.buscarTodas());
		model.addAttribute("habilitaciones", habilitacionService.buscarTodos());
		model.addAttribute("bancos", bancosService.buscarTodos());
		model.addAttribute("editar", "si");
		return "Perceptor";
	}

	@GetMapping(path = "/visualizarPerceptor")
	public String visualizarPerceptor(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request) {

		LOGGER.debug("Entrando en visualizarPerceptor..");
		Perceptor perceptor = perceptorService.buscarPerceptorPorId(id);
		model.addAttribute("perceptor", perceptor);
		model.addAttribute("provincias", provinciaService.listarProvincias());
		model.addAttribute("clasenominas", clasenominaService.buscarTodas());
		model.addAttribute("habilitaciones", habilitacionService.buscarTodos());
		model.addAttribute("consultar", "si");
		return "Perceptor";
	}

	private void limpiarCampos(Model model) {
		model.addAttribute("id", null);
		model.addAttribute("nombre", "");
		model.addAttribute("apellidos", "");
		model.addAttribute("dni", "");
		model.addAttribute("sit", null);
		model.addAttribute("dup", "");
		model.addAttribute("idProvincia", null);
		model.addAttribute("idHabilitacion", null);
		model.addAttribute("idClasenomina", null);
	}

	// ************** perceptor exportcsv

	@GetMapping("/exportPerceptor")
	public void exportToExcelPerceptor(HttpServletResponse response, @ModelAttribute Perceptor perceptorBuscado)	throws IOException {

		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=perceptor_" + currentDateTime + ".csv";
		response.setHeader(headerKey, headerValue);

		if (Objects.equals(0, perceptorBuscado.getIdPerceptor())) {
			perceptorBuscado.setIdPerceptor(null);
		}

		if (Objects.equals("", perceptorBuscado.getNombre())) {
			perceptorBuscado.setNombre(null);
		}

		if (Objects.equals("", perceptorBuscado.getApellidos())) {
			perceptorBuscado.setApellidos(null);
		}

		if (Objects.equals("", perceptorBuscado.getDni())) {
			perceptorBuscado.setDni(null);
		}
/*
		if (Objects.equals("", perceptorBuscado.getSit())) {
			perceptorBuscado.setSit(null);
		}
*/
		if (Objects.equals("", perceptorBuscado.getDup())) {
			perceptorBuscado.setDup(null);
		}

		List<Perceptor> listadoPerceptores = perceptorService.buscarListado(perceptorBuscado);

		List<String> columnNames = new ArrayList<>();
		columnNames.add("ID");
		columnNames.add("NOMBRE");
		columnNames.add("APELLIDOS");
		columnNames.add("SIT");
		columnNames.add("DNI");
		columnNames.add("DUP");
		columnNames.add("PROVINCIA");
		columnNames.add("CLASE NOMINA");
		columnNames.add("HABILITACION");
		
		// parte cabecera
		workbook = new SXSSFWorkbook();
		sheet = workbook.createSheet("PERCEPTORES");
		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setBold(true);
		style.setFont(font);

		List<Cell> celdas = CommonExporter.writeHeaderLine(columnNames, "PERCEPTORES", style, row);

		// parte de datos
		int rowCount = 1;
		font.setBold(false);
		style.setFont(font);

		for (Perceptor perceptor : listadoPerceptores) {
			row = sheet.createRow(rowCount++);
			int columnCount = 0;
			celdas.add(CommonExporter.createCell(row, columnCount++, perceptor.getIdPerceptor(), style));
			celdas.add(CommonExporter.createCell(row, columnCount++, perceptor.getNombre(), style));
			celdas.add(CommonExporter.createCell(row, columnCount++, perceptor.getApellidos(), style));
//			celdas.add(CommonExporter.createCell(row, columnCount++, perceptor.getSit(), style));
			celdas.add(CommonExporter.createCell(row, columnCount++, perceptor.getDni(), style));
			celdas.add(CommonExporter.createCell(row, columnCount++, perceptor.getDup(), style));
			celdas.add(CommonExporter.createCell(row, columnCount++, perceptor.getDescripcionProvinciaPlano(), style));
			celdas.add(CommonExporter.createCell(row, columnCount++, perceptor.getDescripcionClasenominaPlano(), style));
			celdas.add(CommonExporter.createCell(row, columnCount++, perceptor.getDescripcionHabilitacionPlano(), style));
									
		}
		CommonExporter.export(response, workbook);
	}
}
