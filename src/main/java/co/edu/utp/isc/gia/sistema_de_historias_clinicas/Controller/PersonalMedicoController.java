package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Controller;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.PersonalMedicoService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.PersonalMedicoDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("personalMedico")
@NoArgsConstructor
@AllArgsConstructor
public class PersonalMedicoController {

    @Autowired
    private PersonalMedicoService personalMedicoService;

    @PostMapping()
    public PersonalMedicoDTO guardarPersonalMedico(@RequestBody PersonalMedicoDTO personalMedicoDTO){
        return personalMedicoService.guardarPersonalMedico(personalMedicoDTO);
    }

    @PutMapping()
    public boolean actualizarPersonalMedico(@RequestBody PersonalMedicoDTO personalMedicoDTO){
        return personalMedicoService.actualizarPersonalMedico(personalMedicoDTO);
    }

    @DeleteMapping()
    public boolean eliminarPersonalMedico(@RequestParam("id") Long id){
        return personalMedicoService.eliminarPersonalMedico(id);
    }
}
