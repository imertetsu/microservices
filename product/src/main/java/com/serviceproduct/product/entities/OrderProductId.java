package com.serviceproduct.product.entities;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductId implements Serializable {
    private Long orderProductId;
    private Long orderId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProductId that = (OrderProductId) o;
        return Objects.equals(orderProductId, that.orderProductId) && Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderProductId, orderId);
    }
}
