package com.sbs.exam.app;

import java.util.Scanner;

import com.sbs.exam.app.container.Container;
import com.sbs.exam.app.controller.UsrArticleController;

public class App {
	Scanner sc;

	App() {
		sc = Container.getSc();
	}

	public void run() {
		System.out.println("== 텍스트 게시판 시작 ==");

		UsrArticleController usrArticleController = new UsrArticleController();

		while (true) {
			System.out.printf("명령어) ");

			String command = sc.nextLine().trim();

			Rq rq = new Rq(command);

			if (rq.isValid == false) {
				System.out.printf("명령어가 올바르지 않습니다.\n");
				continue;
			}

			if (rq.getControllerTypeCode().equals("usr")) {
				usrArticleController.performAction(rq);
			} else if (rq.getActionPath().equals("/usr/system/exit")) {
				System.out.println("프로그램을 종료 합니다.");
				break;
			}
		}

		System.out.println("== 텍스트 게시판 끝 ==");
	}

}
