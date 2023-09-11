package com.elasticsearch.basic.search.controller;

import com.elasticsearch.basic.search.entity.LogMessage;
import com.elasticsearch.basic.search.service.LogMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequiredArgsConstructor
public class LogMessageRestController {

    private final LogMessageService logMessageService;

    @GetMapping("/api/log-message/search")
    public List<LogMessage> searchMessage(@RequestParam String keyword) {
        return logMessageService.searchMessage(keyword);
    }

}
