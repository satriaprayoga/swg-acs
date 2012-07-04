/**
 * 
 */
package com.swg.acs.message.cwmp;

import com.swg.acs.Argument;
import com.swg.acs.MessageArgument;


/**
 * @author satriaprayoga
 *
 */
public abstract class ArgumentFactory {

	private static ArgumentFactory instance=null;
	
	public static ArgumentFactory getInstance() {
		if(instance==null)
			instance=new CwmpArgumentFactory();
		return instance;
	}
	
	public Argument createArgument(String name){
		return createArgument(name, null, null);
	}
	
	public Argument createArgument(String name,String prefix,String uri){
		Argument argument=new CwmpArgument(name, prefix, uri);
		return argument;
	}
	
	public abstract MessageArgument createMessageArgument(String name,String prefix,String uri);
	
	public MessageArgument createMessageArgument(String name){
		return createMessageArgument(name, null, null);
	}
	
	private static class CwmpArgumentFactory extends ArgumentFactory{
		public CwmpArgumentFactory() {
		}
		public MessageArgument createMessageArgument(String name,String prefix,String uri){
			return (MessageArgument) createArgument(name, prefix, uri);
		}
		
		
	}
}
