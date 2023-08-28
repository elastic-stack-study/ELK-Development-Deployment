package com.elasticsearch.basic.search.dto;

import lombok.Data;

@Data
public class MemberAggregationResult {
    private String gender;
    private long docCount;

    // 생성자, getter, setter 등 필요한 메소드 추가

    public MemberAggregationResult(String gender, long docCount) {
        this.gender = gender;
        this.docCount = docCount;
    }
}
