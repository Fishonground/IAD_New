package pip.course.serviseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pip.course.entities.PrisonerEntity;
import pip.course.entities.ThingsEntity;
import pip.course.repository.ThingsRepository;

@Service
public class Things {
    @Autowired
    ThingsRepository thingsRepository;

    @Transactional
    public ThingsEntity CreateNewThing(String name, String description, Integer price, PrisonerEntity prisonerEntity){
        ThingsEntity thingsEntity = new ThingsEntity();
        thingsEntity.setName(name);
        thingsEntity.setDescription(description);
        thingsEntity.setPrice(price);
        thingsEntity.setPrisonerByOwner(prisonerEntity);
        thingsRepository.save(thingsEntity);
        return thingsEntity;
    }

    @Transactional
    public  ThingsEntity changeName(ThingsEntity thingsEntity, String name){
        thingsEntity.setName(name);
        thingsRepository.save(thingsEntity);
        return (thingsEntity);
    }

    @Transactional
    public  ThingsEntity changeDescription(ThingsEntity thingsEntity, String description){
        thingsEntity.setDescription(description);
        thingsRepository.save(thingsEntity);
        return (thingsEntity);
    }
    @Transactional
    public  ThingsEntity changePrice(ThingsEntity thingsEntity, Integer price){
        thingsEntity.setPrice(price);
        thingsRepository.save(thingsEntity);
        return (thingsEntity);
    }
    @Transactional
    public  ThingsEntity changeOwner(ThingsEntity thingsEntity, PrisonerEntity prisonerEntity){
        thingsEntity.setPrisonerByOwner(prisonerEntity);
        thingsRepository.save(thingsEntity);
        return (thingsEntity);
    }

    public ThingsEntity getThingByName(String name){
        ThingsEntity thingsEntity = thingsRepository.findById(name).get();
        return thingsEntity;
    }
    public Integer delThingsById(String id){
        thingsRepository.deleteById(id);
        return 1;
    }


}
