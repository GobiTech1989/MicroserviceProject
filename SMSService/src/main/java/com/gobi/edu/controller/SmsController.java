package com.gobi.edu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
public class SmsController {

	 @GetMapping(value = "/sendSMS")
     public ResponseEntity<String> sendSMS() {

             Twilio.init("AC864bb5cbba20e59eed6b4448f120205a", "1adf07d3c1b67f8ad9a1a25400163a7f");
             

             Message.creator(new PhoneNumber("+919629378035"),
                             new PhoneNumber("+18304653913"), "This is your OTP :: "+generateOTP()+" Please don't Share.").create();

             return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
     }
	 
	 public String generateOTP() {
		 int randomPin   =(int) (Math.random()*9000)+1000;
	     return String.valueOf(randomPin);
	 }
}
