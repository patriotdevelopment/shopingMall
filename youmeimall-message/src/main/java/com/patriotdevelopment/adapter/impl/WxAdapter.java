package com.patriotdevelopment.adapter.impl;


import com.patriotdevelopment.adapter.MsgAdapter;
import org.springframework.stereotype.Component;



@Component
public class WxAdapter implements MsgAdapter {

	@Override
	public boolean excute(String json) {
		//处理微信相关的业务
		return false;
	}

}
