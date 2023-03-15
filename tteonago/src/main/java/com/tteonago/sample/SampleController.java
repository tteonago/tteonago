package com.tteonago.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/sample")
public class SampleController {

    @GetMapping({"", "/"})
    public String sample() {
        return "pages/sample";
    }

}
