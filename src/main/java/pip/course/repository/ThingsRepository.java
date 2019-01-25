package pip.course.repository;
import org.springframework.data.repository.CrudRepository;
import pip.course.entities.ThingsEntity;

import java.util.List;

public interface ThingsRepository extends CrudRepository<ThingsEntity, String> {
 List<ThingsEntity> findThingsEntitiesByPrisonerByOwner(ThingsEntity thingsEntity);
 List<ThingsEntity>findAllByOrderByPrice();
 List<ThingsEntity>findThingsEntitiesByDescriptionEquals(String description);
}
