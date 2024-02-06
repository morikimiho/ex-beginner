package com.example.exbeginner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exbeginner.form.UserForm;
import com.example.exbeginner.model.User;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
    @GetMapping({"", "/"})
    public String index(Model model, UserForm form) {
        return "exam04";
    }

    @PostMapping({"/input-user", "/input-user/"})
    public String inputUser(@Validated UserForm form, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return index(model, form);
        }
        User user = new User();
        user.setName(form.getName());
        user.setAge(form.getAge());
        user.setComment(form.getComment());
        model.addAttribute("user", user);

        return "exam04-result";
    }

    @GetMapping({"/result", "/result/"})
    public String result() {
        return "exam04-result";
    }
}
