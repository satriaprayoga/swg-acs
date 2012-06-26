/**
 * 
 */
package com.swg.acs.message.datamodel;

import java.io.Serializable;

/**
 * @author satriaprayoga
 *
 */
public interface DataModel extends Serializable {

	public DataModel getRoot() throws DataModelException;
	public String getName();
	public Class<?> getType();
	public Object getValue();
	public boolean isNumberIdentifier();
	public boolean isAliasIdentifier();
}
