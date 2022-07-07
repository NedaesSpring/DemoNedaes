package nedaes.demo.serviceImp;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nedaes.demo.model.HabilitacionMutua;
import nedaes.demo.repository.IHabilitacionMutuaRepository;
import nedaes.demo.service.IHabilitacionMutuaService;

@Service
public class HabilitacionMutuaServiceImpl implements IHabilitacionMutuaService  {

	@Autowired
	private IHabilitacionMutuaRepository habilitacionMutuaRepository;

	public HabilitacionMutuaServiceImpl(IHabilitacionMutuaRepository habilitacionMutuaRepository) {
		this.habilitacionMutuaRepository = Objects.requireNonNull(habilitacionMutuaRepository);
	}

	@Override
	public HabilitacionMutua insertarHabilitacion(HabilitacionMutua habilitacion) {

		// Antes de guardar actualizamos los valores de los campos repetidos de los combos

		//habilitacion.setCdbanco(habilitacion.getBanco().getCdbanco());//
		//habilitacion.setCdsucur(habilitacion.getSucurba().getCdsucur());//

		HabilitacionMutua habilitacionInsertado = habilitacionMutuaRepository.save(habilitacion);
		return habilitacionInsertado;
	}

	public int editarHabilitacion(HabilitacionMutua habilitacion) {

		return habilitacionMutuaRepository.actualizarHabilitacion(habilitacion.getIdHabilitacion(),  
				habilitacion.getCdidmuf(), habilitacion.getCdorgmuf(), habilitacion.getCdordmuf(), habilitacion.getCdistipadm(), habilitacion.getDsisretap1(),  
				habilitacion.getDsisretap2(), habilitacion.getDsisretnom(), habilitacion.getDsisordap1(), habilitacion.getDsisordap2(),  
				habilitacion.getDsisordnom(), habilitacion.getCdmujorg(), habilitacion.getDsmujorg(), habilitacion.getCdmujger(),  
				habilitacion.getDsmujger(), habilitacion.getCdautoriz(), habilitacion.getFeautoriz(), habilitacion.getDsautoriz(), habilitacion.getTxtc11(),  
				habilitacion.getTxtc12(), habilitacion.getTxtc13(), habilitacion.getTxtc14()			
				);
	}

	public HabilitacionMutua buscarHabilitacionPorId(Integer id) {
		Optional<HabilitacionMutua> h = habilitacionMutuaRepository.findById(id);
		HabilitacionMutua habilitacion = null;
		if (h.isPresent()) {
			habilitacion = h.get(); // se coge el objeto Habilitacion
		}
		return habilitacion;
	}

	public Integer existeHabilitacion(HabilitacionMutua habilitacion) {

		HabilitacionMutua h = habilitacionMutuaRepository.existeHabilitacion(habilitacion.getCdhabil());
		if (Objects.equals(null, h)) {
			return 0;
		} else {
			return h.getIdHabilitacion();
		}

	}	
}
