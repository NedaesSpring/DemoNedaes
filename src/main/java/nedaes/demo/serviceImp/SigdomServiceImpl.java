package nedaes.demo.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import nedaes.demo.model.Sigdom;
import nedaes.demo.repository.ISigdomRepository;
import nedaes.demo.service.ISigdomService;

@Service
public class SigdomServiceImpl implements ISigdomService {

	@Autowired
	private ISigdomRepository sigdomRepository;

	public SigdomServiceImpl(ISigdomRepository sigdomRepository) {
		this.sigdomRepository = Objects.requireNonNull(sigdomRepository);
	}
	
	@Override
	public List<Sigdom> buscarTodos() {
		List<Sigdom> sigdoms = new ArrayList<Sigdom>();
		sigdoms = sigdomRepository.findAll(Sort.by(Sort.Direction.ASC, "dssiglas"));
		return sigdoms;
	}
}
