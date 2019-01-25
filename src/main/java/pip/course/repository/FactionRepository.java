package pip.course.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pip.course.entities.FactionEntity;
import pip.course.entities.PeopleEntity;
import pip.course.entities.PrisonerEntity;

import java.util.List;

public interface FactionRepository extends CrudRepository<FactionEntity, String> {
   List<FactionEntity> findFactionEntitiesByOrderByRating();
   FactionEntity findFactionEntityByPrisonerByMainPerson(PrisonerEntity prisonerEntity);
   @Query (value = "select prisoner from PrisonerEntity prisoner join FactionEntity faction on prisoner.personId=faction.prisonerByMainPerson.personId")
    List<PeopleEntity> getListOfFractionLeaders();
   FactionEntity findTop3ByOrderByRating();

}
