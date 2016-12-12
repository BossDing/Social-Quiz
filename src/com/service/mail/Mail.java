package com.service.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeBodyPart;

import com.service.SendMessage;


public class Mail {
	
	String to = ""; //�ռ���
	String from = ""; //������
	String host = "localhost"; //smtp����
	String username = ""; 
	String password = "";
	String subject = ""; //�ʼ�����
	String content = ""; //�ʼ�����
	
	public Mail() {
		
	}
	
	public Mail(String to, String from, String host, String username,
			String password, String subject, String content) {
		this.to = to;
		this.from = from;
		this.host = host;
		this.username = username;
		this.password = password;
		this.subject = subject;
		this.content = content;
	}
	

	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String tranferChinese(String contentText) {
		
		try {
			contentText = MimeUtility.encodeText(new String(contentText.getBytes(),
					 "GB2312"), "GB2312", "B");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return contentText;
	}
	
	public boolean sendMail() {
		// �ռ��˵�������
	    String to = "dzymt6627@163.com";
	    // �����˵�������
	    String from = "616947459@qq.com";
	    // ָ�������ʼ�������Ϊ localhost
	    String host = "localhost";
		//����session
		Properties prop = System.getProperties(); //��ȡϵͳ����
		prop.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(prop);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			subject = tranferChinese(subject);
			message.setSubject("�һ�����");
			//����Multipart
			Multipart mp = new MimeMultipart();
			MimeBodyPart mbpContent = new MimeBodyPart();
			content = "findpassword";
			mbpContent.setContent(content,"text/html;charset=utf-8");
			mp.addBodyPart(mbpContent);
			message.setContent(mp);
			message.setSentDate(new Date());
			Transport.send(message);
			System.out.println("Sent message successfully....");
			
		} catch(MessagingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
}




