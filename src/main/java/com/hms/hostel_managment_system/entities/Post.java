package com.hms.hostel_managment_system.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name="posts")
@Getter
@Setter
@NoArgsConstructor
public class Post {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer postId;
	
	@Column(name="post_title", length=100, nullable=false)
	private String title;
	
	@Column(name="male_female", length=100, nullable=false)
	private String genders;
	
	@Column(name="caste_category", length=100, nullable=false)
	private String casteCategory;
	
	@Column(name="parents_name",length=100, nullable=false)
	private String parents;
	
	@Column(name="parent_income", length=100, nullable=false)
	private String income;
	
	private String ans;
	
	@Column( length=1000)
	private String content;
	
	@Column(length=10000)
	private String  address;
	
	@Column(length=10000)
	private String  lastinstitude;
	
	@Column(length=10000)
	private String  curentinstitude;
	
	@Column(name="last_stay_adds", length=100, nullable=false)
	private String field1;
	
	@Column(name="Enrolled_adds", length=100, nullable=false)
	private String field2;
	
	@Column(name="edu__duration", length=100, nullable=false)
	private String field3;
	
	private String imageName;
	
	private String imageName1;
	
	private Date addedDate;
	
	private String dateOfBirth;
	
	private String joinDate;
	
	private Integer age;
	
	private String subject;
	
	private Integer marks;
	
	@ManyToOne
	@JoinColumn(name="category_id")//change for column name
	private Category category;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="post",cascade=CascadeType.ALL)
	private Set<Comment> comments= new HashSet<>();

}
