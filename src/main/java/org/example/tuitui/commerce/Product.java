package org.example.tuitui.commerce;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.example.tuitui.common.BaseEntity;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    private String name;        // 商品名稱 (e.g. "質感針織外套")

    private BigDecimal price;   // 價格 (使用 BigDecimal 處理金錢才精準)

    private String coverUrl;    // 商品封面圖

    private String description; // 商品描述
}