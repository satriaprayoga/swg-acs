/**
 * 
 */
package com.swg.acs;

/**
 * @author satriaprayoga
 *
 */
public interface MessageHeader extends MessageArgument{

	boolean isMustUnderstand();
	void setMustUnderstand(boolean mustUnderstand);
	long getSessionTimeOut();
	void setSessionTimeOut(long sessionTimeOut);
	boolean isHoldRequest();
	void setHoldRequest(boolean holdRequest);
}
