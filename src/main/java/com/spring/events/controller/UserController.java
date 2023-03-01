package com.spring.events.controller;


import com.spring.events.entity.User;
import com.spring.events.event.AuditEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    AuditEventPublisher auditEventPublisher;

    @PostMapping("user")
    public String regsiter(@RequestBody User user){
        auditEventPublisher.publishEvent("user saved successfully with "+user.getName());
        return "user saved successfully";
    }
}
