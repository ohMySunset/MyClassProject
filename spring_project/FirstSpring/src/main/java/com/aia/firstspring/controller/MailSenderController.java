package com.aia.firstspring.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aia.firstspring.member.service.MailSenderService;

@Controller
@RequestMapping("/mail")
public class MailSenderController {

	@Autowired
	MailSenderService mailSenderService;

//	@Autowired
//	private JavaMailSender mailSender;

//	@Autowired
//	private SimpleMailMessage templateMessage;

	@RequestMapping("/simplemail") // /mail/simplemail
	public void simpleMailSend() {

		// SimpleMailMessage message = new SimpleMailMessage();
//		SimpleMailMessage message = new SimpleMailMessage(templateMessage);
//		message.setTo("znfnznfnakqj@naver.com");
		// message.setSubject("테스트 이메일 발송입니다.");
		// message.setText("내용입니다.");

//		mailSenderService.simpleMailSend();
		mailSenderService.mailSend("znfnznfnakqj@naver.com");

	}

	

}
