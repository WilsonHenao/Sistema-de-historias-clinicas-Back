package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.implementation;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.HistoriaClinicaEntity;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.HospitalizacionEntity;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Repository.HistoriaClinicaRepository;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.HistoriaClinicaService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.HistoriaClinicaDTO;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.HospitalizacionDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoriaClinicaImpl implements HistoriaClinicaService {

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public HistoriaClinicaImpl(){
    }

    public HistoriaClinicaImpl(HistoriaClinicaRepository historiaClinicaRepository,
                               ModelMapper modelMapper){
        this.historiaClinicaRepository = historiaClinicaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public HistoriaClinicaDTO guardarHistoriaClinica(HistoriaClinicaDTO historiaClinicaDTO) {

        HistoriaClinicaEntity historiaClinicaEntity = historiaClinicaRepository.save(modelMapper.map(
                historiaClinicaDTO, HistoriaClinicaEntity.class));

        HistoriaClinicaDTO historiaClinicaDTO1 = modelMapper.map(historiaClinicaEntity,
                HistoriaClinicaDTO.class);

        return historiaClinicaDTO1;
    }

    @Override
    public boolean actualizarHistoriaClinica(HistoriaClinicaDTO historiaClinicaDTO) {

        if (historiaClinicaRepository.existsById(historiaClinicaDTO.getId())){
            HistoriaClinicaEntity historiaClinica = historiaClinicaRepository.save(modelMapper.map(
                    historiaClinicaDTO, HistoriaClinicaEntity.class));
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarHistoriaClinica(Long id) {

        if (historiaClinicaRepository.existsById(id)){
            historiaClinicaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<HistoriaClinicaDTO> listarHistoriaClinica() {
        Iterable<HistoriaClinicaEntity> historiaClinicaEntities = historiaClinicaRepository.findAll();
        List<HistoriaClinicaDTO> historiaClinicaDTOS = new ArrayList();
        for (HistoriaClinicaEntity historiaClinica: historiaClinicaEntities){
            historiaClinicaDTOS.add(modelMapper.map(historiaClinica, HistoriaClinicaDTO.class));
        }
        return historiaClinicaDTOS;
    }
}
