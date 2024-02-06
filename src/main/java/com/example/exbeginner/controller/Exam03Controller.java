package com.example.exbeginner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping({"/exam03", "/exam03/"})
public class Exam03Controller {
    private ServletContext application;

    @GetMapping({"", "/"})
    public String index() {
        return "exam03";
    }

    @PostMapping("/input-price")
    public String inputPrice(Integer product1, Integer product2, Integer product3) {
        Integer sum = product1 + product2 + product3;
        double includeTax = sum * 1.1;
        application.setAttribute("sum", sum);
        application.setAttribute("includeTax", includeTax);
        return "exam03-result";
    }

    @GetMapping({"/result", "/result/"})
    public String result() {
        return "exam03-result";
    }
}
