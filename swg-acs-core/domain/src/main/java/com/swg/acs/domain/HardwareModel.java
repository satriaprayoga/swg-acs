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
public class HardwareModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String oui;
	
	private String hClass;
	
	private String displayName;
	
	private String manufacture;
	
	private String version;
	
	@OneToMany(mappedBy="hardwareModel", cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<Host> hosts = new ArrayList<Host>();
	
	@OneToMany(mappedBy="hardwareModel", cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<Configuration> configurations = new ArrayList<Configuration>();
	
	@OneToMany(mappedBy="hardwareModel", cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<Software> softwares = new ArrayList<Software>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOui() {
		return oui;
	}

	public void setOui(String oui) {
		this.oui = oui;
	}

	public String gethClass() {
		return hClass;
	}

	public void sethClass(String hClass) {
		this.hClass = hClass;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Host> getHosts() {
		return hosts;
	}

	public void setHosts(List<Host> hosts) {
		this.hosts = hosts;
	}

	public List<Configuration> getConfigurations() {
		return configurations;
	}

	public void setConfigurations(List<Configuration> configurations) {
		this.configurations = configurations;
	}

	public List<Software> getSoftwares() {
		return softwares;
	}

	public void setSoftwares(List<Software> softwares) {
		this.softwares = softwares;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + ((hClass == null) ? 0 : hClass.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((manufacture == null) ? 0 : manufacture.hashCode());
		result = prime * result + ((oui == null) ? 0 : oui.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		HardwareModel other = (HardwareModel) obj;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (hClass == null) {
			if (other.hClass != null)
				return false;
		} else if (!hClass.equals(other.hClass))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (manufacture == null) {
			if (other.manufacture != null)
				return false;
		} else if (!manufacture.equals(other.manufacture))
			return false;
		if (oui == null) {
			if (other.oui != null)
				return false;
		} else if (!oui.equals(other.oui))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HardwareModel [id=" + id + ", oui=" + oui + ", hClass="
				+ hClass + ", displayName=" + displayName + ", manufacture="
				+ manufacture + ", version=" + version + "]";
	}

}
