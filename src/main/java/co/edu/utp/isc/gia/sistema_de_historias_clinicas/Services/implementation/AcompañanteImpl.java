package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.implementation;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.AcompañanteEntity;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Repository.AcompañanteRepository;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.AcompañanteService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.AcompañanteDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcompañanteImpl implements AcompañanteService {

    @Autowired
    private AcompañanteRepository acompañanteRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public AcompañanteImpl(){
    }

    public AcompañanteImpl(AcompañanteRepository acompañanteRepository, ModelMapper modelMapper){
        this.acompañanteRepository = acompañanteRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AcompañanteDTO guardarAcompañante(AcompañanteDTO acompañanteDTO) {

        AcompañanteEntity acompañanteEntity = acompañanteRepository.save(modelMapper.map(acompañanteDTO,
                AcompañanteEntity.class));

        AcompañanteDTO acompañanteDTO1 = modelMapper.map(acompañanteEntity, AcompañanteDTO.class);

        return acompañanteDTO1;
    }

    @Override
    public boolean actualizarAcompañante(AcompañanteDTO acompañanteDTO) {

        if (acompañanteRepository.existsById(acompañanteDTO.getId())){
            AcompañanteEntity acompañanteEntity =acompañanteRepository.save(
                    modelMapper.map(acompañanteDTO, AcompañanteEntity.class));
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarAcompañante(Long id) {

        if (acompañanteRepository.existsById(id)){
            acompañanteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
