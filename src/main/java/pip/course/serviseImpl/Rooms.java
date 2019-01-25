package pip.course.serviseImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pip.course.entities.RoomsEntity;
import pip.course.repository.RoomsRepository;

@Service
public class Rooms {
    @Autowired

    RoomsRepository roomsRepository;

    @Transactional
    public RoomsEntity CreateNewRoom(Integer id, Integer guests, String name){
        RoomsEntity roomsEntity = new RoomsEntity();
        roomsEntity.setId(id);
        roomsEntity.setName(name);
        roomsEntity.setNumberOfPrisoners(guests);
        roomsRepository.save(roomsEntity);
        return roomsEntity;
    }

    @Transactional
    public  RoomsEntity changeName(RoomsEntity roomsEntity, String name){
        roomsEntity.setName(name);
        roomsRepository.save(roomsEntity);
        return (roomsEntity);
    }

    @Transactional
    public  RoomsEntity changeGuests(RoomsEntity roomsEntity, Integer guests){
        roomsEntity.setNumberOfPrisoners(guests);
        roomsRepository.save(roomsEntity);
        return (roomsEntity);
    }

    public RoomsEntity getRoomById(Integer id){
        RoomsEntity roomsEntity = roomsRepository.findById(id).get();
        return roomsEntity;
    }
    public Integer delRoomsById(Integer id){
        roomsRepository.deleteById(id);
        return 1;
    }


}
