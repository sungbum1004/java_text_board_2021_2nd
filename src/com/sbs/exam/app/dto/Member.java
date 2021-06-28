package com.sbs.exam.app.dto;

import lombok.Data;

@Data
public class Member {
	private String regDate;
	private int id;
	private String updateDate;
	private String loginId;
	private String loginPw;
	private String name;
	private String nickname;
}
