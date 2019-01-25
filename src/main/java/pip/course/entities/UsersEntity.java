package pip.course.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users", schema = "public", catalog = "vzope")
public class UsersEntity {

    private String password;
    private String login;
    private Collection<MessagesEntity> messagesByLogin;
    private Collection<OrdersEntity> ordersByLogin;
    private Collection<PrisonerEntity> prisonersByLogin;
    private UsersStatusEntity usersStatusByStatus;
    private PeopleEntity peopleByPeopleId;



    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;



        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 10;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);

        return result;
    }

    @OneToMany(mappedBy = "usersByUser")
    @JsonIgnore
    public Collection<MessagesEntity> getMessagesByLogin() {
        return messagesByLogin;
    }

    public void setMessagesByLogin(Collection<MessagesEntity> messagesByLogin) {
        this.messagesByLogin = messagesByLogin;
    }

    @OneToMany(mappedBy = "usersByCustomer")
    @JsonIgnore
    public Collection<OrdersEntity> getOrdersByLogin() {
        return ordersByLogin;
    }

    public void setOrdersByLogin(Collection<OrdersEntity> ordersByLogin) {
        this.ordersByLogin = ordersByLogin;
    }

    @OneToMany(mappedBy = "usersByOwner")
    @JsonIgnore
    public Collection<PrisonerEntity> getPrisonersByLogin() {
        return prisonersByLogin;
    }

    public void setPrisonersByLogin(Collection<PrisonerEntity> prisonersByLogin) {
        this.prisonersByLogin = prisonersByLogin;
    }

    @ManyToOne
    @JoinColumn(name = "status", referencedColumnName = "id", nullable = false)
    public UsersStatusEntity getUsersStatusByStatus() {
        return usersStatusByStatus;
    }

    public void setUsersStatusByStatus(UsersStatusEntity usersStatusByStatus) {
        this.usersStatusByStatus = usersStatusByStatus;
    }

    @ManyToOne
    @JoinColumn(name = "people_id", referencedColumnName = "id", nullable = false)
    public PeopleEntity getPeopleByPeopleId() {
        return peopleByPeopleId;
    }

    public void setPeopleByPeopleId(PeopleEntity peopleByPeopleId) {
        this.peopleByPeopleId = peopleByPeopleId;
    }
}
