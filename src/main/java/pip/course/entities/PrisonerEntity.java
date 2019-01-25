package pip.course.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "prisoner", schema = "public", catalog = "vzope")
public class PrisonerEntity {
    private int personId;
    private Date term;
    private int rating;;
    private Collection<FactionEntity> factionsByPersonId;
    private Collection<MessagesEntity> messagesByPersonId;
    private PeopleEntity peopleByPersonId;
    private RoomsEntity roomsByRoom;
    private UsersEntity usersByOwner;
    private FactionEntity factionByFaction;
    private Collection<ThingsEntity> thingsByPersonId;

    @Id
    @Column(name = "person_id")
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "term")
    public Date getTerm() {
        return term;
    }

    public void setTerm(Date term) {
        this.term = term;
    }


    @Basic
    @Column(name = "rating")
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrisonerEntity that = (PrisonerEntity) o;

        if (personId != that.personId) return false;
        if (rating != that.rating) return false;
        if (term != null ? !term.equals(that.term) : that.term != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personId;
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + rating;
        return result;
    }

    @OneToMany(mappedBy = "prisonerByMainPerson")
    @JsonIgnore
    public Collection<FactionEntity> getFactionsByPersonId() {
        return factionsByPersonId;
    }

    public void setFactionsByPersonId(Collection<FactionEntity> factionsByPersonId) {
        this.factionsByPersonId = factionsByPersonId;
    }

    @OneToMany(mappedBy = "prisonerByPrisoner")
    @JsonIgnore
    public Collection<MessagesEntity> getMessagesByPersonId() {
        return messagesByPersonId;
    }

    public void setMessagesByPersonId(Collection<MessagesEntity> messagesByPersonId) {
        this.messagesByPersonId = messagesByPersonId;
    }

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    public PeopleEntity getPeopleByPersonId() {
        return peopleByPersonId;
    }

    public void setPeopleByPersonId(PeopleEntity peopleByPersonId) {
        this.peopleByPersonId = peopleByPersonId;
    }

    @ManyToOne
    @JoinColumn(name = "room", referencedColumnName = "id", nullable = false)
    public RoomsEntity getRoomsByRoom() {
        return roomsByRoom;
    }

    public void setRoomsByRoom(RoomsEntity roomsByRoom) {
        this.roomsByRoom = roomsByRoom;
    }

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "login", nullable = false)
    @JsonIgnore
    public UsersEntity getUsersByOwner() {
        return usersByOwner;
    }

    public void setUsersByOwner(UsersEntity usersByOwner) {
        this.usersByOwner = usersByOwner;
    }

    @ManyToOne
    @JoinColumn(name = "faction", referencedColumnName = "name")
    @JsonIgnore
    public FactionEntity getFactionByFaction() {
        return factionByFaction;
    }

    public void setFactionByFaction(FactionEntity factionByFaction) {
        this.factionByFaction = factionByFaction;
    }

    @OneToMany(mappedBy = "prisonerByOwner")
    @JsonIgnore
    public Collection<ThingsEntity> getThingsByPersonId() {
        return thingsByPersonId;
    }

    public void setThingsByPersonId(Collection<ThingsEntity> thingsByPersonId) {
        this.thingsByPersonId = thingsByPersonId;
    }
}
