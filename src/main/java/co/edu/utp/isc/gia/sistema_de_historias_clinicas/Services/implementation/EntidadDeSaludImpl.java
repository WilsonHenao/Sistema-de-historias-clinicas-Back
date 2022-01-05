package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.implementation;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.EntidadDeSaludEntity;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Repository.EntidadDeSaludRepository;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.EntidadDeSaludService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.EntidadDeSaludDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntidadDeSaludImpl implements EntidadDeSaludService {

    @Autowired
    private EntidadDeSaludRepository entidadDeSaludRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public EntidadDeSaludImpl(){
    }

    public EntidadDeSaludImpl(EntidadDeSaludRepository entidadDeSaludRepository,
                              ModelMapper modelMapper){
        this.entidadDeSaludRepository = entidadDeSaludRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EntidadDeSaludDTO guardarEntidadDeSalud(EntidadDeSaludDTO entidadDeSaludDTO) {

        EntidadDeSaludEntity entidadDeSalud = entidadDeSaludRepository.save(modelMapper.map(
                entidadDeSaludDTO, EntidadDeSaludEntity.class));

        EntidadDeSaludDTO entidadDeSaludDTO1 = modelMapper.map(entidadDeSalud, EntidadDeSaludDTO.class);

        return entidadDeSaludDTO1;
    }

    @Override
    public boolean actualizarEntidadDeSalud(EntidadDeSaludDTO entidadDeSaludDTO) {

        if (entidadDeSaludRepository.existsById(entidadDeSaludDTO.getId())){
            EntidadDeSaludEntity entidadDeSalud =entidadDeSaludRepository.save(modelMapper.map(
                    entidadDeSaludDTO, EntidadDeSaludEntity.class));
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarEntidadDeSalud(Long id) {

        if (entidadDeSaludRepository.existsById(id)){
            entidadDeSaludRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<EntidadDeSaludDTO> listarEntidadDeSalud() {

        Iterable<EntidadDeSaludEntity> entidadDeSalud = entidadDeSaludRepository.findAll();
        List<EntidadDeSaludDTO> entidadDeSaludDTO = new ArrayList();
        for (EntidadDeSaludEntity entidadDeSaludEntity: entidadDeSalud){
            entidadDeSaludDTO.add(modelMapper.map(entidadDeSaludEntity, EntidadDeSaludDTO.class));
        }
        return entidadDeSaludDTO;
    }
}
