package com.elasticsearch.basic.search.service;

import com.elasticsearch.basic.search.entity.LogMessage;
import com.elasticsearch.basic.search.repository.LogMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class LogMessageService {
    private final LogMessageRepository logMessageRepository;

    public List<LogMessage> searchMessage(String keyword) {
        return logMessageRepository.findByMessage(keyword);
    }
}
