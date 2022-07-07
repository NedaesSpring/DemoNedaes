package nedaes.demo.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import nedaes.demo.model.Habilitacion;
import nedaes.demo.repository.IHabilitacionRepository;
import nedaes.demo.service.IHabilitacionService;

@Service
public class HabilitacionServiceImpl implements IHabilitacionService {

	@Autowired
	private IHabilitacionRepository habilitacionRepository;

	public HabilitacionServiceImpl(IHabilitacionRepository habilitacionRepository) {
		this.habilitacionRepository = Objects.requireNonNull(habilitacionRepository);
	}

	@Override
	public Habilitacion insertarHabilitacion(Habilitacion habilitacion) {

		// Antes de guardar actualizamos los valores de los campos repetidos de los
		// combos

		habilitacion.setCdbanco(habilitacion.getBanco().getCdbanco());
		habilitacion.setCdsiglas(habilitacion.getSigdom().getCdsiglas());
		habilitacion.setCdsucur(habilitacion.getSucurba().getCdsucur());
		habilitacion.setCdloc(habilitacion.getLocalid().getCdloc());

		Habilitacion habilitacionInsertado = habilitacionRepository.save(habilitacion);
		return habilitacionInsertado;
	}

	@Override
	public List<Habilitacion> listarHabilitaciones() {
		List<Habilitacion> habilitaciones = new ArrayList<Habilitacion>();
		habilitaciones = habilitacionRepository.findAll(Sort.by(Sort.Direction.ASC, "cdhabil"));
		return habilitaciones;
	}

	public List<Habilitacion> buscarListado(Habilitacion habilitacion) {
		List<Habilitacion> listado = new ArrayList<Habilitacion>();

		Integer cdprov = null;
		Integer idbanco = null;
		Integer cddelhac = null;
		Integer idlocalid = null;
		Integer idsigdom = null;
		Integer idsucurba = null;

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
		if (Objects.equals(null, habilitacion.getLocalid())) {
			idlocalid = null;
		} else {
			if (Objects.equals(null, habilitacion.getLocalid().getIdlocalid())) {
				idlocalid = null;
			} else {
				idlocalid = habilitacion.getLocalid().getIdlocalid();
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

		listado = habilitacionRepository.buscarHabilitacionesPorFiltro(habilitacion.getCdhabil(), habilitacion.getDsorg(), habilitacion.getDscentro(), 
				 cdprov, cddelhac, idsigdom, idbanco, idlocalid, idsucurba);
		return listado;
	}

	public Page<Habilitacion> buscarListadoPageable(Habilitacion habilitacion, int pageNumber, int capacidad) {
		Page<Habilitacion> listado;

		Pageable pagina = PageRequest.of(pageNumber - 1, capacidad);

		Integer cdprov = null;
		Integer idbanco = null;
		Integer cddelhac = null;
		Integer idlocalid = null;
		Integer idsigdom = null;
		Integer idsucurba = null;

		if (Objects.equals(null, habilitacion.getLocalid())) {
			idlocalid = null;
		} else {
			if (Objects.equals(null, habilitacion.getLocalid().getIdlocalid())) {
				idlocalid = null;
			} else {
				idlocalid = habilitacion.getLocalid().getIdlocalid();
			}
		}
		if (Objects.equals(null, habilitacion.getDelhac())) {
			idsucurba = null;
		} else {
			if (Objects.equals(null, habilitacion.getSucurba().getIdsucurba())) {
				idsucurba = null;
			} else {
				idsucurba = habilitacion.getSucurba().getIdsucurba();
			}
		}
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
		listado = habilitacionRepository.buscarHabilitacionesPorFiltroPageable(habilitacion.getCdhabil(), habilitacion.getDsorg(), habilitacion.getDscentro(), 
				                 cdprov, cddelhac, idsigdom, idbanco, idlocalid, idsucurba, pagina);
		return listado;
	}

	public boolean borrarHabilitacion(Integer id) {
		boolean borrado = false;
		habilitacionRepository.deleteById(id);
		borrado = true;
		return borrado;
	}

	public int editarHabilitacion(Habilitacion habilitacion) {

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

		return habilitacionRepository.actualizarHabilitacion(habilitacion.getIdHabilitacion(), habilitacion.getCdhabil(),
				habilitacion.getDsorg(), habilitacion.getDsorgext(), habilitacion.getDscentro(), 
				cddelhac,cdprov, idsigdom, idbanco, idlocalid, idsucurba, 
				habilitacion.getCdsiglas(), habilitacion.getCdsucur(), habilitacion.getCdloc(),
				habilitacion.getCdbanco(), habilitacion.getDscalle(), habilitacion.getDsnumero(), habilitacion.getCdpostal(),
				habilitacion.getDshabil(), habilitacion.getDssuplen(),
				habilitacion.getNombre() + ' ' + habilitacion.getApellido1() + ' ' + habilitacion.getApellido2(), habilitacion.getNombre(),
				habilitacion.getApellido1(), habilitacion.getApellido2(), habilitacion.getCarcert(), habilitacion.getNmtelefcert(),
				habilitacion.getNmfaxcert(), habilitacion.getCddnom(), habilitacion.getCddvar(), habilitacion.getCddrec(),
				habilitacion.getOtcon10(), habilitacion.getOtc10_rdl202012(), habilitacion.getOtpacepro(), habilitacion.getCdraapp(),
				habilitacion.getCdssperso(), habilitacion.getNmmaxanxaapp(), habilitacion.getNmaappanx(), habilitacion.getNmmaxanxdes(),
				habilitacion.getOttelcon1(), habilitacion.getOtrecibi(), habilitacion.getCddnisigp(), habilitacion.getCdususigp(),

		habilitacion.getCdident(), 
		habilitacion.getCdcuenta(), habilitacion.getCdcodee(), habilitacion.getCdbic(), habilitacion.getOtchetra(),
		habilitacion.getOtorden(), habilitacion.getCdgastos(), habilitacion.getSuford(), habilitacion.getOtidentinst(),
		habilitacion.getCdpropct(), habilitacion.getCdcargo(), habilitacion.getCdemisorbde(), habilitacion.getDsmsgidxml(),
		habilitacion.getCdinstrprty(), habilitacion.getCddlvrymtd(), habilitacion.getCdcruzado(), habilitacion.getCdemicarta(),
		habilitacion.getCdhacien(), habilitacion.getCdadmon(), habilitacion.getNmtelef(),
		habilitacion.getDsmunic(), habilitacion.getNmlicen(), habilitacion.getCdemailhab(), habilitacion.getCengest(),
		habilitacion.getCendir(), habilitacion.getCengestesoro(), habilitacion.getOtfictesoro(), habilitacion.getCdipfunciona(),
		habilitacion.getCdusufunciona(), habilitacion.getCdpasswdfunciona(), 
		habilitacion.getCddirdesfunciona(),
		
		
		habilitacion.getCdidmuf(), habilitacion.getCdorgmuf(), habilitacion.getCdordmuf(), habilitacion.getCdistipadm(), habilitacion.getDsisretap1(),  
		habilitacion.getDsisretap2(), habilitacion.getDsisretnom(), habilitacion.getDsisordap1(), habilitacion.getDsisordap2(),  
		habilitacion.getDsisordnom(), habilitacion.getCdmujorg(), habilitacion.getDsmujorg(), habilitacion.getCdmujger(),  
		habilitacion.getDsmujger(), habilitacion.getCdautoriz(), habilitacion.getFeautoriz(), habilitacion.getDsautoriz(), habilitacion.getTxtc11(),  
		habilitacion.getTxtc12(), habilitacion.getTxtc13(), habilitacion.getTxtc14()			

		
		);

	}

	public int editarHabilitacionMutua(Habilitacion habilit) {

		// return HabilitRepository.actualizarHabilitPersonal(habilit.getIdHabilit(),
		// habilit.getCdhabil(), habilit.getDsorg(), habilit.getDscentro(), cddelhac,
		// cdprov, idsigdom, idbanco);
		return 1;

	}

	public Habilitacion buscarHabilitacionPorId(Integer id) {
		Optional<Habilitacion> h = habilitacionRepository.findById(id);
		Habilitacion habilitacion = null;
		if (h.isPresent()) {
			habilitacion = h.get(); // se coge el objeto Habilit
		}
		return habilitacion;
	}

	@Override
	public Page<Habilitacion> paginacion(int pageNumber, int capacidad) {
		Pageable pageable = PageRequest.of(pageNumber - 1, capacidad);
		return habilitacionRepository.BuscarTodasPageable(pageable);
	}

	public Integer existeHabilitacion(Habilitacion habilitacion) {

		if (habilitacion.getDsorg().equals("")) {
			habilitacion.setDsorg(null);
		}
		Habilitacion h = habilitacionRepository.existeHabilitacion(habilitacion.getCdhabil());
		if (Objects.equals(null, h)) {
			return 0;
		} else {
			return h.getIdHabilitacion();
		}

	}

	@Override
	public Habilitacion findByNombre(String cdhabil, String dsorg) {
		return habilitacionRepository.findByNombre(cdhabil, dsorg);
	}

	@Override
	public List<Habilitacion> listarHabilitacionesPorOrden() {
		return habilitacionRepository.findAll(Sort.by(Sort.Direction.ASC, "cdhabil"));
	}
}
