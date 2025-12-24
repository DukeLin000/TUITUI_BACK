package org.example.tuitui.social;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.tuitui.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post extends BaseEntity {

    @Column(nullable = false)
    private String userId;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String locationName;

    private Integer likeCount = 0;
    private Integer commentCount = 0;

    // --- 修改這一行 ---
    // 加上 fetch = FetchType.EAGER，代表「急切加載」，不管用到沒用到，都先抓回來再說
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<PostImage> images = new ArrayList<>();

    public void addImage(String url) {
        PostImage image = new PostImage();
        image.setImageUrl(url);
        image.setSortOrder(this.images.size());
        image.setPost(this);
        this.images.add(image);
    }
}