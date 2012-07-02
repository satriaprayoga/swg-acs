package com.swg.acs.web;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.swg.acs.Message;
import com.swg.acs.message.GetRPCMethods;
import com.swg.acs.message.soap.CwmpMessageBuilder;
import com.swg.acs.message.soap.CwmpMessageParser;
import com.swg.acs.message.soap.SoapMessageBuilder;

public class TestCwmpServlet {

	private Tomcat tomcat;
	
	@Before
	public void startUp() throws LifecycleException{
		tomcat=new Tomcat();
		String baseDir=System.getProperty("java.io.tmpdir");

		Context context=tomcat.addContext("/swg-acs", baseDir);
		tomcat.addServlet("/swg-acs", "acsServlet", new TestSoapServlet());
		context.addServletMapping("/", "acsServlet");
		tomcat.start();
	}
	
	@Test
	public void test() throws Exception{
		Message message=new GetRPCMethods();
		SoapMessageBuilder builder=CwmpMessageBuilder.getSoapMessageBuilderInstance();
		SOAPMessage message2=builder.build(message);
		ByteArrayOutputStream stream=new ByteArrayOutputStream();
		message2.writeTo(stream);
		byte[] data=stream.toByteArray();
		stream.close();
		//System.out.println(new String(data));
		HttpClient client=new DefaultHttpClient();
		HttpPost httpPost=new HttpPost("http://localhost:8080/swg-acs/");
		httpPost.addHeader("Content-Type", "text/xml");
		httpPost.setEntity(new ByteArrayEntity(data));
		HttpResponse httpResponse=client.execute(httpPost);
		InputStreamReader inputStream=new InputStreamReader(httpResponse.getEntity().getContent());
		String line="";
		BufferedReader reader=new BufferedReader(inputStream);
		StringBuilder builder2=new StringBuilder();
		while((line=reader.readLine())!=null){
			builder2.append(line);
		}
		reader.close();
		System.out.println(builder2.toString());
		MessageFactory factory=MessageFactory.newInstance();
		SOAPMessage message3=factory.createMessage(null, new ByteArrayInputStream(builder2.toString().getBytes()));
		Message message4=CwmpMessageParser.getMessageParserInstance().parse(message3);
		System.out.println(message4.getName());
		
	}
	
	@After
	public void tearDown() throws LifecycleException{
		tomcat.stop();
		tomcat.destroy();
	}
}
