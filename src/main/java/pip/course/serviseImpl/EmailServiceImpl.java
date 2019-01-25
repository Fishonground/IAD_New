package pip.course.serviseImpl;

import org.springframework.stereotype.Service;
import pip.course.repository.EmailService;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static javax.xml.transform.OutputKeys.ENCODING;

@Service
public class EmailServiceImpl implements EmailService {


    public void sendSimpleMessage(
            String to, String subject, String text) {

        to = "..........";
        subject = "Our coursach!";
        String msg ="You have received this message from KURSAAACH";
        final String from ="..........";
        final  String password ="........";
        text = "";


        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,password);
                    }
                });

        //session.setDebug(true);
        Transport transport = null;
        try {
            transport = session.getTransport();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        InternetAddress addressFrom = null;
        try {
            addressFrom = new InternetAddress(from);
        } catch (AddressException e) {
            e.printStackTrace();
        }

        MimeMessage message = new MimeMessage(session);
        try {
            message.setSender(addressFrom);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try{
            message.setSubject(subject);
            message.setContent(msg, "text/plain");}
        catch (MessagingException e1) {
            e1.printStackTrace();
        }
        try {
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        try {
            transport.connect();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    class MyAuthenticator extends Authenticator {
        private String user;
        private String password;

        MyAuthenticator(String user, String password) {
            this.user = user;
            this.password = password;
        }

        public PasswordAuthentication getPasswordAuthentication() {
            String user = this.user;
            String password = this.password;
            return new PasswordAuthentication(user, password);
        }
    }

}
