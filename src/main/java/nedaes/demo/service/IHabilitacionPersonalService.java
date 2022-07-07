package nedaes.demo.service;

import nedaes.demo.model.HabilitacionPersonal;

public interface IHabilitacionPersonalService {

	public HabilitacionPersonal insertarHabilitacion(HabilitacionPersonal habilitacion);
	
	public HabilitacionPersonal buscarHabilitacionPorId(Integer id);

	public Integer existeHabilitacion(HabilitacionPersonal habilitacion);

	public int editarHabilitacionPersonal(HabilitacionPersonal habilitacion);

}
