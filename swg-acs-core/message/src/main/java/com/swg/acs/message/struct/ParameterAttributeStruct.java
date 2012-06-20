/**
 * 
 */
package com.swg.acs.message.struct;

import java.util.ArrayList;
import java.util.List;

/**
 * @author satriaprayoga
 *
 */
public class ParameterAttributeStruct {

	private String name;
	private int notification;
	private List<String> accessList;
	
	public ParameterAttributeStruct() {
		accessList=new ArrayList<String>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNotification() {
		return notification;
	}
	public void setNotification(int notification) {
		this.notification = notification;
	}
	public List<String> getAccessList() {
		return accessList;
	}
	public void setAccessList(List<String> accessList) {
		this.accessList = accessList;
	}
	public void addAccessList(String acl){
		accessList.add(acl);
	}
	
	
}
