package com.tteonago.member.controller;

import com.tteonago.member.service.FreeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class FreeBoardController {

    private final FreeBoardService freeBoardService;


    @RequestMapping("/free")
    public String freeBoardHome(Model model,
                                @RequestParam(defaultValue = "1") int page,
                                @RequestParam(defaultValue = "") String keyword) {

        model.addAttribute("pages", freeBoardService.getPageFreeBoard(--page, keyword));

        return "pages/freeboard";
    }

}
