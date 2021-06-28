package com.sbs.exam.app;

import java.util.Scanner;

import com.sbs.exam.app.container.Container;
import com.sbs.exam.app.controller.Controller;
import com.sbs.exam.app.dto.Member;

public class App {
	Scanner sc;

	App() {
		sc = Container.getSc();
	}

	public void run() {
		System.out.println("== 텍스트 게시판 시작 ==");

		Session session = Container.getSession();

		while (true) {
			Member loginedMember = (Member) session.getAttribute("loginedMember");

			String promprName = "명령어";

			if (loginedMember != null) {
				promprName = loginedMember.getNickname();
			}

			System.out.printf("%s) ", promprName);

			String command = sc.nextLine().trim();

			Rq rq = new Rq(command);

			if (rq.isValid() == false) {
				System.out.printf("명령어가 올바르지 않습니다.\n");
				continue;
			}

			Controller controller = getControllerByRequestUri(rq);

			controller.performAction(rq);

			if (rq.getActionPath().equals("/usr/system/exit")) {
				break;
			}
		}

		System.out.println("== 텍스트 게시판 끝 ==");
	}

	private Controller getControllerByRequestUri(Rq rq) {
		switch (rq.getControllerTypeCode()) {
		case "usr":
			switch (rq.getControllerName()) {
			case "article":
				return Container.getUsrArticleController();
			case "member":
				return Container.getUsrMemberController();
			case "system":
				return Container.getUsrSystemController();
			}

			break;
		}

		return null;
	}

}
