package com.example.osapp.model.persistence.repositories;

import com.example.osapp.model.persistence.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(User user);
    Cart findById(String id);
    int countAllById(String id);
}
