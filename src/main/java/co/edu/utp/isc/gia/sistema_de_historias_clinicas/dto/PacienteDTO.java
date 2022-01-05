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
public class PacienteDTO implements Serializable {

    private Long id;
    private String nombre;
    private String apellido;
    private String estadoCivil;
    private int documentoDeIdentidad;
    private Date fechaDeNacimiento;
    private int edad;
    private String sexo;
    private String ocupacion;
    private String direccion;
    private String telefonoDelDomicilio;
    private String lugarDeResidencia;
    private String estado;
    private Long idContactoDeEmergencia;
}
