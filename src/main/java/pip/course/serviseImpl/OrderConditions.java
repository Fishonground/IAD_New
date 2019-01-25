package pip.course.serviseImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pip.course.entities.OrderConditionsEntity;
import pip.course.repository.OrderConditionsRepository;

@Service
public class OrderConditions {
    @Autowired
    OrderConditionsRepository orderConditionsRepository;


    @Transactional
    public OrderConditionsEntity CreateNewOrderCondition(Integer id, String description){
        OrderConditionsEntity orderConditionsEntity = new OrderConditionsEntity();
        orderConditionsEntity.setId(id);
        orderConditionsEntity.setDescription(description);
        orderConditionsRepository.save(orderConditionsEntity);

        return orderConditionsEntity;
    }

    @Transactional
    public  OrderConditionsEntity changeDescription(OrderConditionsEntity orderConditionsEntity, String description){
        orderConditionsEntity.setDescription(description);
        orderConditionsRepository.save(orderConditionsEntity);
        return (orderConditionsEntity);
    }

    public OrderConditionsEntity getOrderConditionsById(Integer id){
        OrderConditionsEntity orderConditionsEntity = orderConditionsRepository.findById(id).get();
        return orderConditionsEntity;
    }
    public Integer delOrderConditionsById(Integer id){
        orderConditionsRepository.deleteById(id);
        return 1;
    }

}
