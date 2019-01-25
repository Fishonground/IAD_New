package pip.course.serviseImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pip.course.entities.NewsEntity;
import pip.course.entities.VideosEntity;
import pip.course.repository.NewsRepository;

@Service
public class News {
    @Autowired
    NewsRepository newsRepository;


    @Transactional
    public NewsEntity CreateNewNews(String name, String text, VideosEntity videosEntity){
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setName(name);
        newsEntity.setText(text);
        newsEntity.setVideosByVideo(videosEntity);
        newsRepository.save(newsEntity);

        return newsEntity;
    }

    @Transactional
    public  NewsEntity changeText(NewsEntity newsEntity, String text){
        newsEntity.setName(text);
        newsRepository.save(newsEntity);
        return (newsEntity);
    }

    public NewsEntity getNewsByName(String name){
        //NewsEntity newsEntity = newsRepository.findNewsEntityByNameEquals(name);
        NewsEntity newsEntity1 = newsRepository.findById(name).get();
        return newsEntity1;
    }
    public Integer delNewsByName(String name){
        newsRepository.deleteById(name);
        return 1;
    }


}
