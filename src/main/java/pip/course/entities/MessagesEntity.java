package pip.course.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "messages", schema = "public", catalog = "vzope")
public class MessagesEntity {
    private int id;
    private String massege;
    private UsersEntity usersByUser;
    private PrisonerEntity prisonerByPrisoner;
    private VideosEntity videosByVideo;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "massege")
    public String getMassege() {
        return massege;
    }

    public void setMassege(String massege) {
        this.massege = massege;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessagesEntity that = (MessagesEntity) o;

        if (id != that.id) return false;

        if (massege != null ? !massege.equals(that.massege) : that.massege != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (massege != null ? massege.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "login")
    public UsersEntity getUsersByUser() {
        return usersByUser;
    }

    public void setUsersByUser(UsersEntity usersByUser) {
        this.usersByUser = usersByUser;
    }

    @ManyToOne
    @JoinColumn(name = "prisoner", referencedColumnName = "person_id", nullable = false)
    public PrisonerEntity getPrisonerByPrisoner() {
        return prisonerByPrisoner;
    }

    public void setPrisonerByPrisoner(PrisonerEntity prisonerByPrisoner) {
        this.prisonerByPrisoner = prisonerByPrisoner;
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
