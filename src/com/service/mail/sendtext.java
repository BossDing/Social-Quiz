package com.service.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class sendtext {
	
	String to = ""; //�ռ���
	String from = ""; //������
	String host = "localhost"; //smtp����
	String username = ""; 
	String password = "";
	String subject = ""; //�ʼ�����
	String content = ""; //�ʼ�����

	public static void main(String[] args) {
		// �ռ��˵�������
	    String to = "616947459@qq.com";
	    // �����˵�������
	    String from = "616947459@qq.com";
	    // ָ�������ʼ�������Ϊ localhost
	    String host = "localhost";
		//����session
		Properties prop = System.getProperties(); //��ȡϵͳ����
		prop.setProperty("smtp.sohu.com", host);
		Session session = Session.getDefaultInstance(prop);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			//subject = tranferChinese(subject);
			message.setSubject("�һ�����");
			//����Multipart
			Multipart mp = new MimeMultipart();
			MimeBodyPart mbpContent = new MimeBodyPart();
			//content = "findpassword";
			mbpContent.setContent("findpassword!!!!!!!!!!!","text/html;charset=utf-8");
			mp.addBodyPart(mbpContent);
			message.setContent(mp);
			message.setSentDate(new Date());
			Transport.send(message);
			System.out.println("Sent message successfully....");
			
		} catch(MessagingException e) {
			e.printStackTrace();
		}
		
	}
}
