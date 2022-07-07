package nedaes.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import nedaes.demo.model.Banco;

public interface IBancosService {
	
	public List<Banco> buscarTodos();
		
	public Banco findByBancoNombre(String bancoNombre);
	
	public Banco insertarBanco(Banco banco);

	public List<Banco> listarBancos();
	
	public List<Banco> buscarListado(Banco banco);
	
	List<Banco> listarBancosPorOrden();

	public boolean borrarBanco(Integer id);
		
	public Banco buscarBancoPorId(Integer id);
	
	Page<Banco> paginacion(int pageNumber, int capacidad);
	
	public Page<Banco> listAll(Banco banco, int pageNumber, int capacidad);
	
	public Page<Banco> buscarListadoPageable(Banco banco, int pageNumber, int capacidad);

	public Integer existeBanco(Banco banco);
	
	public int editarBanco(Banco banco);
	
}
