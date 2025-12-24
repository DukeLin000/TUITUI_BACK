package org.example.tuitui.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Column(length = 36, nullable = false, updatable = false)
    private String id;

    // 建立時間
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // 更新時間
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // --- 關鍵修改：我們自己動手寫時間，不靠 Spring 自動了 ---

    @PrePersist // 存檔前執行
    public void prePersist() {
        // 1. 如果沒有 ID，自動產生
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
        // 2. 自動填入現在時間
        LocalDateTime now = LocalDateTime.now();
        if (this.createdAt == null) {
            this.createdAt = now;
        }
        if (this.updatedAt == null) {
            this.updatedAt = now;
        }
    }

    @PreUpdate // 更新前執行
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}