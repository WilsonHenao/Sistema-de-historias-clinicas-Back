package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "acompañante")
public class AcompañanteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String telefono;

    private String parentescoConPaciente;

    @JoinTable(
            name = "rel_acomp_paci",
            joinColumns = @JoinColumn(name = "Fk_acompañante", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "Fk_paciente", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<PacienteEntity> paciente;
}
