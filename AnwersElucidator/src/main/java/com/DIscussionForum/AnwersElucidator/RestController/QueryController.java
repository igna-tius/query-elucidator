/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DIscussionForum.AnwersElucidator.RestController;

import java.net.URI;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.DIscussionForum.AnwersElucidator.Dto.Query;
import com.DIscussionForum.AnwersElucidator.Repository.QueryDataRepo;

/**
 *
 * @author Sameer
 */
@RestController
@CrossOrigin(origins="http://localhost:3000")
public class QueryController {
    
    @Autowired
    QueryDataRepo queryData;
    
    // Find all questions
    @GetMapping(path="/allquery")
    public List<Query> getAllQuestions() 
    {
        return queryData.findAll();
    }
    

/*
 * Get By username
 */
    @GetMapping(path="users/{username}/queries")
    public List<Query> getAllQuestions(@PathVariable String username) 
    {
    	System.out.println("Entered");
        return queryData.findByUsername(username);
    }
/*
 * get by qid and uname
 */

    @GetMapping(path="users/{username}/queries/{id}")
    public Query getQuestionsByNameAndId(@PathVariable String username,@PathVariable("id") int qid) 
    {	
    	return queryData.findByUsernameAndId(username,qid);
//        return queryData.findByUsernameAndQid(username,qid);
    }
    
/*
 * Put Mapping 
 */
    @PutMapping(path="/users/{username}/queries/{id}")
	public ResponseEntity<Query>  updateQuestions(@PathVariable("username") String username,@PathVariable("id") int qid,@RequestBody Query query){
		
    	Optional<Query> _query = queryData.findById(qid);
		if(_query.isPresent())
		{
			query.setUsername(username);
//			Query q=_query.get();
////			q.setQid(q.geyQid());
//			q.setCategories(query.getCategories());
//			q.setDescription(query.getDescription());
//			q.setTitle(query.getTitle());
			query.setId(qid);
			queryData.save(query);
			return new ResponseEntity<>(query,HttpStatus.OK);
		}
		return new ResponseEntity<Query>(query,HttpStatus.NOT_FOUND);
	}
	
/*
 * Changes Made to React App
 * api->QueryDataService
 * put -> post 
 * 
 * Post Mapping
 */
    @PostMapping(path="/users/{username}/queries")
    public ResponseEntity<Query> saveQuestionByUsername(@PathVariable("username") String username,@RequestBody Query ques)
    {
        Query x=queryData.save(ques);
        URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(x.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    
    
    
    
    
/*
 * Delete Mapping By qid
 */
    @DeleteMapping("/users/{username}/queries/{id}")
	public ResponseEntity<Void> deleteQuestions(@PathVariable("username") String username,@PathVariable("id") int qid ){
		try {
			queryData.deleteById(qid);
			return ResponseEntity.noContent().build();
		}
    	catch(Exception ex)
		{
    		return ResponseEntity.notFound().build();
		}
	}
    
}

/******************FIND BY QID*****************************

    @GetMapping(path="/questions/{qid}")
    public ResponseEntity<Questions> getQuestion(@PathVariable int qid)
    {
        Questions ques=quesData.findById(qid);
        if(ques!=null)
        {
            return new ResponseEntity<Questions>(ques,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


Post Question

@PostMapping(path="/questions")
public ResponseEntity<Questions> saveQuestion(@RequestBody Questions ques)
{
    Questions x=quesData.save(ques);
    return new ResponseEntity<Questions>(x,HttpStatus.OK);
}

Get Mapping WIth Excepton Handling

@GetMapping(path="/questions/{qid}")
public Optional<Questions> getQuestion(@PathVariable int qid)
{
    Optional<Questions> ques=quesData.findById(qid);
    if(!ques.isPresent())
    {
        throw new ResourceNotFoundException("Question Not Found !");
    }
    
    return ques;
}
*/    

