package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.implementation;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.ConsultaEntity;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.HistoriaClinicaEntity;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Repository.ConsultaRepository;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.ConsultaService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.ConsultaDTO;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.HistoriaClinicaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaImpl implements ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public ConsultaImpl(){
    }

    public ConsultaImpl(ConsultaRepository consultaRepository, ModelMapper modelMapper){
        this.consultaRepository = consultaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ConsultaDTO guardarConsulta(ConsultaDTO consultaDTO) {

        ConsultaEntity consulta = consultaRepository.save(modelMapper.map(consultaDTO,
                ConsultaEntity.class));

        ConsultaDTO consultaDTO1 = modelMapper.map(consulta, ConsultaDTO.class);

        return consultaDTO1;
    }

    @Override
    public boolean actualizarConsulta(ConsultaDTO consultaDTO) {

        if (consultaRepository.existsById(consultaDTO.getId())){
            ConsultaEntity consulta = consultaRepository.save(modelMapper.map(consultaDTO,
                    ConsultaEntity.class));
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarConsulta(Long id) {

        if (consultaRepository.existsById(id)){
            consultaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<ConsultaDTO> listarConsulta() {
        Iterable<ConsultaEntity> consultaEntities = consultaRepository.findAll();
        List<ConsultaDTO> consultaDTOS = new ArrayList();
        for (ConsultaEntity consulta: consultaEntities){
            consultaDTOS.add(modelMapper.map(consulta, ConsultaDTO.class));
        }
        return consultaDTOS;
    }
}
