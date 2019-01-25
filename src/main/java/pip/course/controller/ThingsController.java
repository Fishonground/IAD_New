package pip.course.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pip.course.entities.ThingsEntity;
import pip.course.serviseImpl.Things;

@RestController
@RequestMapping(value = "/api")
public class ThingsController {

    @Autowired
    public Things things;


    //Это любой юзер
    @Secured({ "ROLE_USER","ROLE_GUEST", "ROLE_ADMIN" ,"ROLE_TRAINER"})
    @RequestMapping(value = "/things", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewThings(
            @RequestBody ThingsEntity thingsEntity
            ){
        ThingsEntity thingsEntity1 = things.CreateNewThing(thingsEntity.getName(),thingsEntity.getDescription(),thingsEntity.getPrice(),thingsEntity.getPrisonerByOwner());
        return ResponseEntity.ok(thingsEntity1);
    }

    @Secured({ "ROLE_GUEST", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/things/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getThings(
            @PathVariable String name
    ){
        ThingsEntity thingsEntity = things.getThingByName(name);
        return ResponseEntity.ok(thingsEntity);
    }
    @Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/things/del/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delThings(
            @PathVariable String id
    ){
        Integer i = things.delThingsById(id);
        return ResponseEntity.ok(i);
    }

}