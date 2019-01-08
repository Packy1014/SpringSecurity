package com.packy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/userLogin")
    public String login() {
        return "login";
    }

    @RequestMapping("/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }
}