/**
 * 
 */
package com.swg.acs.message.struct;

/**
 * @author satriaprayoga
 *
 */
public class EventStruct {

	private final String eventCode;
	private final String commandKey;
	
	public EventStruct(String eventCode,String commandKey) {
		this.eventCode=eventCode;
		this.commandKey=commandKey;
	}
	
	public String getEventCode() {
		return eventCode;
	}
	public String getCommandKey() {
		return commandKey;
	}
	
	
}
