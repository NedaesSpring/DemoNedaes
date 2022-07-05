package nedaes.demo.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import nedaes.demo.model.Perceptor;
import nedaes.demo.model.Provinc;
import nedaes.demo.model.Sucurba;
import nedaes.demo.repository.ISucurbaRepository;
import nedaes.demo.service.ISucurbaService;

@Service
public class SucurbaServiceImpl implements ISucurbaService {
	@Autowired
	private ISucurbaRepository sucurbaRepository;

	public SucurbaServiceImpl(ISucurbaRepository sucurbaRepository) {
		this.sucurbaRepository = Objects.requireNonNull(sucurbaRepository);
	}
	
	@Override
	public List<Sucurba> buscarTodas() {
		return sucurbaRepository.findAll(Sort.by(Sort.Direction.ASC, "cdsucur"));

	}
	
	@Override
	public List<Sucurba> buscarSucurbaBanco(Integer idbanco) {
		
		List<Sucurba> sucurbas = new ArrayList<Sucurba>();
		sucurbas = sucurbaRepository.buscarSucurbaBanco(idbanco);
		return sucurbas;
	}
	
	
	
	@Override
	public Sucurba findBySucurbaNombre(String sucurbaNombre) { return new Sucurba();};
	
	@Override
	public Sucurba insertarSucurba(Sucurba sucurba) { return new Sucurba();};

	@Override
	public List<Sucurba> listarSucurbas() { return new ArrayList<Sucurba>();};
	
	@Override
	public List<Sucurba> buscarListado(Sucurba sucurba) { return new ArrayList<Sucurba>();};
	
	@Override
	public List<Sucurba> listarSucurbasPorOrden() {
		return sucurbaRepository.findAll(Sort.by(Sort.Direction.ASC, "cdsucur"));
	}

	@Override
	public boolean borrarSucurba(Integer id) { return true;}
		
	@Override
	public Sucurba buscarSucurbaPorId(Integer id) {
		Optional<Sucurba> s = sucurbaRepository.findById(id);
		Sucurba sucurba = null;
		if (s.isPresent()) {
			sucurba = s.get(); // se coge el objeto Sucurba
		}
		return sucurba;
	}

	
	@Override
	public Page<Sucurba> paginacion(int pageNumber, int capacidad) {
		Pageable pageable = PageRequest.of(pageNumber - 1, capacidad);
		return sucurbaRepository.findAll(pageable);
	}
	
	@Override
	public Page<Sucurba> listAll(Sucurba sucurba, int pageNumber, int capacidad) { return null;	};
	
	
	
	@Override
	public Page<Sucurba> buscarListadoPageable(Sucurba sucurba, int pageNumber, int capacidad) {
		Page<Sucurba> listado;
		Integer idbanco = null;

		if (Objects.equals(null, sucurba.getBanco())) {
			idbanco = null;
		} else {
			if (Objects.equals(null, sucurba.getBanco().getIdbanco() )) {
				idbanco = null;
			} else {
				idbanco = sucurba.getBanco().getIdbanco() ;
			}
		}

		Pageable pagina = PageRequest.of(pageNumber - 1, capacidad);

		listado = sucurbaRepository.buscarSucurbasPorFiltroPageable(pagina, idbanco, sucurba.getCdbanco(), sucurba.getCdsucur());

		return listado;
	}
	
	
	@Override
	public Integer existeSucurba(Sucurba sucurba) { 
	
		if (!(sucurba.getCdsucur() != null ) && (sucurba.getCdsucur() != "")) {
			sucurba.setCdsucur(null);
		}
		if (!(sucurba.getCdbanco() != null) && (sucurba.getCdbanco() != "")) {
			sucurba.setCdbanco(null);
		}
		
		Sucurba s = sucurbaRepository.existeSucurba(sucurba.getCdsucur(), sucurba.getCdbanco());
		if (Objects.equals(null, s)) {
			return 0;
		} else {
			return s.getIdsucurba();
		}
	}

	
	@Override
	public int editarSucurba(Sucurba sucurba) {
		return sucurbaRepository.actualizarSucurba(sucurba.getCdsucur(),sucurba.getCdbic(),sucurba.getDsdomic(), sucurba.getDsplaza(), sucurba.getCdprov(),sucurba.getCdnacion(), sucurba.getDsresto(),
				sucurba.getIdsucurba());		
	}
}
