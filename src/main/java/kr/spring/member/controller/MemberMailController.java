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
	
	// �ڹٺ�(Ŀ�ǵ� ��ü) �ʱ�ȭ
	@ModelAttribute("command")
	public MemberCommand initCommand() {
		return new MemberCommand();
	}

	//���ϸ� 
	/** �ڹ� ���� �߼� * @throws MessagingException * @throws AddressException **/ 
	@RequestMapping(value = "/mailSender") 
	public void mailSender(String user_id,String user_email) throws AddressException, MessagingException {
		
		// ���̹��� ��� smtp.naver.com �� �Է��մϴ�. 
		// Google�� ��� smtp.gmail.com �� �Է��մϴ�. 
		String host = "smtp.gmail.com"; 
		final String username = "helloworld.khacademy"; //���̹� ���̵� �Է����ּ���. @nave.com�� �Է����� �ʴ´�. 
		final String password = "khacademy123";		//���̹� �̸��� ��й�ȣ�� �Է����ּ���. 
		int port=587;		//��Ʈ��ȣ 
		
		MemberCommand member = memberService.selectMember(user_id);
		
		String user_pw=member.getUser_pw(); 
		
		// ���� ���� 
		String recipient = user_email;		//�޴� ����� �����ּҸ� �Է����ּ���. 
		String subject = "��й�ȣ�� �߼۵Ǿ����ϴ� [HelloWorld]"; 	//���� ���� �Է����ּ���. 
		String body = user_id+"���� ��й�ȣ�� "+user_pw+" �Դϴ�."; //���� ���� �Է����ּ���. 
		
		Properties props = System.getProperties(); // ������ ��� ���� ��ü ���� 
		
		// SMTP ���� ���� ���� 
		props.put("mail.smtp.host", host); 
		props.put("mail.smtp.port", port); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.ssl.enable", "true"); 
		props.put("mail.smtp.ssl.trust", host); 
		
		//Session ���� 
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() { 
			String un=username; 
			String pw=password; 
			
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() { 
				return new javax.mail.PasswordAuthentication(un, pw); 
			} 
		}); 
		session.setDebug(true); //for debug 
		
		Message mimeMessage = new MimeMessage(session); //MimeMessage ���� 
		
		mimeMessage.setFrom(new InternetAddress("helloworld.khacademy@gmail.com")); 
		//�߽��� ���� , ������ ����� �̸����ּҸ� �ѹ� �� �Է��մϴ�. �̶��� �̸��� Ǯ �ּҸ� �� �ۼ����ּ���. 
		
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); 
		//�����ڼ��� //.TO �ܿ� .CC(����) .BCC(��������) �� ���� 
		
		mimeMessage.setSubject(subject); //������� 
		mimeMessage.setText(body); //������� 
		Transport.send(mimeMessage); //javax.mail.Transport.send() �̿� }
	}
}
