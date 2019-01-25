package pip.course.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "videos", schema = "public", catalog = "vzope")
public class VideosEntity {
    private int id;
    private int camId;
    private String description;
    private Timestamp time;
    private Collection<MessagesEntity> messagesById;
    private Collection<NewsEntity> newsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cam_id")
    public int getCamId() {
        return camId;
    }

    public void setCamId(int camId) {
        this.camId = camId;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideosEntity that = (VideosEntity) o;

        if (id != that.id) return false;
        if (camId != that.camId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + camId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "videosByVideo")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
        public Collection<MessagesEntity> getMessagesById() {
        return messagesById;
    }

    public void setMessagesById(Collection<MessagesEntity> messagesById) {
        this.messagesById = messagesById;
    }

    @OneToMany(mappedBy = "videosByVideo")
    @JsonIgnore
    public Collection<NewsEntity> getNewsById() {
        return newsById;
    }

    public void setNewsById(Collection<NewsEntity> newsById) {
        this.newsById = newsById;
    }
}
