package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ID;

	@Column(name = "title")
	private String title;

	@Column(name = "url")
	private String url;

	@Column(name = "description")
	private String description;
	
	@Column(name = "tags")
	private String tags;
	

	public Image() {

	}
}
