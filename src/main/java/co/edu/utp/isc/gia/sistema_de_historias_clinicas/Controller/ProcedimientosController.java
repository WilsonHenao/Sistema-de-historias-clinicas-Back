package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Controller;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.ProcedimientosService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.ProcedimientosDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("procedimientos")
@NoArgsConstructor
@AllArgsConstructor
public class ProcedimientosController {

    @Autowired
    private ProcedimientosService procedimientosService;

    @PostMapping()
    public ProcedimientosDTO guardarProcedimientos(@RequestBody ProcedimientosDTO procedimientosDTO){
        return procedimientosService.guardarProcedimientos(procedimientosDTO);
    }

    @PutMapping()
    public boolean actualizarProcedimientos(@RequestBody ProcedimientosDTO procedimientosDTO){
        return procedimientosService.actualizarProcedimientos(procedimientosDTO);
    }

    @DeleteMapping()
    public boolean eliminarProcedimientos(@RequestParam("id") Long id){
        return procedimientosService.eliminarProcedimientos(id);
    }
}
