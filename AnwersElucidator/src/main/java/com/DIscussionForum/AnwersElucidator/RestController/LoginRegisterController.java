/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DIscussionForum.AnwersElucidator.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.DIscussionForum.AnwersElucidator.Dto.Users;
import com.DIscussionForum.AnwersElucidator.Repository.UsersDataRepo;

/**
 *
 * @author Sameer
 */
@RestController
@CrossOrigin(origins="http://localhost:3000")
public class LoginRegisterController {
    
    @Autowired
    UsersDataRepo userData;
    
    /*FOR LOGIN (POST METHOD)
     * Request- JSON {"username":"DATA" , "password": "DATA"}
     * Response-VOID ,
     * 	 		HttpStatus :
     * 				if found - OK (200)
     * 				if not found - NOT FOUND (402)
     */
    @PostMapping(path="/login")
    public ResponseEntity<Users> checkAndLogin(@RequestBody Users user)
    {
        boolean present = userData.existsByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(present)
        {
        	Users u = userData.findById(user.getUsername()).get();
            return new ResponseEntity<>(u,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        //return null;
    }
    
    /*
     * FOR REGISTER (POST METHOD)
     * REQUEST - JSON {"username":"DATA", "firstname":"DATA", "lastname":"DATA", "email":"DATA", "password":"DATA"}
     * RESPONSE- JSON 
     * 			- if user already exists - HttpStatus IM_USED (226), JSON ERROR RESPONSE
     * 			- else, returns HttpStatus OK (200), JSON of the created user
     */
    @PostMapping(path="/register")
    public ResponseEntity<Users> registerUser(@RequestBody Users user)
    {
    	System.out.println("Entered Register");
        boolean present=userData.existsById(user.getUsername());
        if(present)
        {
            return new ResponseEntity<>(null,HttpStatus.IM_USED);
        }
        Users u = userData.save(user);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }
    

}    
/************* SENDING RESPONSE IN STRING FORMAT *******************
    
    With String in Jason
    
    @PostMapping(path="/login")
    public ResponseEntity<String> checkAndLogin(@RequestBody Users user)
    {
        boolean present = userData.existsByUnameAndPassword(user.getUname(), user.getPassword());
        if(present)
        {
            return new ResponseEntity<>("Success !",HttpStatus.OK);
        }
        return new ResponseEntity<>("Incorrect Credentials ! ",HttpStatus.NOT_FOUND);
    }
    
    With String in Jason
    @PostMapping(path="/register")
    public ResponseEntity<String> registerUser(@RequestBody Users user)
    {
        boolean present=userData.existsById(user.getUname());
        if(present)
        {
            return new ResponseEntity<String>("User Already Exists !",HttpStatus.SEE_OTHER);
        }
        userData.save(user);
        return new ResponseEntity<String>("Success !", HttpStatus.CREATED);
    }
    
    
    Post Mapping With Exception Handling
    
    @PostMapping(path="/register")
    public ResponseEntity<Users> registerUser(@RequestBody Users user)
    {
        boolean present=userData.existsById(user.getUsername());
        if(present)
        {
            throw new ResourceAlreadyExistsException("Username Taken !");
        }
        Users u = userData.save(user);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }
    
*/    
