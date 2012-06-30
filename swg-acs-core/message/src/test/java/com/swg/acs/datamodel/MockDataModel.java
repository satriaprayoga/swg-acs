package com.swg.acs.datamodel;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.swg.acs.message.datamodel.CwmpDataModel;
import com.swg.acs.message.datamodel.DataModel;

public class MockDataModel {

	static Logger logger=Logger.getLogger(MockDataModel.class);
	
	static String regex="((\\w*|\\d*)?\\.{1})";
	static Pattern pattern=Pattern.compile(regex);
	
	@Test 
	public void testDeviceDataModel(){
		DataModel dataModel=CwmpDataModel.DEVICE;
		logger.info(dataModel.getRootName());
		logger.info(dataModel.isEmpty());
		dataModel.append("ManagemenServer.");
		logger.info(dataModel.getFullDesc());
		logger.info(dataModel.isEmpty());
		dataModel.append("URL.");
		logger.info(dataModel.getFullDesc());
		
		DataModel dataModel2=CwmpDataModel.INT_GATEWAY_DEVICE;
		logger.info(dataModel2.getRootName());
		logger.info(dataModel2.isEmpty());
		dataModel2.append("ManagemenServer.");
		logger.info(dataModel2.getFullDesc());
		logger.info(dataModel2.isEmpty());
		dataModel2.append("URL.");
		logger.info(dataModel2.getFullDesc());
	}
}
