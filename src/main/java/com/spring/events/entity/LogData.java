package com.spring.events.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Data
@Builder
@Getter
@Setter
public class LogData {

    private Map<String,String> data;

}
