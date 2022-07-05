package nedaes.demo.service;

import nedaes.demo.model.HabilitacionBancaria;

public interface IHabilitacionBancariaService {

	public HabilitacionBancaria insertarHabilitacion(HabilitacionBancaria habilitacion);
	
	public HabilitacionBancaria buscarHabilitacionPorId(Integer id);

	public Integer existeHabilitacion(HabilitacionBancaria habilitacion);

	public int editarHabilitacion(HabilitacionBancaria habilitacion);		

}
