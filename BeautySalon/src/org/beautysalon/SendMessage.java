package org.beautysalon;

import java.io.Serializable;

public class SendMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;	//用户名
	private int type;		//请求类型		1:用户登陆	2:得到美容功能列表 3：得到美发功能列表 4:得到发型具体信息
	private int id;		//用户,发型，美容等id
	private float score;	//评分
	private String password;	//用户密码
	private UserInfo userInfo;	//用户详细信息
	
	public SendMessage(int type) {
		this.type = type;
		this.password = null;
		this.userInfo = null;
	}
	
	public SendMessage(int type, int id) {
		this.type = type;
		this.id = id;
		this.userInfo = null;
	}
	
	public  SendMessage(int type, String email, String password) {
		this.type = type;
		this.email = email;
		this.password = password;
		this.userInfo = null;
	}
	
	public  SendMessage(int type, String email, String password, UserInfo userInfo) {
		this.type = type;
		this.email = email;
		this.password = password;
		this.userInfo = null;
		this.userInfo = userInfo;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}	
	
	
}
