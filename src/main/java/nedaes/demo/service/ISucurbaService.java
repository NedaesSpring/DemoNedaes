package nedaes.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import nedaes.demo.model.Sucurba;

public interface ISucurbaService {
	
	public List<Sucurba> buscarTodas();

	public List<Sucurba> buscarSucurbaBanco(Integer idsucurba);

	
	public Sucurba findBySucurbaNombre(String sucurbaNombre);
	
	public Sucurba insertarSucurba(Sucurba sucurba);

	public List<Sucurba> listarSucurbas();
	
	public List<Sucurba> buscarListado(Sucurba sucurba);
	
	List<Sucurba> listarSucurbasPorOrden();

	public boolean borrarSucurba(Integer id);
		
	public Sucurba buscarSucurbaPorId(Integer id);
	
	Page<Sucurba> paginacion(int pageNumber, int capacidad);
	
	public Page<Sucurba> listAll(Sucurba sucurba, int pageNumber, int capacidad);
	
	public Page<Sucurba> buscarListadoPageable(Sucurba sucurba, int pageNumber, int capacidad);

	public Integer existeSucurba(Sucurba sucurba);
	
	public int editarSucurba(Sucurba sucurba);
	
	
}
