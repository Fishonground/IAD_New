package pip.course.serviseImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pip.course.entities.UsersStatusEntity;
import pip.course.repository.UsersStatusRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsersStatus {
    @Autowired
    UsersStatusRepository usersStatusRepository;

    @Transactional
    public UsersStatusEntity createNewUsersStatus(Integer id, String name) {
        UsersStatusEntity usersStatusEntity = new UsersStatusEntity();
        usersStatusEntity.setId(id);
        usersStatusEntity.setName(name);
        usersStatusRepository.save(usersStatusEntity);
        return usersStatusEntity;
    }
    @Transactional
    public UsersStatusEntity changeStatus(UsersStatusEntity usersStatusEntity, String status){
        usersStatusEntity.setName(status);
        usersStatusRepository.save(usersStatusEntity);
        return usersStatusEntity;
    }
    @Transactional
    public UsersStatusEntity searchById(Integer id) throws NoSuchElementException {
        Optional<UsersStatusEntity> usersStatusEntity = usersStatusRepository.findById(id);
        if (usersStatusEntity.isPresent()) return usersStatusEntity.get();
        else throw new NoSuchElementException("It doesn't exist!");
    }
    public Integer delUsersStatusById(Integer id){
        usersStatusRepository.deleteById(id);
        return 1;
    }

}
