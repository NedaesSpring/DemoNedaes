package nedaes.demo.controlador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import nedaes.demo.model.Clasenomina;
import nedaes.demo.model.HabilitacionInicial;
import nedaes.demo.service.IClasenominaService;
import nedaes.demo.service.IHabilitacionInicialService;


@Controller
public class LoginController {
	
	@Autowired
	private IHabilitacionInicialService habilitacionInicialService; 
	
	@Autowired
	private IClasenominaService clasenominaService;
	
	@GetMapping("/login")
	public String login(Model model, HttpServletRequest request) {
		
		List<HabilitacionInicial> habilitaciones = habilitacionInicialService.buscarTodos();
		model.addAttribute("habilitaciones", habilitaciones);
		
		List<Clasenomina> clasenominas = clasenominaService.buscarTodas();
	    model.addAttribute("clasenominas", clasenominas);
		
		return "login";
		
		
	}
}
