package pip.course.serviseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pip.course.entities.ProductEntity;
import pip.course.repository.ProductRepository;

@Service
public class Product {
    @Autowired

    ProductRepository productRepository;

    @Transactional
    public ProductEntity CreateNewProduct(String name, Integer count, Integer price, Integer authority){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(name);
        productEntity.setCount(count);
        productEntity.setPrice(price);
        productEntity.setAuthority(authority);
        productRepository.save(productEntity);
        return productEntity;
    }

    @Transactional
    public  ProductEntity changeName(ProductEntity productEntity, String name){
        productEntity.setName(name);
        productRepository.save(productEntity);
        return (productEntity);
    }

    @Transactional
    public  ProductEntity changeCount(ProductEntity productEntity, Integer  count){
        productEntity.setCount(count);
        productRepository.save(productEntity);
        return (productEntity);
    }
    @Transactional
    public  ProductEntity changePrice(ProductEntity productEntity, Integer price){
        productEntity.setPrice(price);
        productRepository.save(productEntity);
        return (productEntity);
    }
    @Transactional
    public  ProductEntity changeAughtority(ProductEntity productEntity, Integer augh){
        productEntity.setAuthority(augh);
        productRepository.save(productEntity);
        return (productEntity);
    }
    public ProductEntity getProductById(String id){
        ProductEntity productEntity = productRepository.findById(id).get();
        return productEntity;
    }
    public Integer delProductById(String id){
        productRepository.deleteById(id);
        return 1;
    }

}
