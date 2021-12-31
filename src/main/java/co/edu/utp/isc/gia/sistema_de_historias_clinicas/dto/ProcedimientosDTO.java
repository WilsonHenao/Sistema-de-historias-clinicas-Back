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
public class ProcedimientosDTO implements Serializable {

    private Long id;
    private Date fechaDeProcedimiento;
    private String claseDeProcedimiento;
    private String tipoDeProcedimiento;
    private String tipoDeHistoriaClinica;
    private Long idPaciente;
    private Long idPersonalMedico;
}
