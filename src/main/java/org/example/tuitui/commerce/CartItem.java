package org.example.tuitui.commerce;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.example.tuitui.common.BaseEntity;

@Getter
@Setter
@Entity
@Table(name = "cart_items")
public class CartItem extends BaseEntity {

    private String userId; // 這個項目屬於哪個用戶

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product; // 買了什麼商品

    private int quantity; // 買了幾個
}