/**
 * 
 */
package com.swg.acs.domain.util;

/**
 * @author satriaprayoga
 *
 */
public class StringCpeParam implements CpeParam<String>{
	
	private final String paramValue;
	
	private final String paramName;
	
	public StringCpeParam(String paramName,String paramValue) {
		this.paramName=paramName;
		this.paramValue=paramValue;
	}

	@Override
	public String getParamName() {
		return paramName;
	}

	@Override
	public String getParamValue() {
		return paramValue;
	}

	@Override
	public Class<String> getParamClass() {
		return String.class;
	}

	@Override
	public String toString() {
		return "StringCpeParam [paramValue=" + paramValue + ", paramName="
				+ paramName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((paramName == null) ? 0 : paramName.hashCode());
		result = prime * result
				+ ((paramValue == null) ? 0 : paramValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StringCpeParam other = (StringCpeParam) obj;
		if (paramName == null) {
			if (other.paramName != null)
				return false;
		} else if (!paramName.equals(other.paramName))
			return false;
		if (paramValue == null) {
			if (other.paramValue != null)
				return false;
		} else if (!paramValue.equals(other.paramValue))
			return false;
		return true;
	}
	
	

}
