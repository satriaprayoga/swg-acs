package com.swg.acs.datamodel;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.swg.acs.message.datamodel.DataModel;
import com.swg.acs.message.datamodel.DataModelUtil;

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
}
