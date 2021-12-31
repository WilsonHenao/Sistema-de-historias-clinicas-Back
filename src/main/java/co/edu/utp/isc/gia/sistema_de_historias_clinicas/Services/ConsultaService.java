package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.ConsultaDTO;

public interface ConsultaService {
    ConsultaDTO guardarConsulta(ConsultaDTO consultaDTO);

    boolean actualizarConsulta(ConsultaDTO consultaDTO);

    boolean eliminarConsulta(Long id);
}
