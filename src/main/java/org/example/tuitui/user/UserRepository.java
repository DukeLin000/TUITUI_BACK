package org.example.tuitui.user; // 確認這行沒紅字

import org.springframework.data.jpa.repository.JpaRepository;

// <User, String> 意思操作 User 表，主鍵 ID 是 String (UUID)
public interface UserRepository extends JpaRepository<User, String> {
    // 這裡可以神奇地定義查詢，例如：
    // Optional<User> findByUsername(String username);
}