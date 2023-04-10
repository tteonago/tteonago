package com.tteonago.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

@AllArgsConstructor
@NoArgsConstructor
@Builder

@Setter
@Getter
@ToString

@Entity
@Table(name="member")
public class Member {	
	@Id
	@Column(name = "username")
	private String username;
	
	@NonNull
	@JsonIgnore
	@Column(name = "password")
	private String password;
	
	@NonNull
	@Column(name = "name")
	private String name;
	
	@NonNull
	@Column(name = "email")
	private String email;
	
	@NonNull
	@Column(name = "role")
	private String role;
	
	@NonNull
	@Column(name = "point")
	private Integer point;
}
