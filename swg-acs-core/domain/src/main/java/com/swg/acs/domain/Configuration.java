package com.swg.acs.domain;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 * @author Puradidjaja
 *
 */

@Entity
public class Configuration implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private int hwId;
	
	private String name;
	
	@Lob
	private byte[] config;

	private String fileName;
	
	private String version;
	
	@ManyToOne(targetEntity=com.swg.acs.domain.HardwareModel.class)
	private HardwareModel hardwareModel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getHwId() {
		return hwId;
	}

	public void setHwId(int hwId) {
		this.hwId = hwId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getConfig() {
		return config;
	}

	public void setConfig(byte[] config) {
		this.config = config;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public HardwareModel getHardwareModel() {
		return hardwareModel;
	}

	public void setHardwareModel(HardwareModel hardwareModel) {
		this.hardwareModel = hardwareModel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(config);
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + hwId;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Configuration other = (Configuration) obj;
		if (!Arrays.equals(config, other.config))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (hwId != other.hwId)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		return "Configuration [id=" + id + ", hwId=" + hwId + ", name=" + name
				+ ", config=" + Arrays.toString(config) + ", fileName="
				+ fileName + ", version=" + version + "]";
	}

}
