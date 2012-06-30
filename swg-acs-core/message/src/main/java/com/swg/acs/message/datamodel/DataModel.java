/**
 * 
 */
package com.swg.acs.message.datamodel;

import java.io.Serializable;

/**
 * @author satriaprayoga
 *
 */
public interface DataModel extends Serializable{

	String getRootName();
	
	void append(String identifier);
	
	boolean isEmpty();
	
	String getFullDesc();
	
	Object getValue();
	
	void setValue(String value);
	
	boolean isPartialPath();
}
