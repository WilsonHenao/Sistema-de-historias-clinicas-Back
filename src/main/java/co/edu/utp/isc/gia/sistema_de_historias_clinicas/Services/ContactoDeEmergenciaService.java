package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.ContactoDeEmergenciaDTO;

public interface ContactoDeEmergenciaService {
    ContactoDeEmergenciaDTO guardarContactoDeEmergencia(ContactoDeEmergenciaDTO contactoDeEmergenciaDTO);

    boolean actualizarContactoDeEmergencia(ContactoDeEmergenciaDTO contactoDeEmergenciaDTO);

    boolean eliminarContactoDeEmergencia(Long id);
}
