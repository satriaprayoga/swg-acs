/**
 * 
 */
package com.swg.acs.message.datamodel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * @author satriaprayoga
 *
 */
public abstract class DataModelUtil {
	
	static String regex="\\G((([A-Za-z0-9]+)|(\\[[A-Za-z0-9]+]))?\\.*)";//"((\\w*|\\d*)?\\.{1})";
	static Pattern pattern=Pattern.compile(regex);
	
	static Logger logger=Logger.getLogger(DataModelUtil.class);

	private DataModelUtil(){}
	
	public static DataModel parseFromInput(String input)throws DataModelException{
		DataModel model=null;
		if(input.startsWith("Device."))
			model=new DeviceDataModel();
		else if(input.startsWith("InternetGatewayDevice.")){
			model=new InternetGatewayDeviceDataModel();
		}else{
			throw new DataModelException("Invalid root Name");
		}
		parse(model, input);
		return model;
	}
	
	private static String parse(DataModel model,String input){
		String rootName=model.getRootName();
		input=input.replace(rootName, "").trim();
		Matcher matcher=pattern.matcher(input);
		while(matcher.find()){
			String parsed=matcher.group().trim();
			if(!parsed.trim().isEmpty()){
				logger.info("parse: "+parsed);
				model.append(parsed);
			}
		}
		return input;
	}
	
	
}
