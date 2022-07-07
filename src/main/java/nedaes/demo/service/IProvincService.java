package nedaes.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import nedaes.demo.model.Provinc;

public interface IProvincService {

		public Provinc findByDsprov(String dsprov);
	
		public Provinc insertarProvincia(Provinc provinc);

		public List<Provinc> listarProvincias();
		
		public List<Provinc> buscarListado(Provinc provinc);
		
		public List<Provinc> listarProvinciaPorOrden();

		public boolean borrarProvincia(Integer id);
			
		public Provinc buscarProvinciaPorId(Integer id);
		
		Page<Provinc> paginacion(int pageNumber, int capacidad);
		
		public Page<Provinc> listAll(Provinc provincia, int pageNumber, int capacidad);
		
		public Page<Provinc> buscarListadoPageable(Provinc provinc, int pageNumber, int capacidad);

		public Integer existeProvincia(Provinc provinc);
		
		public int editarProvincia(Provinc provinc);

}
