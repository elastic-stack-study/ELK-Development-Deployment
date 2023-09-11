package com.elasticsearch.basic.search.repository;

import com.elasticsearch.basic.search.entity.LogMessage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface LogMessageRepository extends ElasticsearchRepository<LogMessage, String> {
    List<LogMessage> findByMessage(String message);

}
