package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.AcompañanteDTO;

public interface AcompañanteService {
    AcompañanteDTO guardarAcompañante(AcompañanteDTO acompañanteDTO);

    boolean actualizarAcompañante(AcompañanteDTO acompañanteDTO);

    boolean eliminarAcompañante(Long id);
}
