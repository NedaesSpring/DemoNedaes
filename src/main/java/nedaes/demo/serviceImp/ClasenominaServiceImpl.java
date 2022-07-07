package nedaes.demo.serviceImp;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nedaes.demo.model.Clasenomina;
import nedaes.demo.repository.IClasenominaRepository;
import nedaes.demo.service.IClasenominaService;

@Service
public class ClasenominaServiceImpl implements IClasenominaService 
 {

	@Autowired
	private IClasenominaRepository clasenominaRepository;

	
	public ClasenominaServiceImpl(IClasenominaRepository claseNominaRepository) {
		this.clasenominaRepository = Objects.requireNonNull(claseNominaRepository);
	}

	@Override
	public List<Clasenomina> buscarTodas() {
		return clasenominaRepository.findAll();
	}
}
