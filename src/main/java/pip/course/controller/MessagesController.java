package pip.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pip.course.entities.MessagesEntity;
import pip.course.serviseImpl.Messages;

@RestController
@RequestMapping(value = "/api")
public class MessagesController {

    @Autowired
    public Messages messages;



    //Это любой юзер
    @Secured({ "ROLE_USER","ROLE_GUEST", "ROLE_ADMIN" ,"ROLE_TRAINER"})
    @RequestMapping(value = "/messages", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewMessage(
            @RequestBody MessagesEntity messagesEntity
    ){
        MessagesEntity messagesEntity1 = messages.createNewMessage(messagesEntity.getId(),messagesEntity.getMassege(),messagesEntity.getPrisonerByPrisoner(),
                messagesEntity.getUsersByUser(),messagesEntity.getVideosByVideo());
        return ResponseEntity.ok(messagesEntity1);
    }

    @Secured({ "ROLE_GUEST", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/messages/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getMessage(
            @PathVariable Integer id
    ){
        MessagesEntity messagesEntity = messages.getMessageById(id);
        return ResponseEntity.ok(messagesEntity);
    }

    @Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/messages/del/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delMessages(
            @PathVariable Integer id
    ){
        Integer i = messages.delMessagesById(id);
        return ResponseEntity.ok(i);
    }
}
