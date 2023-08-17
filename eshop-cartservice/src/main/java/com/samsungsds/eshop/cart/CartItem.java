package com.samsungsds.eshop.cart;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("cart")
public class CartItem {
    @Id
    private String id;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuantity() {
        return status;
    }

    public void setQuantity(String quantity) {
        this.status = quantity;
    }

    @Override
    public String toString() {
        return "TestRunItem{" +
                "id='" + id + '\'' +
                ", status=" + status +
                '}';
    }
}

