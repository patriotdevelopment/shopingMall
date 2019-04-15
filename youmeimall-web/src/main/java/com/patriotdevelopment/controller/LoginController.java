package com.patriotdevelopment.controller;

import com.patriotdevelopment.constans.RespCode;
import com.patriotdevelopment.entity.User;
import com.patriotdevelopment.feign.MemberFeign;
import com.patriotdevelopment.result.Resultes;
import com.patriotdevelopment.utils.CookieUtils;
import com.patriotdevelopment.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/loginFeign")
public class LoginController {
    @Autowired
    private MemberFeign memberFeign;

    @RequestMapping("/")
    public String logins(){
        return "login";
    }

    @RequestMapping("/logins")
  public String login(User user, HttpServletResponse resp, HttpSession httpSession){
        String password = MD5Utils.MD5(user.getPassword());
        user.setPassword(password);
        Resultes login = memberFeign.login(user);
        Integer code = login.getCode();
        if (code.equals(RespCode.SUCCESS)){
            String token = (String) login.getData();
            CookieUtils.setCookie(resp,"localUser",token);
            return "redirect:/index_v1";
        }else {
            return "login";
        }

  }

}
