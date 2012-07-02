package com.swg.acs.datamodel;

import java.util.regex.Pattern;

import javax.xml.soap.SOAPMessage;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.swg.acs.Message;
import com.swg.acs.message.GetRPCMethods;
import com.swg.acs.message.datamodel.DataModel;
import com.swg.acs.message.datamodel.DataModelUtil;
import com.swg.acs.message.soap.CwmpMessageBuilder;
import com.swg.acs.message.soap.SoapMessageBuilder;

public class MockDataModel {
	
	

	static Logger logger=Logger.getLogger(MockDataModel.class);
	
	static String regex="(((.*)?\\.{1})|(\\[.*?\\.{1}]))";
	static Pattern pattern=Pattern.compile(regex);
	
	@Test 
	public void testDeviceDataModel(){
		String input="InternetGatewayDevice.DeviceInfo.WANSettings";
		DataModel dataModel=DataModelUtil.parseFromInput(input);
		logger.info("full: "+dataModel.getFullDesc());
		logger.info("value: "+dataModel.getValue().toString());
		logger.info("is partial path: "+dataModel.isPartialPath());
	}
	
	@Test
	public void testRequest()throws Exception{
		Message message=new GetRPCMethods();
		SoapMessageBuilder builder=CwmpMessageBuilder.getSoapMessageBuilderInstance();
		SOAPMessage soapMessage=builder.build(message);
		soapMessage.writeTo(System.out);
	}
}
