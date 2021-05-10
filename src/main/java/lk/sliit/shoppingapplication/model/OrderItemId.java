package lk.sliit.shoppingapplication.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderItemId implements Serializable {

    @Column(name = "orderId", nullable = false)
    private String orderId;

    @Column(name = "productId", nullable = false)
    private String productId;

    public OrderItemId(String orderId, String productId) {
        this.orderId = orderId;
        this.productId = productId;
    }
}
