package com.kerenedu.app;

import javax.ws.rs.core.HttpHeaders;

import com.google.gson.Gson;

public class BuilderHttpHeaders {
	
	public static synchronized long getidUsers(HttpHeaders header){
		Gson gson = new Gson();
		long id = gson.fromJson(header.getRequestHeader("userid").get(0), Long.class);
		return id;
		
	}

}
