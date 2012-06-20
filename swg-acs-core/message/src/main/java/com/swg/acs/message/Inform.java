/**
 * 
 */
package com.swg.acs.message;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.swg.acs.MessageArgument;
import com.swg.acs.MessageBody;
import com.swg.acs.message.cwmp.ArgumentFactory;
import com.swg.acs.message.cwmp.CwmpMessage;
import com.swg.acs.message.struct.DeviceIdStruct;
import com.swg.acs.message.struct.EventStruct;
import com.swg.acs.message.struct.ParameterValueStruct;

/**
 * @author satriaprayoga
 *
 */
public class Inform extends CwmpMessage {

	private static final long serialVersionUID = -5714051071391056821L;
	
	private List<EventStruct> eventStructs;
	private List<ParameterValueStruct> parameterValueStructs;
	private DeviceIdStruct deviceIdStruct;
	
	private int maxEnvelopes=1;
	private String currentTime;
	private int retryCount;
	
	public Inform() {
		super("Inform");
		eventStructs=new ArrayList<EventStruct>();
		parameterValueStructs=new ArrayList<ParameterValueStruct>();
	}

	/* (non-Javadoc)
	 * @see com.swg.acs.Message#configureBody(com.swg.acs.MessageBody, com.swg.acs.message.cwmp.ArgumentFactory)
	 */
	@Override
	protected void configureBody(MessageBody bodyPart,
			ArgumentFactory argumentFactory) {
		
	}

	/* (non-Javadoc)
	 * @see com.swg.acs.Message#configureParse(com.swg.acs.MessageBody)
	 */
	@Override
	protected void configureParse(MessageBody messageBody) {
		configureDeviceId(messageBody);
		configureEvent(messageBody);
		maxEnvelopes=Integer.parseInt(messageBody.getChild("MaxEnvelopes").getValue());
		currentTime=messageBody.getChild("CurrentTime").getValue();
		retryCount=Integer.parseInt(messageBody.getChild("RetryCount").getValue());
		configureParameterValueStruct(messageBody);
	}
	
	private void configureDeviceId(MessageArgument argument){
		MessageArgument deviceArg=argument.getChild("DeviceId");
		String manufacturer=deviceArg.getChild("Manufacturer").getValue();
		String oui=deviceArg.getChild("OUI").getValue();
		String productClass=deviceArg.getChild("ProductClass").getValue();
		String serialNumber=deviceArg.getChild("SerialNumber").getValue();
		deviceIdStruct=new DeviceIdStruct(manufacturer, oui, productClass, serialNumber);
	}
	
	private void configureEvent(MessageArgument argument){
		MessageArgument eventArg=argument.getChild("Event");
		Iterator<MessageArgument> iterator=eventArg.childIterator();
		while(iterator.hasNext()){
			MessageArgument event=iterator.next();
			String eventCode=event.getChild("EventCode").getValue();
			String commandKey=event.getChild("CommandKey").getValue();
			EventStruct eventStruct=new EventStruct(eventCode, commandKey);
			eventStructs.add(eventStruct);
		}
	}
	
	private void configureParameterValueStruct(MessageArgument arg){
		MessageArgument argument=arg.getChild("ParameterList");
		Iterator<MessageArgument> iterator=argument.childIterator();
		while(iterator.hasNext()){
			MessageArgument paramStruct=iterator.next();
			MessageArgument name=paramStruct.getChild("Name");
			MessageArgument value=paramStruct.getChild("value");
			
			ParameterValueStruct struct=new ParameterValueStruct(name.getValue(), (value==null?"":value.getValue()));
			parameterValueStructs.add(struct);
		}
	}

	public List<EventStruct> getEventStructs() {
		return eventStructs;
	}

	public List<ParameterValueStruct> getParameterValueStructs() {
		return parameterValueStructs;
	}

	public DeviceIdStruct getDeviceIdStruct() {
		return deviceIdStruct;
	}

	public int getMaxEnvelopes() {
		return maxEnvelopes;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public int getRetryCount() {
		return retryCount;
	}
	
	

}
