/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DIscussionForum.AnwersElucidator.Dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Sameer
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Users {

	@Id
	@Column(name = "uname")
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "fname")
	private String firstname;

	@Column(name = "lname")
	private String lastname;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	// @Size(min=2, message="Password should contain more than 2 char !")
	private String password;

}

/******************
 * RELATIONS*********************************
 * 
 * @OneToMany(mappedBy="uname", cascade = CascadeType.ALL, orphanRemoval = true)
 *                              private List<Questions> questions=new
 *                              ArrayList<Questions>();
 * 
 *                              public List<Questions> getQuestions() { return
 *                              questions; }
 * 
 *                              public void setQuestions(List<Questions>
 *                              questions) { this.questions = questions; }
 */