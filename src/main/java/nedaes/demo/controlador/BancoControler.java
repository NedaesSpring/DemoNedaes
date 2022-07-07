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
	import nedaes.demo.model.Banco;
    import nedaes.demo.service.IBancosService;

	
	@Controller
	public class BancoControler {
	
		private static final Logger LOGGER = LoggerFactory.getLogger(BancoControler.class);
    	
		private SXSSFWorkbook workbook;
		private SXSSFSheet sheet;

		
		/* INYECCION DE DEPENDENCIAS **************************************** */
		@Autowired
		private IBancosService bancoService; 
		
		
		@GetMapping("/bancos")
		public String customersPage(Model model, HttpServletRequest request) {

			return inicioBanco(model, 1, request);
		}
		
		
		@GetMapping("/inicioBanco/{pageNumber}")
		public String inicioBanco(Model model, @PathVariable("pageNumber") int currentPage, HttpServletRequest request) {
			
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("totalPages", currentPage);
			model.addAttribute("eppResultados", 10);
			
			limpiarCampos(model);
			return "ConsultaBanco";
		}
		
		
		@GetMapping("/consultaBanco")
		public String consultaBanco(Model model, @Param("eppResultados") String eppResultados, HttpServletRequest request) {

			int capacidad;
			if (eppResultados == null)	capacidad = 10;
			else  						capacidad = Integer.parseInt(eppResultados);
			int currentPage = 1;

			Page<Banco> pageBanco = bancoService.paginacion(currentPage, capacidad);

			List<Banco> bancos = pageBanco.getContent();

			model.addAttribute("listado", bancos);

			model.addAttribute("eppResultados", eppResultados);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("totalPages", pageBanco.getTotalPages());
			model.addAttribute("totalItems", pageBanco.getTotalElements());
			model.addAttribute("totalItemsPage", pageBanco.getNumberOfElements());

			return "ConsultaBanco";
		}
		
		
		
		
		@GetMapping(value = "/consultaBanco/{pageNumber}")
		public String consultaBanco(Model model, @ModelAttribute Banco bancoBuscado, 
				@PathVariable("pageNumber") int currentPage, @Param("eppResultados") String eppResultados,
				HttpServletRequest request) {

			int capacidad;
			if (eppResultados == null)	capacidad = 10;
			else 						capacidad = Integer.parseInt(eppResultados);

			if (Objects.equals("", bancoBuscado.getCdbanco())) {
				bancoBuscado.setCdbanco(null);        
			}

			if (Objects.equals(null, bancoBuscado.getDsbanco())) {
				bancoBuscado.setDsbanco(null);
			}

			Page<Banco> listadoBancos = bancoService.buscarListadoPageable(bancoBuscado, currentPage, capacidad);
			List<Banco> bancos = listadoBancos.getContent();
			model.addAttribute("listado", bancos);
			model.addAttribute("cdbanco", bancoBuscado.getCdbanco());
			model.addAttribute("dsbanco", bancoBuscado.getDsbanco());
			
			model.addAttribute("eppResultados", eppResultados);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("totalPages", listadoBancos.getTotalPages());
			model.addAttribute("totalItems", listadoBancos.getTotalElements());
			model.addAttribute("totalItempsPage", listadoBancos.getNumberOfElements());

			return "ConsultaBanco";
		}
		
		
		
		@GetMapping(value = "/consultaTodosBancos")
		public String consultaTodosBancos(Model model, @Param("eppResultados") String eppResultados,
				HttpServletRequest request) {

			int capacidad;
			if (eppResultados == null)	capacidad = 10;
			else 						capacidad = Integer.parseInt(eppResultados);

			Page<Banco> listadoBancos = bancoService.paginacion(1, capacidad);
			List<Banco> bancos = listadoBancos.getContent();
			model.addAttribute("listado", bancos);
			
			model.addAttribute("eppResultados", 10);
			model.addAttribute("currentPage", 1);
			model.addAttribute("totalPages", listadoBancos.getTotalPages());
			model.addAttribute("totalItems", listadoBancos.getTotalElements());
			model.addAttribute("totalItempsPage", listadoBancos.getNumberOfElements());

			return "ConsultaBanco";
		}

		
		@GetMapping("/banco")
		public String nuevoBanco(Model model, @ModelAttribute Banco banco, HttpServletRequest request) {
			model.addAttribute("banco", new Banco());

			model.addAttribute("aniadir", "si");
			return "Banco";
		}
				 
		@GetMapping("/insertarModificarBanco")
		public String insertarModificarBanco(Model model,@Valid @ModelAttribute Banco banco, BindingResult result, HttpServletRequest request) {
			
			LOGGER.debug("Entrando en insertarModificarBanco..");			
			
			if (!result.hasErrors()) {
				// No existen errores en el formulario					
							
				if (Objects.isNull(banco.getIdbanco()) ||  Objects.equals(0, banco.getIdbanco())  ) {
					
					// Alta: Se comprueba si ya existe la banco en BD
					Integer idBanco = bancoService.existeBanco(banco);
					
					if (!Objects.equals(0, idBanco)) {
						// Banco ya existe

						model.addAttribute("mensajeError", "La banco ya existe. Por favor, introduzca otros valores");

						model.addAttribute("banco", banco);
					}else {
						// Banco no existe
						Banco pro = bancoService.insertarBanco(banco);
						if (Objects.equals(0, pro.getIdbanco())) {

							model.addAttribute("mensaje", "No se ha podido insertar/modificar la banco");

						} else {
							model.addAttribute("idbanco", pro.getIdbanco());
							model.addAttribute("mensaje", "Éxito");
							model.addAttribute("bancoNuevaModificada", pro);
							model.addAttribute("mostrarTabla", "si");
						}
					}
				}else {
					// Modificación
					Integer idBanco = bancoService.existeBanco(banco);
					
					
					if (Objects.equals(0, idBanco)) {
						// Se está modificando el nombre de la banco y/o codigo de banco (por tanto la banco a modificar existe en BD pero con otros nombres de banco y/ codigo, 
						// el idBanco devuelto es 0, pq no coinciden con el q ya existe). 
						int numero = bancoService.editarBanco(banco);
						if (numero == 0) {
							
							model.addAttribute("mensaje", "No se ha podido modificar la banco");
							
						}else {
							model.addAttribute("idbanco", banco.getIdbanco());
							model.addAttribute("mensaje", "Éxito");
							model.addAttribute("bancoNuevaModificada", banco);
							model.addAttribute("mostrarTabla", "si");
							
						}
					}else {
						// La banco existe en BD, puede ser la misma banco (pq en este caso el nombre de la banco se mantiene y lo que se modifica es el codigo de banco)
						if (Objects.equals(idBanco,banco.getIdbanco())) {
							// Se modifica la propia banco
							int numero = bancoService.editarBanco(banco);
							if (numero == 0) {
								
								model.addAttribute("mensaje", "No se ha podido modificar la banco");
								
							}else {
								model.addAttribute("idbanco", banco.getIdbanco());
								model.addAttribute("mensaje", "Éxito");
								model.addAttribute("bancoNuevaModificada", banco);
								model.addAttribute("mostrarTabla", "si");
								
							}
						}else {
							// Se está intentando modificar la banco con un nombre de banco y codigo que ya existe en BD
							model.addAttribute("mensajeError", "La banco ya existe. Por favor, introduzca otros valores");
						}
					}

				}
			}

			model.addAttribute("aniadir", "si");
			return "Banco";
		}

    
		
	
		@GetMapping("/borrarBanco")
		public String borrarBanco(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request) {

			LOGGER.debug("Entrando en borrarBanco..");
			Banco banco = bancoService.buscarBancoPorId(id);
			boolean borrado = false;
			if (banco != null) {
				borrado = bancoService.borrarBanco(banco.getIdbanco());
			}
			if (!borrado) {
				model.addAttribute("mensaje", "No puede eliminar la banco porque hay perceptores que dependen de ella.");
			} else {
				model.addAttribute("mensaje", "Se ha eliminado correctamente la banco.");
			}
			return "ConsultaBanco";
		}

		@GetMapping("/editarBanco")
		public String editarBanco(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request) {

			LOGGER.debug("Entrando en editarBanco..");
			Banco banco = bancoService.buscarBancoPorId(id);
			if (banco != null) {
				model.addAttribute("banco", banco);
			}
			model.addAttribute("editar", "si");
			return "Banco";
		}

		@GetMapping(path = "/visualizarBanco")
		public String visualizarBanco(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request) {

			LOGGER.debug("Entrando en visualizarBanco..");
			Banco banco = bancoService.buscarBancoPorId(id);
			model.addAttribute("banco", banco);
			model.addAttribute("consultar", "si");
			return "Banco";
		}


		private void limpiarCampos(Model model) {
			model.addAttribute("idbanco", null);
			model.addAttribute("dsbanco", "");
			model.addAttribute("cdbanco", "");
		}

		// ************** banco exportcsv

		@GetMapping("/exportBanco")
		public void exportToExcelBanco(HttpServletResponse response, @ModelAttribute Banco bancoBuscada)	throws IOException {

			response.setContentType("application/octet-stream");
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
			String currentDateTime = dateFormatter.format(new Date());

			String headerKey = "Content-Disposition";
			String headerValue = "attachment; filename=banco_" + currentDateTime + ".csv";
			response.setHeader(headerKey, headerValue);

			if (Objects.equals(0, bancoBuscada.getIdbanco())) {
				bancoBuscada.setIdbanco(null);
			}

			if (Objects.equals("", bancoBuscada.getDsbanco())) {
				bancoBuscada.setDsbanco(null);
			}

			if (Objects.equals("", bancoBuscada.getCdbanco())) {
				bancoBuscada.setCdbanco(null);
			}

			List<Banco> listadoBancos = bancoService.buscarListado(bancoBuscada);

			List<String> columnNames = new ArrayList<>();
			columnNames.add("ID BANCO");
			columnNames.add("ENTIDAD BANCARIA");
			columnNames.add("CODIGO");
			columnNames.add("USO");
			columnNames.add("BIC");

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

			for (Banco banco : listadoBancos) {
				row = sheet.createRow(rowCount++);
				int columnCount = 0;
				celdas.add(CommonExporter.createCell(row, columnCount++, banco.getIdbanco(), style));
				celdas.add(CommonExporter.createCell(row, columnCount++, banco.getDsbanco(), style));
				celdas.add(CommonExporter.createCell(row, columnCount++, banco.getCdbanco(), style));
				celdas.add(CommonExporter.createCell(row, columnCount++, banco.getOtbanex(), style));
				celdas.add(CommonExporter.createCell(row, columnCount++, banco.getCdbic(), style));
			}
			CommonExporter.export(response, workbook);
		}

}
