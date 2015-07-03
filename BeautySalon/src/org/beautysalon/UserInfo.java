package org.beautysalon;

import java.io.Serializable;


public class UserInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private String userName;
	private String birthday;
	private String registTime;
	private String phoneNum;
	private String address;
	private String staff;		//特定对应咨询人员姓名
	
	public UserInfo() {
		;
	}
	
	public UserInfo(int userId, String userName, String birthday, 
			String registTime, String phoneNum, String address, String staff) {
		this.userId = userId;
		this.userName = userName;
		this.birthday = birthday;
		this.registTime = registTime;
		this.phoneNum = phoneNum;
		this.address = address;
		this.staff = staff;		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getRegistTime() {
		return registTime;
	}

	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}
		
}
