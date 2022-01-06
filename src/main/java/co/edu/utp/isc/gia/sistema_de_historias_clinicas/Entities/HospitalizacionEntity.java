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
@Table(name = "hospitalizacion")
public class HospitalizacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaDeEgreso;
    private String horaDeEgreso;
    private int diasDeEstancia;
    private String estadoEgreso;
    private Long idViaDeIngreso;
}
