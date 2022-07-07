package nedaes.demo.service;

import java.util.List;

import nedaes.demo.model.Habilitacion;

import org.springframework.data.domain.Page;

public interface IHabilitacionService {

	Habilitacion findByNombre(String cdhabil, String dsorg);

	public Habilitacion insertarHabilitacion(Habilitacion habilitacion);
	
	public List<Habilitacion> listarHabilitaciones();

	public List<Habilitacion> buscarListado(Habilitacion habilitacion);

	public boolean borrarHabilitacion(Integer id);

	public Habilitacion buscarHabilitacionPorId(Integer id);

	Page<Habilitacion> paginacion(int pageNumber, int capacidad);

	public Page<Habilitacion> buscarListadoPageable(Habilitacion habilitacion, int pageNumber, int capacidad);

	public Integer existeHabilitacion(Habilitacion habilitacion);

	public int editarHabilitacion(Habilitacion habilitacion);
	
	List<Habilitacion> listarHabilitacionesPorOrden();

}
