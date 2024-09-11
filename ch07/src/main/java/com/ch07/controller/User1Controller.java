package com.ch07.controller;

import com.ch07.dto.User1DTO;
import com.ch07.service.User1Service;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class User1Controller {


    private final User1Service user1Service;

    @GetMapping("/user1/list")
    public String list(Model model) {
        List<User1DTO> users = user1Service.selectUser1s();
        model.addAttribute("users", users);

        return "/user1/list";
    }

    @GetMapping("/user1/register")
    public String register(){
        return "/user1/register";
    }

    @PostMapping("/user1/register")
    public String register(User1DTO user1DTO){
        user1Service.insertUser1(user1DTO);
        return "redirect:/user1/register";
    }

    @GetMapping("/user1/modify")
    public String modify(String uid, Model model){

        User1DTO user = user1Service.selectUser1(uid);
        model.addAttribute(user);

        return "/user1/modify";
    }

    @PostMapping("/user1/modify")
    public String modify(User1DTO user1DTO){

        user1Service.updateUser1(user1DTO);

        return "redirect:/user1/modify";
    }

    @GetMapping("/user1/delete")
    public String delete(String uid){
        user1Service.deleteUser1(uid);
        return "redirect:/user1/list";
    }
}
