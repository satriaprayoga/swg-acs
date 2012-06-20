package com.swg.acs.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 * @author Puradidjaja
 *
 */

@Entity
public class Software implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private int hwId;
	
	private String version;
	
	private String minVersion;
	
	private String url;
	
	private int size;
	
	private String fileName;
	
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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getMinVersion() {
		return minVersion;
	}

	public void setMinVersion(String minVersion) {
		this.minVersion = minVersion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + hwId;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((minVersion == null) ? 0 : minVersion.hashCode());
		result = prime * result + size;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Software other = (Software) obj;
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
		if (minVersion == null) {
			if (other.minVersion != null)
				return false;
		} else if (!minVersion.equals(other.minVersion))
			return false;
		if (size != other.size)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
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
		return "Software [id=" + id + ", hwId=" + hwId + ", version=" + version
				+ ", minVersion=" + minVersion + ", url=" + url + ", size="
				+ size + ", fileName=" + fileName + "]";
	}
	
	
}
