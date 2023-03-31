package com.tteonago.member.controller;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MemberRestController {
		
	@Value("${jwt.token.secret}")
	private String SecretKey;

	@PostMapping(value = "/auth")
	public void auth(@RequestParam(value = "email") String email, Authentication authentication) {		
		final String username = "sh72551326@gmail.com";
		final String password = "ipyavftkxwzgmrtc";
		Properties props = createEmailProperties();

		String authenticationCode = "56";
	
		Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

		try {
			Message message = createEmailMessage(session, email, username, authenticationCode);
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Properties createEmailProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        return props;
    }
	
	private Message createEmailMessage(Session session, String email, String username, String authenticationCode) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        message.setSubject("즐거운 여행 tteonago 이메일 인증 번호");
        message.setText("인증 번호: " + authenticationCode);
        return message;
    }
}