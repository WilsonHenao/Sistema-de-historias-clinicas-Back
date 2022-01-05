package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Controller;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.HospitalizacionService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.HistoriaClinicaDTO;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.HospitalizacionDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hospitalizacion")
@AllArgsConstructor
@NoArgsConstructor
public class HospitalizacionController {

    @Autowired
    private HospitalizacionService hospitalizacionService;

    @PostMapping()
    public HospitalizacionDTO guardarHospitalizacion(@RequestBody HospitalizacionDTO hospitalizacionDTO){
        return hospitalizacionService.guardarHospitalizacion(hospitalizacionDTO);
    }

    @PutMapping()
    public boolean actualizarHospitalizacion(@RequestBody HospitalizacionDTO hospitalizacionDTO){
        return hospitalizacionService.actualizarHospitalizacion(hospitalizacionDTO);
    }

    @DeleteMapping()
    public boolean eliminarHospitalizacion(@RequestParam("id") Long id){
        return hospitalizacionService.eliminarHospitalizacion(id);
    }

    @GetMapping()
    public List<HospitalizacionDTO> listarHospitalizacion(){
        return hospitalizacionService.listarHospitalizacion();
    }
}
