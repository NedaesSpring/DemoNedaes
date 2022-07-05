package nedaes.demo.controlador;

import java.io.IOException;
	import java.util.List;
	import java.util.Objects;

	import javax.servlet.http.HttpServletRequest;
	import javax.validation.Valid;

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

import nedaes.demo.model.Bpersona;
import nedaes.demo.model.Clasenomina;
import nedaes.demo.service.IBpersonaService;
import nedaes.demo.service.IClasenominaService;



	@Controller
	public class CambioDniController {
		
		private static final Logger LOGGER = LoggerFactory.getLogger(PerceptorControler.class);

		@Autowired
		private IBpersonaService bpersonaService; 
		
		@Autowired
		private IClasenominaService clasenominaService;

		@GetMapping("/cambioDnis")
		public String customersPage(Model model, HttpServletRequest request) {

			return cambioDni(model, 1, request);
		}
		
		@GetMapping("/inicioCambioDni/{pageNumber}")
		public String cambioDni(Model model, @PathVariable("pageNumber") int currentPage, HttpServletRequest request) {
			
			model.addAttribute("currentPage", currentPage);
			limpiarCampos(model);
			model.addAttribute("clasenominas", clasenominaService.buscarTodas());
			
			model.addAttribute("eppResultados", "10");
			model.addAttribute("totalPages", currentPage);
			return "ConsultaCambioDni";
		}
		
		@GetMapping("/consultaCambioDni")
		public String paginarCambioDni(Model model, @Param("eppResultados") String eppResultados, HttpServletRequest request) {

			int capacidad;
			if (eppResultados == null)	capacidad = 10;
			else  						capacidad = Integer.parseInt(eppResultados);
			int currentPage = 1;

			Page<Bpersona> pageBpersona = bpersonaService.paginacion(currentPage, capacidad);

			List<Bpersona> bpersonas = pageBpersona.getContent();

			model.addAttribute("listado", bpersonas);
			model.addAttribute("claseNominas", clasenominaService.buscarTodas());
			model.addAttribute("clasenomina", new Clasenomina());
			
			model.addAttribute("eppResultados", eppResultados);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("totalPages", pageBpersona.getTotalPages());
			model.addAttribute("totalItems", pageBpersona.getTotalElements());
			model.addAttribute("totalItemsPage", pageBpersona.getNumberOfElements());

			return "ConsultaCambioDni";
		}
		
		@GetMapping(value = "/consultaCambioDni/{pageNumber}")
		public String listarCambioDnis(Model model, @ModelAttribute Bpersona bpersonaBuscada, 
				@PathVariable("pageNumber") int currentPage, @Param("eppResultados") String eppResultados,
				HttpServletRequest request) {

			int capacidad;
			if (eppResultados == null)	capacidad = 10;
			else 						capacidad = Integer.parseInt(eppResultados);

			if (Objects.equals("", bpersonaBuscada.getCdclasnm())) {
				bpersonaBuscada.setCdclasnm(null);
			}
						
			if (Objects.equals(null, bpersonaBuscada.getClasenomina())) {
				bpersonaBuscada.setClasenomina(new Clasenomina());
			}
			if (Objects.equals("", bpersonaBuscada.getCddni())) {
				bpersonaBuscada.setCddni(null);
			}
			if (Objects.equals("", bpersonaBuscada.getCddup())) {
				bpersonaBuscada.setCddup(null);
			}
			if (Objects.equals("", bpersonaBuscada.getDsapell1())) {
				bpersonaBuscada.setDsapell1(null);
			}
			if (Objects.equals("", bpersonaBuscada.getDsapell2())) {
				bpersonaBuscada.setDsapell2(null);
			}
			if (Objects.equals("", bpersonaBuscada.getDsnombre())) {
				bpersonaBuscada.setDsnombre(null);
			}
			
			Page<Bpersona> listadoBpersonasPage = bpersonaService.buscarListadoPageable(bpersonaBuscada, currentPage, capacidad);
			List<Bpersona> listadoBpersonas = listadoBpersonasPage.getContent();
			model.addAttribute("listado", listadoBpersonas);
			model.addAttribute("cdclasnm", bpersonaBuscada.getCdclasnm());
			model.addAttribute("cddni", bpersonaBuscada.getCddni());
			model.addAttribute("cddup", bpersonaBuscada.getCddup());
			model.addAttribute("dsapell1", bpersonaBuscada.getDsapell1());
			model.addAttribute("dsapell2", bpersonaBuscada.getDsapell2());
			model.addAttribute("dsnombre", bpersonaBuscada.getDsnombre());
			if (Objects.equals(null, bpersonaBuscada.getClasenomina())){
				model.addAttribute("clasenomina", new Clasenomina());
			} else {
				model.addAttribute("clasenomina", bpersonaBuscada.getClasenomina());
			}
			model.addAttribute("clasenominas", clasenominaService.buscarTodas());
			
			model.addAttribute("eppResultados", eppResultados);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("totalPages", listadoBpersonasPage.getTotalPages());
			model.addAttribute("totalItems", listadoBpersonasPage.getTotalElements());
			model.addAttribute("totalItemsPage", listadoBpersonasPage.getNumberOfElements());

			return "ConsultaCambioDni";
		}

		@GetMapping("/cambioDni")
		public String nuevaCambioDni(Model model, @ModelAttribute Bpersona bpersona, HttpServletRequest request) {
			model.addAttribute("bpersona", new Bpersona());
			model.addAttribute("clasenominas", clasenominaService.buscarTodas());

			model.addAttribute("aniadir", "si");
			return "CambioDni";
		}
		
		
		@GetMapping("/insertarModificarBpersona")
		public String insertarModificarBpersona(Model model,@Valid @ModelAttribute Bpersona bpersona, BindingResult result, HttpServletRequest request) {
			
			LOGGER.debug("Entrando en insertarModificarBPersona..");			
			
//			if (!result.hasErrors()) {
				
			if (Objects.isNull(bpersona.getIdbpersona())  || Objects.equals(0, bpersona.getIdbpersona())) {
				if (!result.hasErrors()) {
					// No existen errores en el formulario			
				
					// Alta: Se comprueba si ya existe la Persona en BD
					Integer idBpersona = bpersonaService.existeBpersona(bpersona);
					
					if (!Objects.equals(0, idBpersona)) {
						// Persona ya existe

						model.addAttribute("mensajeError", "La persona ya existe. Por favor, introduzca otros valores");

						model.addAttribute("bpersona", bpersona);
					}else {
						// Persona no existe
					 
					 if (!Objects.equals(0,bpersona.getClasenomina().getIdClasenomina())) {
					 	if (Objects.equals(null, bpersona.getClasenomina())) {
							model.addAttribute("errorClaseNomSel", "El campo Clase Nomina no puede estar vacío");
							model.addAttribute("mensaje", "No se ha podido insertar/modificar la persona");
						} else {
							model.addAttribute("errorClasNomSel", null);
						
							Bpersona per = bpersonaService.insertarBpersona(bpersona);
							if (Objects.equals(null, per.getIdbpersona())) {

								model.addAttribute("mensaje", "No se ha podido insertar/modificar la persona");

							} else {
								model.addAttribute("bpersona", per);
								model.addAttribute("clasenominas", clasenominaService.buscarTodas());		
								model.addAttribute("mensaje", "Éxito");
								model.addAttribute("bpersonaNuevoModificado", per);
								model.addAttribute("mostrarTabla", "si");
							}
					  	}
					  }
					}
				}
			} else {
					// Modificación
					Integer idBpersona = bpersona.getIdbpersona();
					
					// Viene vacio, solo con el campo cddni, por lo que lo recupero el objeto de nuevo
					Bpersona bpersonaMod = bpersonaService.buscarBpersonaPorId(idBpersona);
					
					bpersonaMod.setCddni(bpersona.getCddni());
					
					// La persona existe en BD, puede ser la misma persona (pq en este caso el DNI se mantiene)
					
					int numero = bpersonaService.editarBpersona(bpersonaMod);
					if (numero == 0) {
						model.addAttribute("mensaje", "No se ha podido modificar el DNI de la persona");
								
					}else {
						model.addAttribute("bpersona", bpersonaMod);
						model.addAttribute("clasenominas", clasenominaService.buscarTodas());		
						model.addAttribute("mensaje", "Éxito");
						model.addAttribute("bpersonaNuevoModificado", bpersonaMod);
						model.addAttribute("mostrarTabla", "si");
					}
			}

			model.addAttribute("aniadir", "si");
			return "CambioDNI";
		}
		
		

		@GetMapping("/editarCambioDni")
		public String editarCambioDni(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request) {

			LOGGER.debug("Entrando en editarPersona..");
			Bpersona bpersona = bpersonaService.buscarBpersonaPorId(id);
			
			if (bpersona != null) {
				model.addAttribute("bpersona", bpersona);
			}

			model.addAttribute("clasenominas", clasenominaService.buscarTodas());

			model.addAttribute("editar", "si");
			return "CambioDni";
		}

		private void limpiarCampos(Model model) {
			model.addAttribute("id", null);
			model.addAttribute("cddni", "");
			model.addAttribute("cddup", "");
			model.addAttribute("dsapell1", "");
			model.addAttribute("dsapell2", "");
			model.addAttribute("dsnombre", "");
			model.addAttribute("idClasenomina", null);
		}
	}
