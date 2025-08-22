package com.scaler.BookMyShow2.Services;

import com.scaler.BookMyShow2.Models.Booking;
import com.scaler.BookMyShow2.Models.User;
import com.scaler.BookMyShow2.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User signUp(String name, String email, String password){

        // Business Validations
        // If user already exists
        // we will have to query the database - "select * from user where email ='email'"
        Optional<User> userOptional = userRepository.findByEmail(email);

        if(userOptional.isPresent()){
            throw new RuntimeException("User already exists!");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        user.setPassword(bCryptPasswordEncoder.encode(password)); // Is this a good practice? NO GDPR

        user.setBooking(new ArrayList<>());
        return userRepository.save(user);
    }

    public void login(String email, String password){
        Optional<User> userOptional = userRepository.findByEmail(email);

        if(userOptional.isEmpty()){
            throw new RuntimeException("User does not exist!");
        }

        User user  = userOptional.get();

        BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();

        if(!cryptPasswordEncoder.matches(password, user.getPassword())){
            throw new RuntimeException("Invalid Password");
        }
        return;
    }
}
//B