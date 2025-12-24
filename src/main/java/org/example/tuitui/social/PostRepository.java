package org.example.tuitui.social;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, String> {
    // 查詢某個人的所有貼文 (個人頁用)
    List<Post> findByUserIdOrderByCreatedAtDesc(String userId);
}