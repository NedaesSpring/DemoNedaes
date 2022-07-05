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
import nedaes.demo.model.Localid;
import nedaes.demo.model.Delhac;
import nedaes.demo.model.Sigdom;
import nedaes.demo.model.Sucurba;
import nedaes.demo.model.Habilitacion;
import nedaes.demo.model.HabilitacionBancaria;
import nedaes.demo.model.HabilitacionMutua;
import nedaes.demo.model.HabilitacionPersonal;
import nedaes.demo.model.Banco;
import nedaes.demo.model.Provinc;
import nedaes.demo.service.IBancosService;
import nedaes.demo.service.IDelhacService;
import nedaes.demo.service.IHabilitacionBancariaService;
import nedaes.demo.service.IHabilitacionMutuaService;
import nedaes.demo.service.IHabilitacionPersonalService;
import nedaes.demo.service.IHabilitacionService;
import nedaes.demo.service.ILocalidService;
import nedaes.demo.service.IProvincService;
import nedaes.demo.service.ISigdomService;
import nedaes.demo.service.ISucurbaService;

@Controller
public class HabilitacionControler {

	private static final Logger LOGGER = LoggerFactory.getLogger(HabilitacionControler.class);

	private SXSSFWorkbook workbook;
	private SXSSFSheet sheet;
	
	@Autowired
	private IHabilitacionService habilitacionService; 
	
	@Autowired
	private IHabilitacionPersonalService habilitacionPersonalService; 
	
	@Autowired
	private IHabilitacionBancariaService habilitacionBancariaService; 
	
	@Autowired
	private IHabilitacionMutuaService habilitacionMutuaService;
	
	@Autowired
	private IProvincService provincService; 

	@Autowired
	private IBancosService bancoService;

	@Autowired
	private ILocalidService localidService;
	
	@Autowired
	private IDelhacService delhacService;
	
	@Autowired
	private ISigdomService sigdomService;
	
	@Autowired
	private ISucurbaService sucurbaService;
	
	@GetMapping("/habilitaciones")
	public String customersPage(Model model, HttpServletRequest request) {

		return inicioHabilitacion(model, 1, request);
	}
	

	@GetMapping("/inicioHabilitacion/{pageNumber}")
	public String inicioHabilitacion(Model model, @PathVariable("pageNumber") int currentPage, HttpServletRequest request) {
		
		limpiarCampos(model);
		guardarCombos(model);
		inicializaItemCombos(model);
		
		model.addAttribute("eppResultados", "10");
		model.addAttribute("totalPages", currentPage);
		model.addAttribute("currentPage", currentPage);
		return "ConsultaHabilitacion";
	}
	
	@GetMapping("/ListarLocalidProvinc")  
	public String listarLocalidProvinc(Model model, @Param("provinc") String provinc) {  
		
		Integer cdprov = Integer.parseInt(provinc);  
		List<Localid> localids = localidService.buscarLocalidProvinc(cdprov);		
		model.addAttribute("localids", localids);
		return "ConsultaHabilitacion :: fraglocalid";		
	}
	
	
	@GetMapping("/ListarSucurbaBanco")  
	public String listarSucurbaBanco(Model model, @Param("banco") String banco) {  
		
		Integer idbanco = Integer.parseInt(banco);  
		List<Sucurba> sucurbas = sucurbaService.buscarSucurbaBanco(idbanco);		
		model.addAttribute("sucurbas", sucurbas);
		return "ConsultaHabilitacion :: fragsucurba";		
	}
	
	@GetMapping("/ListarLocalidProvincEdit")  
	public String listarLocalidProvincEdit(Model model, @Param("provinc") String provinc) {  
		
		Integer cdprov = Integer.parseInt(provinc);  
		List<Localid> localids = localidService.buscarLocalidProvinc(cdprov);		
		model.addAttribute("localids", localids);
		return "Habilitacion :: fraglocalid";		
	}
	
	
	@GetMapping("/ListarSucurbaBancoEdit")  
	public String listarSucurbaBancoEdit(Model model, @Param("banco") String banco) {  
		
		Integer idbanco = Integer.parseInt(banco);  
		List<Sucurba> sucurbas = sucurbaService.buscarSucurbaBanco(idbanco);		
		model.addAttribute("sucurbas", sucurbas);
		return "Habilitacion :: fragsucurba";		
	}
	
	@GetMapping("/ListarLocalidProvincPersonalEdit")  
	public String listarLocalidProvincPersonalEdit(Model model, @Param("provinc") String provinc) {  
		
		Integer cdprov = Integer.parseInt(provinc);  
		List<Localid> localids = localidService.buscarLocalidProvinc(cdprov);		
		model.addAttribute("localids", localids);
		return "HabilitacionPersonal :: fraglocalid";		
	}
	
	
	@GetMapping("/ListarSucurbaBancoPersonalEdit")  
	public String listarSucurbaBancoPersonalEdit(Model model, @Param("banco") String banco) {  
		
		Integer idbanco = Integer.parseInt(banco);  
		List<Sucurba> sucurbas = sucurbaService.buscarSucurbaBanco(idbanco);		
		model.addAttribute("sucurbas", sucurbas);
		return "HabilitacionPersonal :: fragsucurba";		
	}
	
	@GetMapping("/ListarSucurbaBancoBancariaEdit")  
	public String listarSucurbaBancoBancariaEdit(Model model, @Param("banco") String banco) {  
		
		Integer idbanco = Integer.parseInt(banco);  
		List<Sucurba> sucurbas = sucurbaService.buscarSucurbaBanco(idbanco);
		model.addAttribute("sucurbas", sucurbas);
		return "HabilitacionBancaria :: fragsucurba";		
	}
	

	
	@GetMapping("/consultaHabilitacion")
	public String consultaHabilitacion(Model model, @Param("eppResultados") String eppResultados, HttpServletRequest request) {

		int capacidad;
		if (eppResultados == null)	capacidad = 10;
		else  						capacidad = Integer.parseInt(eppResultados);
		int currentPage = 1;

		Page<Habilitacion> pageHabilitacion = habilitacionService.paginacion(currentPage, capacidad);

		List<Habilitacion> habilitaciones = pageHabilitacion.getContent();
		
        model.addAttribute("habilitacion", new Habilitacion());		
		
        model.addAttribute("listado", habilitaciones);
		
		model.addAttribute("banco", new Banco());
		model.addAttribute("provinc", new Provinc());
		model.addAttribute("delhac", new Delhac());
		model.addAttribute("sigdom", new Sigdom());
		model.addAttribute("sucurba", new Sucurba());
		model.addAttribute("localid", new Localid());
		
		guardarCombos(model);
		guardarTotales(model, pageHabilitacion, currentPage, eppResultados);
		
		return "ConsultaHabilitacion";
	}
	
	@GetMapping(value = "/consultaHabilitacion/{pageNumber}")
	public String listarHabilitaciones(Model model, @ModelAttribute Habilitacion habilitacionBuscada, 
			@PathVariable("pageNumber") int currentPage, @Param("eppResultados") String eppResultados,
			HttpServletRequest request) {

		int capacidad;
		if (eppResultados == null)	capacidad = 10;
		else 						capacidad = Integer.parseInt(eppResultados);

		habilitacionBuscada = validarFiltros(habilitacionBuscada);	
		
		Page<Habilitacion> listadoHabilitaciones = habilitacionService.buscarListadoPageable(habilitacionBuscada, currentPage, capacidad);
		List<Habilitacion> habilitaciones = listadoHabilitaciones.getContent();
		model.addAttribute("listado", habilitaciones);
		
		guardarCombos(model);
		
		guardarFiltros(model, habilitacionBuscada);
		guardarTotales(model, listadoHabilitaciones, currentPage, eppResultados);
		
		return "ConsultaHabilitacion";
	}

	
	@GetMapping("/consultaTodasHabilitaciones")
	public String consultaTodasHabilitaciones(Model model, @Param("eppResultados") String eppResultados, HttpServletRequest request) {

		int capacidad;
		if (eppResultados == null)	capacidad = 10;
		else  						capacidad = Integer.parseInt(eppResultados);
		int currentPage = 1;

		Page<Habilitacion> pageHabilitaciones = habilitacionService.paginacion(currentPage, capacidad);

		List<Habilitacion> habilitaciones = pageHabilitaciones.getContent();
		model.addAttribute("listado", habilitaciones);
		
		inicializaItemCombos(model);
		guardarCombos(model);
		guardarTotales(model, pageHabilitaciones, currentPage, "10");
		
		return "ConsultaHabilitacion";
	}
	
	
	@GetMapping("/habilitacion")
	public String nuevaHabilitacion(Model model, @ModelAttribute Habilitacion habilitacion, HttpServletRequest request) {
		model.addAttribute("habilitacion", new Habilitacion());
		inicializaItemCombos(model);
		guardarCombos(model);
		model.addAttribute("aniadir", "si");
		return "Habilitacion";
	}

	@GetMapping("/insertarModificarHabilitacion")
	public String insertarModificarHabilitacion(Model model, @Valid @ModelAttribute Habilitacion habilitacion, BindingResult result, HttpServletRequest request) {
		
		LOGGER.debug("Entrando en insertarModificarHabilitacion.");			
		
		if (!result.hasErrors()) {
			// No existen errores en el formulario					
			
			if (chequearErroresHabilitacion(model, habilitacion)) { 
				Habilitacion hab = habilitacionService.insertarHabilitacion(habilitacion);
				if (Objects.equals(null, hab.getIdHabilitacion())) {
					model.addAttribute("mensaje", "No se ha podido insertar/modificar el habilitacion");
				} else {
					model.addAttribute("mensaje", "Éxito");
					model.addAttribute("habilitacionNuevaModificada", hab);
					model.addAttribute("mostrarTabla", "si");
				}
			}else {
				// Modificación
				Integer idHabilitacion = habilitacionService.existeHabilitacion(habilitacion);
				
				if (Objects.equals(0, idHabilitacion)) {
					// Se está modificando el nombre del Habilit y/o apellidos (por tanto el Habilitacion a modificar existe en BD pero con otros nombres y apellidos, 
					// el idHabilitacion devuelto es 0, pq no coinciden con el q ya existe). 
					
					int numero = habilitacionService.editarHabilitacion(habilitacion);
					if (numero == 0) {
						
						model.addAttribute("mensaje", "No se ha podido modificar el habilitacion");
						
					}else {
						model.addAttribute("mensaje", "Éxito");
						model.addAttribute("habilitacionNuevaModificada", habilitacion);
						model.addAttribute("mostrarTabla", "si");
						
					}
				}else {
					// El habilitacion existe en BD, puede ser el mismo habilitacion (pq en este caso el nombre y los apellidos de la provincia se mantienen)
					if (Objects.equals(idHabilitacion, habilitacion.getIdHabilitacion())) {
						// Se modifica el propio Habilitacion

						int numero = habilitacionService.editarHabilitacion(habilitacion);
						if (numero == 0) {
							
							model.addAttribute("mensaje", "No se ha podido modificar la habilitacion");
							
						}else {
							model.addAttribute("mensaje", "Éxito");
							model.addAttribute("habilitacionNuevaModificada", habilitacion);
							model.addAttribute("mostrarTabla", "si");
						}
					}else {
						// Se está intentando modificar el habilitacion con un nombre de habilitacion y apellidos que ya existe en BD
						model.addAttribute("mensajeError", "La habilitacion ya existe. Por favor, introduzca otros valores");
					}
				}

			}
		}

		model.addAttribute("habilitacion", habilitacion);
		guardarItemCombos(model, habilitacion);
		guardarCombos(model);

		model.addAttribute("aniadir", "si");
		return "Habilitacion";
	}

	
	
	
	@GetMapping("/insertarModificarHabilitacionPersonal")
	public String insertarModificarHabilitacionPersonal(Model model, @Valid @ModelAttribute HabilitacionPersonal habilitacion, BindingResult result, HttpServletRequest request) {
		
		LOGGER.debug("Entrando en insertarModificarHabilitacion.");			
		
		if (!result.hasErrors()) {
			// No existen errores en el formulario					
			
			if (chequearErroresHabilitacionPersonal(model, habilitacion)) { 
				HabilitacionPersonal hab = habilitacionPersonalService.insertarHabilitacion(habilitacion);
				if (Objects.equals(null, hab.getIdHabilitacion())) {
					model.addAttribute("mensaje", "No se ha podido insertar/modificar el habilitacion");
				} else {
					model.addAttribute("mensaje", "Éxito");
					model.addAttribute("habilitacionNuevaModificada", hab);
					model.addAttribute("mostrarTabla", "si");
				}
			}else {
				// Modificación
				Integer idHabilitacion = habilitacionPersonalService.existeHabilitacion(habilitacion);
				
				if (Objects.equals(0, idHabilitacion)) {
					// Se está modificando el nombre del Habilit y/o apellidos (por tanto el Habilitacion a modificar existe en BD pero con otros nombres y apellidos, 
					// el idHabilitacion devuelto es 0, pq no coinciden con el q ya existe). 
					
					int numero = habilitacionPersonalService.editarHabilitacionPersonal(habilitacion);
					if (numero == 0) {
						
						model.addAttribute("mensaje", "No se ha podido modificar el habilitacion");
						
					}else {
						model.addAttribute("mensaje", "Éxito");
						model.addAttribute("habilitacionNuevaModificada", habilitacion);
						model.addAttribute("mostrarTabla", "si");
						
					}
				}else {
					// El habilitacion existe en BD, puede ser el mismo habilitacion (pq en este caso el nombre y los apellidos de la provincia se mantienen)
					if (Objects.equals(idHabilitacion, habilitacion.getIdHabilitacion())) {
						// Se modifica el propio Habilitacion

						int numero = habilitacionPersonalService.editarHabilitacionPersonal(habilitacion);
						if (numero == 0) {
							
							model.addAttribute("mensaje", "No se ha podido modificar la habilitacion");
							
						}else {
							model.addAttribute("mensaje", "Éxito");
							model.addAttribute("habilitacionNuevaModificada", habilitacion);
							model.addAttribute("mostrarTabla", "si");
						}
					}else {
						// Se está intentando modificar el habilitacion con un nombre de habilitacion y apellidos que ya existe en BD
						model.addAttribute("mensajeError", "La habilitacion ya existe. Por favor, introduzca otros valores");
					}
				}

			}
		}

		model.addAttribute("habilitacionPersonal", habilitacion);
		guardarItemCombosPersonal(model, habilitacion);
		guardarCombos(model);

		model.addAttribute("aniadir", "si");
		return "HabilitacionPersonal";
	}

	
	@GetMapping("/insertarModificarHabilitacionBancaria")
	public String insertarModificarHabilitacionBancaria(Model model,@Valid @ModelAttribute HabilitacionBancaria habilitacion, BindingResult result, HttpServletRequest request) {
		
		LOGGER.debug("Entrando en insertarModificarHabilitacion.");			
		
		if (!result.hasErrors()) {
			// No existen errores en el formulario					
			
			if (chequearErroresHabilitacionBancaria(model, habilitacion)) { 
				// Compongo el iban
//				habilitacion.setIban(habilitacion.getCdprefijiban() + '-' + habilitacion.getCdbanco() + '-' + habilitacion.getCdsucur() + '-' + habilitacion.getCdcodee()  + '-' + habilitacion.getCdcuenta());
				HabilitacionBancaria hab = habilitacionBancariaService.insertarHabilitacion(habilitacion);
				if (Objects.equals(null, hab.getIdHabilitacion())) {
					model.addAttribute("mensaje", "No se ha podido insertar/modificar el habilitacion");
				} else {
					model.addAttribute("mensaje", "Éxito");
					model.addAttribute("habilitacionNuevaModificada", hab);
					model.addAttribute("mostrarTabla", "si");
				}
			}else {
				// Modificación
				Integer idHabilitacion = habilitacionBancariaService.existeHabilitacion(habilitacion);
				
				if (Objects.equals(0, idHabilitacion)) {
					// Se está modificando el nombre del Habilit y/o apellidos (por tanto el Habilit a modificar existe en BD pero con otros nombres y apellidos, 
					// el idHabilitacion devuelto es 0, pq no coinciden con el q ya existe). 
					
					// Compongo el iban
//					habilitacion.setIban(habilitacion.getCdprefijiban() + '-' + habilitacion.getCdbanco() + '-' + habilitacion.getCdsucur() + '-' + habilitacion.getCdcodee()  + '-' + habilitacion.getCdcuenta());

					int numero = habilitacionBancariaService.editarHabilitacion(habilitacion);
					if (numero == 0) {
						
						model.addAttribute("mensaje", "No se ha podido modificar el habilitacion");
						
					}else {
						model.addAttribute("mensaje", "Éxito");
						model.addAttribute("habilitacionNuevaModificada", habilitacion);
						model.addAttribute("mostrarTabla", "si");
						
					}
				}else {
					// El habilit existe en BD, puede ser el mismo habilitacion (pq en este caso el nombre y los apellidos de la provincia se mantienen)
					if (Objects.equals(idHabilitacion,habilitacion.getIdHabilitacion())) {
						
						// Compongo el iban
	//					habilitacion.setIban(habilitacion.getCdprefijiban() + '-' + habilitacion.getCdbanco() + '-' + habilitacion.getCdsucur() + '-' + habilitacion.getCdcodee()  + '-' + habilitacion.getCdcuenta());
						
						// Se modifica el propio Habilitacion
						int numero = habilitacionBancariaService.editarHabilitacion(habilitacion);
						if (numero == 0) {
							
							model.addAttribute("mensaje", "No se ha podido modificar la habilitacion");
							
						}else {
							model.addAttribute("mensaje", "Éxito");
							model.addAttribute("habilitacionNuevaModificada", habilitacion);
							model.addAttribute("mostrarTabla", "si");
						}
					}else {
						// Se está intentando modificar el habilitacion con un nombre de habilitacion y apellidos que ya existe en BD
						model.addAttribute("mensajeError", "La habilitacion ya existe. Por favor, introduzca otros valores");
					}
				}

			}
		}
		model.addAttribute("habilitacionBancaria", habilitacion);
		guardarItemCombosBancaria(model, habilitacion);
		guardarCombosBancaria(model);

		model.addAttribute("aniadir", "si");
		return "HabilitacionBancaria";
	}

	
	@GetMapping("/insertarModificarHabilitacionMutua")
	public String insertarModificarHabilitacionMutua(Model model,@Valid @ModelAttribute HabilitacionMutua habilitacion, BindingResult result, HttpServletRequest request) {
		
			LOGGER.debug("Entrando en insertarModificarHabilitacion.");			
			
			if (!result.hasErrors()) {
				// No existen errores en el formulario					
				
				if (chequearErroresHabilitacionMutua(model, habilitacion)) { 
					HabilitacionMutua hab = habilitacionMutuaService.insertarHabilitacion(habilitacion);
					if (Objects.equals(null, hab.getIdHabilitacion())) {
						model.addAttribute("mensaje", "No se ha podido insertar/modificar la habilitacion");
					} else {
						model.addAttribute("mensaje", "Éxito");
						model.addAttribute("habilitacionNuevaModificada", hab);
						model.addAttribute("mostrarTabla", "si");
					}
				}else {
					// Modificación
					Integer idHabilitacion = habilitacionMutuaService.existeHabilitacion(habilitacion);
					
					if (Objects.equals(0, idHabilitacion)) {
						// Se está modificando el nombre del Habilit y/o apellidos (por tanto el Habilit a modificar existe en BD pero con otros nombres y apellidos, 
						// el idHabilitacion devuelto es 0, pq no coinciden con el q ya existe). 

						int numero = habilitacionMutuaService.editarHabilitacion(habilitacion);
						if (numero == 0) {
							
							model.addAttribute("mensaje", "No se ha podido modificar el habilitacion");
							
						}else {
							model.addAttribute("mensaje", "Éxito");
							model.addAttribute("habilitacionNuevaModificada", habilitacion);
							model.addAttribute("mostrarTabla", "si");
							
						}
					}else {
						// El habilit existe en BD, puede ser el mismo habilitacion (pq en este caso el nombre y los apellidos de la provincia se mantienen)
						if (Objects.equals(idHabilitacion,habilitacion.getIdHabilitacion())) {
							
							// Se modifica el propio Habilitacion
							int numero = habilitacionMutuaService.editarHabilitacion(habilitacion);
							if (numero == 0) {
								
								model.addAttribute("mensaje", "No se ha podido modificar la habilitacion");
								
							}else {
								model.addAttribute("mensaje", "Éxito");
								model.addAttribute("habilitacionNuevaModificada", habilitacion);
								model.addAttribute("mostrarTabla", "si");
							}
						}else {
							// Se está intentando modificar el habilitacion con un nombre de habilitacion y apellidos que ya existe en BD
							model.addAttribute("mensajeError", "La habilitacion ya existe. Por favor, introduzca otros valores");
						}
					}

				}
			}
			model.addAttribute("habilitacionMutua", habilitacion);
			model.addAttribute("aniadir", "si");
			return "HabilitacionMutua";
		}

	
	@GetMapping("/borrarHabilitacion")
	public String borrarHabilitacion(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request) {

		LOGGER.debug("Entrando en borrarHabilitacion.");
		Habilitacion habilitacion = habilitacionService.buscarHabilitacionPorId(id);
		boolean borrado = false;
		if (habilitacion != null) {
			borrado = habilitacionService.borrarHabilitacion(habilitacion.getIdHabilitacion());
		}
		if (!borrado) {
			model.addAttribute("mensaje", "No puede eliminar la habilitacion porque hay campos que dependen de ella.");
		} else {
			model.addAttribute("mensaje", "Se ha eliminado correctamente la habilitacion.");
		}
		inicializaItemCombos(model);
		guardarCombos(model);		

		return "ConsultaHabilitacion";
	}

	@GetMapping(path = "/visualizarHabilitacion")
	public String visualizarHabilitacion(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request) {

		LOGGER.debug("Entrando en visualizarHabilitacion.");
		Habilitacion habilitacion = habilitacionService.buscarHabilitacionPorId(id);
		model.addAttribute("habilitacion", habilitacion);
		guardarCombos(model);
		model.addAttribute("consultar", "si");
		return "Habilitacion";
	}

	
	@GetMapping("/editarHabilitacion")
	public String editarHabilitacion(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request) {

		LOGGER.debug("Entrando en editar Habilitacion.");
		Habilitacion habilitacion = habilitacionService.buscarHabilitacionPorId(id);
		if (habilitacion != null) {
			model.addAttribute("habilitacion", habilitacion);
		}
		guardarItemCombos(model, habilitacion);
		guardarCombos(model);
		model.addAttribute("editar", "si");
		return "Habilitacion";
	}
	
	
	@GetMapping("/editarHabilitacionPersonal")
	public String editarHabilitPersonal(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request) {

		LOGGER.debug("Entrando en editar Habilitacion Personal.");
		HabilitacionPersonal habilitacion = habilitacionPersonalService.buscarHabilitacionPorId(id);
		if (habilitacion != null) {
			model.addAttribute("habilitacionPersonal", habilitacion);
		}
		
		guardarItemCombosPersonal(model, habilitacion);
		guardarCombos(model);
		model.addAttribute("editar", "si");
		return "HabilitacionPersonal";
	}
	
	@GetMapping("/editarHabilitacionBancaria")
	public String editarHabilitacionBancaria(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request) {

		LOGGER.debug("Entrando en editar Habilitacion Bancaria.");
		HabilitacionBancaria habilitacion = habilitacionBancariaService.buscarHabilitacionPorId(id);
		if (habilitacion != null) {
			// Compongo el iban
			habilitacion.setIban(habilitacion.getCdprefijiban() + '-' + habilitacion.getCdbanco() + '-' + habilitacion.getCdsucur() + '-' + habilitacion.getCdcodee()  + '-' + habilitacion.getCdcuenta());
			model.addAttribute("habilitacionBancaria", habilitacion);
		}
		guardarItemCombosBancaria(model, habilitacion);		
		guardarCombosBancaria(model);
		model.addAttribute("editar", "si");
		return "HabilitacionBancaria";
	}
	
	@GetMapping("/editarHabilitacionMutua")
	public String editarHabilitacionMutua(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request) {

		LOGGER.debug("Entrando en editar Habilitacion de Mutuas.");
		HabilitacionMutua habilitacion = habilitacionMutuaService.buscarHabilitacionPorId(id);
		if (habilitacion != null) {
			model.addAttribute("habilitacionMutua", habilitacion);
		}
		model.addAttribute("editar", "si");
		return "HabilitacionMutua";
	}


	private boolean chequearErroresHabilitacionPersonal(Model model, HabilitacionPersonal habilitacion) {
		
		boolean respuesta = false;

		if (Objects.isNull(habilitacion.getIdHabilitacion()) ||  Objects.equals(0, habilitacion.getIdHabilitacion())  ) {
					
			// Alta: Se comprueba si ya existe la Habilitacion en BD
			Integer idHabilitacion = habilitacionPersonalService.existeHabilitacion(habilitacion);
			
			if (!Objects.equals(0, idHabilitacion)) {
				// Habilitacion ya existe

				model.addAttribute("mensajeError", "La habilitacion ya existe. Por favor, introduzca otros valores");

				model.addAttribute("habilitacion", habilitacion);
			}else {
				// Habilitacion no existe
			 
			  if (!Objects.equals(0,habilitacion.getIdHabilitacion())) {
				if (Objects.equals(null, habilitacion.getBanco())) {
					model.addAttribute("errorBancoSel", "El campo Banco no puede estar vacío");
					model.addAttribute("mensaje", "No se ha podido insertar/modificar el banco");
				} else 	if (Objects.equals(null, habilitacion.getSucurba())) {
					model.addAttribute("errorSucurbaSel", "El campo Sucursal bancaria no puede estar vacío");
					model.addAttribute("mensaje", "No se ha podido insertar/modificar la sucursal bancaria");
				} else if (Objects.equals(null, habilitacion.getLocalid())) {
					model.addAttribute("errorLocalidSel", "El campo Localidad no puede estar vacío");
					model.addAttribute("mensaje", "No se ha podido insertar/modificar la localidad");
				} else if (Objects.equals(null, habilitacion.getDelhac())) {
					model.addAttribute("errorDelhacSel", "El campo Delhac no puede estar vacío");
					model.addAttribute("mensaje", "No se ha podido insertar/modificar el delhac");
				} else if (Objects.equals(null, habilitacion.getSigdom())) {
					model.addAttribute("errorSigdomSel", "El campo Sigdom no puede estar vacío");
					model.addAttribute("mensaje", "No se ha podido insertar/modificar el sigdom");
				} else if (Objects.equals(null, habilitacion.getProvinc())) {
					model.addAttribute("errorProvincSel", "El campo Provinc no puede estar vacío");
					model.addAttribute("mensaje", "No se ha podido insertar/modificar la provinc");
				} else  {
					model.addAttribute("erroreHabilitacionSel", null);
					respuesta = true;
				}
			  }
			}
		}
		return respuesta;
	}
	
	private boolean chequearErroresHabilitacion(Model model, Habilitacion habilitacion) {
		boolean respuesta = false;

		if (Objects.isNull(habilitacion.getIdHabilitacion()) ||  Objects.equals(0, habilitacion.getIdHabilitacion())  ) {
					
			// Alta: Se comprueba si ya existe la Habilitacion en BD
			Integer idHabilitacion = habilitacionService.existeHabilitacion(habilitacion);
			
			if (!Objects.equals(0, idHabilitacion)) {
				// Habilitacion ya existe

				model.addAttribute("mensajeError", "La habilitacion ya existe. Por favor, introduzca otros valores");

				model.addAttribute("habilitacion", habilitacion);
			}else {
				// Habilitacion no existe
			 
			  if (!Objects.equals(0,habilitacion.getIdHabilitacion())) {
				if (Objects.equals(null, habilitacion.getBanco())) {
					model.addAttribute("errorBancoSel", "El campo Banco no puede estar vacío");
					model.addAttribute("mensaje", "No se ha podido insertar/modificar el banco");
				} else 	if (Objects.equals(null, habilitacion.getSucurba())) {
					model.addAttribute("errorSucurbaSel", "El campo Sucursal bancaria no puede estar vacío");
					model.addAttribute("mensaje", "No se ha podido insertar/modificar la sucursal bancaria");
				} else if (Objects.equals(null, habilitacion.getLocalid())) {
					model.addAttribute("errorLocalidSel", "El campo Localidad no puede estar vacío");
					model.addAttribute("mensaje", "No se ha podido insertar/modificar la localidad");
				} else if (Objects.equals(null, habilitacion.getDelhac())) {
					model.addAttribute("errorDelhacSel", "El campo Delhac no puede estar vacío");
					model.addAttribute("mensaje", "No se ha podido insertar/modificar el delhac");
				} else if (Objects.equals(null, habilitacion.getSigdom())) {
					model.addAttribute("errorSigdomSel", "El campo Sigdom no puede estar vacío");
					model.addAttribute("mensaje", "No se ha podido insertar/modificar el sigdom");
				} else if (Objects.equals(null, habilitacion.getProvinc())) {
					model.addAttribute("errorProvincSel", "El campo Provinc no puede estar vacío");
					model.addAttribute("mensaje", "No se ha podido insertar/modificar la provinc");
				} else  {
					model.addAttribute("erroreHabilitacionSel", null);
					respuesta = true;
				}
			  }
			}
		}
		return respuesta;
	}

	private boolean chequearErroresHabilitacionBancaria(Model model, HabilitacionBancaria habilitacion) {
		boolean respuesta = false;

		if (Objects.isNull(habilitacion.getIdHabilitacion()) ||  Objects.equals(0, habilitacion.getIdHabilitacion())  ) {
					
			// Alta: Se comprueba si ya existe la Habilitacion en BD
			Integer idHabilitacion = habilitacionBancariaService.existeHabilitacion(habilitacion);
			
			if (!Objects.equals(0, idHabilitacion)) {
				// Habilitacion ya existe

				model.addAttribute("mensajeError", "La habilitacion ya existe. Por favor, introduzca otros valores");

				model.addAttribute("habilitacionBancaria", habilitacion);
			}else {
				// Habilitacion no existe
			 
			  if (!Objects.equals(0,habilitacion.getIdHabilitacion())) {
				if (Objects.equals(null, habilitacion.getBanco())) {
					model.addAttribute("errorBancoSel", "El campo Banco no puede estar vacío");
					model.addAttribute("mensaje", "No se ha podido insertar/modificar el banco");
				} else 	if (Objects.equals(null, habilitacion.getSucurba())) {
					model.addAttribute("errorSucurbaSel", "El campo Sucursal bancaria no puede estar vacío");
					model.addAttribute("mensaje", "No se ha podido insertar/modificar la sucursal bancaria");
				} else if (Objects.equals(null, habilitacion.getDelhac())) {
					model.addAttribute("errorDelhacSel", "El campo Delhac no puede estar vacío");
					model.addAttribute("mensaje", "No se ha podido insertar/modificar el delhac");
				} else  {
					model.addAttribute("erroreHabilitacionSel", null);
					respuesta = true;
				}
			  }
			}
		}
		return respuesta;
	}
	
	private boolean chequearErroresHabilitacionMutua(Model model, HabilitacionMutua habilitacion) {
		boolean respuesta = false;

		if (Objects.isNull(habilitacion.getIdHabilitacion()) ||  Objects.equals(0, habilitacion.getIdHabilitacion())  ) {
					
			// Alta: Se comprueba si ya existe la Habilitacion en BD
			Integer idHabilitacion = habilitacionMutuaService.existeHabilitacion(habilitacion);
			
			if (!Objects.equals(0, idHabilitacion)) {
				// Habilitacion ya existe

				model.addAttribute("mensajeError", "La habilitacion ya existe. Por favor, introduzca otros valores");

				model.addAttribute("habilitacionMutua", habilitacion);
			}else {
				// Habilitacion no existe
			 
			  if (!Objects.equals(0,habilitacion.getIdHabilitacion())) {
					model.addAttribute("erroreHabilitacionSel", null);
					respuesta = true;				
			  }
			}
		}
		return respuesta;
	}

	private void guardarItemCombos(Model model, Habilitacion habilitacion) {
		model.addAttribute("sucurba", habilitacion.getSucurba());		
		model.addAttribute("localid", habilitacion.getLocalid());
		model.addAttribute("provinc", habilitacion.getProvinc());
		model.addAttribute("banco", habilitacion.getBanco());
		model.addAttribute("delhac", habilitacion.getDelhac());
		model.addAttribute("sigdom", habilitacion.getSigdom());
		model.addAttribute("sucurbas", sucurbaService.buscarSucurbaBanco(habilitacion.getBanco().getIdbanco()));		
		model.addAttribute("localids", localidService.buscarLocalidProvinc(habilitacion.getProvinc().getCdprov()));
	}

	private void guardarItemCombosBancaria(Model model, HabilitacionBancaria habilitacion) {
		model.addAttribute("delhac", habilitacion.getDelhac());
		model.addAttribute("banco", habilitacion.getBanco());
		model.addAttribute("sucurbas", sucurbaService.buscarSucurbaBanco(habilitacion.getBanco().getIdbanco()));	
		model.addAttribute("sucurba", habilitacion.getSucurba());
	}

	private void guardarItemCombosPersonal(Model model, HabilitacionPersonal habilitacion) {
		model.addAttribute("sucurba", habilitacion.getSucurba());		
		model.addAttribute("localid", habilitacion.getLocalid());
		model.addAttribute("provinc", habilitacion.getProvinc());
		model.addAttribute("banco", habilitacion.getBanco());
		model.addAttribute("delhac", habilitacion.getDelhac());
		model.addAttribute("sigdom", habilitacion.getSigdom());
		model.addAttribute("sucurbas", sucurbaService.buscarSucurbaBanco(habilitacion.getBanco().getIdbanco()));		
		model.addAttribute("localids", localidService.buscarLocalidProvinc(habilitacion.getProvinc().getCdprov()));
	}

	private Habilitacion validarFiltros(Habilitacion habilitacionBuscada) {


		if (Objects.equals("", habilitacionBuscada.getCdhabil())) {
			habilitacionBuscada.setCdhabil(null);
		}
		if (Objects.equals("", habilitacionBuscada.getDsorg())) {
			habilitacionBuscada.setDsorg(null);
		}
		if (Objects.equals("", habilitacionBuscada.getDscentro())) {
			habilitacionBuscada.setDscentro(null);
		}
		if (Objects.equals(null, habilitacionBuscada.getSucurba())) {
			habilitacionBuscada.setSucurba(new Sucurba());
		} 		
		if (Objects.equals(null, habilitacionBuscada.getLocalid())) {
			habilitacionBuscada.setLocalid(new Localid());
		}
		if (Objects.equals(null, habilitacionBuscada.getProvinc())) {
			habilitacionBuscada.setProvinc(new Provinc());
		}
		if (Objects.equals(null, habilitacionBuscada.getBanco())) {
			habilitacionBuscada.setBanco(new Banco());
		}
		if (Objects.equals(null, habilitacionBuscada.getSigdom())) {
			habilitacionBuscada.setSigdom(new Sigdom());
		}
		if (Objects.equals(null, habilitacionBuscada.getDelhac())) {
			habilitacionBuscada.setDelhac(new Delhac());
		}
		
		return habilitacionBuscada;
	
	}		
	
	private void guardarFiltros(Model model, Habilitacion habilitacionBuscada) {
		
		model.addAttribute("id", habilitacionBuscada.getIdHabilitacion());
		model.addAttribute("cdhabil", habilitacionBuscada.getCdhabil());
		model.addAttribute("dsorg", habilitacionBuscada.getDsorg());
		model.addAttribute("dscentro", habilitacionBuscada.getDscentro());

		
		if (Objects.equals(null, habilitacionBuscada.getSigdom())){
			model.addAttribute("sigdom", new Sigdom());
		} else {
			model.addAttribute("sigdom", habilitacionBuscada.getSigdom());
		}

		if (Objects.equals(null, habilitacionBuscada.getDelhac())){
			model.addAttribute("delhac", new Delhac());
		} else {
			model.addAttribute("delhac", habilitacionBuscada.getDelhac());
		}
	
		if (Objects.equals(null, habilitacionBuscada.getProvinc())){
			model.addAttribute("provinc", new Provinc());
		} else {
			model.addAttribute("provinc", habilitacionBuscada.getProvinc());
			// Por optimizar guarda aqui tambien el combo de localidad			
			if (!Objects.equals(null, habilitacionBuscada.getProvinc().getCdprov())){
				model.addAttribute("localids", localidService.buscarLocalidProvinc(habilitacionBuscada.getProvinc().getCdprov()));	
			}

		}
		
		if (Objects.equals(null, habilitacionBuscada.getBanco())){
			model.addAttribute("banco", new Banco());
		} else {
			model.addAttribute("banco", habilitacionBuscada.getBanco());
			// Por optimizar guarda aqui tambien el combo de sucurba			
			if (!Objects.equals(null, habilitacionBuscada.getBanco().getIdbanco())){
				model.addAttribute("sucurbas", sucurbaService.buscarSucurbaBanco(habilitacionBuscada.getBanco().getIdbanco()));	
			}
		}
		
	
		if (Objects.equals(null, habilitacionBuscada.getLocalid())){
			model.addAttribute("localid", new Localid());
		} else {
			model.addAttribute("localid", habilitacionBuscada.getLocalid());
		}
		
		
		if (Objects.equals(null, habilitacionBuscada.getSucurba())){
			model.addAttribute("sucurba", new Sucurba());
		} else {
			model.addAttribute("sucurba", habilitacionBuscada.getSucurba());
		}
		
	}
	
	private void inicializaItemCombos(Model model) {
		Habilitacion habilitacion = new Habilitacion();
		habilitacion.setLocalid(new Localid());
		habilitacion.setProvinc(new Provinc());
		habilitacion.setBanco(new Banco());
		habilitacion.setSucurba(new Sucurba());
		habilitacion.setDelhac(new Delhac());
		habilitacion.setSigdom(new Sigdom());
		
		model.addAttribute("habilitacion", habilitacion); 
		model.addAttribute("sucurba", new Sucurba());		
		model.addAttribute("localid", new Localid());
		model.addAttribute("provinc", new Provinc());
		model.addAttribute("banco", new Banco());
		model.addAttribute("delhac", new Delhac());
		model.addAttribute("sigdom", new Sigdom());
	}

	private void guardarCombos(Model model) {
		model.addAttribute("provincs", provincService.listarProvincias());
		model.addAttribute("bancos", bancoService.buscarTodos());
		model.addAttribute("delhacs", delhacService.buscarTodas());
		model.addAttribute("sigdoms", sigdomService.buscarTodos());
	}
	
	private void guardarCombosBancaria(Model model) {
		model.addAttribute("bancos", bancoService.buscarTodos());
		model.addAttribute("delhacs", delhacService.buscarTodas());		
	}

	private void guardarTotales(Model model, Page<Habilitacion> pageHabilitacion,  int currentPage, String eppResultados)
	{		
		model.addAttribute("eppResultados", eppResultados);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", pageHabilitacion.getTotalPages());
		model.addAttribute("totalItems", pageHabilitacion.getTotalElements());
		model.addAttribute("totalItemsPage", pageHabilitacion.getNumberOfElements());
	}

	

	private void limpiarCampos(Model model) {
		model.addAttribute("id", null);
		model.addAttribute("cdhabil", "");
		model.addAttribute("dsorg", "");
		model.addAttribute("dscentro", "");
		model.addAttribute("idbanco", null);
		model.addAttribute("idlocalid", null);
		model.addAttribute("idsucurba", null);
		model.addAttribute("cdprov", null);
		model.addAttribute("idsigdom", null);
		model.addAttribute("cddelhac", null);
	}

	// ************** listadoHabilitacion exportcsv

	@GetMapping("/exportHabilitacion")
	public void exportToExcelHabilitacion(HttpServletResponse response, @ModelAttribute Habilitacion habilitacionBuscada)	throws IOException {

		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=habilit_" + currentDateTime + ".csv";
		response.setHeader(headerKey, headerValue);

		if (Objects.equals(0, habilitacionBuscada.getIdHabilitacion())) {
			habilitacionBuscada.setIdHabilitacion(null);
		}

		habilitacionBuscada = validarFiltros(habilitacionBuscada);	

		List<Habilitacion> listadoHabilitaciones = habilitacionService.buscarListado(habilitacionBuscada);

		List<String> columnNames = new ArrayList<>();
		columnNames.add("ID");
		columnNames.add("CDHABIL");
		columnNames.add("DSORG");
		columnNames.add("DSCENTRO");
		columnNames.add("LOCALIDAD");
		columnNames.add("SUCURBA");
		columnNames.add("PROVINCIA");
		columnNames.add("BANCO");
		columnNames.add("DELHAC");
		columnNames.add("SIGDOM");
		
		// parte cabecera
		workbook = new SXSSFWorkbook();
		sheet = workbook.createSheet("HABILITACIONES");
		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setBold(true);
		style.setFont(font);

		List<Cell> celdas = CommonExporter.writeHeaderLine(columnNames, "HABILITACIONES", style, row);

		// parte de datos
		int rowCount = 1;
		font.setBold(false);
		style.setFont(font);

		for (Habilitacion habilitacion : listadoHabilitaciones) {
			row = sheet.createRow(rowCount++);
			int columnCount = 0;
			celdas.add(CommonExporter.createCell(row, columnCount++, habilitacion.getIdHabilitacion(), style));
			celdas.add(CommonExporter.createCell(row, columnCount++, habilitacion.getCdhabil(), style));
			celdas.add(CommonExporter.createCell(row, columnCount++, habilitacion.getDsorg(), style));
			celdas.add(CommonExporter.createCell(row, columnCount++, habilitacion.getDscentro(), style));
			celdas.add(CommonExporter.createCell(row, columnCount++, habilitacion.getSucurbaPlano(), style));
			celdas.add(CommonExporter.createCell(row, columnCount++, habilitacion.getLocalidPlano(), style));
			celdas.add(CommonExporter.createCell(row, columnCount++, habilitacion.getProvincPlano(), style));
			celdas.add(CommonExporter.createCell(row, columnCount++, habilitacion.getBancoPlano(), style));
			celdas.add(CommonExporter.createCell(row, columnCount++, habilitacion.getDelhacPlano(), style));
			celdas.add(CommonExporter.createCell(row, columnCount++, habilitacion.getSigdomPlano(), style));									
		}
		CommonExporter.export(response, workbook);
	}
}
