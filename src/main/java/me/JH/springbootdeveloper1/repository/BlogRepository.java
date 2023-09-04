package me.JH.springbootdeveloper1.repository;

import me.JH.springbootdeveloper1.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
