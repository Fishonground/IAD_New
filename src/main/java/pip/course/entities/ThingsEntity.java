package pip.course.entities;


import javax.persistence.*;

@Entity
@Table(name = "things", schema = "public", catalog = "vzope")
public class ThingsEntity {
    private String name;
    private String description;
    private int price;

    private PrisonerEntity prisonerByOwner;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThingsEntity that = (ThingsEntity) o;

        if (price != that.price) return false;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + price;

        return result;
    }

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "person_id", nullable = false)
    public PrisonerEntity getPrisonerByOwner() {
        return prisonerByOwner;
    }

    public void setPrisonerByOwner(PrisonerEntity prisonerByOwner) {
        this.prisonerByOwner = prisonerByOwner;
    }
}
