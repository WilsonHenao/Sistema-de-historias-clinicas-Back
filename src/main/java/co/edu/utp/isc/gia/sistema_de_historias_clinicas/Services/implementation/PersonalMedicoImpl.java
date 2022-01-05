package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.implementation;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.EntidadDeSaludEntity;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.PersonalMedicoEntity;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Repository.PersonalMedicoRepository;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.PersonalMedicoService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.EntidadDeSaludService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.PersonalMedicoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalMedicoImpl implements PersonalMedicoService {

    @Autowired
    private PersonalMedicoRepository personalMedicoRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private EntidadDeSaludService entidadDeSaludService;

    public PersonalMedicoImpl(){
    }

    public PersonalMedicoImpl(PersonalMedicoRepository personalMedicoRepository,
                              ModelMapper modelMapper){
        this.personalMedicoRepository = personalMedicoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonalMedicoDTO guardarPersonalMedico(PersonalMedicoDTO personalMedicoDTO) {

        EntidadDeSaludEntity entidadDeSalud = entidadDeSaludService.obtenerEntidadDeSalud(
                personalMedicoDTO.getIdEntidadDeSalud());
        PersonalMedicoEntity personalMedico = modelMapper.map(personalMedicoDTO,
                PersonalMedicoEntity.class);
        personalMedico.setEntidadDeSalud(entidadDeSalud);
        PersonalMedicoDTO personalMedicoDTO1 = modelMapper.map(
                personalMedicoRepository.save(personalMedico), PersonalMedicoDTO.class);
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

    @Override
    public List<PersonalMedicoDTO> listarPersonalMedico() {

        Iterable<PersonalMedicoEntity> personalMedicoEntities = personalMedicoRepository.findAll();
        List<PersonalMedicoDTO> personalMedicoDTOS = new ArrayList<>();
        for (PersonalMedicoEntity personalMedico: personalMedicoEntities){
            personalMedicoDTOS.add(modelMapper.map(personalMedico, PersonalMedicoDTO.class));
        }
        return personalMedicoDTOS;
    }
}
