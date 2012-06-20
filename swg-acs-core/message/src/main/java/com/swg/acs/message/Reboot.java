/**
 * 
 */
package com.swg.acs.message;

import com.swg.acs.MessageBody;
import com.swg.acs.message.cwmp.ArgumentFactory;
import com.swg.acs.message.cwmp.CwmpMessage;

/**
 * @author satriaprayoga
 *
 */
public class Reboot extends CwmpMessage{
	private static final long serialVersionUID = 7202338234676217963L;
	
	private String commandKey;
	
	public Reboot() {
		super("Reboot");
	}
	
	public Reboot(String commandKey){
		this();
		this.commandKey=commandKey;
	}

	@Override
	protected void configureBody(MessageBody bodyPart,
			ArgumentFactory argumentFactory) {
		bodyPart.addMessageArgument(argumentFactory.createMessageArgument("CommandKey")).setValue(commandKey);
	}

	@Override
	protected void configureParse(MessageBody messageBody) {
		
	}
	
	public String getCommandKey() {
		return commandKey;
	}

}
