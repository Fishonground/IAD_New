package pip.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pip.course.entities.FactionEntity;
import pip.course.entities.PrisonerEntity;
import pip.course.serviseImpl.Prisoner;

@RestController
@RequestMapping(value = "/api")
public class PrisonerController {

    @Autowired
    public Prisoner prisoner;


    //Это любой юзер
    @Secured({ "ROLE_USER","ROLE_GUEST", "ROLE_ADMIN" ,"ROLE_TRAINER"})
    @RequestMapping(value = "/prisoner", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewPrisoner(
            @RequestBody PrisonerEntity prisonerEntity
    ){
        PrisonerEntity prisonerEntity1 = prisoner.CreateNewPrisoner(prisonerEntity.getPersonId(), prisonerEntity.getTerm(), prisonerEntity.getRoomsByRoom(),
                prisonerEntity.getUsersByOwner(), prisonerEntity.getRating(), prisonerEntity.getFactionByFaction());
        return ResponseEntity.ok(prisonerEntity1);
    }

    @Secured({ "ROLE_GUEST", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/prisoner/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPrisoner(
            @PathVariable Integer id
    ){
        PrisonerEntity prisonerEntity = prisoner.getPrisonerById(id);
        return ResponseEntity.ok(prisonerEntity);
    }
    @Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/prisoner/del/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delPrisoner(
            @PathVariable Integer id
    ){
        Integer i = prisoner.delPrisonersById(id);
        return ResponseEntity.ok(i);
    }

    @Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/prisoner/{id}/upd/faction", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updPrisoner(
            @PathVariable Integer id,
            @RequestBody FactionEntity factionEntity
    ){
        PrisonerEntity prisonerEntity1 = prisoner.getPrisonerById(id);
        prisonerEntity1 = prisoner.changeFaction(prisonerEntity1, factionEntity);
        return ResponseEntity.ok(prisonerEntity1);
    }
}