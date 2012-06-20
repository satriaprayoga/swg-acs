/**
 * 
 */
package com.swg.acs;


/**
 * @author satriaprayoga
 *
 */
public interface Argument {

	
	void setAttribute(String name,String value);
	boolean hasChild();
	Argument setValue(String value);
	String getValue();
	String getAttribute(String name);
	String getAttributeName();
	int childSize();
	String getName();
	String getUri();
	String getPrefix();
}
