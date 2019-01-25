package pip.course.entities;


import org.hibernate.annotations.LazyCollection;

import javax.persistence.*;

@Entity
@Table(name = "news", schema = "public", catalog = "vzope")
public class NewsEntity {
    private String name;
    private String text;
    private VideosEntity videosByVideo;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsEntity that = (NewsEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);

        return result;
    }

    @ManyToOne
    @JoinColumn(name = "video", referencedColumnName = "id")
    public VideosEntity getVideosByVideo() {
        return videosByVideo;
    }

    public void setVideosByVideo(VideosEntity videosByVideo) {
        this.videosByVideo = videosByVideo;
    }
}
