package pip.course.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pip.course.entities.UsersStatusEntity;
import pip.course.serviseImpl.UsersStatus;

@RestController
@RequestMapping(value = "/api")
public class UsersStatusController {

    @Autowired
    public UsersStatus usersStatus;


    //Это любой юзер
    @Secured({ "ROLE_USER","ROLE_GUEST", "ROLE_ADMIN" ,"ROLE_TRAINER"})
    @RequestMapping(value = "/usersstatus", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewUsersStatus(
            @RequestBody UsersStatusEntity usersStatusEntity
    ){
        UsersStatusEntity usersStatusEntity1 = usersStatus.createNewUsersStatus(usersStatusEntity.getId(),usersStatusEntity.getName());
        return ResponseEntity.ok(usersStatusEntity1);
    }

    @Secured({ "ROLE_GUEST", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/usersstatus/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUsersStatus(
            @PathVariable Integer id
    ){
        UsersStatusEntity usersStatusEntity = usersStatus.searchById(id);
        return ResponseEntity.ok(usersStatusEntity);
    }

    @Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/usersstatus/del/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delUsersStatus(
            @PathVariable Integer id
    ){
        Integer i = usersStatus.delUsersStatusById(id);
        return ResponseEntity.ok(i);
    }

}