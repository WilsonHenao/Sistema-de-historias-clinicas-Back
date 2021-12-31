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
@Table(name = "consulta")
public class ConsultaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaDeConsulta;
    private Date horaDeConsulta;
    private String tipoDeConsulta;
    private String causaExterna;
    private String conducta;
    private String tipoDeHistoriaClinica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pacId0", foreignKey = @ForeignKey(name = "pacId"))
    private PacienteEntity paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pMedId0", foreignKey = @ForeignKey(name = "pMedId"))
    private PersonalMedicoEntity personalMedico;
}
