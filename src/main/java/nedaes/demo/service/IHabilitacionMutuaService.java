package nedaes.demo.service;

import nedaes.demo.model.HabilitacionMutua;

public interface IHabilitacionMutuaService {

	public HabilitacionMutua insertarHabilitacion(HabilitacionMutua habilitacion);
	
	public HabilitacionMutua buscarHabilitacionPorId(Integer id);

	public Integer existeHabilitacion(HabilitacionMutua habilitacion);

	public int editarHabilitacion(HabilitacionMutua habilitacion);	
	
}
