package com.sbs.exam.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sbs.exam.app.Rq;
import com.sbs.exam.app.container.Container;
import com.sbs.exam.app.dto.Article;
import com.sbs.exam.util.Util;

public class UsrArticleController {
	private List<Article> articles;
	private int articlesLastId;
	private Scanner sc;

	public UsrArticleController() {
		sc = Container.getSc();
		articles = new ArrayList<>();
		articlesLastId = 0;

		// 테스트 게시물 만들기
		makeTestData();
	}

	private void makeTestData() {
		for (int i = 0; i < 10; i++) {
			Article article = new Article();
			article.setId(articlesLastId + 1);
			article.setRegDate(Util.getNowDateStr());
			article.setUpdateDate(Util.getNowDateStr());
			article.setTitle("제목 " + article.getId());
			article.setBody("내용 " + article.getId());
			articles.add(article);
			articlesLastId++;
		}
	}

	private Article getArticleById(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}

		return null;
	}

	public void performAction(Rq rq) {
		if (rq.getActionPath().equals("/usr/article/write")) {
			actionWrite(rq);
		} else if (rq.getActionPath().equals("/usr/article/list")) {
			actionList(rq);
		} else if (rq.getActionPath().equals("/usr/article/detail")) {
			actionDetail(rq);
		} else if (rq.getActionPath().equals("/usr/article/delete")) {
			actionDelete(rq);

		} else if (rq.getActionPath().equals("/usr/article/modify")) {
			actionModify(rq);
		}
	}

	private void actionModify(Rq rq) {
		int id = rq.getIntParam("id", 0);

		if (id == 0) {
			System.out.println("id를 입력해주세요.");
			return;
		}

		Article foundArticle = getArticleById(id);

		if (foundArticle == null) {
			System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
			return;
		}

		System.out.printf("새 제목 : ");
		foundArticle.setTitle(sc.nextLine().trim());
		System.out.printf("새 내용 : ");
		foundArticle.setBody(sc.nextLine().trim());
		foundArticle.setUpdateDate(Util.getNowDateStr());

		System.out.printf("%d번 게시물을 수정하였습니다.\n", id);
	}

	private void actionDelete(Rq rq) {
		int id = rq.getIntParam("id", 0);

		if (id == 0) {
			System.out.println("id를 입력해주세요.");
			return;
		}

		Article foundArticle = getArticleById(id);

		if (foundArticle == null) {
			System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
			return;
		}

		articles.remove(foundArticle);

		System.out.printf("%d번 게시물을 삭제하였습니다.\n", id);
	}

	private void actionDetail(Rq rq) {
		int id = rq.getIntParam("id", 0);

		if (id == 0) {
			System.out.println("id를 입력해주세요.");
			return;
		}

		Article foundArticle = getArticleById(id);

		if (foundArticle == null) {
			System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
			return;
		}

		System.out.printf("번호 : %d\n", foundArticle.getId());
		System.out.printf("작성날짜 : %s\n", foundArticle.getRegDate());
		System.out.printf("수정날짜 : %s\n", foundArticle.getUpdateDate());
		System.out.printf("제목 : %s\n", foundArticle.getTitle());
		System.out.printf("내용 : %s\n", foundArticle.getBody());
	}

	private void actionList(Rq rq) {
		System.out.printf("번호 / 작성날자 / 제목\n");

		for (int i = articles.size() - 1; i >= 0; i--) {
			Article article = articles.get(i);
			System.out.printf("%d / %s / %s\n", article.getId(), article.getRegDate(), article.getTitle());
		}
	}

	private void actionWrite(Rq rq) {
		System.out.printf("제목 : ");
		String title = sc.nextLine().trim();
		System.out.printf("내용 : ");
		String body = sc.nextLine().trim();

		Article article = new Article();
		article.setId(articlesLastId + 1);
		article.setRegDate(Util.getNowDateStr());
		article.setUpdateDate(Util.getNowDateStr());
		article.setTitle(title);
		article.setBody(body);
		articles.add(article);

		articlesLastId++;

		System.out.printf("%d번 게시물이 생성되었습니다.\n", article.getId());
	}

}
