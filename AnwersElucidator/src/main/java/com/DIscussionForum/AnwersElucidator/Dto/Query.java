/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DIscussionForum.AnwersElucidator.Dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Sameer
 */
@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Query")
public class Query {
	/* int qid 
	 * int upvote (not required)
	 * 
	 * String username 
	 * String category
	 * String title
	 * String description
	 * Date queryDate
	 * 
	 */
	
   @Column(name="fk_uname")
   private String username;
   private String title;
   private String description;
   
   
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="qid")
   private int id;
   
   //@JsonIgnoreProperties("query")
   @OneToMany(fetch=FetchType.EAGER,
		   cascade= {CascadeType.ALL})
   @JoinColumn(name="fk_qid") //, referencedColumnName="id"
   private List<Category> categoryList=new ArrayList<>();
   

   @Column(name="pdate")
   private Date date=(new Date());//queryDate

   private int upvote;
   
   
   public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public int getUpvote() {
	return upvote;
}

public void setUpvote(int upvote) {
	this.upvote = upvote;
}

public ArrayList<String> getCategoryList()
   {
	   String c;
	   ArrayList<String> arr=new ArrayList<>();
	   for(int i=0; i< categoryList.size(); i++)
	   {
		   c=categoryList.get(i).getCategory();
		   arr.add(c);
	   }
	   return arr;
   }
   
   @JsonProperty("categoryList")
   public void setCategoryList(List<String> cat)
   {
	   if(cat!=null)
	   {
		   for(int i =0; i<cat.size(); i++)
		   {
			   Category c=new Category(cat.get(i));
			   categoryList.add(c);
		   }
	   }
   }
   
}



/***************RELATIONS*****************
   //   @JsonIgnoreProperties("query")
//   @OneToMany(mappedBy="query",fetch=FetchType.EAGER,
//		   cascade= {CascadeType.ALL})
//   private List<Category> categories;
   
   //private String category;
   
//   @JsonIgnoreProperties("query")
//   @OneToMany(fetch=FetchType.EAGER,
//		   cascade= {CascadeType.ALL})
//   @JoinColumn(name="cat",referencedColumnName="qid")
//   private List<Category> categories;
//   

   
   
   
   
   OLD CODE
   
   @ManyToOne
   @JoinColumn(name="fk_uname")
   private Users uname;


    public Users getUname() {
        return uname;
    }

    public void setUname(Users uname) {
        this.uname = uname;
    } 
*/