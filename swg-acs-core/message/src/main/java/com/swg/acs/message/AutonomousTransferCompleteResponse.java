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
public class AutonomousTransferCompleteResponse extends CwmpMessage{

	private static final long serialVersionUID = 8698719035003093834L;
	
	public AutonomousTransferCompleteResponse() {
		super("AutonomousTransferCompleteResponse");
	}

	@Override
	protected void configureBody(MessageBody bodyPart,
			ArgumentFactory argumentFactory) {
	}

	@Override
	protected void configureParse(MessageBody messageBody) {
	
	}

}
