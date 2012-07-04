/**
 * 
 */
package com.swg.acs.message;

import com.swg.acs.MessageArgument;
import com.swg.acs.MessageBody;
import com.swg.acs.message.cwmp.ArgumentFactory;
import com.swg.acs.message.cwmp.CwmpMessage;

/**
 * @author satriaprayoga
 *
 */
public class AutonomousTransferComplete extends CwmpMessage{

	private static final long serialVersionUID = 6831558813446128626L;
	
	private String announceURL;
	private String transferURL;
	private boolean download;
	private String fileType;
	private int fileSize;
	private String targetFileName;
	private String startTime;
	private String completeTime;
	private String faultCode;
	private String faultString;
	
	public AutonomousTransferComplete() {
		super("AutonomousTransferComplete");
	}
	
	@Override
	protected void configureBody(MessageBody bodyPart,
			ArgumentFactory argumentFactory) {
	}
	
	@Override
	protected void configureParse(MessageBody messageBody) {
		announceURL=messageBody.getChild("AnnounceURL").getValue();
		transferURL=messageBody.getChild("TransferURL").getValue();
		download=messageBody.getChild("IsDownload").getValue().equals("1");
		fileType=messageBody.getChild("FileSize").getValue();
		fileSize=Integer.parseInt(messageBody.getChild("FileSize").getValue());
		targetFileName=messageBody.getChild("TargetFileName").getValue();
		MessageArgument faultArg=messageBody.getChild("FaultStruct");
		if(faultArg!=null){
			faultCode=faultArg.getChild("FaultCode").getValue();
			faultString=faultArg.getChild("FaultString").getValue();
		}else{
			faultCode="0";
			faultString=null;
		}
		startTime=messageBody.getChild("StartTime").getValue();
		completeTime=messageBody.getChild("CompleteTime").getValue();
		
	}
	
	public String getAnnounceURL() {
		return announceURL;
	}
	public String getTransferURL() {
		return transferURL;
	}
	public boolean isDownload() {
		return download;
	}
	public String getFileType() {
		return fileType;
	}
	public int getFileSize() {
		return fileSize;
	}
	public String getTargetFileName() {
		return targetFileName;
	}
	public String getStartTime() {
		return startTime;
	}
	public String getCompleteTime() {
		return completeTime;
	}
	public String getFaultCode() {
		return faultCode;
	}
	public String getFaultString() {
		return faultString;
	}
	
	
}
