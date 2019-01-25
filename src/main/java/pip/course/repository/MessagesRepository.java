package pip.course.repository;

import org.springframework.data.repository.CrudRepository;
import pip.course.entities.MessagesEntity;
import pip.course.entities.PrisonerEntity;
import pip.course.entities.UsersEntity;

import java.util.List;

public interface MessagesRepository extends CrudRepository<MessagesEntity, Integer > {
    List<MessagesEntity> findAllByUsersByUser(UsersEntity usersEntity);
    List<MessagesEntity> findAllByPrisonerByPrisoner(PrisonerEntity prisonerEntity);
}
