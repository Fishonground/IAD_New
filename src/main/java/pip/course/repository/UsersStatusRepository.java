package pip.course.repository;

import org.springframework.data.repository.CrudRepository;
import pip.course.entities.UsersStatusEntity;

public interface UsersStatusRepository extends CrudRepository<UsersStatusEntity, Integer> {
    UsersStatusEntity findUsersStatusEntityById(Integer id);
}
