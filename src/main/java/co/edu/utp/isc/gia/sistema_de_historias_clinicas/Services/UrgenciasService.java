package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.UrgenciasDTO;

public interface UrgenciasService {
    UrgenciasDTO guardarUrgencias(UrgenciasDTO urgenciasDTO);

    boolean actualizarUrgencias(UrgenciasDTO urgenciasDTO);

    boolean eliminarUrgencias(Long id);
}
