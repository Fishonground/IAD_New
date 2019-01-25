package pip.course.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pip.course.entities.OrderConditionsEntity;
import pip.course.serviseImpl.OrderConditions;

@RestController
@RequestMapping(value = "/api")
public class OrderConditionsController {

    @Autowired
    public OrderConditions orderConditions;


    //Это любой юзер
    @Secured({ "ROLE_USER","ROLE_GUEST", "ROLE_ADMIN" ,"ROLE_TRAINER"})
    @RequestMapping(value = "/orderconditions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewNews(
            @RequestBody OrderConditionsEntity orderConditionsEntity
    ){
        OrderConditionsEntity orderConditionsEntity1 = orderConditions.CreateNewOrderCondition(orderConditionsEntity.getId(),
                orderConditionsEntity.getDescription());
        return ResponseEntity.ok(orderConditionsEntity1);
    }

    @Secured({ "ROLE_GUEST", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/orderconditions/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOrderConditions(
            @PathVariable Integer id
    ){
        OrderConditionsEntity orderConditionsEntity = orderConditions.getOrderConditionsById(id);
        return ResponseEntity.ok(orderConditionsEntity);
    }
    @Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/orderconditions/del/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delOrderConditions(
            @PathVariable Integer id
    ){
        Integer i = orderConditions.delOrderConditionsById(id);
        return ResponseEntity.ok(i);
    }

}
