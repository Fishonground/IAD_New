package pip.course.controller;

//import entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pip.course.entities.*;
import pip.course.serviseImpl.Rooms;
//import serviseImpl.*;

@RestController
@RequestMapping(value = "/api")
public class RoomsController {

    @Autowired
    public Rooms rooms;


    //Это любой юзер
    @Secured({ "ROLE_USER","ROLE_GUEST", "ROLE_ADMIN" ,"ROLE_TRAINER"})
    @RequestMapping(value = "/rooms", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewRooms(
            @RequestBody RoomsEntity roomsEntity
    ){
        RoomsEntity roomsEntity1 = rooms.CreateNewRoom(roomsEntity.getId(),roomsEntity.getNumberOfPrisoners(),roomsEntity.getName());
        return ResponseEntity.ok(roomsEntity1);
    }

    @Secured({ "ROLE_GUEST", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/rooms/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getRooms(
            @PathVariable Integer id
    ){
        RoomsEntity roomsEntity = rooms.getRoomById(id);
        return ResponseEntity.ok(roomsEntity);
    }
    @Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/rooms/del/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delRooms(
            @PathVariable Integer id
    ){
        Integer i = rooms.delRoomsById(id);
        return ResponseEntity.ok(i);
    }

}