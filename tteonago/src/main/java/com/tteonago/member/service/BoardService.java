package com.tteonago.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tteonago.member.entity.Board;
import com.tteonago.member.repository.BoardRepository;
import com.tteonago.reservation.dto.BoardDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	public List<Object[]> findAllBoard() {
		return boardRepository.getBoardList1();
	}
	
	public void submitQuestion(BoardDTO boardDTO) {
        Board.BoardBuilder boardBuilder = Board.builder()
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .member(boardDTO.getMember())
                .writedate(boardDTO.getWritedate());

        if (boardDTO.getParent_no() != null) {
            boardBuilder.parent_no(boardDTO.getParent_no());
        }

        boardRepository.save(boardBuilder.build());
    }

	public void deleteQuestion(Long id) {
		boardRepository.deleteById(id);
	}
}
