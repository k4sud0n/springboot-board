package me.k4sud0n.firstproject.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;
import me.k4sud0n.firstproject.entity.Article;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private Long id;
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(id, title, content);
    }
}