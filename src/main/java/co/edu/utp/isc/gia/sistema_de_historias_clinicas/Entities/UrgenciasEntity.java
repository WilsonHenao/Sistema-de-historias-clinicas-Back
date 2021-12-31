package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "urgencias")
public class UrgenciasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaDeIngreso;
    private Date horaDeIngreso;
    private Date fechaDeSalida;
    private Date horaDeSalida;
    private String causaExterna;
    private String conducta;
    private int horasDeObservacion;
    private String tipoDeHistoriaClinica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pciId0", foreignKey = @ForeignKey(name = "pciId"))
    private PacienteEntity paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pMediId0", foreignKey = @ForeignKey(name = "pMediId"))
    private PersonalMedicoEntity personalMedico;
}
