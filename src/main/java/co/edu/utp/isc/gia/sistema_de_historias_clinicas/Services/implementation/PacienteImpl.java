package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.implementation;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.PacienteEntity;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Repository.PacienteRepository;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.PacienteService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.PacienteDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public PacienteImpl(){
    }

    public PacienteImpl(PacienteRepository pacienteRepository, ModelMapper modelMapper){
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PacienteDTO guardarPaciente(PacienteDTO pacienteDTO) {

        PacienteEntity paciente = pacienteRepository.save(modelMapper.map(pacienteDTO,
                PacienteEntity.class));

        PacienteDTO pacienteDTO1 = modelMapper.map(paciente, PacienteDTO.class);

        return pacienteDTO1;
    }

    @Override
    public boolean actualizarPaciente(PacienteDTO pacienteDTO) {

        if (pacienteRepository.existsById(pacienteDTO.getId())){
            PacienteEntity paciente = pacienteRepository.save(modelMapper.map(pacienteDTO,
                    PacienteEntity.class));
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarPaciente(Long id) {

        if (pacienteRepository.existsById(id)){
            pacienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
