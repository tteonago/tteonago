package com.tteonago.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name="member")
public class Member {
	
	@Id
	@Column(name = "username")
	private String username;
	
	@NonNull
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
