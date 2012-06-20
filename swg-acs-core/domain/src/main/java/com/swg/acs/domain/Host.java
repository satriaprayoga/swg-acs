package com.swg.acs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Puradidjaja
 *
 */
@Entity
public class Host implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String customerId;
	
	private String userName;
	
	private String password;
	
	private int authType;
	
	private String profileName;
	
	private String conreqUser;
	
	private String conreqPass;
	
	private String serialNo;
	
	private String url;
	
	private String configName;
	
	private String currentSoftware;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date sfwUpdTime;
	
	private String sfwUpdRes;
	
	private String cfgUpdRes;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastContact;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date cfgUpdTime;
	
	private String hardware;
	
	private int hardwareId;
	
	private String cfgVersion;
	
	@Lob
	private byte[] props;
	
	private int cfgForce;
	
	@ManyToMany(mappedBy="hosts", cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private List<Service> services = new ArrayList<Service>();
	
	@OneToMany(mappedBy="host", cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<HostProperty> hostProperties = new ArrayList<HostProperty>();
	
	@ManyToOne(targetEntity=com.swg.acs.domain.HardwareModel.class)
	private HardwareModel hardwareModel;
	
	@ManyToOne(targetEntity=com.swg.acs.domain.DeviceProfile.class)
	private DeviceProfile deviceProfile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAuthType() {
		return authType;
	}

	public void setAuthType(int authType) {
		this.authType = authType;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getConreqUser() {
		return conreqUser;
	}

	public void setConreqUser(String conreqUser) {
		this.conreqUser = conreqUser;
	}

	public String getConreqPass() {
		return conreqPass;
	}

	public void setConreqPass(String conreqPass) {
		this.conreqPass = conreqPass;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getCurrentSoftware() {
		return currentSoftware;
	}

	public void setCurrentSoftware(String currentSoftware) {
		this.currentSoftware = currentSoftware;
	}

	public Date getSfwUpdTime() {
		return sfwUpdTime;
	}

	public void setSfwUpdTime(Date sfwUpdTime) {
		this.sfwUpdTime = sfwUpdTime;
	}

	public String getSfwUpdRes() {
		return sfwUpdRes;
	}

	public void setSfwUpdRes(String sfwUpdRes) {
		this.sfwUpdRes = sfwUpdRes;
	}

	public String getCfgUpdRes() {
		return cfgUpdRes;
	}

	public void setCfgUpdRes(String cfgUpdRes) {
		this.cfgUpdRes = cfgUpdRes;
	}

	public Date getLastContact() {
		return lastContact;
	}

	public void setLastContact(Date lastContact) {
		this.lastContact = lastContact;
	}

	public Date getCfgUpdTime() {
		return cfgUpdTime;
	}

	public void setCfgUpdTime(Date cfgUpdTime) {
		this.cfgUpdTime = cfgUpdTime;
	}

	public String getHardware() {
		return hardware;
	}

	public void setHardware(String hardware) {
		this.hardware = hardware;
	}

	public int getHardwareId() {
		return hardwareId;
	}

	public void setHardwareId(int hardwareId) {
		this.hardwareId = hardwareId;
	}

	public String getCfgVersion() {
		return cfgVersion;
	}

	public void setCfgVersion(String cfgVersion) {
		this.cfgVersion = cfgVersion;
	}

	public byte[] getProps() {
		return props;
	}

	public void setProps(byte[] props) {
		this.props = props;
	}

	public int getCfgForce() {
		return cfgForce;
	}

	public void setCfgForce(int cfgForce) {
		this.cfgForce = cfgForce;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<HostProperty> getHostProperties() {
		return hostProperties;
	}

	public void setHostProperties(List<HostProperty> hostProperties) {
		this.hostProperties = hostProperties;
	}

	public HardwareModel getHardwareModel() {
		return hardwareModel;
	}

	public void setHardwareModel(HardwareModel hardwareModel) {
		this.hardwareModel = hardwareModel;
	}

	public DeviceProfile getDeviceProfile() {
		return deviceProfile;
	}

	public void setDeviceProfile(DeviceProfile deviceProfile) {
		this.deviceProfile = deviceProfile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + authType;
		result = prime * result + cfgForce;
		result = prime * result
				+ ((cfgUpdRes == null) ? 0 : cfgUpdRes.hashCode());
		result = prime * result
				+ ((cfgUpdTime == null) ? 0 : cfgUpdTime.hashCode());
		result = prime * result
				+ ((cfgVersion == null) ? 0 : cfgVersion.hashCode());
		result = prime * result
				+ ((configName == null) ? 0 : configName.hashCode());
		result = prime * result
				+ ((conreqPass == null) ? 0 : conreqPass.hashCode());
		result = prime * result
				+ ((conreqUser == null) ? 0 : conreqUser.hashCode());
		result = prime * result
				+ ((currentSoftware == null) ? 0 : currentSoftware.hashCode());
		result = prime * result
				+ ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result
				+ ((hardware == null) ? 0 : hardware.hashCode());
		result = prime * result + hardwareId;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastContact == null) ? 0 : lastContact.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((profileName == null) ? 0 : profileName.hashCode());
		result = prime * result + Arrays.hashCode(props);
		result = prime * result
				+ ((serialNo == null) ? 0 : serialNo.hashCode());
		result = prime * result
				+ ((sfwUpdRes == null) ? 0 : sfwUpdRes.hashCode());
		result = prime * result
				+ ((sfwUpdTime == null) ? 0 : sfwUpdTime.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
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
		Host other = (Host) obj;
		if (authType != other.authType)
			return false;
		if (cfgForce != other.cfgForce)
			return false;
		if (cfgUpdRes == null) {
			if (other.cfgUpdRes != null)
				return false;
		} else if (!cfgUpdRes.equals(other.cfgUpdRes))
			return false;
		if (cfgUpdTime == null) {
			if (other.cfgUpdTime != null)
				return false;
		} else if (!cfgUpdTime.equals(other.cfgUpdTime))
			return false;
		if (cfgVersion == null) {
			if (other.cfgVersion != null)
				return false;
		} else if (!cfgVersion.equals(other.cfgVersion))
			return false;
		if (configName == null) {
			if (other.configName != null)
				return false;
		} else if (!configName.equals(other.configName))
			return false;
		if (conreqPass == null) {
			if (other.conreqPass != null)
				return false;
		} else if (!conreqPass.equals(other.conreqPass))
			return false;
		if (conreqUser == null) {
			if (other.conreqUser != null)
				return false;
		} else if (!conreqUser.equals(other.conreqUser))
			return false;
		if (currentSoftware == null) {
			if (other.currentSoftware != null)
				return false;
		} else if (!currentSoftware.equals(other.currentSoftware))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (hardware == null) {
			if (other.hardware != null)
				return false;
		} else if (!hardware.equals(other.hardware))
			return false;
		if (hardwareId != other.hardwareId)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastContact == null) {
			if (other.lastContact != null)
				return false;
		} else if (!lastContact.equals(other.lastContact))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (profileName == null) {
			if (other.profileName != null)
				return false;
		} else if (!profileName.equals(other.profileName))
			return false;
		if (!Arrays.equals(props, other.props))
			return false;
		if (serialNo == null) {
			if (other.serialNo != null)
				return false;
		} else if (!serialNo.equals(other.serialNo))
			return false;
		if (sfwUpdRes == null) {
			if (other.sfwUpdRes != null)
				return false;
		} else if (!sfwUpdRes.equals(other.sfwUpdRes))
			return false;
		if (sfwUpdTime == null) {
			if (other.sfwUpdTime != null)
				return false;
		} else if (!sfwUpdTime.equals(other.sfwUpdTime))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Host [id=" + id + ", customerId=" + customerId + ", userName="
				+ userName + ", password=" + password + ", authType="
				+ authType + ", profileName=" + profileName + ", conreqUser="
				+ conreqUser + ", conreqPass=" + conreqPass + ", serialNo="
				+ serialNo + ", url=" + url + ", configName=" + configName
				+ ", currentSoftware=" + currentSoftware + ", sfwUpdTime="
				+ sfwUpdTime + ", sfwUpdRes=" + sfwUpdRes + ", cfgUpdRes="
				+ cfgUpdRes + ", lastContact=" + lastContact + ", cfgUpdTime="
				+ cfgUpdTime + ", hardware=" + hardware + ", hardwareId="
				+ hardwareId + ", cfgVersion=" + cfgVersion + ", props="
				+ Arrays.toString(props) + ", cfgForce=" + cfgForce + "]";
	}	

}
