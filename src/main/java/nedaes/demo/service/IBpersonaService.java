package nedaes.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import nedaes.demo.model.Bpersona;

public interface IBpersonaService {

	public Bpersona insertarBpersona(Bpersona bpersona);
			
	public Bpersona buscarBpersonaPorId(Integer id);
		
	Page<Bpersona> paginacion(int pageNumber, int capacidad);
	
		
	public Page<Bpersona> buscarListadoPageable(Bpersona bpersona, int pageNumber, int capacidad);

	public Integer existeBpersona(Bpersona bpersona);
	
	
	public int editarBpersona(Bpersona bpersona);


}
