package nedaes.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import nedaes.demo.model.Perceptor;

public interface IPerceptorService {
	Perceptor findByNombre(String nombre, String dsapell1, String dsapell2);
	
	public Perceptor insertarPerceptor(Perceptor perceptor);

	public List<Perceptor> listarPerceptores();
		
	public List<Perceptor> buscarListado(Perceptor perceptor);
		
	public boolean borrarPerceptor(Integer id);
			
	public Perceptor buscarPerceptorPorId(Integer id);
		
	Page<Perceptor> paginacion(int pageNumber, int capacidad);
		
	public Page<Perceptor> listAll(Perceptor perceptor, int pageNumber, int capacidad);
		
	public Page<Perceptor> buscarListadoPageable(Perceptor perceptor, int pageNumber, int capacidad);

	public Integer existePerceptor(Perceptor perceptor);
		
	public int editarPerceptor(Perceptor perceptor);

	List<Perceptor> listarPerceptoresPorOrden();
	
	public Page<Perceptor> buscarPerceptoresPorIdbanco(Integer idbanco, int pageNumber, int capacidad);		
}
