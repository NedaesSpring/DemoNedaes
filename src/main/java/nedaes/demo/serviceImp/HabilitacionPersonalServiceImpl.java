package nedaes.demo.serviceImp;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nedaes.demo.model.HabilitacionPersonal;
import nedaes.demo.repository.IHabilitacionPersonalRepository;
import nedaes.demo.service.IHabilitacionPersonalService;

@Service
public class HabilitacionPersonalServiceImpl implements IHabilitacionPersonalService {

	@Autowired
	private IHabilitacionPersonalRepository habilitacionPersonalRepository;

	public HabilitacionPersonalServiceImpl(IHabilitacionPersonalRepository habilitacionPersonalRepository) {
		this.habilitacionPersonalRepository = Objects.requireNonNull(habilitacionPersonalRepository);
	}

	@Override
	public HabilitacionPersonal insertarHabilitacion(HabilitacionPersonal habilitacion) {

		// Antes de guardar actualizamos los valores de los campos repetidos de los
		// combos

		habilitacion.setCdbanco(habilitacion.getBanco().getCdbanco());
		habilitacion.setCdsiglas(habilitacion.getSigdom().getCdsiglas());
		habilitacion.setCdsucur(habilitacion.getSucurba().getCdsucur());
		habilitacion.setCdloc(habilitacion.getLocalid().getCdloc());

		HabilitacionPersonal habilitacionInsertado = habilitacionPersonalRepository.save(habilitacion);
		return habilitacionInsertado;
	}



	public int editarHabilitacionPersonal(HabilitacionPersonal habilitacion) {

		Integer cdprov = null;
		Integer idbanco = null;
		Integer cddelhac = null;
		Integer idlocalid = null;
		Integer idsigdom = null;
		Integer idsucurba = null;
		
		// chequeo los rCheckBox de Personal
		if (!Objects.equals(null, habilitacion.getOtcon10()) && (Objects.equals("1", habilitacion.getOtcon10()) || Objects.equals("S", habilitacion.getOtcon10()))) {
			habilitacion.setOtcon10("1");  
		} else {
			habilitacion.setOtcon10("0");  				
		} 
		
		if (!Objects.equals(null, habilitacion.getOtc10_rdl202012()) && (Objects.equals("1", habilitacion.getOtc10_rdl202012()) || Objects.equals("S", habilitacion.getOtc10_rdl202012()))) {
			habilitacion.setOtc10_rdl202012("1");  
		} else {
			habilitacion.setOtc10_rdl202012("0");  				
		} 
		
		if (!Objects.equals(null, habilitacion.getOtpacepro()) && (Objects.equals("1", habilitacion.getOtpacepro()) || Objects.equals("S", habilitacion.getOtpacepro()))) {
			habilitacion.setOtpacepro("1");  
		} else {
			habilitacion.setOtpacepro("0");  				
		} 
		if (!Objects.equals(null, habilitacion.getCdraapp()) && (Objects.equals("1", habilitacion.getCdraapp()) || Objects.equals("S", habilitacion.getCdraapp()))) {
			habilitacion.setCdraapp("1");  
		} else {
			habilitacion.setCdraapp("0");  				
		} 
		if (!Objects.equals(null, habilitacion.getCdssperso()) && (Objects.equals("1", habilitacion.getCdssperso()) || Objects.equals("S", habilitacion.getCdssperso()))) {
			habilitacion.setCdssperso("1");  
		} else {
			habilitacion.setCdssperso("0");  				
		} 
		if (!Objects.equals(null, habilitacion.getOttelcon1()) && (Objects.equals("1", habilitacion.getOttelcon1()) || Objects.equals("S", habilitacion.getOttelcon1()))) {
			habilitacion.setOttelcon1("1");  
		} else {
			habilitacion.setOttelcon1("0");  				
		} 
		
		if (!Objects.equals(null, habilitacion.getOtrecibi()) && (Objects.equals("1", habilitacion.getOtrecibi()) || Objects.equals("S", habilitacion.getOtrecibi()))) {
			habilitacion.setOtrecibi("1");  
		} else {
			habilitacion.setOtrecibi("0");  				
		} 																								

		// Ahora los combos

		if (Objects.equals(null, habilitacion.getProvinc())) {
			cdprov = null;
		} else {
			if (Objects.equals(null, habilitacion.getProvinc().getCdprov())) {
				cdprov = null;
			} else {
				cdprov = habilitacion.getProvinc().getCdprov();
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
		if (Objects.equals(null, habilitacion.getSigdom())) {
			idsigdom = null;
		} else {
			if (Objects.equals(null, habilitacion.getSigdom().getIdsigdom())) {
				idsigdom = null;
			} else {
				idsigdom = habilitacion.getSigdom().getIdsigdom();
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

		if (Objects.equals(null, habilitacion.getSucurba())) {
			idsucurba = null;
		} else {
			if (Objects.equals(null, habilitacion.getSucurba().getIdsucurba())) {
				idsucurba = null;
			} else {
				idsucurba = habilitacion.getSucurba().getIdsucurba();
			}
		}

		if (Objects.equals(null, habilitacion.getLocalid())) {
			idlocalid = null;
		} else {
			if (Objects.equals(null, habilitacion.getLocalid().getIdlocalid())) {
				idlocalid = null;
			} else {
				idlocalid = habilitacion.getLocalid().getIdlocalid();
			}
		}

		habilitacion.setCdbanco(habilitacion.getBanco().getCdbanco());
		habilitacion.setCdsiglas(habilitacion.getSigdom().getCdsiglas());
		habilitacion.setCdsucur(habilitacion.getSucurba().getCdsucur());
		habilitacion.setCdloc(habilitacion.getLocalid().getCdloc());

		return habilitacionPersonalRepository.actualizarHabilitacionPersonal(habilitacion.getIdHabilitacion(), habilitacion.getCdhabil(),
				habilitacion.getDsorg(), habilitacion.getDsorgext(), habilitacion.getDscentro(), 
//				cddelhac, cdprov, idsigdom, idbanco, idlocalid, idsucurba, 
				habilitacion.getCdsiglas(), habilitacion.getCdsucur(), habilitacion.getCdloc(),
				habilitacion.getCdbanco(), habilitacion.getDscalle(), habilitacion.getDsnumero(), habilitacion.getCdpostal(),
				habilitacion.getDshabil(), habilitacion.getDssuplen(),
				habilitacion.getNombre() + ' ' + habilitacion.getApellido1() + ' ' + habilitacion.getApellido2(), habilitacion.getNombre(),
				habilitacion.getApellido1(), habilitacion.getApellido2(), habilitacion.getCarcert(), habilitacion.getNmtelefcert(),
				habilitacion.getNmfaxcert(), habilitacion.getCddnom(), habilitacion.getCddvar(), habilitacion.getCddrec(),
				habilitacion.getOtcon10(), habilitacion.getOtc10_rdl202012(), habilitacion.getOtpacepro(), habilitacion.getCdraapp(),
				habilitacion.getCdssperso(), habilitacion.getNmmaxanxaapp(), habilitacion.getNmaappanx(), habilitacion.getNmmaxanxdes(),
//				habilitacion.getOttelcon1(), 
				habilitacion.getOtrecibi(), habilitacion.getCddnisigp(), habilitacion.getCdususigp());
	}

	
	public HabilitacionPersonal buscarHabilitacionPorId(Integer id) {
		Optional<HabilitacionPersonal> h = habilitacionPersonalRepository.findById(id);
		HabilitacionPersonal habilitacion = null;
		if (h.isPresent()) {
			habilitacion = h.get(); // se coge el objeto Habilitacion
		}
		return habilitacion;
	}

	public Integer existeHabilitacion(HabilitacionPersonal habilitacion) {

		HabilitacionPersonal h = habilitacionPersonalRepository.existeHabilitacion(habilitacion.getCdhabil());
		if (Objects.equals(null, h)) {
			return 0;
		} else {
			return h.getIdHabilitacion();
		}

	}
}
