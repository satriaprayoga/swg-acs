/**
 * 
 */
package com.swg.acs.message.datamodel;


/**
 * @author satriaprayoga
 *
 */
public abstract class CwmpDataModel implements DataModel{
	private static final long serialVersionUID = -181110367139226483L;
	
	protected DataModelItem head=null;
	protected DataModelItem tail=null;
	
	private final String rootName;
	
	public CwmpDataModel() {
		this(null);
	}
	
	public CwmpDataModel(String rootName) {
		this.rootName=rootName;
	}
	
	
	
	@Override
	public void append(String identifier) {
		DataModelItem item=new DataModelItem(identifier);
		if(head==null){
			head=tail=item;
		}else{
			tail.next=item;
			tail=item;
		}
		
	}
	
	@Override
	public String getRootName() {
		return rootName;
	}
	
	@Override
	public void setValue(String value) {
		tail.value=value;
	}
	
	@Override
	public Object getValue() {
		return tail.value;
	}
	
	@Override
	public boolean isPartialPath() {
		String lastValue=(String) tail.value;
		return lastValue.endsWith(".");
	}
	
	@Override
	public boolean isEmpty() {
		return (head==null);
	}
	
	@Override
	public String getFullDesc() {
		StringBuilder builder=new StringBuilder();
		DataModelItem item=head;
		while(item!=null){
			builder.append(item.value);
			item=item.next;
		}
		return builder.toString();
	}
	
	
	
}
