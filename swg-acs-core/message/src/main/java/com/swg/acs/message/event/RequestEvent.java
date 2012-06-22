/**
 * 
 */
package com.swg.acs.message.event;

import java.util.EventObject;

import com.swg.acs.Message;

/**
 * @author satriaprayoga
 *
 */
public class RequestEvent extends EventObject{
	
	private Message message;

	private static final long serialVersionUID = 1L;

	public RequestEvent(Message source) {
		super(source);
	}
	
	public Message getMessage() {
		if(!getSource().equals(message))
			throw new IllegalArgumentException();
		return message;
	}
}
