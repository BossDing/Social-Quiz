package com.service.mail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.model.User;
import com.service.mail.Mail;;


public class send extends Mail{
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void finalsend(String email, String url) throws AddressException,MessagingException {
		Mail post = new Mail();
		StringBuffer sb = new StringBuffer();
		sb.append("�װ����û�" + user.getUsername()+"�����ã�<br><br>");
		sb.append("        ���յ�����������ʼ�����Ϊ�� (Ҳ������ĳ��ð����������) ������һ���µ����롣�����ⲻ��������������, �벻�����<br>�������ʼ�, ��������������յ�������ż�ɧ��, ���������������Ա��<br><br>");
		sb.append("        Ҫʹ���µ�����, ��ʹ�����������������롣<br><br>");
		sb.append("" + url);
		
		String strm[] = email.split("@");
		post.setTo("616947459@qq.com");
		post.setFrom("dzymt6627@163.com");
		post.setHost("smtp.163.com");
		post.setUsername(user.getUsername());
		post.setPassword(user.getPassword());
		post.setSubject("[Staple]�һ��˻�����");
		post.setContent(sb.toString());
		if(post.sendMail()) {
			System.out.println("�����ύ�ɹ�����鿴���" + strm[strm.length - 1] + "����");
		} else {
			System.out.println("����ʧ�ܣ��Ժ�����");
		}
	}

	public static void main(String []args) {
		Mail pos = new Mail();
		if(pos.sendMail()) {
			System.out.println("successful sending");
		}
	}
	
	
}




