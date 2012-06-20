/**
 * 
 */
package com.swg.acs.message.struct;

/**
 * @author satriaprayoga
 *
 */
public class DeviceIdStruct {

	private String manufacturer;
	private String oui;
	private String productClass;
	private String serialNumber;
	
	public DeviceIdStruct(String manufacturer,String oui,String productClass,String serialNumber) {
		this.manufacturer=manufacturer;
		this.oui=oui;
		this.productClass=productClass;
		this.serialNumber=serialNumber;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getOui() {
		return oui;
	}

	public String getProductClass() {
		return productClass;
	}

	public String getSerialNumber() {
		return serialNumber;
	}
	
	
	
}
