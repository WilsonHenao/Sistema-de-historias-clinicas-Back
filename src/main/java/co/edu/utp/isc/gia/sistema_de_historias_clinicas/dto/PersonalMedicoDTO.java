package co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonalMedicoDTO implements Serializable {

    private Long id;
    private String nombre;
    private String apellido;
    private String especialidad;
    private Long idEntidadDeSalud;
}
