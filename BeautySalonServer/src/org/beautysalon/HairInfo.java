package org.beautysalon;

import java.io.Serializable;

public class HairInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int hairId;			//����id
	private String hairName;	//��������
	private String hairProfile;	//���ͼ��
	private int price;			//���ͼ۸�
	private float score;			//��������
	private int selfScore;		//���˵�����
//	List<String> commentList;	//��������
	
	public HairInfo (int hairId) {
		this.hairId = hairId;
	}
	
	public HairInfo (int hairId, String hairName) {
		this.hairId = hairId;
		this.hairName = hairName;
	}

	public int getHairId() {
		return hairId;
	}

	public void setHairId(int hairId) {
		this.hairId = hairId;
	}

	public String getHairName() {
		return hairName;
	}

	public void setHairName(String hairName) {
		this.hairName = hairName;
	}

	public String getHairProfile() {
		return hairProfile;
	}

	public void setHairProfile(String hairProfile) {
		this.hairProfile = hairProfile;
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

	
//	public List<String> getCommentList() {
//		return commentList;
//	}
//
//	public void setCommentList(List<String> coment) {
//		this.commentList = coment;
//	}
//	
//	public void addComment(String s) {
//		if (this.commentList == null) {
//			this.commentList = new ArrayList<String>();
//			this.commentList.add(s);
//		} else {
//			this.commentList.add(s);
//		}
//	}
//	
//	public void cutComment(String s) {
//		for (int i = 0; i < this.commentList.size(); i++) {
//			if (s.equals( this.commentList.get(i))) {
//				this.commentList.remove(i);
//			}
//		}
//	}
	
	
}
