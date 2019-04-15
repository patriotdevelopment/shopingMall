package com.patriotdevelopment.receive;

import javax.mail.MessagingException;


import com.patriotdevelopment.adapter.MsgAdapter;
import com.patriotdevelopment.adapter.impl.MailAdapter;
import com.patriotdevelopment.adapter.impl.WxAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;


@Component
public class MsgHandler {

	@Autowired
	private MailAdapter mailAdapter;
	@Autowired
	private WxAdapter wxAdapter;

	private MsgAdapter msgAdapter;

	// 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
	@JmsListener(destination = "youmeimall_queue")
	public void receiveQueue(String json) throws MessagingException {
		System.out.println("####消息服务收到的报文为:" + json);
		JSONObject oj = JSONObject.parseObject(json);
		String type = (String) oj.get("type");
		switch (type) {
		case "email":
			msgAdapter = (MsgAdapter) mailAdapter;
			//msgAdapter = mailAdapter;
			break;
		case "sms":
			msgAdapter = wxAdapter;
			break;
		case "wx":
			msgAdapter = wxAdapter;
			break;
		default:
			break;
		}
		msgAdapter.excute(json);
	}
}
