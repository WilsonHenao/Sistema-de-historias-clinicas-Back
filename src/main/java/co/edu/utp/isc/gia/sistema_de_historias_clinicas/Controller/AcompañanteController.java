package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Controller;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.AcompañanteService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.AcompañanteDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("acompañante")
@NoArgsConstructor
@AllArgsConstructor
public class AcompañanteController {

    @Autowired
    private AcompañanteService acompañanteService;

    @PostMapping()
    public AcompañanteDTO guardarAcompañante(@RequestBody AcompañanteDTO acompañanteDTO){
        return acompañanteService.guardarAcompañante(acompañanteDTO);
    }

    @PutMapping()
    public boolean actualizarAcompañante(@RequestBody AcompañanteDTO acompañanteDTO){
        return acompañanteService.actualizarAcompañante(acompañanteDTO);
    }

    @DeleteMapping()
    public boolean eliminarAcompañante(@RequestParam("id") Long id){
        return acompañanteService.eliminarAcompañante(id);
    }
}
