package com.tgb.model;

import java.util.List;

/**
 * 用户
 * @author liang
 *
 */
public class User {

	private int id;
	private int code;
	private String age;
	private String userName;
	List<Tool> toolList;
	public User(){
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public User(int id, String age, String userName) {
		super();
		this.id = id;
		this.age = age;
		this.userName = userName;
	}
	public List<Tool> getToolList() {
		return toolList;
	}
	public void setToolList(List<Tool> toolList) {
		this.toolList = toolList;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
	
}
