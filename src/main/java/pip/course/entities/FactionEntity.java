package pip.course.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "faction", schema = "public", catalog = "vzope")
public class FactionEntity {
    private String name;
    private int rating;
    private PrisonerEntity prisonerByMainPerson;
    private Collection<PrisonerEntity> prisonersByName;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        FactionEntity that = (FactionEntity) o;

        if (rating != that.rating) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + rating;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "main_person", referencedColumnName = "person_id", nullable = false)
    public PrisonerEntity getPrisonerByMainPerson() {
        return prisonerByMainPerson;
    }

    public void setPrisonerByMainPerson(PrisonerEntity prisonerByMainPerson) {
        this.prisonerByMainPerson = prisonerByMainPerson;
    }

    @OneToMany(mappedBy = "factionByFaction")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<PrisonerEntity> getPrisonersByName() {
        return prisonersByName;
    }

    public void setPrisonersByName(Collection<PrisonerEntity> prisonersByName) {
        this.prisonersByName = prisonersByName;
    }
}
