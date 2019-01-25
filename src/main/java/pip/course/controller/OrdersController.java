package pip.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pip.course.entities.OrderConditionsEntity;
import pip.course.entities.OrdersEntity;
import pip.course.serviseImpl.Orders;

@RestController
@RequestMapping(value = "/api")
public class OrdersController {

    @Autowired
    public Orders orders;


    //Это любой юзер
    @Secured({ "ROLE_USER","ROLE_GUEST", "ROLE_ADMIN" ,"ROLE_TRAINER"})
    @RequestMapping(value = "/orders", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewOrders(
            @RequestBody OrdersEntity ordersEntity
    ){
        OrdersEntity ordersEntity1 = orders.CreateNewOrder(ordersEntity.getId(),ordersEntity.getOrderConditionsByCondition(),
                ordersEntity.getProductByProduct(), ordersEntity.getUsersByCustomer());
        return ResponseEntity.ok(ordersEntity1);
    }

    @Secured({ "ROLE_GUEST", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOrders(
            @PathVariable Integer id
    ){
        OrdersEntity ordersEntity = orders.getOrderById(id);
        return ResponseEntity.ok(ordersEntity);
    }
    @Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/orders/del/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delOrders(
            @PathVariable Integer id
    ){
        Integer i = orders.delOrdersById(id);
        return ResponseEntity.ok(i);
    }

    @Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/orders/{id}/upd/conditions", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updConditions(
            @PathVariable Integer id,
            @RequestBody OrderConditionsEntity orderConditionsEntity
    ){
        OrdersEntity ordersEntity = orders.getOrderById(id);
        ordersEntity = orders.changeCondition(ordersEntity, orderConditionsEntity);
        return ResponseEntity.ok(ordersEntity);
    }
}
