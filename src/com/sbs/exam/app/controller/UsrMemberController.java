package com.sbs.exam.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sbs.exam.app.Rq;
import com.sbs.exam.app.container.Container;
import com.sbs.exam.app.dto.Member;
import com.sbs.exam.util.Util;

public class UsrMemberController {
	private List<Member> members;
	private int membersLastId;
	private Scanner sc;

	public UsrMemberController() {
		sc = Container.getSc();
		members = new ArrayList<>();
		membersLastId = 0;

		// 테스트 게시물 만들기
		makeTestData();
	}

	private void makeTestData() {
		for (int i = 0; i < 2; i++) {
			Member member = new Member();
			member.id = membersLastId + 1;
			member.regDate = Util.getNowDateStr();
			member.updateDate = Util.getNowDateStr();
			member.loginId = "user" + member.id;
			member.loginPw = member.loginId;
			member.name = "홍길동" + member.id;
			member.nickname = "강바랑" + member.id;

			members.add(member);
			membersLastId++;
		}
	}

	private Member getMemberByLoginId(String loginId) {
		for (Member member : members) {
			if (member.loginId.equals(loginId)) {
				return member;
			}
		}

		return null;
	}

	public void performAction(Rq rq) {
		if (rq.getActionPath().equals("/usr/member/login")) {
			actionLogin(rq);
		} else if (rq.getActionPath().equals("/usr/member/logout")) {
			actionLogout(rq);
		}
	}

	private void actionLogout(Rq rq) {
		// TODO Auto-generated method stub
	}

	private void actionLogin(Rq rq) {
		System.out.printf("로그인아이디 : ");
		String loginId = sc.nextLine().trim();

		if (loginId.length() == 0) {
			System.out.println("로그인아이디를 입력해주세요.");
			return;
		}

		Member member = getMemberByLoginId(loginId);

		if (member == null) {
			System.out.println("해당 회원은 존재하지 않습니다.");
			return;
		}

		System.out.printf("로그인비밀번호 : ");
		String loginPw = sc.nextLine().trim();

		if (loginId.length() == 0) {
			System.out.println("로그인비밀번호를 입력해주세요.");
			return;
		}

		if (member.loginPw.equals(loginPw) == false) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}

		rq.setSessionAttr("loginedMember", member);

		System.out.printf("%s님 환영합니다.\n", member.nickname);
	}
}
