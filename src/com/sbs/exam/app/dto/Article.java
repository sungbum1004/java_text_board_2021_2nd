package com.sbs.exam.app.dto;

public class Article extends Object {
	public int id;
	public String regDate;
	public String updateDate;
	public String title;
	public String body;

	@Override
	public String toString() {
		return "Article [id=" + id + ", regDate=" + regDate + ", updateDate=" + updateDate + ", title=" + title
				+ ", body=" + body + "]";
	}
}
