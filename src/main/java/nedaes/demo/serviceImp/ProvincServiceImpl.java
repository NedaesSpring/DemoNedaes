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
import nedaes.demo.repository.IPerceptorRepository;
import nedaes.demo.repository.IProvincRepository;
import nedaes.demo.service.IProvincService;

@Service
public class ProvincServiceImpl implements IProvincService {

	@Autowired
	private IProvincRepository provincRepository;

	@Autowired
	private IPerceptorRepository perceptorRepository;

	public ProvincServiceImpl(IProvincRepository provincRepository) {
		this.provincRepository = Objects.requireNonNull(provincRepository);
	}

	@Override
	public Provinc insertarProvincia(Provinc provincia) {

		Provinc provinciaInsertada = provincRepository.save(provincia);
		return provinciaInsertada;
	}

	@Override
	public List<Provinc> listarProvincias() {
		List<Provinc> provincias = new ArrayList<Provinc>();
		provincias = provincRepository.findAll(Sort.by(Sort.Direction.ASC, "dsprov"));
		return provincias;
	}

	public List<Provinc> buscarListado(Provinc provinc) {
		List<Provinc> listado = new ArrayList<Provinc>();

		listado = provincRepository.buscarProvinciasPorFiltro(provinc.getCdprov(), provinc.getDsprov());

		return listado;
	}

	public Page<Provinc> buscarListadoPageable(Provinc provinc, int pageNumber, int capacidad) {
		Page<Provinc> listado;

		Pageable pagina = PageRequest.of(pageNumber - 1, capacidad);

		listado = provincRepository.buscarProvinciasPorFiltroPageable(pagina, provinc.getCdprov(), provinc.getDsprov());

		return listado;
	}

	public boolean borrarProvincia(Integer id) {
		boolean borrado = false;
		List<Perceptor> listado = perceptorRepository.buscarProvinciaPorPerceptor(id);
		
		if (listado.isEmpty()) {
			provincRepository.deleteById(id);
			borrado = true;
		}		
		return borrado;
	}

	public int editarProvincia(Provinc provincia) {
		return provincRepository.actualizarProvincia(provincia.getCdprov(), provincia.getDsprov(), provincia.getIdProvincia());
	}

	public Provinc buscarProvinciaPorId(Integer id) {
		Optional<Provinc> p = provincRepository.findById(id);
		Provinc provincia = null;
		if (p.isPresent()) {
			provincia = p.get(); // se coge el objeto Provinc
		}
		return provincia;
	}

	@Override
	public Page<Provinc> paginacion(int pageNumber, int capacidad) {
		Pageable pageable = PageRequest.of(pageNumber - 1, capacidad);
		return provincRepository.findAll(pageable);
	}

	@Override
	public List<Provinc> listarProvinciaPorOrden(){
		return provincRepository.findAll(Sort.by(Sort.Direction.ASC, "dsprov"));
	}

	@Override
	public Integer existeProvincia(Provinc provincia)  {
	
		if (!(provincia.getCdprov() != null && provincia.getCdprov() != 0)) {
			provincia.setCdprov(null);
		}
		Provinc p = provincRepository.existeProvincia(provincia.getDsprov(), provincia.getCdprov());
		if (Objects.equals(null, p)) {
			return 0;
		} else {
			return p.getCdprov();
		}
	}

	
	@Override
	public  Page<Provinc> listAll(Provinc provincia, int pageNumber, int capacidad) {
		Integer idProvincia = 0;
		Integer cdprov = 0;
		String dsprov = "";
		Pageable pageable = PageRequest.of(pageNumber - 1, capacidad);

		if (provincia.getIdProvincia() != null && provincia.getIdProvincia() != 0) {
			idProvincia = provincia.getIdProvincia();
		}
		
		if (provincia.getDsprov() != null && provincia.getDsprov() != "") {
			dsprov = provincia.getDsprov();
		}
		
		if (provincia.getCdprov() != null && provincia.getCdprov() != 0) {
			cdprov = provincia.getCdprov();
		}

		Page<Provinc> Provincias = provincRepository.findByParameters(idProvincia, cdprov, dsprov, pageable);

		return Provincias;
	}

	@Override
	public Provinc findByDsprov(String dsprov) {
		return provincRepository.findByDsprov(dsprov);
	}
}
