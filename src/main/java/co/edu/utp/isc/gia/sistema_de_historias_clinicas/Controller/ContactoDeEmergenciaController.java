package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Controller;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.ContactoDeEmergenciaService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.ConsultaDTO;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.ContactoDeEmergenciaDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contacto")
@NoArgsConstructor
@AllArgsConstructor
public class ContactoDeEmergenciaController {

    @Autowired
    private ContactoDeEmergenciaService contactoDeEmergenciaService;

    @PostMapping()
    public ContactoDeEmergenciaDTO guardarContactoDeEmergencia(
            @RequestBody ContactoDeEmergenciaDTO  contactoDeEmergenciaDTO){
        return contactoDeEmergenciaService.guardarContactoDeEmergencia(contactoDeEmergenciaDTO);
    }

    @PutMapping()
    public boolean actualizarContactoDeEmergencia(
            @RequestBody ContactoDeEmergenciaDTO contactoDeEmergenciaDTO){
        return contactoDeEmergenciaService.actualizarContactoDeEmergencia(contactoDeEmergenciaDTO);
    }

    @DeleteMapping()
    public boolean eliminarContactoDeEmergencia(@RequestParam("id") Long id){
        return contactoDeEmergenciaService.eliminarContactoDeEmergencia(id);
    }

    @GetMapping()
    public List<ContactoDeEmergenciaDTO> listarContacto(){
        return contactoDeEmergenciaService.listarContacto();
    }
}
