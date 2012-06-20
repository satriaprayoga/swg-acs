/**
 * 
 */
package com.swg.acs;

import java.util.Map;

/**
 * @author satriaprayoga
 *
 */
public interface MessageEnvelope {

	void addNamespace(String name,String value);
	Map<String,String> getNamespaceMap();
	String getNamespaceValue(String name);
}
