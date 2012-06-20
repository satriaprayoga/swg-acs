/**
 * 
 */
package com.swg.acs.message.struct;


/**
 * @author satriaprayoga
 *
 */
public class ParameterValueStruct{
	
	private final String name;
	private final String value;
	
	public ParameterValueStruct(String name,String value) {
		this.name=name;
		this.value=value;
	}
	
	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}


	@Override
	public String toString() {
		return "ParameterValueStruct [name=" + name + ", value=" + value
				+ "]";
	}
	
	
}
