package com.sbs.exam.app;

import java.util.Scanner;

public class App {
	public static void run() {
		System.out.println("== 텍스트 게시판 시작 ==");

		Scanner sc = new java.util.Scanner(System.in);

		while (true) {
			System.out.printf("명령어) ");

			String command = sc.nextLine().trim();

			if (command.equals("/usr/system/exit")) {
				System.out.println("프로그램을 종료 합니다.");
				break;
			}
		}

		System.out.println("== 텍스트 게시판 끝 ==");
	}

}
