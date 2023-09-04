package me.JH.springbootdeveloper1.dto;

import lombok.Getter;
import me.JH.springbootdeveloper1.domain.Article;

@Getter
public class ArticleRespnse {
    private final String title;
    private final String content;

    public ArticleRespnse(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
