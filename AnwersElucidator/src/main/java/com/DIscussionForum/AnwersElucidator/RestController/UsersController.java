/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DIscussionForum.AnwersElucidator.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.DIscussionForum.AnwersElucidator.Dto.Users;
import com.DIscussionForum.AnwersElucidator.Repository.UsersDataRepo;

/**
 *
 * @author Sameer
 */

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UsersController {

    @Autowired
    UsersDataRepo userData;
    
    @GetMapping(path="/users")
    public List<Users> getAllUsers()
    {
    	System.out.println("Entered User");
        return userData.findAll();
    }
    

    
}


/*******************************************************************************
    post -> uname/pass
    return -> userObj / null
     
        
    @GetMapping(path="/user/{uid}")
    public Optional<Users> getById(@PathVariable int uid)
    {
        return userData.findById(uid);
    }
    
    
    
    @GetMapping(path="/user/{uid}")
    public Optional<Users> getById(@PathVariable int uid)
    {
        return userData.findById(uid);
    }
    
    @GetMapping(path="/uname/{name}")
    public List<Users> getById(@PathVariable String name)
    {
        return userData.findByUname(name);
    }
    
    @PutMapping(path="/upvote/{uid}")
    public ResponseEntity<Users> upvote(@PathVariable int uid)
    {
        Users u=userData.getOne(uid);
        int up = u.getUpvote();
        u.setUpvote(++up);
        Users x=userData.save(u);
        return new ResponseEntity<Users>(x,HttpStatus.OK);
    }

*/
