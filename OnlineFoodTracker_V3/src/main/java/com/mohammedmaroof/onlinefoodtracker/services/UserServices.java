package com.mohammedmaroof.onlinefoodtracker.services;
import com.mohammedmaroof.onlinefoodtracker.entity.User;
import com.mohammedmaroof.onlinefoodtracker.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<User> getAll(){
        return userRepository.findAll();
    }




    public void saveEntry(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        userRepository.save(user);
    }


    public void deleteById(ObjectId objectId){
        userRepository.deleteById(objectId);
    }

    public void deleteByUserName(String username){
        userRepository.deleteByUserName(username);
    }

    public Optional<User> findById(ObjectId objectId){
        return userRepository.findById(objectId);
    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

}
