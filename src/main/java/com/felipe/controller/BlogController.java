package com.felipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @GetMapping(value = "/")
    public String mainPage() {
        return "index";
    }
}
