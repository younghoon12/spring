/* package com.ch07.controller;

import com.ch07.dto.User2DTO;
import com.ch07.entity.User2;
import com.ch07.service.User2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class User2Controller {


    private final User2Service user2service;

    private String list(Model model) {
        List<User2DTO> users = user2service.insertUser2();
        return "/user2/list";
    }

    @GetMapping
    private String register(){
        return "/user2/register";
    }

    @PostMapping
    private String register(){
        return "/user2/register";
    }

    @GetMapping
    private String modify(User2DTO user2DTO){

        return "/user2/modify";
    }

    @PostMapping
    private String modify(){
        return "/user2/modify";
    }




}
*/