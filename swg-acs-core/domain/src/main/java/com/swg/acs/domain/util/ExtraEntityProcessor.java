/**
 * 
 */
package com.swg.acs.domain.util;

import java.util.List;

import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor;

/**
 * @author satriaprayoga
 *
 */
public class ExtraEntityProcessor implements PersistenceUnitPostProcessor{
	
	private List<String> entityClassNames;

	@Override
	public void postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo arg0) {
		for(String entityName:entityClassNames){
			arg0.addManagedClassName(entityName);
		}
	}
	
	public void setEntityClassNames(List<String> entityClassNames) {
		this.entityClassNames = entityClassNames;
	}
	
	public List<String> getEntityClassNames() {
		return entityClassNames;
	}

}
