package pip.course.repository;

import org.springframework.data.repository.CrudRepository;
import pip.course.entities.OrderConditionsEntity;
import pip.course.entities.OrdersEntity;
import pip.course.entities.ProductEntity;
import pip.course.entities.UsersEntity;

import java.util.List;

public interface OrdersRepository extends CrudRepository<OrdersEntity, Integer> {
    List<OrdersEntity> findAllByAddresseeId(Integer add);
    List<OrdersEntity> findAllByUsersByCustomerOrderByAddresseeId(UsersEntity usersEntity);
    List<OrdersEntity> findAllByOrderConditionsByConditionEquals(OrderConditionsEntity orderConditionsEntity);
    List<OrdersEntity> findOrdersEntitiesByProductByProductOrderByAddresseeId(ProductEntity productEntity);
}
