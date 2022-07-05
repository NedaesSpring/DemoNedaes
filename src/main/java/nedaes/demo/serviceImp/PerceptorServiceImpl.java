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
import org.springframework.transaction.annotation.Transactional;

import nedaes.demo.util.Constantes;
import nedaes.demo.model.Perceptor;
import nedaes.demo.model.Bperban;
import nedaes.demo.model.Bperadm;
import nedaes.demo.repository.IPerceptorRepository;
import nedaes.demo.service.IBperadmService;
import nedaes.demo.service.IBperbanService;
import nedaes.demo.service.IPerceptorService;

@Service
public class PerceptorServiceImpl implements IPerceptorService {

	@Autowired
	private IPerceptorRepository perceptorRepository;

	@Autowired
	private IBperadmService bperadmService;

	@Autowired
	private IBperbanService bperbanService;

	public PerceptorServiceImpl(IPerceptorRepository perceptorRepository) {
		this.perceptorRepository = Objects.requireNonNull(perceptorRepository);
	}

	@Transactional
	@Override
	public Perceptor insertarPerceptor(Perceptor perceptor) {

		// CREAR CLASENOMINA, BPERADM, BPERBAN
		Bperadm bperadm = null;
		
		Optional<Bperadm> padm = bperadmService.buscarPorAK(perceptor.getHabilitacion().getCdhabil(), perceptor.getClasenomina().getCdclasnm(), perceptor.getDni(), perceptor.getDup());
		if (padm.isPresent()) { // Existe, pues se usa
			bperadm = padm.get();
			bperadmService.editarBperadm(bperadm, perceptor.getBperadm().getCdsitnom());
		} else { // No existe, pues se crea uno
			bperadm =  new Bperadm();			
			bperadm = bperadmService.insertarBperadm(perceptor.getHabilitacion().getCdhabil(), perceptor.getClasenomina().getCdclasnm(),  perceptor.getDni(), perceptor.getDup(), perceptor.getBperadm().getCdsitnom());
		}
		
		Bperban bperban = null;
		Optional<Bperban> pban = bperbanService.buscarPorAK(perceptor.getHabilitacion().getCdhabil(), perceptor.getClasenomina().getCdclasnm(), perceptor.getDni(), perceptor.getDup());
		if (pban.isPresent()) {// Existe, pues se usa
			bperban = pban.get(); 
			bperbanService.editarBperban(bperban, perceptor.getBperban().getCdbanco(), perceptor.getBperban().getBanco().getIdbanco());
		} else { // No existe, pues se crea uno
			bperban =  new Bperban();
			bperban = bperbanService.insertarBperban(perceptor.getHabilitacion().getCdhabil(), perceptor.getClasenomina().getCdclasnm(), perceptor.getDni(), perceptor.getDup(), perceptor.getBperban().getCdbanco(), perceptor.getBperban().getBanco());
		}
		
		perceptor.setBperban(bperban);
		perceptor.setBperadm(bperadm);
		perceptor.setCn(perceptor.getClasenomina().getCdclasnm());
		perceptor.setHab(perceptor.getHabilitacion().getCdhabil());
		perceptor.setBperban(bperban);
		String Scdprov = "0" + perceptor.getProvincia().getCdprov().toString();
		if (perceptor.getProvincia().getCdprov().toString().length() == 1)
			Scdprov = "0" + perceptor.getProvincia().getCdprov().toString();
		else
			Scdprov = perceptor.getProvincia().getCdprov().toString();
		perceptor.setCdprov(Scdprov);
		Perceptor perceptorInsertado = perceptorRepository.save(perceptor);
		return perceptorInsertado;
	}

	@Override
	public List<Perceptor> listarPerceptores() {
		List<Perceptor> perceptores = new ArrayList<Perceptor>();
		perceptores = perceptorRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
		return perceptores;
	}

	public List<Perceptor> buscarListado(Perceptor perceptor) {
		List<Perceptor> listado = new ArrayList<Perceptor>();

		Integer idProvincia = null;
		Integer idClasenomina = null;
		Integer idHabilitacion = null;
		Integer idBperban = null;
		Integer idBperadm = null;
		if (Objects.equals(null, perceptor.getProvincia())){
			idProvincia = null;
		} else {
			if (Objects.equals(0, perceptor.getProvincia().getIdProvincia())){
				idProvincia = null;
			} else {
				idProvincia = perceptor.getProvincia().getIdProvincia();
			}
		}
		
		if (Objects.equals(null, perceptor.getClasenomina())){
			idClasenomina = null;
		} else {
			if (Objects.equals(0, perceptor.getClasenomina().getIdClasenomina())){
				idClasenomina = null;
			} else {
				idClasenomina = perceptor.getClasenomina().getIdClasenomina();
			}
		}
		
		if (Objects.equals(null, perceptor.getHabilitacion())){
			idHabilitacion = null;
		} else {
			if (Objects.equals(0, perceptor.getHabilitacion().getIdHabilitacion())){
				idHabilitacion = null;
			} else {
				idHabilitacion = perceptor.getHabilitacion().getIdHabilitacion();
			}
		}
		if (Objects.equals(null, perceptor.getBperban())){
			idBperban  = null;
		} else {
			if (Objects.equals(0, perceptor.getBperban().getIdbperban())){
				idBperban = null;
			} else {
				idBperban = perceptor.getBperban().getIdbperban();
			}
		}
		if (Objects.equals(null, perceptor.getBperadm())){
			idBperban  = null;
		} else {
			if (Objects.equals(0, perceptor.getBperadm().getIdbperadm())){
				idBperadm = null;
			} else {
				idBperadm = perceptor.getBperadm().getIdbperadm();
			}
		}
        listado = perceptorRepository.buscarPerceptoresPorFiltro(perceptor.getNombre(), perceptor.getApellidos(), perceptor.getDsapell2(), perceptor.getDni(), perceptor.getDup(), perceptor.getCn(), perceptor.getHab(), 
        		idBperadm, idProvincia, idClasenomina, idHabilitacion, idBperban);       
        
		return listado;
	}

	public Page<Perceptor> buscarListadoPageable(Perceptor perceptor, int pageNumber, int capacidad) {
		Page<Perceptor> listado;

		Pageable pagina = PageRequest.of(pageNumber - 1, capacidad);
		Integer idProvincia = null;
		Integer idClasenomina = null;
		Integer idHabilitacion = null;
		Integer idBperadm = null;
		Integer idBperban = null;
		if (Objects.equals(null, perceptor.getProvincia())){
			idProvincia = null;
		} else {
			if (Objects.equals(0, perceptor.getProvincia().getIdProvincia())){
				idProvincia = null;
			} else {
				idProvincia = perceptor.getProvincia().getIdProvincia();
			}
		}
		
		if (Objects.equals(null, perceptor.getClasenomina())){
			idClasenomina = null;
		} else {
			if (Objects.equals(0, perceptor.getClasenomina().getIdClasenomina())){
				idClasenomina = null;
			} else {
				idClasenomina = perceptor.getClasenomina().getIdClasenomina();
			}
		}
		
		if (Objects.equals(null, perceptor.getHabilitacion())){
			idHabilitacion = null;
		} else {
			if (Objects.equals(0, perceptor.getHabilitacion().getIdHabilitacion())){
				idHabilitacion = null;
			} else {
				idHabilitacion = perceptor.getHabilitacion().getIdHabilitacion();
			}
		}
		if (Objects.equals(null, perceptor.getBperadm())){
			idBperadm = null;
		} else {
			if (Objects.equals(0, perceptor.getBperadm().getIdbperadm())){
				idBperadm = null;
			} else {
				idBperadm = perceptor.getBperadm().getIdbperadm();
			}
		}
		
		if (Objects.equals(null, perceptor.getBperban())){
			idBperban = null;
		} else {
			if (Objects.equals(0, perceptor.getBperban().getIdbperban())){
				idBperban = null;
			} else {
				idBperban = perceptor.getBperban().getIdbperban();
			}
		}
		
        listado = perceptorRepository.buscarPerceptoresPorFiltroPageable(perceptor.getNombre(), perceptor.getApellidos(), perceptor.getDsapell2(), perceptor.getDni(), perceptor.getDup(), perceptor.getCn(), perceptor.getHab(), 
        		idBperadm, idProvincia, idClasenomina, idHabilitacion, idBperban, pagina);       
		return listado;
	}

	public boolean borrarPerceptor(Integer id) {
		boolean borrado = false;
			perceptorRepository.deleteById(id);
			borrado = true;
		return borrado;
	}

	public int editarPerceptor(Perceptor perceptor) {
		
		Integer idProvincia = null;
		Integer idClasenomina = null;
		Integer idHabilitacion = null;
		
		if (Objects.equals(null, perceptor.getProvincia())){
			idProvincia = null;
		} else {
			if (Objects.equals(0, perceptor.getProvincia().getIdProvincia())){
				idProvincia = null;
			} else {
				idProvincia = perceptor.getProvincia().getIdProvincia();
			}
		}
		
		if (Objects.equals(null, perceptor.getClasenomina())){
			idClasenomina = null;
		} else {
			if (Objects.equals(0, perceptor.getClasenomina().getIdClasenomina())){
				idClasenomina = null;
			} else {
				idClasenomina = perceptor.getClasenomina().getIdClasenomina();
			}
		}
		
		if (Objects.equals(null, perceptor.getHabilitacion())){
			idHabilitacion = null;
		} else {
			if (Objects.equals(0, perceptor.getHabilitacion().getIdHabilitacion())){
				idHabilitacion = null;
			} else {
				idHabilitacion = perceptor.getHabilitacion().getIdHabilitacion();
			}
		}
				
		return perceptorRepository.actualizarPerceptor(perceptor.getNombre(), perceptor.getApellidos(), perceptor.getDsapell2(), idProvincia,
				perceptor.getIdPerceptor(), perceptor.getDni(), 
				perceptor.getProvincia().getCdprov().toString(), perceptor.getCdsexo(), perceptor.getCddomnot(), perceptor.getCdforpag(), perceptor.getCdnumero(), perceptor.getDsviapub(),
//				perceptor.getSit(), 
				perceptor.getDup(), perceptor.getCn(), perceptor.getHab(), idClasenomina, idHabilitacion );
	}

	public Perceptor buscarPerceptorPorId(Integer id) {
		Optional<Perceptor> p= perceptorRepository.findById(id);
		Perceptor perceptor = null;
		if (p.isPresent()) {
			perceptor = p.get(); // se coge el objeto Perceptor 
		}
		return perceptor ;
	}

	@Override
	public Page<Perceptor> paginacion(int pageNumber, int capacidad) {
		Pageable pageable = PageRequest.of(pageNumber - 1, capacidad);
		return perceptorRepository.findAll(pageable);
	}

	public Integer existePerceptor(Perceptor perceptor) {

		if (perceptor.getApellidos().equals("")) {
			perceptor.setApellidos(null);
		}
		Perceptor p = perceptorRepository.existePerceptor(perceptor.getNombre(), perceptor.getApellidos(), perceptor.getDsapell2());
		if (Objects.equals(null, p)) {
			return 0;
		} else {
			return p.getIdPerceptor();
		}

	}

	@Override
	public Page<Perceptor> listAll(Perceptor perceptor, int pageNumber, int capacidad) {
		Integer idPerceptor = null;
		Integer idProvincia = null;

		String nombre = null;
		String dsapell1 = null;
		String dsapell2 = null;
		Pageable pageable = PageRequest.of(pageNumber - 1, capacidad);

		if (perceptor.getIdPerceptor() != 0) {
			idPerceptor = perceptor.getIdPerceptor();
		}

		if (perceptor.getProvincia() != null && perceptor.getProvincia().getIdProvincia() != 0) {
			idProvincia = perceptor.getProvincia().getIdProvincia();
		}
			
		if (perceptor.getNombre() != null && perceptor.getNombre() != "") {
			nombre = perceptor.getNombre();
		}
		
		if (perceptor.getApellidos() != null && perceptor.getApellidos() != "") {
			dsapell1 = perceptor.getApellidos();
		}

		if (perceptor.getDsapell2() != null && perceptor.getDsapell2() != "") {
			dsapell1 = perceptor.getDsapell2();
		}
		
		Page<Perceptor> Perceptores = perceptorRepository.findByParameters(idPerceptor, idProvincia, nombre, dsapell1, dsapell2, pageable);


		return Perceptores;
	}

	@Override
	public Perceptor findByNombre(String nombre, String dsapell1, String dsapell2) {
		return perceptorRepository.findByNombre(nombre, dsapell1, dsapell2);
	}

	@Override
	public List<Perceptor> listarPerceptoresPorOrden() {
		return perceptorRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
		
	}
	
	@Override
	public Page<Perceptor> buscarPerceptoresPorIdbanco(Integer idbanco, int pageNumber, int capacidad) {
		Page<Perceptor> listado;

		Pageable pagina = PageRequest.of(pageNumber - 1, capacidad);
        listado = perceptorRepository.buscarPerceptoresPorIdbanco(idbanco, pagina);       
		return listado;
	}
}
