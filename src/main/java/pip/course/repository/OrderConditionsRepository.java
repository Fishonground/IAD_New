package pip.course.repository;

import org.springframework.data.repository.CrudRepository;
import pip.course.entities.OrderConditionsEntity;

public interface OrderConditionsRepository extends CrudRepository <OrderConditionsEntity, Integer> {
}
