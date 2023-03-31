package com.tteonago.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder

@Entity
@Table(name="admin")
public class Admin {
	@Id
	@Column(name = "userName")
	private String userName;
	
	@NonNull
	@Column(name = "passWord")
	private String passWord;
}
