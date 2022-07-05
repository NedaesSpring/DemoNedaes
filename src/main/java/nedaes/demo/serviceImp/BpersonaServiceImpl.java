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
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import nedaes.demo.util.DNI;
import nedaes.demo.model.Bpersona;
import nedaes.demo.model.Clasenomina;
import nedaes.demo.repository.IBpersonaRepository;
import nedaes.demo.repository.IBperadmRepository;
import nedaes.demo.repository.IBperrgsRepository;
import nedaes.demo.repository.IBpersesoRepository;
import nedaes.demo.repository.IBpeirpfnRepository;
import nedaes.demo.service.IBpersonaService;

@Service
public class BpersonaServiceImpl implements IBpersonaService {
	@Autowired
	private IBpersonaRepository bpersonaRepository;

	@Autowired
	private IBperadmRepository bperadmRepository;
	@Autowired
	private IBperrgsRepository bperrgsRepository;
	@Autowired
	private IBpersesoRepository bpersesoRepository;
	@Autowired
	private IBpeirpfnRepository bpeirpfnRepository;

	public BpersonaServiceImpl(IBpersonaRepository bpersonaRepository) {
		this.bpersonaRepository = Objects.requireNonNull(bpersonaRepository);
	}
	
	

	@Override
	public Bpersona insertarBpersona(Bpersona bpersona) {

		Bpersona bpersonaInsertado = bpersonaRepository.save(bpersona);
		return bpersonaInsertado;
	}

	
	public Page<Bpersona> buscarListadoPageable(Bpersona bpersona, int pageNumber, int capacidad) {
		Page<Bpersona> listado;

		Pageable pagina = PageRequest.of(pageNumber - 1, capacidad);
		Integer idClasenomina = null;

		if (Objects.equals(null, bpersona.getClasenomina())){
			idClasenomina = null;
		} else {
			if (Objects.equals(0, bpersona.getClasenomina().getIdClasenomina())){
				idClasenomina = null;
			} else {
				idClasenomina = bpersona.getClasenomina().getIdClasenomina();
			}
		}
		
	 	listado = bpersonaRepository.buscarBpersonasPorFiltroPageable(
	 			bpersona.getCdclasnm(), 
	 			bpersona.getCddni(), bpersona.getCddup(), bpersona.getDsapell1(), bpersona.getDsapell2(), bpersona.getDsnombre(),
	 			idClasenomina, 
	 			pagina);
		return listado;
	}

	public int editarBpersona(Bpersona bpersona) {
		int result = 0;
		Integer idbperadm = null;
		Integer idbperrgss = null;
		Integer idbpeirpfn = null;
		Integer ibpersesomuface = null;
		Integer ibpersesomugeju = null;
		Integer ibpersesoisfas = null;
		
		if (Objects.equals(null, bpersona.getBperadm())){
			idbperadm = null;
		} else {
			if (Objects.equals(0, bpersona.getBperadm().getIdbperadm())){
				idbperadm = null;
			} else {
				idbperadm  = bpersona.getBperadm().getIdbperadm();
			}
		}

		if (Objects.equals(null, bpersona.getBperrgss())){
			idbperrgss = null;
		} else {
			if (Objects.equals(0, bpersona.getBperrgss().getIdbperrgss())){
				idbperrgss = null;
			} else {
				idbperrgss  = bpersona.getBperrgss().getIdbperrgss();
			}
		}

		if (Objects.equals(null, bpersona.getBpeirpfn())){
			idbpeirpfn = null;
		} else {
			if (Objects.equals(0, bpersona.getBpeirpfn().getIdbpeirpfn())){
				idbpeirpfn = null;
			} else {
				idbpeirpfn  = bpersona.getBpeirpfn().getIdbpeirpfn();
			}
		}

		if (Objects.equals(null, bpersona.getBpersesomuface())){
			ibpersesomuface = null;
		} else {
			if (Objects.equals(0, bpersona.getBpersesomuface().getIdbperseso())){
				ibpersesomuface = null;
			} else {
				ibpersesomuface  = bpersona.getBpersesomuface().getIdbperseso();
			}
		}

		if (Objects.equals(null, bpersona.getBpersesomugeju())){
			ibpersesomugeju = null;
		} else {
			if (Objects.equals(0, bpersona.getBpersesomugeju().getIdbperseso())){
				ibpersesomugeju = null;
			} else {
				ibpersesomugeju  = bpersona.getBpersesomugeju().getIdbperseso();
			}
		}

		if (Objects.equals(null, bpersona.getBpersesoisfas())){
			ibpersesoisfas = null;
		} else {
			if (Objects.equals(0, bpersona.getBpersesoisfas().getIdbperseso())){
				ibpersesoisfas = null;
			} else {
				ibpersesoisfas  = bpersona.getBpersesoisfas().getIdbperseso();
			}
		}
		DNI dni = new DNI();
		dni.setNumeroDNI(Integer.parseInt(bpersona.getCddni()));
		String cdnif = bpersona.getCddni() + dni.obtenerLetra();
		
		// actualizarlo en cascada
		 result = bpersonaRepository.actualizarBpersona(bpersona.getCddni(), bpersona.getIdbpersona());
		 bperadmRepository.actualizarBperadm(bpersona.getCddni(), idbperadm);
		 bperrgsRepository.actualizarBperrgss(bpersona.getCddni(), idbperrgss);
// Ya lo hace internamente en un trigger		 
//		 bpeirpfnRepository.actualizarBpeirpfn(bpersona.getCddni(), cdnif, idbpeirpfn);
		 bpersesoRepository.actualizarBperseso(bpersona.getCddni(), ibpersesomuface);
		 bpersesoRepository.actualizarBperseso(bpersona.getCddni(), ibpersesomugeju);
		 bpersesoRepository.actualizarBperseso(bpersona.getCddni(), ibpersesoisfas);
		 
		return result;
		
	}

	public Bpersona buscarBpersonaPorId(Integer id) {
		Optional<Bpersona> p= bpersonaRepository.findById(id);
		Bpersona bpersona = null;
		if (p.isPresent()) {
			bpersona = p.get(); // se coge el objeto Perceptor 
		}
		return bpersona ;
	}

	@Override
	public Page<Bpersona> paginacion(int pageNumber, int capacidad) {
		Pageable pageable = PageRequest.of(pageNumber - 1, capacidad);
		return bpersonaRepository.findAll(pageable);
	}

	public Integer existeBpersona(Bpersona bpersona) {

		if (bpersona.getCddni().equals("")) {
			bpersona.setCddni(null);
		}
		Bpersona p = bpersonaRepository.existeBpersona(bpersona.getCddni(), bpersona.getCddup(), bpersona.getCdhabil()
				,bpersona.getCdclasnm()
				);
		if (Objects.equals(null, p)) {
			return 0;
		} else {
			return p.getIdbpersona();
		}

	}
}
