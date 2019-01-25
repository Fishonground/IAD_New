package pip.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "rooms", schema = "public", catalog = "vzope")
public class RoomsEntity {
    private int id;
    private int numberOfPrisoners;
    private String name;
    private Collection<PrisonerEntity> prisonersById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "number_of_prisoners")
    public int getNumberOfPrisoners() {
        return numberOfPrisoners;
    }

    public void setNumberOfPrisoners(int numberOfPrisoners) {
        this.numberOfPrisoners = numberOfPrisoners;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomsEntity that = (RoomsEntity) o;

        if (id != that.id) return false;
        if (numberOfPrisoners != that.numberOfPrisoners) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + numberOfPrisoners;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roomsByRoom")
    @JsonIgnore
    public Collection<PrisonerEntity> getPrisonersById() {
        return prisonersById;
    }

    public void setPrisonersById(Collection<PrisonerEntity> prisonersById) {
        this.prisonersById = prisonersById;
    }
}
