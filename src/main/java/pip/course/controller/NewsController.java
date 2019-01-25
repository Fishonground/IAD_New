package pip.course.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pip.course.entities.NewsEntity;
import pip.course.serviseImpl.News;

@RestController
@RequestMapping(value = "/api")
public class NewsController {

    @Autowired
    public News news;


    //Это любой юзер
    @Secured({ "ROLE_USER","ROLE_GUEST", "ROLE_ADMIN" ,"ROLE_TRAINER"})
    @RequestMapping(value = "/news", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewNews(
            @RequestBody NewsEntity newsEntity
    ){
        NewsEntity newsEntity1 = news.CreateNewNews(newsEntity.getName(),newsEntity.getText(),newsEntity.getVideosByVideo());
        return ResponseEntity.ok(newsEntity1);
    }

    @Secured({ "ROLE_GUEST", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/news/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getNews(
            @PathVariable String name
    ){
        NewsEntity newsEntity = news.getNewsByName(name);
        return ResponseEntity.ok(newsEntity);
    }
    @Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_TRAINER" })
    @RequestMapping(value = "/news/del/{name}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delNews(
            @PathVariable String name
    ){
        Integer i = news.delNewsByName(name);
        return ResponseEntity.ok(i);
    }

}
