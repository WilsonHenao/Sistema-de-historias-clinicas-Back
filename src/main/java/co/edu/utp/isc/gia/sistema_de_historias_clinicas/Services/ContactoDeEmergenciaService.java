package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.ContactoDeEmergenciaDTO;

import java.util.List;

public interface ContactoDeEmergenciaService {
    ContactoDeEmergenciaDTO guardarContactoDeEmergencia(ContactoDeEmergenciaDTO contactoDeEmergenciaDTO);

    boolean actualizarContactoDeEmergencia(ContactoDeEmergenciaDTO contactoDeEmergenciaDTO);

    boolean eliminarContactoDeEmergencia(Long id);

    List<ContactoDeEmergenciaDTO> listarContacto();
}
