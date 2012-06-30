package com.swg.acs.datamodel;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.swg.acs.message.datamodel.CwmpDataModel;
import com.swg.acs.message.datamodel.DataModel;
import com.swg.acs.message.datamodel.DataModelUtil;

public class MockDataModel {
	
	class MockDeviceDataModel extends CwmpDataModel{

		private static final long serialVersionUID = 1L;
		
		public MockDeviceDataModel() {
			super();
		}
		
		@Override
		public boolean isPartialPath() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}

	static Logger logger=Logger.getLogger(MockDataModel.class);
	
	static String regex="(((.*)?\\.{1})|(\\[.*?\\.{1}]))";
	static Pattern pattern=Pattern.compile(regex);
	
	@Test 
	public void testDeviceDataModel(){
		String input="InternetGatewayDevice.DeviceInfo.WANSettings";
		DataModel dataModel=DataModelUtil.parseFromInput(input);
		System.out.println("full: "+dataModel.getFullDesc());
		System.out.println("value: "+dataModel.getValue().toString());
		System.out.println("is partial path: "+dataModel.isPartialPath());
	}
}
