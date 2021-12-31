package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.implementation;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.HospitalizacionEntity;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Repository.HospitalizacionRepository;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.HospitalizacionService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.HospitalizacionDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalizacionImpl implements HospitalizacionService {

    @Autowired
    private HospitalizacionRepository hospitalizacionRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public HospitalizacionImpl(){
    }

    public HospitalizacionImpl(HospitalizacionRepository hospitalizacionRepository,
                               ModelMapper modelMapper){
        this.hospitalizacionRepository = hospitalizacionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public HospitalizacionDTO guardarHospitalizacion(HospitalizacionDTO hospitalizacionDTO) {

        HospitalizacionEntity hospitalizacionEntity = hospitalizacionRepository.save(modelMapper.map(
                hospitalizacionDTO, HospitalizacionEntity.class));

        HospitalizacionDTO hospitalizacionDTO1 = modelMapper.map(hospitalizacionEntity,
                HospitalizacionDTO.class);

        return hospitalizacionDTO1;
    }

    @Override
    public boolean actualizarHospitalizacion(HospitalizacionDTO hospitalizacionDTO) {

        if (hospitalizacionRepository.existsById(hospitalizacionDTO.getId())){
            HospitalizacionEntity hospitalizacion = hospitalizacionRepository.save(modelMapper.map(
                    hospitalizacionDTO, HospitalizacionEntity.class));
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarHospitalizacion(Long id) {

        if (hospitalizacionRepository.existsById(id)){
            hospitalizacionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
