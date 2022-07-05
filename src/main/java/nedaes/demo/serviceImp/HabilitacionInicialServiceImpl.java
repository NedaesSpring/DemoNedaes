package nedaes.demo.serviceImp;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import nedaes.demo.model.HabilitacionInicial;
import nedaes.demo.repository.IHabilitacionInicialRepository;
import nedaes.demo.service.IHabilitacionInicialService;

@Service
public class HabilitacionInicialServiceImpl implements IHabilitacionInicialService {

	@Autowired
	private IHabilitacionInicialRepository habilitacionInicialRepository;

	public HabilitacionInicialServiceImpl(IHabilitacionInicialRepository habilitacionInicialRepository) {
		this.habilitacionInicialRepository = Objects.requireNonNull(habilitacionInicialRepository);
	}
	
	@Override
	public List<HabilitacionInicial> buscarTodos() {
		return habilitacionInicialRepository.BuscarTodas();
	}
}
