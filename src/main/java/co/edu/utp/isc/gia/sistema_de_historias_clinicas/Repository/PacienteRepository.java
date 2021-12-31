package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Repository;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.PacienteEntity;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepository extends CrudRepository<PacienteEntity, Long> {
}
