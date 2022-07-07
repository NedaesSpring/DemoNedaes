package nedaes.demo.serviceImp;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nedaes.demo.model.HabilitacionBancaria;
import nedaes.demo.repository.IHabilitacionBancariaRepository;
import nedaes.demo.service.IHabilitacionBancariaService;

@Service
public class HabilitacionBancariaServiceImpl implements IHabilitacionBancariaService {

	@Autowired
	private IHabilitacionBancariaRepository habilitacionBancariaRepository;

	public HabilitacionBancariaServiceImpl(IHabilitacionBancariaRepository habilitacionBancariaRepository) {
		this.habilitacionBancariaRepository = Objects.requireNonNull(habilitacionBancariaRepository);
	}

	@Override
	public HabilitacionBancaria insertarHabilitacion(HabilitacionBancaria habilitacion) {

		// Antes de guardar actualizamos los valores de los campos repetidos de los combos

		habilitacion.setCdbanco(habilitacion.getBanco().getCdbanco());
		habilitacion.setCdsucur(habilitacion.getSucurba().getCdsucur());

		HabilitacionBancaria habilitacionInsertado = habilitacionBancariaRepository.save(habilitacion);
		return habilitacionInsertado;
	}

	public int editarHabilitacion(HabilitacionBancaria habilitacion) {

		Integer idbanco = null;
		Integer idsucurba = null;
		Integer cddelhac = null;
		
		// Compruebo los check box de Bancaria
		if (!Objects.equals(null, habilitacion.getOtchetra()) && (Objects.equals("1", habilitacion.getOtchetra()) || Objects.equals("S", habilitacion.getOtchetra()))) {
			habilitacion.setOtchetra("1");  
		} else {
			habilitacion.setOtchetra("0");  				
		} 
	
		if (!Objects.equals(null, habilitacion.getOtidentinst()) &&  (Objects.equals("1", habilitacion.getOtidentinst()) || Objects.equals("S", habilitacion.getOtidentinst()))) {
			habilitacion.setOtidentinst("1");  
		} else {
			habilitacion.setOtidentinst("0");  				
		}
	
		if (!Objects.equals(null, habilitacion.getOtfictesoro()) &&  (Objects.equals("1", habilitacion.getOtfictesoro()) || Objects.equals("S", habilitacion.getOtfictesoro()))) {
			habilitacion.setOtfictesoro("1");  
		} else {
			habilitacion.setOtfictesoro("0");  				
		}
	
		// Y ahora los combos
		if (Objects.equals(null, habilitacion.getSucurba())) {
			idsucurba = null;
		} else {
			if (Objects.equals(null, habilitacion.getSucurba().getIdsucurba())) {
				idsucurba = null;
			} else {
				idsucurba = habilitacion.getSucurba().getIdsucurba();
			}
		}
		if (Objects.equals(null, habilitacion.getBanco())) {
			idbanco = null;
		} else {
			if (Objects.equals(null, habilitacion.getBanco().getIdbanco())) {
				idbanco = null;
			} else {
				idbanco = habilitacion.getBanco().getIdbanco();
			}
		}
		if (Objects.equals(null, habilitacion.getDelhac())) {
			cddelhac = null;
		} else {
			if (Objects.equals(null, habilitacion.getDelhac().getCddelhac())) {
				cddelhac = null;
			} else {
				cddelhac = habilitacion.getDelhac().getCddelhac();
			}
		}
		return habilitacionBancariaRepository.actualizarHabilitacion(habilitacion.getIdHabilitacion(), habilitacion.getCdhabil(), habilitacion.getCdident(),
//				idbanco, idsucurba,
				habilitacion.getCdcuenta(), habilitacion.getCdcodee(), habilitacion.getCdbic(), habilitacion.getOtchetra(),
				habilitacion.getOtorden(), habilitacion.getCdgastos(), habilitacion.getSuford(), habilitacion.getOtidentinst(),
				habilitacion.getCdpropct(), habilitacion.getCdcargo(), habilitacion.getCdemisorbde(), habilitacion.getDsmsgidxml(),
				habilitacion.getCdinstrprty(), habilitacion.getCddlvrymtd(), habilitacion.getCdcruzado(), habilitacion.getCdemicarta(),
				habilitacion.getCdhacien(), cddelhac, habilitacion.getCdadmon(), habilitacion.getNmtelef(),
				habilitacion.getDsmunic(), habilitacion.getNmlicen(), habilitacion.getCdemailhab(), habilitacion.getCengest(),
				habilitacion.getCendir(), habilitacion.getCengestesoro(), habilitacion.getOtfictesoro(), habilitacion.getCdipfunciona(),
				habilitacion.getCdusufunciona(), habilitacion.getCdpasswdfunciona(), 
				habilitacion.getCddirdesfunciona());
	}

	public HabilitacionBancaria buscarHabilitacionPorId(Integer id) {
		Optional<HabilitacionBancaria> h = habilitacionBancariaRepository.findById(id);
		HabilitacionBancaria habilitacion = null;
		if (h.isPresent()) {
			habilitacion = h.get(); // se coge el objeto Habilitacion
		}
		return habilitacion;
	}

	public Integer existeHabilitacion(HabilitacionBancaria habilitacion) {

		HabilitacionBancaria h = habilitacionBancariaRepository.existeHabilitacion(habilitacion.getCdhabil());
		if (Objects.equals(null, h)) {
			return 0;
		} else {
			return h.getIdHabilitacion();
		}

	}	
}
