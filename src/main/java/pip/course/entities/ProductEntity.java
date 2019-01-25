package pip.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "product", schema = "public", catalog = "vzope")
public class ProductEntity {
    private String name;
    private int price;
    private int count;
    private int authority;
    private Collection<OrdersEntity> ordersByName;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "count")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Basic
    @Column(name = "authority")
    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity that = (ProductEntity) o;

        if (price != that.price) return false;
        if (count != that.count) return false;
        if (authority != that.authority) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + price;
        result = 31 * result + count;
        result = 31 * result + authority;
        return result;
    }

    @OneToMany(mappedBy = "productByProduct")
    @JsonIgnore
    public Collection<OrdersEntity> getOrdersByName() {
        return ordersByName;
    }

    public void setOrdersByName(Collection<OrdersEntity> ordersByName) {
        this.ordersByName = ordersByName;
    }
}
