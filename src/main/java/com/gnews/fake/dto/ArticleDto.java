package com.gnews.fake.dto;

public record ArticleDto(
        String id,
        String title,
        String description,
        String content,
        String url,
        String image,
        String publishedAt, // String formatted strictly as ISO8601
        String lang,
        SourceDto source) {
}
