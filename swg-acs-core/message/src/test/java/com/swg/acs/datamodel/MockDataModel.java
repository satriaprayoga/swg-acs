package com.swg.acs.datamodel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.swg.acs.message.datamodel.DataModel;

public class MockDataModel {

	
	
	static String regex="((\\w*|\\d*)?\\.{1})";
	static Pattern pattern=Pattern.compile(regex);
	
	@Test
	public void testDataModel(){
		DataModel model=new DataModel();
		model.append("Device.");
		model.append("DeviceInfo.");
		model.append("ManagementServer.");
		System.out.println(model.getFullDesc());
	}
	
	@Test
	public void testBikinDataModel(){
		String input="InternetServiceGateway.ManagementServer.URL.WANDeviceSetting.";
		Matcher matcher=pattern.matcher(input);
		DataModel model=new DataModel();
		while(matcher.find()){
			model.append(matcher.group(0));
		}
		System.out.println(model.getFullDesc());
	}
	
}
