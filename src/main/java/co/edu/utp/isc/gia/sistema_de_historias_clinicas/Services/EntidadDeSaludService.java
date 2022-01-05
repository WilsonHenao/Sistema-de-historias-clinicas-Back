package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.EntidadDeSaludEntity;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.EntidadDeSaludDTO;

import java.util.List;

public interface EntidadDeSaludService {

    EntidadDeSaludDTO guardarEntidadDeSalud(EntidadDeSaludDTO entidadDeSaludDTO);

    boolean actualizarEntidadDeSalud(EntidadDeSaludDTO entidadDeSaludDTO);

    boolean eliminarEntidadDeSalud(Long id);

    List<EntidadDeSaludDTO> listarEntidadDeSalud();

    EntidadDeSaludEntity obtenerEntidadDeSalud(Long id);

    EntidadDeSaludDTO buscarPorId(Long id);
}
