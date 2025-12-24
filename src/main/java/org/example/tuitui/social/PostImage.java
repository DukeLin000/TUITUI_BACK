package org.example.tuitui.social;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.example.tuitui.common.BaseEntity; // 引用 BaseEntity
import com.fasterxml.jackson.annotation.JsonIgnore; // 避免 JSON 無限迴圈

@Getter
@Setter
@Entity
@Table(name = "post_images")
public class PostImage extends BaseEntity {

    private String imageUrl; // 圖片網址 (S3 URL)

    private int sortOrder; // 排序 (第1張, 第2張...)

    @ManyToOne
    @JoinColumn(name = "post_id") // 外鍵指向 Post 表
    @JsonIgnore // 重要：轉 JSON 時不要回頭去抓 Post，不然會無窮迴圈
    private Post post;
}