package com.tteonago.member.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.tteonago.member.entity.Board;
import com.tteonago.member.repository.BoardRepository;
import com.tteonago.reservation.dto.BoardDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	public List<Object[]> findAllBoard() {
		List<Object[]> list = boardRepository.getBoardList1();
		return list;
	}
	
	public void submitQuestion(BoardDTO boardDTO) {
		
		if(boardDTO.getParent_no() != null) {
			Board board = Board.builder()
					.parent_no(boardDTO.getParent_no())
					.title(boardDTO.getTitle())
					.content(boardDTO.getContent())
					.member(boardDTO.getMember())
					.writedate(boardDTO.getWritedate())
					.build();
			boardRepository.save(board);
			return;
		}
		
		Board board = Board.builder()
				.title(boardDTO.getTitle())
				.content(boardDTO.getContent())
				.member(boardDTO.getMember())
				.writedate(boardDTO.getWritedate())
				.build();
		boardRepository.save(board);
	}

	public void deleteQuestion(Long id) {
		boardRepository.deleteById(id);
	}
}
