package net.haeyoon.library_web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("common")
@RequiredArgsConstructor
public class commonController {

    @RequestMapping("/messageRedirect")
    public String messageRedirect(){
        return "/common/messageRedirect";
    }
}
