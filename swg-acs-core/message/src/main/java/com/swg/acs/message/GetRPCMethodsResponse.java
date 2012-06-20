/**
 * 
 */
package com.swg.acs.message;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.swg.acs.Argument;
import com.swg.acs.MessageArgument;
import com.swg.acs.MessageBody;
import com.swg.acs.message.cwmp.ArgumentFactory;
import com.swg.acs.message.cwmp.CwmpMessage;

/**
 * @author satriaprayoga
 *
 */
public class GetRPCMethodsResponse extends CwmpMessage{
	private static final long serialVersionUID = -7537081218409233910L;
	
	private List<String> methods;
	
	
	public GetRPCMethodsResponse() {
		super("GetRPCMethodsResponse");
		methods=new ArrayList<String>();
		methods.add("Inform");
		methods.add("GetRPCMethods");
		methods.add("TransferComplete");
	}

	@Override
	protected void configureBody(MessageBody bodyPart,
			ArgumentFactory argumentFactory) {
		MessageArgument argument=bodyPart.addMessageArgument(argumentFactory.createMessageArgument("MethodList"));
		argument.setAttribute(SOAP_ARRAY_TYPE, XSD_STRING+"["+methods.size()+"]");
		for(String s:methods){
			argument.addMessageArgument(argumentFactory.createMessageArgument("string")).setValue(s);
		}
	}
	
	@Override
	protected void configureParse(MessageBody messageBody) {
		MessageArgument argument=messageBody.getChild("MethodList");
		Iterator<MessageArgument> args=argument.childIterator();
		methods=new ArrayList<String>();
		while(args.hasNext()){
			Argument a=args.next();
			methods.add(a.getValue());
		}
	}
	
	public List<String> getMethods() {
		return methods;
	}

}
