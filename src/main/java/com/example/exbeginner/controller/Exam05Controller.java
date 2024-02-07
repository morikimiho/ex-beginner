package com.example.exbeginner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exbeginner.service.MemberService;

@Controller
@RequestMapping({"/exam05", "/exam05/"})
public class Exam05Controller {
    @Autowired
    private MemberService service;

    @GetMapping({"", "/"})
    public String index() {
        return "exam05";
    }

    @PostMapping("/search")
    public String search(String name) {
        service.searchMember(name);
        return "exam05-result";
    }


}
