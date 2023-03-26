package com.tteonago.member.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tteonago.member.service.UserService;
import com.tteonago.member.utils.JwtTokenUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberRestController {
	private final UserService userService;
	@Value("${jwt.token.secret}")
	private String SecretKey;

	@PostMapping(value = "/auth")
	public void auth(@RequestParam(value = "email") String email, Authentication authentication) {
		System.out.println(email);
		final String username = "sh72551326@gmail.com";
		final String password = "ipyavftkxwzgmrtc";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// 인증번호 생성
		String authenticationCode = "56";

		// 이메일 보내기
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("sh72551326@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("즐거운 여행 tteonago 이메일 인증 번호");
			message.setText("인증 번호: " + authenticationCode);
			Transport.send(message);

			System.out.println("이메일 전송 완료!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	@PostMapping("/getToken")
	public ResponseEntity<String> showName(@CookieValue(value = "token", required = false) String token) {
		System.out.println("token-----" + token);

		if (token == null) {
			return ResponseEntity.ok().body(token);
		}

		return ResponseEntity.ok().body(token);
	}

	@PostMapping("/getName")
	public ResponseEntity<String> getName(Authentication authientication) {

		if (authientication == null) {
			return ResponseEntity.ok().body("");
		}
		System.out.println("getName---------" + authientication.getName());

		String userName = authientication.getName();
		return ResponseEntity.ok().body(userName);
	}

	@PostMapping("/getTokenName")
	public ResponseEntity<String> getTokenName(@CookieValue(value = "token", required = false) String token) {
		System.out.println("gettokenname--------" + token);
		if (token == null) {
			return ResponseEntity.ok().body(token);
		}

		String userName = JwtTokenUtil.getUserName(token, SecretKey);
		return ResponseEntity.ok().body(userName);
	}

}
