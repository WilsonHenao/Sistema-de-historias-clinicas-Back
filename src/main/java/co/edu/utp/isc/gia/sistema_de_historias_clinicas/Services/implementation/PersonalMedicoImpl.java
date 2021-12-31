package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.implementation;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.PersonalMedicoEntity;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Repository.PersonalMedicoRepository;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.PersonalMedicoService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.PersonalMedicoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalMedicoImpl implements PersonalMedicoService {

    @Autowired
    private PersonalMedicoRepository personalMedicoRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public PersonalMedicoImpl(){
    }

    public PersonalMedicoImpl(PersonalMedicoRepository personalMedicoRepository,
                              ModelMapper modelMapper){
        this.personalMedicoRepository = personalMedicoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonalMedicoDTO guardarPersonalMedico(PersonalMedicoDTO personalMedicoDTO) {

        PersonalMedicoEntity personalMedico = personalMedicoRepository.save(modelMapper.map(
                personalMedicoDTO, PersonalMedicoEntity.class));

        PersonalMedicoDTO personalMedicoDTO1 = modelMapper.map(personalMedico, PersonalMedicoDTO.class);
        return personalMedicoDTO1;
    }

    @Override
    public boolean actualizarPersonalMedico(PersonalMedicoDTO personalMedicoDTO) {

        if (personalMedicoRepository.existsById(personalMedicoDTO.getId())){
            PersonalMedicoEntity personalMedico = personalMedicoRepository.save(modelMapper.map(
                    personalMedicoDTO, PersonalMedicoEntity.class));
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarPersonalMedico(Long id) {

        if (personalMedicoRepository.existsById(id)){
            personalMedicoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
