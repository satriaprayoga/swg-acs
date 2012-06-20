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
import com.swg.acs.message.struct.ParameterValueStruct;

/**
 * @author satriaprayoga
 *
 */
public class GetParameterValuesResponse extends CwmpMessage{
	private static final long serialVersionUID = 6214746844106518712L;
	
	private List<ParameterValueStruct> parameterValueStructs;
	
	public GetParameterValuesResponse() {
		super("GetParameterValuesResponse");
		parameterValueStructs=new ArrayList<ParameterValueStruct>();
	}

	@Override
	protected void configureBody(MessageBody bodyPart,
			ArgumentFactory argumentFactory) {
		
	}

	@Override
	protected void configureParse(MessageBody messageBody) {
		MessageArgument argument=messageBody.getChild("ParameterList");
		Iterator<MessageArgument> iterator=argument.childIterator();
		while(iterator.hasNext()){
			MessageArgument paramStruct=iterator.next();
			MessageArgument name=paramStruct.getChild("Name");
			MessageArgument value=paramStruct.getChild("value");
			
			ParameterValueStruct struct=new ParameterValueStruct(name.getValue(), (value==null?"":value.getValue()));
			parameterValueStructs.add(struct);
		}
	}
	
	public List<ParameterValueStruct> getParameterValueStructs() {
		return parameterValueStructs;
	}

}
