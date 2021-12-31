package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Controller;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.UrgenciasService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.UrgenciasDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("urgencias")
@NoArgsConstructor
@AllArgsConstructor
public class UrgenciasController {

    @Autowired
    private UrgenciasService urgenciasService;

    @PostMapping()
    public UrgenciasDTO guardarUrgencias(@RequestBody UrgenciasDTO urgenciasDTO){
        return urgenciasService.guardarUrgencias(urgenciasDTO);
    }

    @PutMapping()
    public boolean actualizarUrgencias(@RequestBody UrgenciasDTO urgenciasDTO){
        return urgenciasService.actualizarUrgencias(urgenciasDTO);
    }

    @DeleteMapping()
    public boolean eliminarUrgencias(@RequestParam("id") Long id){
        return urgenciasService.eliminarUrgencias(id);
    }
}
