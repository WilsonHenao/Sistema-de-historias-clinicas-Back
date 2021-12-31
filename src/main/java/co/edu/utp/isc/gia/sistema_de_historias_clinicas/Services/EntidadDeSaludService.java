package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.EntidadDeSaludDTO;

public interface EntidadDeSaludService {

    EntidadDeSaludDTO guardarEntidadDeSalud(EntidadDeSaludDTO entidadDeSaludDTO);

    boolean actualizarEntidadDeSalud(EntidadDeSaludDTO entidadDeSaludDTO);

    boolean eliminarEntidadDeSalud(Long id);
}
