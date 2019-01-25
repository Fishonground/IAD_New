package pip.course.serviseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pip.course.entities.FactionEntity;
import pip.course.entities.PrisonerEntity;
import pip.course.entities.RoomsEntity;
import pip.course.entities.UsersEntity;
import pip.course.repository.PrisonerRepository;

import java.sql.Date;

@Service
public class Prisoner {
    @Autowired


    PrisonerRepository prisonerRepository;

    @Transactional
    public PrisonerEntity CreateNewPrisoner(Integer id, Date term , RoomsEntity roomsEntity, UsersEntity usersEntity, Integer rating, FactionEntity factionEntity){
        PrisonerEntity prisonerEntity = new PrisonerEntity();
        prisonerEntity.setPersonId(id);
        prisonerEntity.setTerm(term);
        prisonerEntity.setRoomsByRoom(roomsEntity);
        prisonerEntity.setUsersByOwner(usersEntity);
        prisonerEntity.setRating(rating);
        prisonerEntity.setFactionByFaction(factionEntity);
        prisonerRepository.save(prisonerEntity);
        return prisonerEntity;
    }

    @Transactional
    public  PrisonerEntity changeTerm(PrisonerEntity prisonerEntity, Date term){
        prisonerEntity.setTerm(term);
        prisonerRepository.save(prisonerEntity);
        return (prisonerEntity);
    }

    @Transactional
    public  PrisonerEntity changeRoom(PrisonerEntity prisonerEntity, RoomsEntity roomsEntity){
        prisonerEntity.setRoomsByRoom(roomsEntity);
        prisonerRepository.save(prisonerEntity);
        return (prisonerEntity);
    }  @Transactional
    public  PrisonerEntity changeRating(PrisonerEntity prisonerEntity, Integer rating){
        prisonerEntity.setRating(rating);
        prisonerRepository.save(prisonerEntity);
        return (prisonerEntity);
    }  @Transactional
    public  PrisonerEntity changeFaction(PrisonerEntity prisonerEntity, FactionEntity factionEntity){
        prisonerEntity.setFactionByFaction(factionEntity);
        prisonerRepository.save(prisonerEntity);
        return (prisonerEntity);
    }
    public PrisonerEntity getPrisonerById(Integer id){
        PrisonerEntity prisonerEntity = prisonerRepository.findById(id).get();
        return prisonerEntity;
    }
    public Integer delPrisonersById(Integer id){
        prisonerRepository.deleteById(id);
        return 1;
    }

}
