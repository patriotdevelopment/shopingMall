package com.patriotdevelopment.service;

import com.patriotdevelopment.entity.User;

import com.patriotdevelopment.result.Resultes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/member")

public interface MemberService {

    @RequestMapping("/register")
    public Resultes register(User user);
    @RequestMapping("/logins")
    public Resultes login(User user);
    @RequestMapping("/log")
    public Resultes logins(@RequestParam("username") String username,@RequestParam("password") String password);
}
