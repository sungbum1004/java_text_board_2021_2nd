package com.sbs.exam.app;

public class Rq {
	private String command;
	private String controllerTypeName;
	private String controllerName;
	private String actionMethodName;
	private String queryString = "";
	public boolean isValid = true;

	public Rq(String command) {
		this.command = command;
		
		String[] commandBits = command.split("\\?", 2);
		
		if ( commandBits.length == 2 ) {
			queryString = commandBits[1];
		}
		
		commandBits = commandBits[0].split("/", 4);
		
		if ( commandBits.length != 4 ) {
			isValid = false;
			return;
		}
		
		controllerTypeName = commandBits[1];
		controllerName = commandBits[2];
		actionMethodName = commandBits[3];
	}

	public Object getActionPath() {
		return "/" + controllerTypeName + "/" + controllerName + "/" + actionMethodName;
	}

}
