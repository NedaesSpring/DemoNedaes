package nedaes.demo.service;

import java.util.List;

import nedaes.demo.model.Localid;

public interface ILocalidService {
	
	public List<Localid> buscarLocalidProvinc(Integer cdprov);

}
