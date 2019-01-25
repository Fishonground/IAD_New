package pip.course.serviseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pip.course.entities.OrderConditionsEntity;
import pip.course.entities.OrdersEntity;
import pip.course.entities.ProductEntity;
import pip.course.entities.UsersEntity;
import pip.course.repository.OrdersRepository;

@Service
public class Orders {
    @Autowired
    OrdersRepository ordersRepository;

    @Transactional
    public OrdersEntity CreateNewOrder(Integer id, OrderConditionsEntity orderConditionsEntity , ProductEntity productEntity,
                                       UsersEntity usersEntity){
        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setId(id);
        ordersEntity.setOrderConditionsByCondition(orderConditionsEntity);
        ordersEntity.setProductByProduct(productEntity);
        ordersEntity.setUsersByCustomer(usersEntity);
        ordersRepository.save(ordersEntity);

        return ordersEntity;
    }

    @Transactional
    public  OrdersEntity changeCondition(OrdersEntity ordersEntity, OrderConditionsEntity orderConditionsEntity){
        ordersEntity.setOrderConditionsByCondition(orderConditionsEntity);
        ordersRepository.save(ordersEntity);
        return (ordersEntity);
    }

    public OrdersEntity getOrderById(Integer id){
        OrdersEntity ordersEntity = ordersRepository.findById(id).get();
        return ordersEntity;
    }
    public Integer delOrdersById(Integer id){
        ordersRepository.deleteById(id);
        return 1;
    }



}
