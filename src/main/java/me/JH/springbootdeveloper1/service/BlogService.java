package me.JH.springbootdeveloper1.service;

import lombok.RequiredArgsConstructor;
import me.JH.springbootdeveloper1.domain.Article;
import me.JH.springbootdeveloper1.dto.AddArticleRequest;
import me.JH.springbootdeveloper1.dto.UpdateArticleRequest;
import me.JH.springbootdeveloper1.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor //final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service //빈으로 등록

public class BlogService {
    private  final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request){

        return blogRepository.save(request.toEntry());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+id));

    }
    public void delete(long id){
        blogRepository.deleteById(id);
    }
    @Transactional
    public Article update(long id, UpdateArticleRequest request){

        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
