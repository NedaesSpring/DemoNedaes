package nedaes.demo.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import nedaes.demo.model.Delhac;
import nedaes.demo.repository.IDelhacRepository;
import nedaes.demo.service.IDelhacService;

@Service
public class DelhacServiceImpl implements IDelhacService {

	@Autowired
	private IDelhacRepository delhacRepository;

	public DelhacServiceImpl(IDelhacRepository delhacRepository) {
		this.delhacRepository = Objects.requireNonNull(delhacRepository);
	}
	
	@Override
	public List<Delhac> buscarTodas() {
		List<Delhac> delhacs = new ArrayList<Delhac>();
		delhacs = delhacRepository.findAll(Sort.by(Sort.Direction.ASC, "cddelhac"));
		return delhacs;
	}
}
