package org.beautysalon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecordInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;			//”√ªßid
	List<String> recordTimeAList;
	List<Integer> recordPriceAlList;
	List<String> recordServiceAlList;
	List<String> recordStaffAList;
	
	
	public RecordInfo(int id) {
		this.id = id;
	}
	
	public RecordInfo(int id, List<String> recordTimeAList, List<Integer> recordPriceAlList,
			List<String> recordServiceAlList,  List<String> recordStaffAList) {
		this.id = id;
		this.recordPriceAlList = recordPriceAlList;
		this.recordServiceAlList = recordServiceAlList;
		this.recordStaffAList = recordStaffAList;
		this.recordTimeAList = recordTimeAList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<String> getRecordTimeAList() {
		return recordTimeAList;
	}

	public void setRecordTimeAList(List<String> recordTimeAList) {
		this.recordTimeAList = recordTimeAList;
	}

	public List<Integer> getRecordPriceAlList() {
		return recordPriceAlList;
	}

	public void setRecordPriceAlList(List<Integer> recordPriceAlList) {
		this.recordPriceAlList = recordPriceAlList;
	}

	public List<String> getRecordServiceAlList() {
		return recordServiceAlList;
	}

	public void setRecordServiceAlList(List<String> recordServiceAlList) {
		this.recordServiceAlList = recordServiceAlList;
	}

	public List<String> getRecordStaffAList() {
		return recordStaffAList;
	}

	public void setRecordStaffAList(List<String> recordStaffAList) {
		this.recordStaffAList = recordStaffAList;
	}
	
	public void addRecord(int price, String time, String service, String staff) {
		if (recordPriceAlList == null) {
			this.recordPriceAlList = new ArrayList<Integer>();
			this.recordServiceAlList = new ArrayList<String>();
			this.recordStaffAList = new ArrayList<String>();
			this.recordTimeAList = new ArrayList<String>();
		}
		this.recordPriceAlList.add(price);
		this.recordServiceAlList.add(service);
		this.recordStaffAList.add(staff);
		this.recordTimeAList.add(time);
	}
	
}
