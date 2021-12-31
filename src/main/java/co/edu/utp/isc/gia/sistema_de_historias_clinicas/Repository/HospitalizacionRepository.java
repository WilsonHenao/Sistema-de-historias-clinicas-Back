package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Repository;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.HospitalizacionEntity;
import org.springframework.data.repository.CrudRepository;

public interface HospitalizacionRepository extends CrudRepository<HospitalizacionEntity, Long> {
}
