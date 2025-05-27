package com.lty.java.text.board.container;

import com.lty.java.text.board.boundedContext.article.controller.ArticleController;

import java.util.Scanner;

public class Container {
  public static Scanner sc;

  public static ArticleController articleController;

  // 프로그램 실행시 딱 한번 실행
  static {
    sc = new Scanner(System.in);

     articleController = new ArticleController();
  }
}