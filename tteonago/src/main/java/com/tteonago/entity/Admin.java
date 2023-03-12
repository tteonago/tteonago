package com.tteonago.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NonNull;

@Entity
@Table(name="admin")
public class Admin {
	//test test test
	// test seongmin
	// test jy
	@Id
	@Column(name = "userName")
	private String userName;
	
	@NonNull
	@Column(name = "passWord")
	private String passWord;
}
