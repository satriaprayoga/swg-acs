package com.swg.acs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Puradidjaja
 *
 */

@Entity
public class DeviceProfile implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private int informInterval;
	
	private int daysKeepStats;
	
	private int saveStats;
	
	private int saveLog;
	
	private int saveParamValue;
	
	private int saveParamValuesInterval;
	
	private int saveParamValuesOnChange;
	
	private int saveParamValuesOnBoot;
	
	private String scriptName;
	
	private String baseProfile;	
	
	@OneToMany(mappedBy="deviceProfile",cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<ProfileProperty> profileProperties = new ArrayList<ProfileProperty>();
	
	@OneToMany(mappedBy="deviceProfile",cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<Host> hosts = new ArrayList<Host>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInformInterval() {
		return informInterval;
	}

	public void setInformInterval(int informInterval) {
		this.informInterval = informInterval;
	}

	public int getDaysKeepStats() {
		return daysKeepStats;
	}

	public void setDaysKeepStats(int daysKeepStats) {
		this.daysKeepStats = daysKeepStats;
	}

	public int getSaveStats() {
		return saveStats;
	}

	public void setSaveStats(int saveStats) {
		this.saveStats = saveStats;
	}

	public int getSaveLog() {
		return saveLog;
	}

	public void setSaveLog(int saveLog) {
		this.saveLog = saveLog;
	}

	public int getSaveParamValue() {
		return saveParamValue;
	}

	public void setSaveParamValue(int saveParamValue) {
		this.saveParamValue = saveParamValue;
	}

	public int getSaveParamValuesInterval() {
		return saveParamValuesInterval;
	}

	public void setSaveParamValuesInterval(int saveParamValuesInterval) {
		this.saveParamValuesInterval = saveParamValuesInterval;
	}

	public int getSaveParamValuesOnChange() {
		return saveParamValuesOnChange;
	}

	public void setSaveParamValuesOnChange(int saveParamValuesOnChange) {
		this.saveParamValuesOnChange = saveParamValuesOnChange;
	}

	public int getSaveParamValuesOnBoot() {
		return saveParamValuesOnBoot;
	}

	public void setSaveParamValuesOnBoot(int saveParamValuesOnBoot) {
		this.saveParamValuesOnBoot = saveParamValuesOnBoot;
	}

	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}

	public String getBaseProfile() {
		return baseProfile;
	}

	public void setBaseProfile(String baseProfile) {
		this.baseProfile = baseProfile;
	}

	public List<ProfileProperty> getProfileProperties() {
		return profileProperties;
	}

	public void setProfileProperties(List<ProfileProperty> profileProperties) {
		this.profileProperties = profileProperties;
	}

	public List<Host> getHosts() {
		return hosts;
	}

	public void setHosts(List<Host> hosts) {
		this.hosts = hosts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((baseProfile == null) ? 0 : baseProfile.hashCode());
		result = prime * result + daysKeepStats;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + informInterval;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + saveLog;
		result = prime * result + saveParamValue;
		result = prime * result + saveParamValuesInterval;
		result = prime * result + saveParamValuesOnBoot;
		result = prime * result + saveParamValuesOnChange;
		result = prime * result + saveStats;
		result = prime * result
				+ ((scriptName == null) ? 0 : scriptName.hashCode());
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
		DeviceProfile other = (DeviceProfile) obj;
		if (baseProfile == null) {
			if (other.baseProfile != null)
				return false;
		} else if (!baseProfile.equals(other.baseProfile))
			return false;
		if (daysKeepStats != other.daysKeepStats)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (informInterval != other.informInterval)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (saveLog != other.saveLog)
			return false;
		if (saveParamValue != other.saveParamValue)
			return false;
		if (saveParamValuesInterval != other.saveParamValuesInterval)
			return false;
		if (saveParamValuesOnBoot != other.saveParamValuesOnBoot)
			return false;
		if (saveParamValuesOnChange != other.saveParamValuesOnChange)
			return false;
		if (saveStats != other.saveStats)
			return false;
		if (scriptName == null) {
			if (other.scriptName != null)
				return false;
		} else if (!scriptName.equals(other.scriptName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DeviceProfile [id=" + id + ", name=" + name
				+ ", informInterval=" + informInterval + ", daysKeepStats="
				+ daysKeepStats + ", saveStats=" + saveStats + ", saveLog="
				+ saveLog + ", saveParamValue=" + saveParamValue
				+ ", saveParamValuesInterval=" + saveParamValuesInterval
				+ ", saveParamValuesOnChange=" + saveParamValuesOnChange
				+ ", saveParamValuesOnBoot=" + saveParamValuesOnBoot
				+ ", scriptName=" + scriptName + ", baseProfile=" + baseProfile
				+ "]";
	}
	
}
