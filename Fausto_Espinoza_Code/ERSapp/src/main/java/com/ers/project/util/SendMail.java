package com.ers.project.util;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;

import com.ers.project.model.Email;
import com.ers.project.model.Users;

public class SendMail {	
	
		
	public static boolean sendMail(Email email, Users user) {
				
		String fromEmail = email.geteFromEmail();
		
		String password = EnDeCrypt.deCrypt(email.getePassword());
		String toEmail = user.getEmail();
		String subject = user.getFirstName() + email.geteSubject();
		String message = email.geteMessage();
		Properties prop = System.getProperties();				
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		
		
//		prop.put("mail.smtp.soocketFactory.class", "javax.net.ssl.SSLSooketFactory");
//		prop.put("mail.smtp.soocketFactory.port", "587");
//		prop.put("mail.smtp.soocketFactory.fallback", "false");
		
		Session mailSession = Session.getDefaultInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});
		mailSession.setDebug(true);
		
		Message mailMessage = new MimeMessage(mailSession);
		
		
		try {
			mailMessage.setFrom(new InternetAddress(fromEmail));
			mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			mailMessage.setSubject(subject);
			mailMessage.setContent(message,"text/html");
//			mailMessage.setText(message);
			
//			Transport transport = mailSession.getTransport("smtp");
//			transport.connect("smtp.gmail.com",username, password);
//			transport.send(mailMessage, mailMessage.getAllRecipients());
			
			Transport.send(mailMessage);
			
//			Transport transport = session.getTransport("smtp");
//		    transport.connect(host, from, pass);
//		    transport.sendMessage(msg, msg.getAllRecipients());
//		    transport.close();
			return true;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}				
		
		return false;
	}
}
