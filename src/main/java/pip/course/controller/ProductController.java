package pip.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pip.course.entities.ProductEntity;
import pip.course.serviseImpl.Product;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

    @Autowired
    public Product product;


    //Это любой юзер
    @Secured({ "ROLE_USER","ROLE_GUEST", "ROLE_ADMIN" ,"ROLE_TRAINER"})
    @RequestMapping(value = "/product", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewProduct(
            @RequestBody ProductEntity productEntity
    ){
        ProductEntity productEntity1 = product.CreateNewProduct(productEntity.getName(),productEntity.getCount(),productEntity.getPrice(),productEntity.getAuthority());
        return ResponseEntity.ok(productEntity1);
    }

    @Secured({ "ROLE_GUEST", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProduct(
            @PathVariable String id
    ){
        ProductEntity productEntity = product.getProductById(id);
        return ResponseEntity.ok(productEntity);
    }
    @Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/product/del/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delProduct(
            @PathVariable String id
    ){
        Integer i = product.delProductById(id);
        return ResponseEntity.ok(i);
    }

    @Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/product/{id}/upd/count/{amount}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updCount(
            @PathVariable String id,
            @PathVariable Integer amount
    ){
        ProductEntity productEntity = product.getProductById(id);
        productEntity = product.changeCount(productEntity, amount);
        return ResponseEntity.ok(productEntity);
    }
    @Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/product/{id}/upd/price/{price}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updPrice(
            @PathVariable String id,
            @PathVariable Integer price
    ){
        ProductEntity productEntity = product.getProductById(id);
        productEntity = product.changePrice(productEntity, price);
        return ResponseEntity.ok(productEntity);
    }
}