package function.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@SpringBootApplication
@Slf4j
public class EmailApplication {

	public static void main(String[] args) {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		String receiver = "lh0156@naver.com";

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(receiver, "섭섭이"));
			msg.addRecipient(Message.RecipientType.TO,
					new InternetAddress(receiver, "섭섭이"));
			msg.setSubject("섭섭아 안녕");
			msg.setText("난 안섭섭이야");
			Transport.send(msg);

			System.out.println("발송 완료");
			log.info("발송 완료");
		} catch (MessagingException | UnsupportedEncodingException e) {
			// ...
		}

		SpringApplication.run(EmailApplication.class, args);

	}

}
