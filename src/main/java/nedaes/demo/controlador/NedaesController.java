package nedaes.demo.controlador;

import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NedaesController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NedaesController.class);

	@GetMapping({"/", "/index","/"})
    public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model, HttpServletRequest request) {
		model.addAttribute("tstamp", LocalDateTime.now()); 
        LOGGER.debug("Test de LOGGER");
        
        return "menu_principal";
    }
}
