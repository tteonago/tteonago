package com.tteonago.reservation.dto;

import java.time.LocalDate;

import com.tteonago.member.entity.Board;
import com.tteonago.member.entity.Member;

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
public class BoardDTO {
	private Long article_no;
	private Long parent_no;
	private String title;
	private String content;
	private Member member;
	private LocalDate writedate;
}
