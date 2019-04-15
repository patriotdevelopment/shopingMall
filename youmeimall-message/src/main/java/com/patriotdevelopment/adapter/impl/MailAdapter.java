package com.patriotdevelopment.adapter.impl;


import javax.mail.internet.MimeMessage;


import com.patriotdevelopment.adapter.MsgAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;


@Component
public class MailAdapter implements MsgAdapter {
	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String systemmail;

	@Override
	public boolean excute(String json) {
		try {
			JSONObject oj = JSONObject.parseObject(json);
			String to = (String) oj.get("to");
			String msg = "你好啊，欢迎注册优美商城" + to;
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
			helper.setFrom(systemmail);
			helper.setTo(to);
			helper.setSubject("注册通知！");
			helper.setText(msg, true);
			mailSender.send(mimeMessage);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
