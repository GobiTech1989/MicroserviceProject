package com.gobi.edu.controller;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gobi.edu.vo.MailVO;

@RestController
@RequestMapping("/api")
public class EmailController {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@PostMapping("/sendMail")
	public ResponseEntity<?> sendSimpleMail(@RequestBody MailVO mailVO) {
		ResponseEntity<?> responseEntity = null;
		
		SimpleMailMessage message = new SimpleMailMessage();
		 
		message.setFrom(mailVO.getMailFrom());
		message.setTo(mailVO.getMailTo());
		message.setSubject("This is a plain text email");
		message.setText("Hello guys! This is a plain text email.");
		 
		javaMailSender.send(message);
		
		responseEntity = new ResponseEntity<>(HttpStatus.OK);
		
		return responseEntity;
	}
	
	@PostMapping("/sendHtmlMail")
	public ResponseEntity<?> sendHtmlMail(@RequestBody MailVO mailVO) {
		ResponseEntity<?> responseEntity = null;
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		 
		try {
			helper.setFrom(mailVO.getMailFrom());
			helper.setTo(mailVO.getMailTo());
			helper.setSubject("This is an HTML email");
			boolean html = true;
			helper.setText("<b>Hey guys</b>,<br><i>Welcome to my new home</i>", html);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		javaMailSender.send(message);
		
		responseEntity = new ResponseEntity<>(HttpStatus.OK);
		
		return responseEntity;
	}
	
	@PostMapping("/sendAttachMail")
	public ResponseEntity<?> sendAttachMail(@RequestBody MailVO mailVO) {
		ResponseEntity<?> responseEntity = null;
		
		MimeMessage message = javaMailSender.createMimeMessage();
		 
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			
			helper.setFrom(mailVO.getMailFrom());
			helper.setTo(mailVO.getMailTo());
			helper.setSubject("Here's your e-book");
			helper.setText("<b>Dear friend</b>,<br><i>Please find the book attached.</i>", true);
			 
			FileSystemResource file = new FileSystemResource(new File("/home/gobinath/Documents/Aadhaar_Gobinath.pdf"));
			helper.addAttachment("Aadhaar_Gobinath_NEW.pdf", file);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		javaMailSender.send(message);
		
		responseEntity = new ResponseEntity<>(HttpStatus.OK);
		
		return responseEntity;
	}
}
