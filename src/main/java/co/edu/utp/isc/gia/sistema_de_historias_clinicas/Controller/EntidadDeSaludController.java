package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Controller;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.EntidadDeSaludEntity;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.EntidadDeSaludService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.EntidadDeSaludDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("entidadDeSalud")
@NoArgsConstructor
@AllArgsConstructor
public class EntidadDeSaludController {

    @Autowired
    private EntidadDeSaludService entidadDeSaludService;

    @PostMapping()
    public EntidadDeSaludDTO guardarEntidadDeSalud(@RequestBody EntidadDeSaludDTO entidadDeSaludDTO){
        return entidadDeSaludService.guardarEntidadDeSalud(entidadDeSaludDTO);
    }

    @PutMapping()
    public boolean actualizarEntidadDeSalud(@RequestBody EntidadDeSaludDTO entidadDeSaludDTO){
        return entidadDeSaludService.actualizarEntidadDeSalud(entidadDeSaludDTO);
    }

    @DeleteMapping()
    public boolean eliminarEntidadDeSalud(@RequestParam("id") Long id){
        return entidadDeSaludService.eliminarEntidadDeSalud(id);
    }

    @GetMapping()
    public List<EntidadDeSaludDTO> listarEntidadDeSalud(){
        return entidadDeSaludService.listarEntidadDeSalud();
    }

    @GetMapping("/{id}")
    public EntidadDeSaludDTO buscarPorId(@PathVariable("id") Long id){
        return entidadDeSaludService.buscarPorId(id);
    }
}
