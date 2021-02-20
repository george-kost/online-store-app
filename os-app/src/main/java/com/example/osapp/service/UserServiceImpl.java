package com.example.osapp.service;

import com.example.osapp.controllers.UserController;
import com.example.osapp.model.persistence.Cart;
import com.example.osapp.model.persistence.repositories.CartRepository;
import com.example.osapp.model.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository ;
   // @Autowired private
 //   BCryptPasswordEncoder bCryptPasswordEncoder;


    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Override
    public User createUser(String username, String password) {
            //User
        User user = new User();
        user.setUsername(username);
        Cart cart = new Cart();
        cart.setTotal(BigDecimal.ZERO);
        cart.setInitialTotalValue(BigDecimal.ZERO);
        cart.setTotalDiscount(BigDecimal.ZERO);
        cartRepository.save(cart);
        user.setCart(cart);
        user.setPassword(password);
        //user.setPassword(bCryptPasswordEncoder.encode(password));
        userRepository.save(user);
        log.info("New user {} created", user.getUsername());
        return user;
    }
}
