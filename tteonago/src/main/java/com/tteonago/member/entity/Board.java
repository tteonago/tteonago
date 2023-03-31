package com.tteonago.member.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder

@Setter
@Getter
@ToString

@DynamicInsert
@Entity
public class Board {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long article_no;
	
	@ColumnDefault("0") 
    private Long parent_no;

    private String title;
    
    private String content;

	@ManyToOne
	@JoinColumn(name="username")
	private Member member;

    private LocalDate writedate;

    @Transient
    private String title_with_indent;
}
