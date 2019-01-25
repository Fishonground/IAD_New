package pip.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pip.course.entities.PeopleEntity;
import pip.course.serviseImpl.People;

@RestController
@RequestMapping(value = "/api")
public class PeopleController {

    @Autowired
    public People people;


    //Это любой юзер
    @Secured({ "ROLE_USER","ROLE_GUEST", "ROLE_ADMIN" ,"ROLE_TRAINER"})
    @RequestMapping(value = "/people", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewPeople(
            @RequestBody PeopleEntity peopleEntity
    ){
        PeopleEntity peopleEntity1 = people.createNewPeople(peopleEntity.getId(),peopleEntity.getGender(),peopleEntity.getName()
        , peopleEntity.getSurname(), peopleEntity.getSecondName(), peopleEntity.getPhoto());
        return ResponseEntity.ok(peopleEntity1);
    }

    @Secured({ "ROLE_GUEST", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPeople(
            @PathVariable Integer id
    ){
        PeopleEntity peopleEntity = people.searchbyId(id);
        return ResponseEntity.ok(peopleEntity);
    }
    @Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/people/del/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delPeople(
            @PathVariable Integer id
    ){
        Integer i = people.delPeopleById(id);
        return ResponseEntity.ok(i);
    }
}