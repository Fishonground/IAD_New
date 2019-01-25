package pip.course.repository;

import org.springframework.data.repository.CrudRepository;
import pip.course.entities.PeopleEntity;

import java.sql.Date;
import java.util.List;

public interface PeopleRepository extends CrudRepository<PeopleEntity, Integer> {
    List<PeopleEntity> findPeopleEntitiesByDateOfBirth(Date date);
    List<PeopleEntity> findPeopleEntitiesByGenderEquals(String gender);
}
