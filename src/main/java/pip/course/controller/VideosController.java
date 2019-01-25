package pip.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pip.course.entities.VideosEntity;
import pip.course.serviseImpl.Videos;

@RestController
@RequestMapping(value = "/api")
public class VideosController {

    @Autowired
    public Videos videos;


    //Это любой юзер
    @Secured({ "ROLE_USER","ROLE_GUEST", "ROLE_ADMIN" ,"ROLE_TRAINER"})
    @RequestMapping(value = "/videos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewVideos(
            @RequestBody VideosEntity videosEntity
    ){
        VideosEntity videosEntity1 = videos.createNewVideo(videosEntity.getId(),videosEntity.getCamId(),videosEntity.getDescription());
        return ResponseEntity.ok(videosEntity1);
    }

    @Secured({ "ROLE_GUEST", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/videos/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getVideos(
            @PathVariable Integer id
    ){
        VideosEntity videosEntity = videos.getVideoById(id);
        return ResponseEntity.ok(videosEntity);
    }
    @Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/videos/del/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delOrderConditions(
            @PathVariable Integer id
    ){
        Integer i = videos.delVideosById(id);
        return ResponseEntity.ok(i);
    }
}