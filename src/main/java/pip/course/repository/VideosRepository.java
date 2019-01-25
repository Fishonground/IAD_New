package pip.course.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pip.course.entities.VideosEntity;

import java.sql.Timestamp;
import java.util.List;

public interface VideosRepository extends CrudRepository<VideosEntity, Integer> {
    @Query (value = "select video from VideosEntity video where video.camId= :name")
    List<VideosEntity> getVideosByCamId(@Param("name") Integer name);
    @Query (value = "select  video from VideosEntity  video where video.time=:time")
    List<VideosEntity> getVideosByTime(@Param("time") Timestamp time);
    @Query (value = "select video from VideosEntity  video where video.camId = :name and video.time >= :timeleft and video.time <= :timeright")
    List<VideosEntity> getVideoByTimeAndCamId(@Param("name") Integer name, @Param("timeleft") Timestamp timeleft, @Param("timeright") Timestamp timeright );
    List<VideosEntity> findVideosEntitiesByDescriptionContains(String text);
    VideosEntity findVideosEntityByNewsById(String name);
}
