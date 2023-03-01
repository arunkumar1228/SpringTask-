package com.task.Springevent.event;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.Springevent.model.LogData;
import lombok.SneakyThrows;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AuditEventHandler {

    @SneakyThrows
    @Async
    @EventListener
    public void handleEvent(AuditEvent<LogData> auditEvent){
        System.out.println(new ObjectMapper().
                writerWithDefaultPrettyPrinter().
                writeValueAsString(auditEvent.getData()));
    }
}
