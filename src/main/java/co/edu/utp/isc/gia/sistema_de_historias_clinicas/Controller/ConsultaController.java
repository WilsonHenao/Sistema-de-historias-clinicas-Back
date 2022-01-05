package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Controller;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.ConsultaService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.ConsultaDTO;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.EntidadDeSaludDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consulta")
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping()
    public ConsultaDTO guardarConsulta(@RequestBody ConsultaDTO consultaDTO){
        return consultaService.guardarConsulta(consultaDTO);
    }

    @PutMapping()
    public boolean actualizarConsulta(@RequestBody ConsultaDTO consultaDTO){
        return consultaService.actualizarConsulta(consultaDTO);
    }

    @DeleteMapping()
    public boolean eliminarConsulta(@RequestParam("id") Long id){

        return consultaService.eliminarConsulta(id);
    }

    @GetMapping()
    public List<ConsultaDTO> listarConsulta(){
        return consultaService.listarConsulta();
    }
}
