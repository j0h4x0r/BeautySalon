package org.beautysalon;

import java.io.Serializable;


public class FaceInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String faceProfile;	//���ͼ��
	private int price;			//���ͼ۸�
	private float score;			//��������
	private int selfScore;		//���˵�����
	
	public FaceInfo(int id) {
		this.id = id;
	}
	
	public FaceInfo(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFaceProfile() {
		return faceProfile;
	}

	public void setFaceProfile(String faceProfile) {
		this.faceProfile = faceProfile;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public int getSelfScore() {
		return selfScore;
	}

	public void setSelfScore(int selfScore) {
		this.selfScore = selfScore;
	}
}
