package com.yyh.elasticsearch.controller

import com.yyh.elasticsearch.model.Rank
import com.yyh.elasticsearch.service.SearchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class SearchController(
        private val searchService: SearchService
) {
    @GetMapping("/search/{text}")
    fun search(@PathVariable("text") text: String): List<Rank> {
        return searchService.find(text = text)
    }

    @GetMapping("/random")
    fun random(): List<Rank> {
        return searchService.random()
    }

}