package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Repository;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.HistoriaClinicaEntity;
import org.springframework.data.repository.CrudRepository;

public interface HistoriaClinicaRepository extends CrudRepository<HistoriaClinicaEntity, Long> {
}
