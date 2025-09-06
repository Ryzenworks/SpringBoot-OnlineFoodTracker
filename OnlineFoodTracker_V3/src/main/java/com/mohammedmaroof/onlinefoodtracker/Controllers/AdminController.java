package com.mohammedmaroof.onlinefoodtracker.Controllers;

import com.mohammedmaroof.onlinefoodtracker.entity.User;
import com.mohammedmaroof.onlinefoodtracker.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserServices userServices;

    //view all the user list
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userServices.getAll(), HttpStatus.OK);
    }
}
