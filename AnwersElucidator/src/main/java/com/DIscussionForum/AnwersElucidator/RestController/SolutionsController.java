/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DIscussionForum.AnwersElucidator.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DIscussionForum.AnwersElucidator.Dto.Solutions;
import com.DIscussionForum.AnwersElucidator.Repository.SolutionsDataRepo;

/**
 *
 * @author Sameer
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SolutionsController {

	@Autowired
	SolutionsDataRepo sol;
/*
 * Get Mapping for all Solution
 */
	@GetMapping("/solutions")
	public List<Solutions> getAllSolutions() {
		return sol.findAll();
	}
	
	/*
	 * Get Mapping for All solution relating to one Question
	 */

	@GetMapping("/solutions/byqid/{qid}")
	public List<Solutions> getSolutionByQid(@PathVariable("qid") int qid)
	{
		ArrayList<Solutions> arr=(ArrayList<Solutions>) sol.findAllByQid(qid);
		return arr;
	}
	
	/*
	 * Get Mapping
	 * TO get specific Solution by SOlution ID
	 */
	@GetMapping("/solutions/bysid/{sid}")
	public Optional<Solutions> getSolutionBySid(@PathVariable("sid") int sid)
	{
		return sol.findById(sid);
	}
	
	/*
	 * Post Mapping
	 * Add new solution using Qid 
	 */
	@PutMapping("questions/{id}/solutions/{sid}")
	public ResponseEntity<Solutions> updateSolution(@PathVariable("sid") int sid, @RequestBody Solutions updated_sol)
	{
		Optional<Solutions> s=sol.findById(sid);
		if(s!=null)
		{	
			Solutions s1=s.get();
			s1.setDescription(updated_sol.getDescription());
			s1.setTitle(updated_sol.getTitle());
			sol.flush();
			return new ResponseEntity<>(s1,HttpStatus.OK);
		}
		return new ResponseEntity<>(updated_sol,HttpStatus.NOT_FOUND);
	}
	
	
	
//	@GetMapping("/solutions/{sid}")
//	public Solutions getSingleSolution(@PathVariable int sid) {
//		Solutions s = sol.findById(sid);
//		if (s == null) {
//			throw new ResourceNotFoundException("Solution not available for this sid !");
//		}
//		return s;
//	}

	@PostMapping("/solutions/{username}/{qid}")
	public ResponseEntity<Void> postSolution(@RequestBody Solutions s,@PathVariable("username") String username, @PathVariable("qid") int qid) {
		
		s.setQid(qid);
		s.setUsername(username);
		Solutions obj = sol.save(s);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
