package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.implementation;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.EntidadDeSaludEntity;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.UrgenciasEntity;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Repository.UrgenciasRepository;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.UrgenciasService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.EntidadDeSaludDTO;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.UrgenciasDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UrgenciasImpl implements UrgenciasService {

    @Autowired
    private UrgenciasRepository urgenciasRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public UrgenciasImpl(){
    }

    public UrgenciasImpl(UrgenciasRepository urgenciasRepository, ModelMapper modelMapper){
        this.urgenciasRepository = urgenciasRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UrgenciasDTO guardarUrgencias(UrgenciasDTO urgenciasDTO) {

        UrgenciasEntity urgencias = urgenciasRepository.save(modelMapper.map(urgenciasDTO,
                UrgenciasEntity.class));

        UrgenciasDTO urgenciasDTO1 = modelMapper.map(urgencias, UrgenciasDTO.class);

        return urgenciasDTO1;
    }

    @Override
    public boolean actualizarUrgencias(UrgenciasDTO urgenciasDTO) {

        if (urgenciasRepository.existsById(urgenciasDTO.getId())){
            UrgenciasEntity urgencias = urgenciasRepository.save(modelMapper.map(urgenciasDTO,
                    UrgenciasEntity.class));
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarUrgencias(Long id) {

        if (urgenciasRepository.existsById(id)){
            urgenciasRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<UrgenciasDTO> listarUrgencias() {
        Iterable<UrgenciasEntity> urgenciasEntities = urgenciasRepository.findAll();
        List<UrgenciasDTO> urgenciasDTOS = new ArrayList();
        for (UrgenciasEntity urgencias: urgenciasEntities){
            urgenciasDTOS.add(modelMapper.map(urgencias, UrgenciasDTO.class));
        }
        return urgenciasDTOS;
    }
}
