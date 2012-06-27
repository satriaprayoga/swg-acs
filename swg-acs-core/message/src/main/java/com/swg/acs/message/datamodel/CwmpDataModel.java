/**
 * 
 */
package com.swg.acs.message.datamodel;

/**
 * @author satriaprayoga
 *
 */
public class CwmpDataModel implements DataModel{
	private static final long serialVersionUID = 2088990895608921720L;
	
	private Object value;
	private DataModel root;
	private String name;
	
	public CwmpDataModel(String name,Object value) {
		this(name,value,null);
	}
	
	public CwmpDataModel(String name,Object value,DataModel root) {
		this.name=name;
		this.value=value;
		this.root=root;
	}

	@Override
	public DataModel getRoot() throws DataModelException {
		return root;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Class<?> getType() {
		return value.getClass();
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public boolean isNumberIdentifier() {
		return (Integer.class.isAssignableFrom(value.getClass()));
	}

	@Override
	public boolean isAliasIdentifier() {
		return (String.class.isAssignableFrom(value.getClass()));
	}

}
