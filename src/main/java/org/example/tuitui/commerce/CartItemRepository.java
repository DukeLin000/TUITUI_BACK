package org.example.tuitui.commerce;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, String> {
    // 找出某個用戶購物車裡的所有東西
    List<CartItem> findByUserId(String userId);
}