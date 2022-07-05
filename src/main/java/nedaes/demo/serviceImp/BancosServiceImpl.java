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

import nedaes.demo.model.Banco;
import nedaes.demo.model.Bperban;
import nedaes.demo.repository.IBancosRepository;
import nedaes.demo.repository.IBperbanRepository;
import nedaes.demo.service.IBancosService;

@Service
public class BancosServiceImpl implements IBancosService {

	@Autowired
	private IBancosRepository bancoRepository;

	@Autowired
	private IBperbanRepository bperbanRepository;

	public BancosServiceImpl(IBancosRepository bancoRepository) {
		this.bancoRepository = Objects.requireNonNull(bancoRepository);
	}

	@Override
	public List<Banco> buscarTodos() {
		List<Banco> bancos = new ArrayList<Banco>();
		bancos = bancoRepository.findAll(Sort.by(Sort.Direction.ASC, "dsbanco"));
		return bancos;
	}
	
	
	@Override
	public Banco insertarBanco(Banco banco) {

		Banco bancoInsertada = bancoRepository.save(banco);
		return bancoInsertada;
	}

	@Override
	public List<Banco> listarBancos() {
		List<Banco> bancos = new ArrayList<Banco>();
		bancos = bancoRepository.findAll(Sort.by(Sort.Direction.ASC, "bancoNombre"));
		return bancos;
	}

	public List<Banco> buscarListado(Banco banco) {
		List<Banco> listado = new ArrayList<Banco>();

		listado = bancoRepository.buscarBancosPorFiltro(banco.getDsbanco(), banco.getCdbanco());

		return listado;
	}

	public Page<Banco> buscarListadoPageable(Banco banco, int pageNumber, int capacidad) {
		Page<Banco> listado;

		Pageable pagina = PageRequest.of(pageNumber - 1, capacidad);

		listado = bancoRepository.buscarBancosPorFiltroPageable(pagina, banco.getDsbanco(), banco.getCdbanco());

		return listado;
	}

	public boolean borrarBanco(Integer id) {
		boolean borrado = false;
		List<Bperban> listado = null ;
				bperbanRepository.buscarBancoPorPerceptor(id);
		if (listado.isEmpty()) {
			bancoRepository.deleteById(id);
			borrado = true;
		}
		return borrado;
	}

	public int editarBanco(Banco banco) {
		return bancoRepository.actualizarBanco(banco.getDsbanco(), banco.getCdbanco(), banco.getOtbanex(), banco.getCdbic(), banco.getIdbanco());
	}

	public Banco buscarBancoPorId(Integer id) {
		Optional<Banco> p = bancoRepository.findById(id);
		Banco banco = null;
		if (p.isPresent()) {
			banco = p.get(); // se coge el objeto Banco
		}
		return banco;
	}

	@Override
	public Page<Banco> paginacion(int pageNumber, int capacidad) {
		Pageable pageable = PageRequest.of(pageNumber - 1, capacidad);
		return bancoRepository.findAll(pageable);
	}

	@Override
	public List<Banco> listarBancosPorOrden() {
		return bancoRepository.findAll(Sort.by(Sort.Direction.ASC, "bancoNombre"));
	}

	@Override
	public Integer existeBanco(Banco banco) {
	
		if (!(banco.getCdbanco() != null && banco.getCdbanco() != "")) {
			banco.setCdbanco(null);
		}
		Banco p = bancoRepository.existeBanco(banco.getDsbanco(), banco.getCdbanco());
		if (Objects.equals(null, p)) {
			return 0;
		} else {
			return p.getIdbanco();
		}
	}

	@Override
	public Page<Banco> listAll(Banco banco, int pageNumber, int capacidad) {
		Integer idBanco = null;
		String cdbanco = null;
		String dsbanco = "";
		Pageable pageable = PageRequest.of(pageNumber - 1, capacidad);

		if (banco.getIdbanco() != null && banco.getIdbanco() != 0) {
			idBanco = banco.getIdbanco();
		}

		if (banco.getDsbanco() != null && banco.getDsbanco() != "") {
			dsbanco = banco.getDsbanco();
		}
		
		if (banco.getCdbanco() != null && banco.getCdbanco() != "") {
			cdbanco = banco.getCdbanco();
		}

		Page<Banco> Bancos = bancoRepository.findByParameters(idBanco, dsbanco, cdbanco, pageable);

		return Bancos;
	}

	@Override
	public Banco findByBancoNombre(String bancoNombre) {
		return bancoRepository.findByBancoNombre(bancoNombre);
	}

}
