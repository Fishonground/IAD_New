package pip.course.serviseImpl;

//import entities.VideosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pip.course.entities.VideosEntity;
import pip.course.repository.VideosRepository;
//import repository.VideosRepository;

import javax.transaction.Transactional;

@Service
public class Videos {
    @Autowired

    VideosRepository videosRepository;

    @Transactional
    public VideosEntity createNewVideo(Integer id, Integer cam_id, String description){

        VideosEntity videosEntity = new VideosEntity();
        videosEntity.setId(id);
        videosEntity.setCamId(cam_id);
        videosEntity.setDescription(description);
        videosRepository.save(videosEntity);

        return videosEntity;
    }

    @Transactional
    public VideosEntity changeDescription(VideosEntity videosEntity, String description){
        videosEntity.setDescription(description);
        videosRepository.save(videosEntity);
        return videosEntity;
    }

    @Transactional
    public VideosEntity changeCamId(VideosEntity videosEntity, Integer cam_id){
        videosEntity.setCamId(cam_id);
        videosRepository.save(videosEntity);
        return videosEntity;
    }
    public VideosEntity getVideoById(Integer id){
        VideosEntity videosEntity = videosRepository.findById(id).get();
    return videosEntity;
    }
    public Integer delVideosById(Integer id){
        videosRepository.deleteById(id);
        return 1;
    }

}
