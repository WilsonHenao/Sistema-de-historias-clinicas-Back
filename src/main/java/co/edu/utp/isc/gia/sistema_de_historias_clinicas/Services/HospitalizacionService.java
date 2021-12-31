package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.HospitalizacionDTO;

public interface HospitalizacionService {
    HospitalizacionDTO guardarHospitalizacion(HospitalizacionDTO hospitalizacionDTO);

    boolean actualizarHospitalizacion(HospitalizacionDTO hospitalizacionDTO);

    boolean eliminarHospitalizacion(Long id);
}
