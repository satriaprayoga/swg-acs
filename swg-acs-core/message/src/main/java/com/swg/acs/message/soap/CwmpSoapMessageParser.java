/**
 * 
 */
package com.swg.acs.message.soap;

import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

import org.apache.log4j.Logger;
import org.w3c.dom.Node;

import com.swg.acs.Message;
import com.swg.acs.MessageArgument;
import com.swg.acs.MessageBody;
import com.swg.acs.MessageEnvelope;
import com.swg.acs.MessageHeader;
import com.swg.acs.message.cwmp.ArgumentFactory;

/**
 * @author satriaprayoga
 *
 */
final class CwmpSoapMessageParser extends CwmpMessageParser{

	private final Logger logger=Logger.getLogger(getClass());
	
	private final static SoapUtil soapUtil=SoapUtil.getInstance();

	@Override
	protected MessageEnvelope parseMessageEnvelope(SOAPMessage soapMessage,Message message)throws SOAPException{
		logger.info("parsing envelope part");
		MessageEnvelope envelope=message.getMessageEnvelope();
		SOAPEnvelope soapEnvelope=soapMessage.getSOAPPart().getEnvelope();
		Iterator<String> iterator=soapEnvelope.getNamespacePrefixes();
		while(iterator.hasNext()){
			String prefix=iterator.next();
			String uri=soapEnvelope.getNamespaceURI(prefix);
			if(uri!=null && !(uri.trim().isEmpty())){
				logger.info("prefix: "+prefix+", uri: "+uri);
				envelope.addNamespace(prefix, uri);
				if(uri.startsWith("urn:dslforum-org:cwmp-")){
					message.setUri(uri);
					logger.info("cwmp namespace: "+message.getUri());
				}
			}
		}
		return envelope;
	}

	@Override
	protected MessageHeader parseMessageHeader(SOAPMessage soapMessage,Message message)throws SOAPException{
		logger.info("parse header part");
		MessageHeader header=message.getMessageHeader();
		SOAPHeader soapHeader=soapMessage.getSOAPHeader();
		if(soapHeader!=null){
			String id=soapUtil.getHeaderElementValue(soapHeader, "ID", Message.CWMP_PREFIX, message.getUri());
			if(id!=null){
				message.setId(id);
				logger.info("message id: "+message.getId());
			}
			String hold=soapUtil.getHeaderElementValue(soapHeader, "HoldRequest", Message.CWMP_PREFIX, message.getUri());
			if(hold!=null){
				header.setHoldRequest(hold.equals("1")?true:false);
				logger.info("hold request: "+header.isHoldRequest());
			}
			String sessionTimeOut=soapUtil.getHeaderElementValue(soapHeader, "SessionTimeout", Message.CWMP_PREFIX, Message.CWMP_URN);
			if(sessionTimeOut!=null)
				header.setSessionTimeOut(Long.parseLong(sessionTimeOut));
		}
		return header;
	}

	@Override
	protected MessageBody parseMessageBody(SOAPMessage soapMessage,Message message)throws SOAPException{
		logger.info("parse body part");
		MessageBody messageBody=message.getMessageBody();
		
		SOAPBodyElement bodyElement=soapUtil.getRequest(soapMessage);
		String requestName=bodyElement.getLocalName();
		logger.info("request name: "+requestName);
	//	Node elementNode=bodyElement.getFirstChild();
		getContent(bodyElement.getChildElements(), messageBody);
		return messageBody;
	}
	
/*
	protected Argument parseMessageArgument(Node bodyElement,Argument body)throws SOAPException{
		if(bodyElement instanceof SOAPElement){
			SOAPElement root=(SOAPElement)bodyElement;
			Iterator element=root.getChildElements();
			while(element.hasNext()){
				Node node=(Node)element.next();
				if(node instanceof SOAPElement){
					QName name = root.getElementQName();
					String value=root.getValue();
					logger.info("name: "+name.getLocalPart()+". value= "+value);
					Iterator attrs = root.getAllAttributesAsQNames();
					while (attrs.hasNext()){
						QName attrName = (QName)attrs.next();
						logger.info( " Attribute name is " +
								attrName.toString());

						logger.info( " Attribute value is " +
								root.getAttributeValue(attrName));
					}
					SOAPElement el=(SOAPElement)node;
					parseMessageArgument(el, body);
				}
			}
		}
	
		return null;
	}
*/
	private void getContent(Iterator iterator,MessageArgument body){
		ArgumentFactory factory=ArgumentFactory.getInstance();
		while (iterator.hasNext()) {
			Node node = (Node) iterator.next();
			SOAPElement element = null;
			//Text text = null;
			MessageArgument argument=null;
			if (node instanceof SOAPElement) {
				element = (SOAPElement)node;
				QName name = element.getElementQName();
				argument=body.addMessageArgument(factory.createMessageArgument(name.toString()));
				logger.info("name: "+argument.getName());
				Iterator attrs = element.getAllAttributesAsQNames();
				while (attrs.hasNext()){
					QName attrName = (QName)attrs.next();
					argument.setAttribute(attrName.toString(), element.getAttributeValue(attrName));
					logger.info("attr: "+argument.getAttributeName()+", value: "+argument.getAttribute(attrName.toString()));
				}
				String content = element.getValue();
				if(content!=null){
					argument.setValue(content);
					logger.info("value: "+argument.getValue());
				}
				Iterator iter2 = element.getChildElements();
				getContent(iter2,argument);
				
			}
		
		}
	}
/*
	public void getContents(Iterator iterator,MessageBody body) {

		while (iterator.hasNext()) {
			Node node = (Node) iterator.next();
			SOAPElement element = null;
			Text text = null;

			if (node instanceof SOAPElement) {
				element = (SOAPElement)node;
				QName name = element.getElementQName();
				System.out.println( "Name is " + name.toString());

				Iterator attrs = element.getAllAttributesAsQNames();
				while (attrs.hasNext()){
					QName attrName = (QName)attrs.next();
					System.out.println( " Attribute name is " +
							attrName.toString());

					System.out.println( " Attribute value is " +
							element.getAttributeValue(attrName));
				}
				Iterator iter2 = element.getChildElements();
				getContents(iter2,body);
			} else {
				text = (Text) node;
				String content = text.getValue();
				System.out.println( "Content is: " + content);

			}
		}
	}
*/
}