package com.example.osapp.controllers;


import com.example.osapp.model.persistence.Cart;
import com.example.osapp.model.requests.ModifyCartRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    public ResponseEntity<Cart> getCart(@PathVariable String username) {

    }

    public ResponseEntity<Cart> addTocart(@RequestBody ModifyCartRequest request) {

    }

    public ResponseEntity<Cart> removeFromcart(@RequestBody ModifyCartRequest request) {

    }
}
