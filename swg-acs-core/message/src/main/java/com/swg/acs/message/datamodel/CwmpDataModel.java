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
	
	public static final DataModel DEVICE=new DeviceDataModel();
	public static final DataModel INT_GATEWAY_DEVICE=new InternetGatewayDeviceDataModel();
	
	protected DataModelItem head=null;
	protected DataModelItem tail=null;
	
	private final String rootName;
	private Object value;
	
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
		this.value=value;
	}
	
	@Override
	public Object getValue() {
		return value;
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
	
	private static class DeviceDataModel extends CwmpDataModel{
		private static final long serialVersionUID = 2425395936345743279L;

		public DeviceDataModel() {
			super("Device.");
			append("Device.");
		}

		
		
	}
	
	private static class InternetGatewayDeviceDataModel extends CwmpDataModel{
		private static final long serialVersionUID = -5401657523825827822L;

		public InternetGatewayDeviceDataModel() {
			super("InternetGatewayDevice.");
			append("InternetGatewayDevice.");
		}

		
		
	}

}
