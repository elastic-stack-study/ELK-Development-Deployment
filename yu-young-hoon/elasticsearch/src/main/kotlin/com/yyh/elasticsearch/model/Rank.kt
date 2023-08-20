package com.yyh.elasticsearch.model

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field

@Document(indexName = "youtube_rank")
data class Rank (
        @Id val id: String?,
        @Field("youtube_rank_id") val youtubeRankId: Int,
        val title: String?,
        @Field("link_id") val linkId: String?,
        val thumbnail: String?
)