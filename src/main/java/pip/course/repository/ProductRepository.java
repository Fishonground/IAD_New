package pip.course.repository;
import org.springframework.data.repository.CrudRepository;
import pip.course.entities.ProductEntity;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, String> {
    List<ProductEntity> findProductEntitiesByAuthorityGreaterThan (Integer authority);
    List<ProductEntity> findProductEntitiesByAuthorityIsLessThan (Integer authority);
    List<ProductEntity> findProductEntitiesByCountGreaterThan(Integer count);
    List<ProductEntity> findProductEntitiesByCountGreaterThanOrderByPrice(Integer count);

}
