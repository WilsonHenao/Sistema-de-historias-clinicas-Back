package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.PersonalMedicoDTO;

public interface PersonalMedicoService {
    PersonalMedicoDTO guardarPersonalMedico(PersonalMedicoDTO personalMedicoDTO);

    boolean actualizarPersonalMedico(PersonalMedicoDTO personalMedicoDTO);

    boolean eliminarPersonalMedico(Long id);
}
