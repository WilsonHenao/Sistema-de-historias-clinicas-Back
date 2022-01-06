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
public class HospitalizacionDTO implements Serializable {

    private Long id;
    private Date fechaDeEgreso;
    private String horaDeEgreso;
    private int diasDeEstancia;
    private String estadoEgreso;
    private Long idViaDeIngreso;
}
