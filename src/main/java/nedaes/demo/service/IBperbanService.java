package nedaes.demo.service;

import java.util.List;
import java.util.Optional;

import nedaes.demo.model.Banco;
import nedaes.demo.model.Bperadm;
import nedaes.demo.model.Bperban;

public interface IBperbanService {
	
	public List<Bperban> buscarTodos();
	
	public Bperban buscarBperbanPorId(Integer id);
	
	public Optional<Bperban> buscarPorAK(String cdhabil, String cdclasnm, String cddni, String cddup);
	
	public int editarBperban(Bperban bperadm, String cdbanco, Integer idbanco);
	public Bperban insertarBperban(String cdhabil, String cdclasnm, String cddni, String cddup, String cdbanco, Banco banco);
}
