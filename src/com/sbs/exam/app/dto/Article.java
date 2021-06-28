package com.sbs.exam.app.dto;

import lombok.Data;

@Data
public class Article extends Object {
	private int id;
	private String regDate;
	private String updateDate;
	private String title;
	private String body;
}
