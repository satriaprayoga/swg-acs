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
public class SetParameterAttributeStruct {

	private String name;
	private boolean notificationChange;
	private int notification;
	private boolean accessListChange;
	private List<String> accessList;
	
	public SetParameterAttributeStruct() {
		accessList=new ArrayList<String>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isNotificationChange() {
		return notificationChange;
	}
	public void setNotificationChange(boolean notificationChange) {
		this.notificationChange = notificationChange;
	}
	public int getNotification() {
		return notification;
	}
	public void setNotification(int notification) {
		this.notification = notification;
	}
	
	public boolean isAccessListChange() {
		return accessListChange;
	}
	
	public void setAccessList(List<String> accessList) {
		this.accessList = accessList;
	}
	
	public List<String> getAccessList() {
		return accessList;
	}
	
	public void addAccessList(String acl){
		accessList.add(acl);
	}
	
}
