package pip.course.serviseImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pip.course.entities.FactionEntity;
import pip.course.entities.PrisonerEntity;
import pip.course.repository.FactionRepository;

@Service
public class Faction{
        @Autowired
        FactionRepository factionRepository;


        @Transactional
        public FactionEntity CreateNewFaction(String name, PrisonerEntity prisonerEntity, Integer rating){
            FactionEntity factionEntity = new FactionEntity();
            factionEntity.setName(name);
            factionEntity.setPrisonerByMainPerson(prisonerEntity);
            factionEntity.setRating(rating);
            return factionRepository.save(factionEntity) ;
        }

        public FactionEntity getFactionByName(String name){
            FactionEntity factionEntity = factionRepository.findById(name).get();
            return factionEntity;
        }

    public Integer delFactionByName(String name){
        factionRepository.deleteById(name);
        return 1;
    }

        @Transactional
        public  FactionEntity changeName(FactionEntity factionEntity, String name){
            factionEntity.setName(name);
            factionRepository.save(factionEntity);
            return (factionEntity);
        }

        @Transactional
        public  FactionEntity changeMain(FactionEntity factionEntity, PrisonerEntity prisonerEntity){
            factionEntity.setPrisonerByMainPerson(prisonerEntity);
            factionRepository.save(factionEntity);
            return (factionEntity);
        }
        @Transactional
    public  FactionEntity changeRating(FactionEntity factionEntity, Integer rating){
    factionEntity.setRating(rating);
    factionRepository.save(factionEntity);
    return (factionEntity);
}
}
