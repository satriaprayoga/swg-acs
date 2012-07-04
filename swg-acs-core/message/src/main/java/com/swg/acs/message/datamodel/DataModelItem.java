/**
 * 
 */
package com.swg.acs.message.datamodel;

/**
 * @author satriaprayoga
 *
 */
class DataModelItem {

	protected DataModelItem next;
	protected Object value;
	
	public DataModelItem() {
		this(null,null);
	}
	
	public DataModelItem(Object value) {
		this(null,value);
	}
	
	public DataModelItem(DataModelItem next,Object value) {
		this.next=next;
		this.value=value;
	}
}
