/**
 * 
 */
package com.swg.acs;

import java.util.Iterator;


/**
 * @author satriaprayoga
 *
 */
public interface MessageArgument extends Argument{

	MessageArgument addMessageArgument(MessageArgument argument);
	MessageArgument getChild(String name);
	Iterator<MessageArgument> childIterator();
}
