package com.sbs.exam.app.container;

import java.util.Scanner;

import com.sbs.exam.app.Session;
import com.sbs.exam.app.controller.UsrArticleController;
import com.sbs.exam.app.controller.UsrMemberController;
import com.sbs.exam.app.controller.UsrSystemController;
import com.sbs.exam.app.repository.ArticleRepository;
import com.sbs.exam.app.service.ArticleService;

import lombok.Getter;

public class Container {
	@Getter
	private static Scanner sc;
	@Getter
	private static Session session;

	@Getter
	private static ArticleService articleService;
	@Getter
	private static ArticleRepository articleRepository;

	@Getter
	private static UsrSystemController usrSystemController;
	@Getter
	private static UsrArticleController usrArticleController;
	@Getter
	private static UsrMemberController usrMemberController;

	static {
		sc = new Scanner(System.in);
		session = new Session();

		articleRepository = new ArticleRepository();

		articleService = new ArticleService();

		usrSystemController = new UsrSystemController();
		usrArticleController = new UsrArticleController();
		usrMemberController = new UsrMemberController();
	}
}
