package function.email;

// [START simple_includes]
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
// [END simple_includes]

// [START multipart_includes]
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import javax.activation.DataHandler;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;


public class MailMessage {

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
        } catch (MessagingException | UnsupportedEncodingException e) {
            // ...
        }

    }

}
