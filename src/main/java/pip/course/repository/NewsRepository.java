package pip.course.repository;

import org.springframework.data.repository.CrudRepository;
import pip.course.entities.NewsEntity;
import pip.course.entities.VideosEntity;

import java.util.List;

public interface NewsRepository extends CrudRepository<NewsEntity, String> {
    NewsEntity findNewsEntityByNameEquals(String name);
    List<NewsEntity> findNewsEntitiesByVideosByVideo(VideosEntity videosEntity);
    List<NewsEntity> findNewsEntitiesByTextIsStartingWith(String text);
}