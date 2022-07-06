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
	import nedaes.demo.model.Sucurba;
import nedaes.demo.service.IBancosService;
import nedaes.demo.service.ISucurbaService;
	import nedaes.demo.model.Banco;
import nedaes.demo.model.Perceptor;
	
	@Controller
	public class SucurbaControler {
	
		private static final Logger LOGGER = LoggerFactory.getLogger(SucurbaControler.class);
    	
		private SXSSFWorkbook workbook;
		private SXSSFSheet sheet;

		
		/* INYECCION DE DEPENDENCIAS **************************************** */
		@Autowired
		private ISucurbaService sucurbaService; 
		
		@Autowired
		private IBancosService bancosService; 
		
		@GetMapping("/sucurbas")
		public String sucurbas(Model model, HttpServletRequest request) {

			return inicioSucurba(model, 1, request);
		}
		
		
		@GetMapping("/inicioSucurba/{pageNumber}")
		public String inicioSucurba(Model model, @PathVariable("pageNumber") int currentPage, HttpServletRequest request) {
			
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("totalPages", currentPage);
			model.addAttribute("eppResultados", 10);
			
			limpiarCampos(model);
			return "ConsultaSucurba";
		}
		
		
		@GetMapping("/consultaSucurba")
		public String consultaSucurba(Model model, @Param("eppResultados") String eppResultados, HttpServletRequest request) {

			int capacidad;
			if (eppResultados == null)	capacidad = 10;
			else  						capacidad = Integer.parseInt(eppResultados);
			int currentPage = 1;

			Page<Sucurba> pageSucurba = sucurbaService.paginacion(currentPage, capacidad);

			List<Sucurba> sucurbas = pageSucurba.getContent();

			model.addAttribute("listado", sucurbas);

			guardarTotales(model, pageSucurba, currentPage, eppResultados);

			return "ConsultaSucurba";
		}
		
		@GetMapping(value = "/consultaSucurba/{pageNumber}")
		public String consultaSucurba(Model model, @ModelAttribute Sucurba sucurbaBuscado, 
				@PathVariable("pageNumber") int currentPage, @Param("eppResultados") String eppResultados,
				HttpServletRequest request) {

			int capacidad;
			if (eppResultados == null)	capacidad = 10;
			else 						capacidad = Integer.parseInt(eppResultados);

			sucurbaBuscado= validarFiltros(sucurbaBuscado);	

			Page<Sucurba> listadoSucurbas = sucurbaService.buscarListadoPageable(sucurbaBuscado, currentPage, capacidad);
			List<Sucurba> sucurbas = listadoSucurbas.getContent();
			model.addAttribute("listado", sucurbas);
			model.addAttribute("cdsucur", sucurbaBuscado.getCdsucur());
			model.addAttribute("cdbanco", sucurbaBuscado.getCdbanco());
			
			guardarTotales(model, listadoSucurbas, currentPage, eppResultados);

			return "ConsultaSucurba";
		}
		
	
		
	@GetMapping(value = "/listarSucursalesBanco")
	public String listarSucursalesBanco(Model model, @ModelAttribute Sucurba sucurbaBuscado, 
			@RequestParam(value = "idbanco") Integer idbanco,
			@Param("eppResultados") String eppResultados,
				HttpServletRequest request) {

			int currentPage = 1;
			int capacidad;
			if (eppResultados == null)	capacidad = 10;
			else 						capacidad = Integer.parseInt(eppResultados);
			
			Banco banco = new Banco();
			banco.setIdbanco(idbanco); 
			sucurbaBuscado.setBanco(banco);
			
			Page<Sucurba> listadoSucurbas = sucurbaService.buscarListadoPageable(sucurbaBuscado, currentPage, capacidad);
			List<Sucurba> sucurbas = listadoSucurbas.getContent();
			model.addAttribute("listado", sucurbas);
			model.addAttribute("cdbanco", sucurbas.get(0).getCdbanco());
			model.addAttribute("idbanco", idbanco);
			
			guardarTotales(model, listadoSucurbas, currentPage, eppResultados);
			
			return "ConsultaSucurba";
		
	}
		
		
		@GetMapping(value = "/consultaTodosSucurbas")
		public String consultaTodosSucurbas(Model model, @Param("eppResultados") String eppResultados,
				HttpServletRequest request) {

			int capacidad;
			if (eppResultados == null)	capacidad = 10;
			else 						capacidad = Integer.parseInt(eppResultados);

			Page<Sucurba> listadoSucurbas = sucurbaService.paginacion(1, capacidad);
			List<Sucurba> sucurbas = listadoSucurbas.getContent();
			model.addAttribute("listado", sucurbas);
			
			guardarTotales(model, listadoSucurbas, 1, eppResultados);
			
			return "ConsultaSucurba";
		}

		
		@GetMapping("/sucurba")
		public String nuevaSucurba(Model model, @ModelAttribute Sucurba sucurba, @RequestParam(value = "idbanco") Integer idbanco, HttpServletRequest request) {
			if (idbanco== null) {
				model.addAttribute("mensajeError", "Para Nueva Sucursal debe haber primero elegido un banco desde la lista de bancos");
				return inicioSucurba(model, 1, request);
		    } else {
				Sucurba sucurbaNueva = new Sucurba();
				Banco banco = bancosService.buscarBancoPorId(idbanco);
				sucurbaNueva.setBanco(banco);
			
				sucurbaNueva.setCdbanco(banco.getCdbanco());
				model.addAttribute("sucurba", sucurbaNueva);
				model.addAttribute("bancos", bancosService.buscarTodos());
			
				model.addAttribute("aniadir", "si");
				return "Sucurba";
			}
		}
				 
		@GetMapping("/insertarModificarSucurba")
		public String insertarModificarSucurba(Model model,@Valid @ModelAttribute Sucurba sucurba, BindingResult result, HttpServletRequest request) {
			
			LOGGER.debug("Entrando en insertarModificarSucurba.");			
			
			if (!result.hasErrors()) {
				// No existen errores en el formulario					
							
				if (Objects.isNull(sucurba.getIdsucurba()) ||  Objects.equals(0, sucurba.getIdsucurba())  ) {
					
					// Alta: Se comprueba si ya existe la sucurba en BD
					Integer idSucurba = sucurbaService.existeSucurba(sucurba);
					
					if (!Objects.equals(0, idSucurba)) {
						// Sucurba ya existe

						model.addAttribute("mensajeError", "La sucurba ya existe. Por favor, introduzca otros valores");

						model.addAttribute("sucurba", sucurba);
					}else {
						// Sucurba no existe
						Sucurba pro = sucurbaService.insertarSucurba(sucurba);
						if (Objects.equals(0, pro.getIdsucurba())) {

							model.addAttribute("mensaje", "No se ha podido insertar/modificar la sucurba");

						} else {
							model.addAttribute("idsucurba", pro.getIdsucurba());
							model.addAttribute("mensaje", "Éxito");
							model.addAttribute("sucurbaNuevaModificada", pro);
							model.addAttribute("mostrarTabla", "si");
						}
					}
				}else {
					// Modificación
					Integer idSucurba = sucurbaService.existeSucurba(sucurba);
					
					
					if (Objects.equals(0, idSucurba)) {
						// Se está modificando el nombre de la sucurba y/o codigo de sucurba (por tanto la sucurba a modificar existe en BD pero con otros nombres de sucurba y/ codigo, 
						// el idSucurba devuelto es 0, pq no coinciden con el q ya existe). 
						int numero = sucurbaService.editarSucurba(sucurba);
						if (numero == 0) {
							
							model.addAttribute("mensaje", "No se ha podido modificar la sucurba");
							
						}else {
							model.addAttribute("idsucurba", sucurba.getIdsucurba());
							model.addAttribute("mensaje", "Éxito");
							model.addAttribute("sucurbaNuevaModificada", sucurba);
							model.addAttribute("mostrarTabla", "si");
							
						}
					}else {
						// La sucurba existe en BD, puede ser la misma sucurba (pq en este caso el nombre de la sucurba se mantiene y lo que se modifica es el codigo de sucurba)
						if (Objects.equals(idSucurba,sucurba.getIdsucurba())) {
							// Se modifica la propia sucurba
							int numero = sucurbaService.editarSucurba(sucurba);
							if (numero == 0) {
								
								model.addAttribute("mensaje", "No se ha podido modificar la sucurba");
								
							}else {
								model.addAttribute("idsucurba", sucurba.getIdsucurba());
								model.addAttribute("mensaje", "Éxito");
								model.addAttribute("sucurbaNuevaModificada", sucurba);
								model.addAttribute("mostrarTabla", "si");
								
							}
						}else {
							// Se está intentando modificar la sucurba con un nombre de sucurba y codigo que ya existe en BD
							model.addAttribute("mensajeError", "La sucurba ya existe. Por favor, introduzca otros valores");
						}
					}

				}
			}
			model.addAttribute("bancos", bancosService.buscarTodos());
			model.addAttribute("aniadir", "si");
			return "Sucurba";
		}

    
		
	
		@GetMapping("/borrarSucurba")
		public String borrarSucurba(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request) {

			LOGGER.debug("Entrando en borrarSucurba..");
			Sucurba sucurba = sucurbaService.buscarSucurbaPorId(id);
			boolean borrado = false;
			if (sucurba != null) {
				borrado = sucurbaService.borrarSucurba(sucurba.getIdsucurba());
			}
			if (!borrado) {
				model.addAttribute("mensaje", "No puede eliminar la sucurba porque hay perceptores que dependen de ella.");
			} else {
				model.addAttribute("mensaje", "Se ha eliminado correctamente la sucurba.");
			}
			return "ConsultaSucurba";
		}

		@GetMapping("/editarSucurba")
		public String editarSucurba(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request) {

			LOGGER.debug("Entrando en editarSucurba..");
			Sucurba sucurba = sucurbaService.buscarSucurbaPorId(id);
			if (sucurba != null) {
				model.addAttribute("sucurba", sucurba);
			}
			model.addAttribute("bancos", bancosService.buscarTodos());
			model.addAttribute("editar", "si");
			return "Sucurba";
		}

		@GetMapping(path = "/visualizarSucurba")
		public String visualizarSucurba(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request) {

			LOGGER.debug("Entrando en visualizarSucurba..");
			Sucurba sucurba = sucurbaService.buscarSucurbaPorId(id);
			model.addAttribute("sucurba", sucurba);
			model.addAttribute("consultar", "si");
			return "Sucurba";
		}


		// ************** sucurba exportcsv

		@GetMapping("/exportSucurba")
		public void exportToExcelSucurba(HttpServletResponse response, @ModelAttribute Sucurba sucurbaBuscada)	throws IOException {

			response.setContentType("application/octet-stream");
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
			String currentDateTime = dateFormatter.format(new Date());

			String headerKey = "Content-Disposition";
			String headerValue = "attachment; filename=sucurba_" + currentDateTime + ".csv";
			response.setHeader(headerKey, headerValue);

			if (Objects.equals(0, sucurbaBuscada.getIdsucurba())) {
				sucurbaBuscada.setIdsucurba(null);
			}

			if (Objects.equals("", sucurbaBuscada.getCdbanco())) {
				sucurbaBuscada.setCdbanco(null);
			}

			if (Objects.equals("", sucurbaBuscada.getCdsucur())) {
				sucurbaBuscada.setCdsucur(null);
			}

			List<Sucurba> listadoSucurbas = sucurbaService.buscarListado(sucurbaBuscada);

			List<String> columnNames = new ArrayList<>();
			columnNames.add("ENTIDAD BANCARIA");
			columnNames.add("CODIGO SUCURSAL");
			columnNames.add("DOMICILIO");
			columnNames.add("PLAZA");
			columnNames.add("PROVINCIA");
			columnNames.add("BIC");
			columnNames.add("NACION");
			columnNames.add("INFORMACION ADICIONAL");
			

			// parte cabecera
			workbook = new SXSSFWorkbook();
			sheet = workbook.createSheet("BANCOS");
			Row row = sheet.createRow(0);

			CellStyle style = workbook.createCellStyle();
			Font font = workbook.createFont();
			font.setBold(true);
			style.setFont(font);

			List<Cell> celdas = CommonExporter.writeHeaderLine(columnNames, "BANCOS", style, row);

			// parte de datos
			int rowCount = 1;
			font.setBold(false);
			style.setFont(font);

			for (Sucurba sucurba : listadoSucurbas) {
				row = sheet.createRow(rowCount++);
				int columnCount = 0;
				celdas.add(CommonExporter.createCell(row, columnCount++, sucurba.getBancoPlano(), style));
				celdas.add(CommonExporter.createCell(row, columnCount++, sucurba.getCdsucur(), style));
				celdas.add(CommonExporter.createCell(row, columnCount++, sucurba.getDsdomic(), style));
				celdas.add(CommonExporter.createCell(row, columnCount++, sucurba.getDsplaza(), style));
				celdas.add(CommonExporter.createCell(row, columnCount++, sucurba.getCdprov(), style));
				celdas.add(CommonExporter.createCell(row, columnCount++, sucurba.getCdbic(), style));
				celdas.add(CommonExporter.createCell(row, columnCount++, sucurba.getCdnacion(), style));
				celdas.add(CommonExporter.createCell(row, columnCount++, sucurba.getDsresto(), style));
			}
			CommonExporter.export(response, workbook);
		}
		
		private Sucurba validarFiltros(Sucurba sucurbaBuscado) {

			if (Objects.equals("", sucurbaBuscado.getCdsucur())) {
				sucurbaBuscado.setCdsucur(null);        
			}
	
			if (Objects.equals(null, sucurbaBuscado.getCdbanco())) {
				sucurbaBuscado.setCdbanco(null);
			}		
			return sucurbaBuscado;	
		}		
	
		private void guardarTotales(Model model, Page<Sucurba> pageSucurba,  int currentPage, String eppResultados)
		{		
			model.addAttribute("eppResultados", eppResultados);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("totalPages", pageSucurba.getTotalPages());
			model.addAttribute("totalItems", pageSucurba.getTotalElements());
			model.addAttribute("totalItemsPage", pageSucurba.getNumberOfElements());
		}

				private void limpiarCampos(Model model) {
			model.addAttribute("idsucurba", null);
			model.addAttribute("dssucurba", "");
			model.addAttribute("cdsucurba", "");
		}

		
}
