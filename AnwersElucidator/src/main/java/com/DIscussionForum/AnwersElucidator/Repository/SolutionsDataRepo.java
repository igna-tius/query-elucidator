/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DIscussionForum.AnwersElucidator.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.DIscussionForum.AnwersElucidator.Dto.Solutions;

/**
 *
 * @author Sameer
 */
public interface SolutionsDataRepo extends JpaRepository<Solutions,Integer> {
	List<Solutions> findAllByQid(int qid);
}
