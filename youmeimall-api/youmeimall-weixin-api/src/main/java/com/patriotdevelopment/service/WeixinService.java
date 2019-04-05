package com.patriotdevelopment.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/wx")
public interface WeixinService {

	@RequestMapping("/send")
	public String sendTemplate(@RequestParam("memberId") Integer memberId, @RequestParam("orderNo") String money,
                               @RequestParam("orderNo") String orderNo);

}
