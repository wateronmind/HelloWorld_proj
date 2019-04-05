package kr.spring.member.controller;

import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
public class MemberMailController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private MemberService memberService;
	
	// 자바빈(커맨드 객체) 초기화
	@ModelAttribute("command")
	public MemberCommand initCommand() {
		return new MemberCommand();
	}

	//메일링 
	/** 자바 메일 발송 * @throws MessagingException * @throws AddressException **/ 
	@RequestMapping(value = "/mailSender") 
	public void mailSender(String user_id,String user_email) throws AddressException, MessagingException {
		
		// 네이버일 경우 smtp.naver.com 을 입력합니다. 
		// Google일 경우 smtp.gmail.com 을 입력합니다. 
		String host = "smtp.gmail.com"; 
		final String username = "helloworld.khacademy"; //네이버 아이디를 입력해주세요. @nave.com은 입력하지 않는다. 
		final String password = "khacademy123";		//네이버 이메일 비밀번호를 입력해주세요. 
		int port=587;		//포트번호 
		
		MemberCommand member = memberService.selectMember(user_id);
		
		String user_pw=member.getUser_pw(); 
		
		// 메일 내용 
		String recipient = user_email;		//받는 사람의 메일주소를 입력해주세요. 
		String subject = "비밀번호가 발송되었습니다 [HelloWorld]"; 	//메일 제목 입력해주세요. 
		String body = user_id+"님의 비밀번호는 "+user_pw+" 입니다."; //메일 내용 입력해주세요. 
		
		Properties props = System.getProperties(); // 정보를 담기 위한 객체 생성 
		
		// SMTP 서버 정보 설정 
		props.put("mail.smtp.host", host); 
		props.put("mail.smtp.port", port); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.ssl.enable", "true"); 
		props.put("mail.smtp.ssl.trust", host); 
		
		//Session 생성 
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() { 
			String un=username; 
			String pw=password; 
			
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() { 
				return new javax.mail.PasswordAuthentication(un, pw); 
			} 
		}); 
		session.setDebug(true); //for debug 
		
		Message mimeMessage = new MimeMessage(session); //MimeMessage 생성 
		
		mimeMessage.setFrom(new InternetAddress("helloworld.khacademy@gmail.com")); 
		//발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력합니다. 이때는 이메일 풀 주소를 다 작성해주세요. 
		
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); 
		//수신자셋팅 //.TO 외에 .CC(참조) .BCC(숨은참조) 도 있음 
		
		mimeMessage.setSubject(subject); //제목셋팅 
		mimeMessage.setText(body); //내용셋팅 
		Transport.send(mimeMessage); //javax.mail.Transport.send() 이용 }
	}
}
