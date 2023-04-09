package com.tteonago.member.controller;

import com.tteonago.member.entity.Freeboard;
import com.tteonago.member.entity.Member;
import com.tteonago.member.service.FreeBoardService;
import com.tteonago.member.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class FreeBoardController {

    private final FreeBoardService freeBoardService;
    private final UserService userService;

    @GetMapping("/free")
    public String freeBoardHome(Model model,
                                @RequestParam(defaultValue = "1") int page,
                                @RequestParam(defaultValue = "") String keyword,
                                @RequestParam(defaultValue = "A") String type) {

        model.addAttribute("pages", freeBoardService.getPageFreeBoard(--page, keyword, type));

        return "pages/freeboard";
    }

    @GetMapping("/freeDetail")
    public String detailFreeBoard(Model model, @RequestParam String fId) {
        model.addAttribute("board", freeBoardService.findFreeboardById(fId).get());

        return "pages/freeboard-detail";
    }

    @DeleteMapping("/free/{fId}")
    @ResponseBody
    public ResponseEntity<Object> deleteFreeBoard(Authentication authentication, @PathVariable String fId) {
        Freeboard freeboard = freeBoardService.findFreeboardById(fId).get();

        try {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String userName = userDetails.getUsername();
            if (userName.equals(freeboard.getMember().getUsername())) {
                freeBoardService.deleteFreeBoard(freeboard);
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/freeModify")
    public String modifyFreeBoard(Authentication authentication,
                                  @RequestParam String fId,
                                  @RequestParam String title,
                                  @RequestParam String contents) {

        Freeboard freeboard = freeBoardService.findFreeboardById(fId).get();

        // 로그인한 사용자와 게시판 작성자가 같은지 체크
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String userName = userDetails.getUsername();
        if (userName.equals(freeboard.getMember().getUsername())) {
            freeboard.setContents(contents);
            freeboard.setTitle(title);
            freeboard.setModifiedDate(LocalDateTime.now());

            freeBoardService.saveFreeBoard(freeboard);
        }

        return "redirect:/freeDetail?fId=" + fId;
    }

    @PostMapping("/free")
    public String saveFreeBoard(Authentication authentication, @RequestParam String title, @RequestParam String contents) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String userName = userDetails.getUsername();
        Member member = userService.findById(userName);

        Freeboard newBoard = Freeboard.builder()
                .title(title)
                .contents(contents)
                .hite(0)
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .deleted(false)
                .member(member)
                .hite(0)
                .build();

        freeBoardService.saveFreeBoard(newBoard);

        return "redirect:/free";
    }

}
