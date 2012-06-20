/**
 * 
 */
package com.swg.acs.domain.util;

/**
 * @author satriaprayoga
 *
 */
public interface CpeParam<E> {

	String getParamName();
	E getParamValue();
	Class<E> getParamClass();
	
}
