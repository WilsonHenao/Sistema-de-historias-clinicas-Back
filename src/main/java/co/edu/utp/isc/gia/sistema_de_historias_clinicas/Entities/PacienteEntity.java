package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paciente")
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String estadoCivil;
    private int documentoDeIdentidad;
    private Date fechaDeNacimiento;
    private int edad;
    private String sexo;
    private String Ocupacion;
    private String direccion;
    private String telefonoDelDomicilio;
    private String lugarDeResidencia;
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cId0", foreignKey = @ForeignKey(name = "cId"))
    private ContactoDeEmergenciaEntity contactoDeEmergencia;

}
