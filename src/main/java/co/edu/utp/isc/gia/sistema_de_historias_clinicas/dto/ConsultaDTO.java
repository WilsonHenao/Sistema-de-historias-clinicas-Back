package co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsultaDTO implements Serializable {

    private Long id;
    private Date fechaDeConsulta;
    private Date horaDeConsulta;
    private String tipoDeConsulta;
    private String causaExterna;
    private String conducta;
    private String tipoDeHistoriaClinica;
    private Long idPaciente;
    private Long idPersonalMedico;
}
