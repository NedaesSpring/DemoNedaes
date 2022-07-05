package nedaes.demo.service;

import java.util.List;
import java.util.Optional;

import nedaes.demo.model.Bperadm;
import nedaes.demo.model.Perceptor;

public interface IBperadmService {
	
	public List<Bperadm> buscarTodos();
	
	public Optional<Bperadm> buscarPorAK(String cdhabil, String cdclasnm, String cddni, String cddup);
	
	public int editarBperadm(Bperadm bperadm, String cdsitnom);
	public Bperadm insertarBperadm(String cdhabil, String cdclasnm, String cddni, String cddup, String cdsitnom);

}
