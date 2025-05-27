package com.lty.java.text.board.container;

import com.lty.java.text.board.boundedContext.article.controller.ArticleController;
import com.lty.java.text.board.boundedContext.article.dto.Article;
import com.lty.java.text.board.boundedContext.article.repository.ArticleRepository;
import com.lty.java.text.board.boundedContext.service.ArticleService;

import java.util.Scanner;

public class Container {
  public static Scanner sc;

  public static ArticleRepository articleRepository;
  public static ArticleService articleService;
  public static ArticleController articleController;

  // 프로그램 실행시 딱 한번 실행
  static {
    sc = new Scanner(System.in);

    articleRepository = new ArticleRepository();

    articleService = new ArticleService();

    articleController = new ArticleController();
  }
}