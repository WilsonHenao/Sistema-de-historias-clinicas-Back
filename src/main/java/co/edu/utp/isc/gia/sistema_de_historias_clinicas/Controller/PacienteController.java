package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Controller;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Repository.PacienteRepository;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.PacienteService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.HospitalizacionDTO;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.PacienteDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paciente")
@NoArgsConstructor
@AllArgsConstructor
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping()
    public PacienteDTO guardarPaciente(@RequestBody PacienteDTO pacienteDTO){
        return pacienteService.guardarPaciente(pacienteDTO);
    }

    @PutMapping()
    public boolean actualizarPaciente(@RequestBody PacienteDTO pacienteDTO){
        return pacienteService.actualizarPaciente(pacienteDTO);
    }

    @DeleteMapping()
    public boolean eliminarPaciente(@RequestParam("id") Long id){

        return pacienteService.eliminarPaciente(id);
    }

    @GetMapping()
    public List<PacienteDTO> listarPaciente(){
        return pacienteService.listarPaciente();
    }
}
