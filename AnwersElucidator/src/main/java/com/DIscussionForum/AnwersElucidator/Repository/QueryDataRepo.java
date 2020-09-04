/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DIscussionForum.AnwersElucidator.Repository;

import com.DIscussionForum.AnwersElucidator.Dto.Query;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Sameer
 */
public interface QueryDataRepo extends JpaRepository<Query,Integer>{
	
	ArrayList<Query> findByUsername(String username);
	
	Query findByUsernameAndId(String username, int id);
    //Query findByUsernameAndQid(String username, int qid);
}
