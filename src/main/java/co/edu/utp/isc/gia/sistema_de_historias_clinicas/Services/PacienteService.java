package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.PacienteDTO;

public interface PacienteService {
    PacienteDTO guardarPaciente(PacienteDTO pacienteDTO);

    boolean actualizarPaciente(PacienteDTO pacienteDTO);

    boolean eliminarPaciente(Long id);
}
