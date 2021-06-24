package com.sbs.exam.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sbs.exam.app.dto.Article;

public class App {
	public static void run() {
		System.out.println("== 텍스트 게시판 시작 ==");

		Scanner sc = new java.util.Scanner(System.in);

		List<Article> articles = new ArrayList<>();
		int articlesLastId = 0;

		while (true) {
			System.out.printf("명령어) ");

			String command = sc.nextLine().trim();

			if (command.equals("/usr/article/write")) {
				System.out.printf("제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("내용 : ");
				String body = sc.nextLine().trim();

				Article article = new Article();
				article.id = articlesLastId + 1;
				article.regDate = "2021-06-24 12:12:12";
				article.updateDate = "2021-06-24 12:12:12";
				article.title = title;
				article.body = body;
				articles.add(article);
				
				articlesLastId++;

				System.out.printf("%d번 게시물이 생성되었습니다.\n", article.id);
			}
			if (command.equals("/usr/system/exit")) {
				System.out.println("프로그램을 종료 합니다.");
				break;
			}
		}

		System.out.println("== 텍스트 게시판 끝 ==");
	}

}
