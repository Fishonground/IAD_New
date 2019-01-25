package pip.course.entities;


import javax.persistence.*;

@Entity
@Table(name = "orders", schema = "public", catalog = "vzope")
public class OrdersEntity {
    private int id;
    private int addresseeId;
    private ProductEntity productByProduct;
    private UsersEntity usersByCustomer;
    private OrderConditionsEntity orderConditionsByCondition;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "addressee_id")
    public int getAddresseeId() {
        return addresseeId;
    }

    public void setAddresseeId(int addresseeId) {
        this.addresseeId = addresseeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (id != that.id) return false;
        if (addresseeId != that.addresseeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + addresseeId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "product", referencedColumnName = "name", nullable = false)
    public ProductEntity getProductByProduct() {
        return productByProduct;
    }

    public void setProductByProduct(ProductEntity productByProduct) {
        this.productByProduct = productByProduct;
    }

    @ManyToOne
    @JoinColumn(name = "customer", referencedColumnName = "login", nullable = false)
    public UsersEntity getUsersByCustomer() {
        return usersByCustomer;
    }

    public void setUsersByCustomer(UsersEntity usersByCustomer) {
        this.usersByCustomer = usersByCustomer;
    }

    @ManyToOne
    @JoinColumn(name = "condition", referencedColumnName = "id", nullable = false)
    public OrderConditionsEntity getOrderConditionsByCondition() {
        return orderConditionsByCondition;
    }

    public void setOrderConditionsByCondition(OrderConditionsEntity orderConditionsByCondition) {
        this.orderConditionsByCondition = orderConditionsByCondition;
    }
}
