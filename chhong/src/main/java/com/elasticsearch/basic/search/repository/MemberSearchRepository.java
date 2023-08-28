package com.elasticsearch.basic.search.repository;

import com.elasticsearch.basic.search.entity.Member;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberSearchRepository extends ElasticsearchRepository<Member, String>, MemberSearchRepositoryCustom {
}
