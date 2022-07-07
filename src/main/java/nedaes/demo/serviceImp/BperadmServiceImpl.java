package nedaes.demo.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import nedaes.demo.model.Bperadm;
import nedaes.demo.model.Provinc;
import nedaes.demo.repository.IBperadmRepository;
import nedaes.demo.service.IBperadmService;

@Service
public class BperadmServiceImpl implements IBperadmService {

		@Autowired
		private IBperadmRepository bperadmRepository;

		public BperadmServiceImpl(IBperadmRepository bperadmRepository) {
			this.bperadmRepository = Objects.requireNonNull(bperadmRepository);
		}
		
		@Override
		public List<Bperadm> buscarTodos() {
			List<Bperadm> bperadms = new ArrayList<Bperadm>();
			bperadms = bperadmRepository.findAll(Sort.by(Sort.Direction.ASC, "cdsitnom"));
			return bperadms;
		}
		
		@Override
		public Optional<Bperadm> buscarPorAK(String cdhabil, String cdclasnm, String cddni, String cddup) {
			
			return bperadmRepository.buscarPorAK(cdhabil, cdclasnm, cddni, cddup);			
		}
		
		@Override
		public int editarBperadm(Bperadm bperadm, String cdsitnom) {
			return bperadmRepository.actualizarBperadm(bperadm.getIdbperadm(), cdsitnom);
		}
		
		@Override
		public Bperadm insertarBperadm(String cdhabil, String cdclasnm, String cddni, String cddup, String cdsitnom) {
			
			return bperadmRepository.findById(1).get();
			/*  estoy dando el primer bperadm, en vez de crearlo ., hay que cambiar esto en un proc almacenado
			String cdagrupr ="DEMO";
			String cdagrupn ="000000";
			Integer fealtano = 2452488;
			Integer feefecoa = 2452488;
			String cdmotiva= "A01";
			String nmregper = "0000111413 A1630";
			String cdloc = "031";
			String cdpais= "724";
			String cddomi = "001";
			String cdseccio= "22";
			String cdundir = "45942";
			String cdunmin = "28";
			String cdundorg = "27075";
			String cdprog = "121A";
			String cdservi = "01";
			String cdorgan = "000";
			String cdprov = "04";
			
			Bperadm bperadm = new Bperadm();
			bperadm.setCdsitnom(cdsitnom);
			bperadm.setCdhabil(cdhabil);
			bperadm.setCdclasnm(cdclasnm);
			bperadm.setCddni(cddni);
			bperadm.setCddup(cddup);
			bperadm.setCdprov(cdprov);
			bperadm.setCdagrupr(cdagrupr);// no se que clave poner aqui
			bperadm.setCdagrupn(cdagrupn);// no se que clave poner aqui
			bperadm.setFealtano(fealtano);// no se que clave poner aqui
			bperadm.setCdmotiva(cdmotiva);// no se que clave poner aqui
			bperadm.setFeefecoa(feefecoa);// no se que clave poner aqui
			bperadm.setNmregper(nmregper);// no se que clave poner aqui
			bperadm.setCdloc(cdloc);// no se que clave poner aqui
			bperadm.setCdpais(cdpais);// no se que clave poner aqui
			bperadm.setCddomi(cddomi);// no se que clave poner aqui
			bperadm.setCdseccio(cdseccio);// no se que clave poner aqui
			bperadm.setCdundir(cdundir);// no se que clave poner aqui
			bperadm.setCdunmin(cdunmin);// no se que clave poner aqui
			bperadm.setCdundorg(cdundorg);// no se que clave poner aqui
			bperadm.setCdprog(cdprog);// no se que clave poner aqui
			bperadm.setCdservi(cdservi);// no se que clave poner aqui
			bperadm.setCdorgan(cdorgan);// no se que clave poner aqui
			Bperadm bperadmInsertado = bperadmRepository.save(bperadm);			
			return bperadmInsertado;
			*/
		}

}
