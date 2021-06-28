package com.sbs.exam.app.container;

import java.util.Scanner;

public class Container {
	private static Scanner sc;
	
	static {
		sc = new Scanner(System.in);
	}
	
	public static Scanner getSc() {
		return sc;
	}
}
