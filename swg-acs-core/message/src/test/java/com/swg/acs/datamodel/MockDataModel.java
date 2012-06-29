package com.swg.acs.datamodel;

import org.junit.Test;

import com.swg.acs.message.datamodel.DataModel;

public class MockDataModel {

	private MockDataModel root;
	private Object value;
	private String label;
	
	public void setRoot(MockDataModel root) {
		this.root = root;
	}
	
	public boolean isRoot(){
		return (root==null);
	}
	
	public MockDataModel getRoot() {
		return root;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	public Object getValue() {
		return value;
	}
	
	public boolean isNumberIdentifier(){
		return (Number.class.isAssignableFrom(value.getClass()));
	}
	
	public boolean isAliasIdentifier(){
		return (String.class.isAssignableFrom(value.getClass()));
	}
	
	public Class<?> getType(){
		return value.getClass();
	}
	
	@Test
	public void testDataModel(){
		DataModel dataModel=new DataModel();
		dataModel.append("Device.");
		dataModel.append("ManagementServer.");
		System.out.println(dataModel.getFullDesc());
	}
	
	
	
	@Test
	public void testBikinDataModel(){
		
	}
	
}
