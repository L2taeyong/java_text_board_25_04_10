package com.lty.java.text.board.boundedContext.service;

import com.lty.java.text.board.boundedContext.article.dto.Article;
import com.lty.java.text.board.boundedContext.article.repository.ArticleRepository;
import com.lty.java.text.board.container.Container;

import java.util.List;

public class ArticleService {
  private ArticleRepository articleRepository;

  public ArticleService() {
    articleRepository = Container.articleRepository;
  }

  public int write(String subject, String content) {
    return articleRepository.write(subject, content);
  }

  public List<Article> findAll() {
    return articleRepository.findAll();
  }

  public List<Article> findAll(String searchKeyword, String orderBy) {
    return articleRepository.findAll(searchKeyword, orderBy);
  }

  public void modify(int id, String subject, String content) {
    articleRepository.modify(id, subject, content);
  }


  public void delete(int id) {
    articleRepository.delete(id);
  }

  public Article findById(int id) {
    return articleRepository.findById(id);
  }
}