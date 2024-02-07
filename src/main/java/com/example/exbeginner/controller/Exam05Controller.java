package com.example.exbeginner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exbeginner.model.Member;
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
    public String search(String name, Model model) {
        List<Member> members = service.searchMember(name);
        model.addAttribute("members", members);
        return "exam05-result";
    }


}
