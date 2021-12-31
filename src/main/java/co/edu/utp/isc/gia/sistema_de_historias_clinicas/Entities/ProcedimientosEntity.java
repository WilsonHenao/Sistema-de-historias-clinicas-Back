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
@Table(name = "procedimientos")
public class ProcedimientosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaDeProcedimiento;
    private String claseDeProcedimiento;
    private String tipoDeProcedimiento;
    private String tipoDeHistoriaClinica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pcId0", foreignKey = @ForeignKey(name = "pcId"))
    private PacienteEntity paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perMedId0", foreignKey = @ForeignKey(name = "perMedId"))
    private PersonalMedicoEntity personalMedico;
}
