package com.task.Springevent.controller;

import com.task.Springevent.event.AuditEventPublisher;
import com.task.Springevent.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    AuditEventPublisher auditEventPublisher;

    @PostMapping("user")
    public String regsiter(@RequestBody User user){
        auditEventPublisher.publishEvent("user saved successfully with"+user.getName());
        return "user saved succefully";
    }
}
