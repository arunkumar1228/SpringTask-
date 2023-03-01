package com.task.Springevent.event;



import com.task.Springevent.model.LogData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuditEventPublisher {



        @Autowired
        private ApplicationEventPublisher applicationEventPublisher;

        public void publishEvent(String message){
            Map<String,String> map=new HashMap<>();
            HttpServletRequest servletRequest=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            map.put("host",servletRequest.getHeader("host"));
            map.put("user-agent",servletRequest.getHeader("user-agent"));
            map.put("message",message);
            applicationEventPublisher.publishEvent(new AuditEvent<LogData>(LogData.builder().data(map).build()));

        }
    }