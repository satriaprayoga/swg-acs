/**
 * 
 */
package com.swg.acs;


/**
 * Interface buat mengolah element SOAP-XML
 * 
 * @author satriaprayoga
 *
 */
public interface Argument {

	/**
	 * setting attribute element
	 * @param name
	 * @param value
	 */
	void setAttribute(String name,String value);
	/**
	 * setting nilai dari element ini
	 * @param value
	 * @return
	 */
	Argument setValue(String value);
	/**
	 * ambil nilai dari element ini
	 * @return
	 */
	String getValue();
	/**
	 * ambil nilai dari attribute ini, dengan input nama attributnya
	 * @param name
	 * @return
	 */
	String getAttribute(String name);
	/**
	 * nilai nama atribut
	 * @return
	 */
	String getAttributeName();
	
	/**
	 * nama dari element ini
	 * @return
	 */
	String getName();
	/**
	 * URI dari element ini (coba baca lagi tentang SOAP)
	 * @return
	 */
	String getUri();
	/**
	 * prefix dari element ini, biasa xsi,xsd, atau userdefined prefix
	 * @return
	 */
	String getPrefix();
}
