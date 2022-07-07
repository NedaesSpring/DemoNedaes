package nedaes.demo.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nedaes.demo.model.Localid;
import nedaes.demo.repository.ILocalidRepository;
import nedaes.demo.service.ILocalidService;

@Service
public class LocalidServiceImpl implements ILocalidService {
	@Autowired
	private ILocalidRepository localidRepository;

	public LocalidServiceImpl(ILocalidRepository localidRepository) {
		this.localidRepository = Objects.requireNonNull(localidRepository);
	}
	
	@Override
	public List<Localid> buscarLocalidProvinc(Integer cdprov) {
		
		List<Localid> localids = new ArrayList<Localid>();
		localids = localidRepository.buscarLocalidProvinc(cdprov);
		return localids;
	}
}
