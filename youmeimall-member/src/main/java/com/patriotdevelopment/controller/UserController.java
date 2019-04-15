package com.patriotdevelopment.controller;

import com.alibaba.fastjson.JSONObject;
import com.patriotdevelopment.mapper.UserMapper;
import com.patriotdevelopment.constans.RespCode;
import com.patriotdevelopment.entity.User;
import com.patriotdevelopment.mq.MessageSender;
import com.patriotdevelopment.redis.RedisServer;
import com.patriotdevelopment.result.Resultes;
import com.patriotdevelopment.service.MemberService;
import com.patriotdevelopment.utils.MD5Utils;
import com.patriotdevelopment.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController implements MemberService {
    @Autowired
     private  UserMapper userMapper;
    @Autowired
    private MessageSender messageSender;
    @Autowired
    private RedisServer redisServer;

    @Override
    public Resultes register(User user) {
        user.setPassword(MD5Utils.MD5(user.getPassword()));
        int register = userMapper.register(user);
        Resultes resultes = new Resultes();
        if (register > 0){
            resultes.setMsg("注册成功");
            resultes.setCode(200);
            resultes.setData(null);
        }else {
           resultes.setCode(300);
           resultes.setMsg("注册失败");
           resultes.setData(null);
        }
        JSONObject json  = new JSONObject();
        String email = user.getEmail();
        json.put("type","email");
        json.put("to",email);
        System.out.println("email:"+email);
        messageSender.send("youmeimall_queue",json.toJSONString());
        return resultes;
    }



    @Override
    public Resultes login(User user) {
        String password = MD5Utils.MD5(user.getPassword());
        user.setPassword(password);
        User logins = userMapper.login(user);
        if (logins == null){
            return   new Resultes(RespCode.UNAUTH,"登录失败，用户名不存在",null);
        }
        if (!logins.getPassword().equals(password)&&!logins.getUsername().equals(user.getUsername())){
              return new Resultes(RespCode.UNAUTH,"用户名或密码不正确",null);
        }
        String token = TokenUtils.getToken();
        redisServer.setString(token,logins.getId()+"");
        return new Resultes(RespCode.SUCCESS,"登录成功",token);
    }

    @Override
    public Resultes logins(String username, String password) {
        String pwd = MD5Utils.MD5(password);
        User user = userMapper.getUserByUsername(username);
        if (user == null){
            return new Resultes(RespCode.UNAUTH, "登陆失败,用户名不存在", null);
        }
        if (!user.getPassword().equals(pwd)){
            return new Resultes(RespCode.UNAUTH,"用户名或密码不正确",null);
        }
        String token = TokenUtils.getToken();
        redisServer.setString(token,user.getId()+"");
        return new Resultes(RespCode.SUCCESS,"登录成功",token);
    }


}
