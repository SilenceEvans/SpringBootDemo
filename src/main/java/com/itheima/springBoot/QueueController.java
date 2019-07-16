package com.itheima.springBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class QueueController {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @RequestMapping("/sendSms")
    public void sendSms(){
        Map map = new HashMap();
        map.put("mobile","18310857356");
        map.put("template_code","SMS_170353043");
        map.put("sign_name","品优购注册验证");
        map.put("param","{\"code\":\"102931\"}");
        jmsMessagingTemplate.convertAndSend("sms",map);
    }
}
