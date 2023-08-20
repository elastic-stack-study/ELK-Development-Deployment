package com.yyh.elasticsearch.service

import com.yyh.elasticsearch.model.Rank
import org.elasticsearch.index.query.QueryBuilders.*
import org.elasticsearch.index.query.functionscore.RandomScoreFunctionBuilder
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.query.Criteria
import org.springframework.data.elasticsearch.core.query.CriteriaQuery
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder
import org.springframework.stereotype.Service
import org.springframework.data.domain.Pageable
import java.util.*
import kotlin.streams.toList


@Service
class SearchService(
        private val elasticsearchOperations: ElasticsearchOperations
) {
    fun find(text: String): List<Rank> {
        val searchQuery = NativeSearchQueryBuilder()
                .withQuery(matchQuery("description", text))
                .withPageable(Pageable.ofSize(9))
                .build()

        val result = elasticsearchOperations.search(searchQuery, Rank::class.java)
        return result.get().map { it.content }.toList()
    }

    fun random(): List<Rank> {
        val randomScoreFunction = RandomScoreFunctionBuilder().setField("youtube_rank_id").seed(Random().nextInt())
        val searchQuery = NativeSearchQueryBuilder()
                .withQuery(functionScoreQuery(randomScoreFunction))
                .withPageable(Pageable.ofSize(9))
                .build()

        val result = elasticsearchOperations.search(searchQuery, Rank::class.java)
        return result.get().map { it.content }.toList()
    }
}