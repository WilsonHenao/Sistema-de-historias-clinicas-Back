package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Controller;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.HistoriaClinicaService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.HistoriaClinicaDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("historiaClinica")
@NoArgsConstructor
@AllArgsConstructor
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @PostMapping()
    public HistoriaClinicaDTO guardarHistoriaClinica(@RequestBody HistoriaClinicaDTO historiaClinicaDTO){
        return historiaClinicaService.guardarHistoriaClinica(historiaClinicaDTO);
    }

    @PutMapping()
    public boolean actualizarHistoriaClinica(@RequestBody HistoriaClinicaDTO historiaClinicaDTO){
        return historiaClinicaService.actualizarHistoriaClinica(historiaClinicaDTO);
    }

    @DeleteMapping()
    public boolean eliminarHistoriaClinica(@RequestParam("id") Long id){
        return historiaClinicaService.eliminarHistoriaClinica(id);
    }
}
