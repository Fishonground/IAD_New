package pip.course.repository;

import org.springframework.data.repository.CrudRepository;
import pip.course.entities.RoomsEntity;

import java.util.List;

public interface RoomsRepository extends CrudRepository<RoomsEntity, Integer> {

    List<RoomsEntity> findRoomsEntitiesByNumberOfPrisonersLessThanOrderByNumberOfPrisoners(Integer number_of_prisoner);
    List<RoomsEntity> findRoomsEntitiesByNameEquals(String name);

}
