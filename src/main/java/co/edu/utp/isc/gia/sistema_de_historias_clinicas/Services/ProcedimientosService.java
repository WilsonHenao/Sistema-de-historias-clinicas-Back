package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.ProcedimientosDTO;

import java.util.List;

public interface ProcedimientosService {
    ProcedimientosDTO guardarProcedimientos(ProcedimientosDTO procedimientosDTO);

    boolean actualizarProcedimientos(ProcedimientosDTO procedimientosDTO);

    boolean eliminarProcedimientos(Long id);

    List<ProcedimientosDTO> listarProcedimientos();
}
