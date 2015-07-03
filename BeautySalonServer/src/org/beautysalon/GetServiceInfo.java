package org.beautysalon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class GetServiceInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> serviceList;
	private List<Integer> serviceIdList;
	
	public GetServiceInfo() {
		serviceList = new ArrayList<String>();
		serviceIdList = new ArrayList<Integer>();
	}
	
//	public GetServiceInfo(List<String> serviceList, List<Integer> serviceIdList) {
//		this.serviceList = serviceList;
//		this.serviceIdList = serviceIdList;
//	}
	
	public List<String> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<String> serviceList) {
		this.serviceList = serviceList;
	}

	public List<Integer> getServiceIdList() {
		return serviceIdList;
	}

	public void setServiceIdList(List<Integer> serviceIdList) {
		this.serviceIdList = serviceIdList;
	}

	/*
	 * 增加一组数据
	 */
	public boolean addServiceList(String service, int serviceId) {
		if (serviceList == null) {
			serviceList = new ArrayList<String>();
			serviceList.add(service);
			serviceIdList = new ArrayList<Integer>();
			serviceIdList.add(serviceId);
			return true;
		} else {
			serviceList.add(service);
			serviceIdList.add(serviceId);
			return true;
		}
	}
	
}
