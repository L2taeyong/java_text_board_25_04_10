package com.lty.java.text.board.boundedContext.article.controller;

import com.lty.java.text.board.boundedContext.article.dto.Article;
import com.lty.java.text.board.boundedContext.service.ArticleService;
import com.lty.java.text.board.container.Container;
import com.lty.java.text.board.global.base.Rq;


import java.util.List;
import java.util.Map;


public class ArticleController {
  public ArticleService articleService;

  public ArticleController() {
    articleService = Container.articleService;
  }

  public void doWrite() {
    System.out.println("== 게시물 작성 ==");
    System.out.print("제목 : ");
    String subject = Container.sc.nextLine();

    if (subject.trim().isEmpty()) {
      System.out.println("제목을 입력해주세요.");
      return;
    }

    System.out.print("내용 : ");
    String content = Container.sc.nextLine();

    if (content.trim().isEmpty()) {
      System.out.println("내용을 입력해주세요.");
      return;
    }

    int id = articleService.write(subject, content);

    System.out.printf("%d번 게시물이 등록되었습니다.\n", id);
  }

  public void showList(Rq rq) {
    String searchKeyword = rq.getParam("searchKeyword", "");
    String orderBy = rq.getParam("orderBy", "idDesc");

    List<Article> articles = articleService.findAll(searchKeyword, orderBy);

    System.out.printf("== 게시물 리스트(총 %d개) ==\n", articles.size());
    System.out.println("번호 | 제목");

    articles.forEach(
        article -> System.out.printf("%d | %s\n", article.getId(), article.getSubject())
    );
  }

  public void showDetail(Rq rq) {
    int id = rq.getIntParam("id", 0);

    if(id == 0) {
      System.out.println("id를 올바르게 입력해주세요.");
      return;
    }

    List<Article> articles = articleService.findAll();

    if (articles.isEmpty()) {
      System.out.println("게시물이 존재하지 않습니다.");
      return;
    }

    if (id > articles.size()) {
      System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
      return;
    }

    Article article = articleService.findById(id);

    if (article == null) {
      System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
      return;
    }

    System.out.printf("== %d번 게시물 상세보기 ==\n", id);
    System.out.printf("번호 : %d\n", article.getId());
    System.out.printf("제목 : %s\n", article.getSubject());
    System.out.printf("내용 : %s\n", article.getContent());
  }

  public void doModify(Rq rq) {
    int id = rq.getIntParam("id", 0);

    if(id == 0) {
      System.out.println("id를 올바르게 입력해주세요.");
      return;
    }

    List<Article> articles = articleService.findAll();

    if (articles.isEmpty()) {
      System.out.println("게시물이 존재하지 않습니다.");
      return;
    }

    Article article = articleService.findById(id);

    if(article == null) {
      System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
      return;
    }

    System.out.printf("== %d번 게시물 수정 ==\n", id);
    System.out.print("새 제목 : ");
    String subject = Container.sc.nextLine();

    System.out.print("새 내용 : ");
    String content = Container.sc.nextLine();

    articleService.modify(id, subject, content);

    System.out.printf("%d번 게시물이 수정되었습니다.\n", id);
  }

  public void doDelete(Rq rq) {
    int id = rq.getIntParam("id", 0);

    if(id == 0) {
      System.out.println("id를 올바르게 입력해주세요.");
      return;
    }

    List<Article> articles = articleService.findAll();

    if (articles.isEmpty()) {
      System.out.println("게시물이 존재하지 않습니다.");
      return;
    }

    Article article = articleService.findById(id);

    if(article == null) {
      System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
      return;
    }

    articleService.delete(id);

    System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);
  }
}