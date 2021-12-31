package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.HistoriaClinicaDTO;

public interface HistoriaClinicaService {
    HistoriaClinicaDTO guardarHistoriaClinica(HistoriaClinicaDTO historiaClinicaDTO);

    boolean actualizarHistoriaClinica(HistoriaClinicaDTO historiaClinicaDTO);

    boolean eliminarHistoriaClinica(Long id);
}
