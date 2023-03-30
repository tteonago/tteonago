package com.tteonago.member.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tteonago.member.entity.Member;
import com.tteonago.member.service.BoardService;
import com.tteonago.member.service.UserService;
import com.tteonago.reservation.dto.BoardDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	private final UserService userService;
	
	@GetMapping("/board")
	public String board(Model model, Authentication authentication) {
		if (authentication != null) {
			model.addAttribute("username", authentication.getName());
		}
		
		List<Object[]> list = boardService.findAllBoard();
		
		model.addAttribute("list", list);
		
		return "pages/board";
	}
	
	@PostMapping("/question")
	public String question(@ModelAttribute BoardDTO boardDTO, @RequestParam(value = "username") String username) {
		boardDTO.setMember(userService.findById(username));
		boardDTO.setWritedate(LocalDate.now());
		
		boardService.submitQuestion(boardDTO);
		
		return "redirect:/board";
	}

	@PostMapping("/questions/{id}")
	public String deleteQuestion(@PathVariable Long id) {
	    boardService.deleteQuestion(id);
	    return "redirect:/board";
	}
}
