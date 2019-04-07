package com.patriotdevelopment.controller;

import com.patriotdevelopment.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @RequestMapping("/login")
  public String login(Model model, HttpServletRequest request){
      return "login";
  }

}
