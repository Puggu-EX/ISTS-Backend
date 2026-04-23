package dev.puggu.ists.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Web Controller, simply point to the

@Controller
public class WebController {
    @GetMapping(value="/")
    public String index(){
        return "forward:index.html";
    }
}
