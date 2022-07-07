package nedaes.demo.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nedaes.demo.model.Banco;
import nedaes.demo.model.Bperban;
import nedaes.demo.repository.IBperbanRepository;
import nedaes.demo.service.IBperbanService;

@Service
public class BperbanServiceImpl implements IBperbanService {

		@Autowired
		private IBperbanRepository bperbanRepository;

		public BperbanServiceImpl(IBperbanRepository bperbanRepository) {
			this.bperbanRepository = Objects.requireNonNull(bperbanRepository);
		}
		
		@Override
		public List<Bperban> buscarTodos() {
			List<Bperban> bperbans = new ArrayList<Bperban>();
			bperbans = bperbanRepository.findAll();
			return bperbans;
		}
		
		@Override
		public Bperban buscarBperbanPorId(Integer id) {
			Optional<Bperban> p = bperbanRepository.findById(id);
			Bperban bperban = null;
			if (p.isPresent()) {
				bperban = p.get(); // se coge el objeto Bperban
			}
			return bperban;
		}
		
		@Override
		public Optional<Bperban> buscarPorAK(String cdhabil, String cdclasnm, String cddni, String cddup) {
		
			return bperbanRepository.buscarPorAK(cdhabil, cdclasnm, cddni, cddup);			
		}
		
		@Override
		public int editarBperban(Bperban bperban, String cdbanco, Integer idbanco) {
			return bperbanRepository.actualizarBperban(bperban.getIdbperban(), cdbanco, idbanco);
		}
		
		@Override
		public Bperban insertarBperban(String cdhabil, String cdclasnm, String cddni, String cddup, String cdbanco, Banco banco) {
			
			Bperban bperban = new Bperban();
			bperban.setCdbanco(cdbanco);
			bperban.setBanco(banco);
			bperban.setCdhabil(cdhabil);
			bperban.setCdclasnm(cdclasnm);
			bperban.setCddni(cddni);
			bperban.setCddup(cddup);
			Bperban bperbanInsertado = bperbanRepository.save(bperban);
			return bperbanInsertado;
		}

		
}
