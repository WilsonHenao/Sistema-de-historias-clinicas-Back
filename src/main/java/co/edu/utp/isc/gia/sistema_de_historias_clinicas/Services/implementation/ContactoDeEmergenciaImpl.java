package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.implementation;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.ConsultaEntity;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.ContactoDeEmergenciaEntity;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Repository.ContactoDeEmergenciaRepository;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.ContactoDeEmergenciaService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.ConsultaDTO;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.ContactoDeEmergenciaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactoDeEmergenciaImpl implements ContactoDeEmergenciaService {

    @Autowired
    private ContactoDeEmergenciaRepository contactoDeEmergenciaRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public ContactoDeEmergenciaImpl(){
    }

    public ContactoDeEmergenciaImpl(
            ContactoDeEmergenciaRepository contactoDeEmergenciaRepository, ModelMapper modelMapper){
        this.contactoDeEmergenciaRepository = contactoDeEmergenciaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ContactoDeEmergenciaDTO guardarContactoDeEmergencia(
            ContactoDeEmergenciaDTO contactoDeEmergenciaDTO) {

        ContactoDeEmergenciaEntity contactoDeEmergencia = contactoDeEmergenciaRepository.save(
                modelMapper.map(contactoDeEmergenciaDTO,
                ContactoDeEmergenciaEntity.class));

        ContactoDeEmergenciaDTO contactoDeEmergenciaDTO1 = modelMapper.map(
                contactoDeEmergencia, ContactoDeEmergenciaDTO.class);

        return contactoDeEmergenciaDTO1;
    }

    @Override
    public boolean actualizarContactoDeEmergencia(ContactoDeEmergenciaDTO contactoDeEmergenciaDTO) {

        if (contactoDeEmergenciaRepository.existsById(contactoDeEmergenciaDTO.getId())){
            ContactoDeEmergenciaEntity contactoDeEmergenciaEntity =contactoDeEmergenciaRepository.save(
                    modelMapper.map(contactoDeEmergenciaDTO, ContactoDeEmergenciaEntity.class));
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarContactoDeEmergencia(Long id) {

        if (contactoDeEmergenciaRepository.existsById(id)){
            contactoDeEmergenciaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<ContactoDeEmergenciaDTO> listarContacto() {
        Iterable<ContactoDeEmergenciaEntity> contactoDeEmergenciaEntities =
                contactoDeEmergenciaRepository.findAll();
        List<ContactoDeEmergenciaDTO> contactoDeEmergenciaDTOS = new ArrayList();
        for (ContactoDeEmergenciaEntity emergencia: contactoDeEmergenciaEntities){
            contactoDeEmergenciaDTOS.add(modelMapper.map(emergencia, ContactoDeEmergenciaDTO.class));
        }
        return contactoDeEmergenciaDTOS;
    }
}
