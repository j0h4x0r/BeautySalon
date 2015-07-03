package org.beautysalon;

import java.io.Serializable;

public class SendMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;	//�û���
	private int type;		//��������		1:�û���½	2:�õ����ݹ����б� 3���õ����������б� 4:�õ����;�����Ϣ
	private int id;		//�û�,���ͣ����ݵ�id
	private float score;	//����
	private String password;	//�û�����
	private UserInfo userInfo;	//�û���ϸ��Ϣ
	
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
