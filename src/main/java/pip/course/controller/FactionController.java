package pip.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pip.course.entities.FactionEntity;
import pip.course.serviseImpl.Faction;

@RestController
@RequestMapping(value = "/api")
public class FactionController {

    @Autowired
    public Faction faction;


    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity test(){


        FactionEntity factionEntity = new FactionEntity();

        factionEntity.setName("Hello");
        factionEntity.setRating(1);

        return ResponseEntity.ok(factionEntity);
    }


    //Это тренер
    @Secured({ "ROLE_USER", "ROLE_ADMIN" ,"ROLE_TRAINER"})
    @RequestMapping(value = "/fraction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewFraction(
            @RequestBody FactionEntity factionEntity
    ){
        FactionEntity factionEntity1 = faction.CreateNewFaction(factionEntity.getName(), factionEntity.getPrisonerByMainPerson(), factionEntity.getRating());

        return ResponseEntity.ok(factionEntity1);
    }

    @Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/fraction/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getFraction(
            @PathVariable String name
    ){
        FactionEntity factionEntity = faction.getFactionByName(name);
        return ResponseEntity.ok(factionEntity);
    }

    @Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/fraction/del/{name}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delFraction(
            @PathVariable String name
    ){
        Integer i = faction.delFactionByName(name);
        return ResponseEntity.ok(i);
    }
}
