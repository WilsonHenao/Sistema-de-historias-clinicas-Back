package co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrgenciasDTO implements Serializable {

    private Long id;
    private Date fechaDeIngreso;
    private String horaDeIngreso;
    private Date fechaDeSalida;
    private String horaDeSalida;
    private String causaExterna;
    private String conducta;
    private int horasDeObservacion;
    private String tipoDeHistoriaClinica;
    private Long idPaciente;
    private Long idPersonalMedico;
}
