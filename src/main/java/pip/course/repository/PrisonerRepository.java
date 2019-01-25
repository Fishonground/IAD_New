package pip.course.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pip.course.entities.PrisonerEntity;
import pip.course.entities.UsersEntity;

import java.sql.Date;
import java.util.List;

public interface PrisonerRepository extends CrudRepository<PrisonerEntity, Integer> {

    //List<PrisonerEntity> findAllByFactionByFactionIsNotNullAndOrderByRating();
    @Query("FROM PrisonerEntity where factionByFaction<>'' ORDER BY rating")
    List<PrisonerEntity> find();
    List<PrisonerEntity> findAllByOrderByRating();
    List<PrisonerEntity> findAllByRatingIsGreaterThan(Integer rating);
    List<PrisonerEntity> findAllByOrderByFactionByFaction();
    List<PrisonerEntity> findPrisonerEntitiesByUsersByOwner(UsersEntity usersEntity);
    List<PrisonerEntity> findPrisonerEntitiesByTermIsLessThan(Date term);
    List<PrisonerEntity> findPrisonerEntitiesByTermIsGreaterThan(Date term);
    List<PrisonerEntity> findPrisonerEntitiesByFactionByFactionIsNull();
    //List<PrisonerEntity> findAllByPrisonerByMainPersonOrderByRating();
    //List<PrisonerEntity> findPrisonerEntitiesByFactionByFactionPrisonerByMainPersonOrderByRating();
}
