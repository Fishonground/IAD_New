package pip.course.serviseImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pip.course.entities.PeopleEntity;
import pip.course.repository.PeopleRepository;

import java.sql.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class People {

    final
    PeopleRepository peopleRepository;

    @Autowired
    public People(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }


    @Transactional
    public PeopleEntity createNewPeople(Integer id, String gender, String name, String surname , String otchestvo, String photo){
        PeopleEntity peopleEntity = new PeopleEntity();
        peopleEntity.setId(id);
        peopleEntity.setGender(gender);
        peopleEntity.setName(name);
        peopleEntity.setSurname(surname);
        peopleEntity.setSecondName(otchestvo);
        peopleEntity.setDateOfBirth(new Date(new java.util.Date().getTime()));
        peopleEntity.setPhoto(photo);
        peopleRepository.save(peopleEntity);
        return peopleEntity;
    }
    @Transactional
    public PeopleEntity searchbyId(Integer id) throws NoSuchElementException{
        Optional<PeopleEntity> peopleEntityOptional = peopleRepository.findById(id);

        if(peopleEntityOptional.isPresent()) return peopleEntityOptional.get();
        else throw new NoSuchElementException("Id doesn't exist!");

    }

    public Integer delPeopleById(Integer id){
        peopleRepository.deleteById(id);
        return 1;
    }


    @Transactional
    public PeopleEntity changeName(PeopleEntity peopleEntity, String name){
        peopleEntity.setName(name);
        peopleRepository.save(peopleEntity);
        return peopleEntity;
    }
    @Transactional
    public PeopleEntity changeSurname(PeopleEntity peopleEntity, String surname){
        peopleEntity.setSurname(surname);
        peopleRepository.save(peopleEntity);
        return peopleEntity;
    }
    @Transactional
    public PeopleEntity changeSecName(PeopleEntity peopleEntity, String secname){
        peopleEntity.setSecondName(secname);
        peopleRepository.save(peopleEntity);
        return peopleEntity;
    }

    @Transactional
    public PeopleEntity changeGender(PeopleEntity peopleEntity, String gender){
        peopleEntity.setGender(gender);
        peopleRepository.save(peopleEntity);
        return peopleEntity;
    }

    @Transactional
    public PeopleEntity changePhoto(PeopleEntity peopleEntity, String photo){
        peopleEntity.setPhoto(photo);
        peopleRepository.save(peopleEntity);
        return peopleEntity;
    }


}
