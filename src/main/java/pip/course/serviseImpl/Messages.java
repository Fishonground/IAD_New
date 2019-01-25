package pip.course.serviseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pip.course.entities.MessagesEntity;
import pip.course.entities.PrisonerEntity;
import pip.course.entities.UsersEntity;
import pip.course.entities.VideosEntity;
import pip.course.repository.MessagesRepository;

@Service
public class Messages {
    @Autowired
    MessagesRepository messagesRepository;

/* may be here will be better to use User twice? Not only prisoner*/
    @Transactional
    public MessagesEntity createNewMessage(Integer id, String message, PrisonerEntity prisonerEntity, UsersEntity usersEntity, VideosEntity videosEntity){
        MessagesEntity messagesEntity = new MessagesEntity();
        messagesEntity.setId(id);
        messagesEntity.setMassege(message);
        messagesEntity.setPrisonerByPrisoner(prisonerEntity);
        messagesEntity.setUsersByUser(usersEntity);
        messagesEntity.setVideosByVideo(videosEntity);
        messagesRepository.save(messagesEntity);
        return messagesEntity;
    }
    @Transactional
    public MessagesEntity getMessageById(Integer id){
        MessagesEntity messagesEntity = messagesRepository.findById(id).get();
        return messagesEntity;
    }

    public Integer delMessagesById(Integer id){
        messagesRepository.deleteById(id);
        return 1;
    }

}
