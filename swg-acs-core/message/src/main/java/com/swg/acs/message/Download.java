/**
 * 
 */
package com.swg.acs.message;

import com.swg.acs.MessageBody;
import com.swg.acs.message.cwmp.ArgumentFactory;
import com.swg.acs.message.cwmp.CwmpMessage;

/**
 * @author satriaprayoga
 *
 */
public class Download extends CwmpMessage {

	private static final long serialVersionUID = -3966204878852598453L;

	public String commandKey = "";
	public String fileType = "";
	public String url = "";
	public String userName = "";
	public String password = "";
	public long fileSize = 0;
	public String targetFileName = "";
	public int delaySeconds = 0;
	public String successUrl = "";
	public String failureUrl = "";

	public static final String FT_FIRMWARE = "1 Firmware Upgrade Image";
	public static final String FT_WEBCONTENT = "2 Web Content";
	public static final String FT_CONFIG = "3 Vendor Configuration File";

	public Download() {
		super("Download");
	}

	/* (non-Javadoc)
	 * @see com.swg.acs.Message#configureBody(com.swg.acs.MessageBody, com.swg.acs.message.cwmp.ArgumentFactory)
	 */
	@Override
	protected void configureBody(MessageBody bodyPart,
			ArgumentFactory argumentFactory) {
		bodyPart.addMessageArgument(argumentFactory.createMessageArgument("CommandKey")).setValue(commandKey);
		bodyPart.addMessageArgument(argumentFactory.createMessageArgument("FileType")).setValue(fileType);
		bodyPart.addMessageArgument(argumentFactory.createMessageArgument("URL")).setValue(url);
		bodyPart.addMessageArgument(argumentFactory.createMessageArgument("Username")).setValue(userName);
		bodyPart.addMessageArgument(argumentFactory.createMessageArgument("Password")).setValue(password);
		bodyPart.addMessageArgument(argumentFactory.createMessageArgument("FileSize")).setValue(String.valueOf(fileSize));
		bodyPart.addMessageArgument(argumentFactory.createMessageArgument("TargetFileName")).setValue(targetFileName);
		bodyPart.addMessageArgument(argumentFactory.createMessageArgument("DelaySeconds")).setValue(String.valueOf(delaySeconds));
		bodyPart.addMessageArgument(argumentFactory.createMessageArgument("SuccessURL")).setValue(successUrl);
		bodyPart.addMessageArgument(argumentFactory.createMessageArgument("FailureURL")).setValue(failureUrl);
	}

	/* (non-Javadoc)
	 * @see com.swg.acs.Message#configureParse(com.swg.acs.MessageBody)
	 */
	@Override
	protected void configureParse(MessageBody messageBody) {
		
	}

	public String getCommandKey() {
		return commandKey;
	}

	public void setCommandKey(String commandKey) {
		this.commandKey = commandKey;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getTargetFileName() {
		return targetFileName;
	}

	public void setTargetFileName(String targetFileName) {
		this.targetFileName = targetFileName;
	}

	public int getDelaySeconds() {
		return delaySeconds;
	}

	public void setDelaySeconds(int delaySeconds) {
		this.delaySeconds = delaySeconds;
	}

	public String getSuccessUrl() {
		return successUrl;
	}

	public void setSuccessUrl(String successUrl) {
		this.successUrl = successUrl;
	}

	public String getFailureUrl() {
		return failureUrl;
	}

	public void setFailureUrl(String failureUrl) {
		this.failureUrl = failureUrl;
	}
	
	

}
