package com.hms.hostel_managment_system.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="comments")
@Getter
@Setter
public class Comment {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	 
	@ManyToOne
	private Post post;

}
