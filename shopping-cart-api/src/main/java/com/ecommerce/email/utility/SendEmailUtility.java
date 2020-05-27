package com.ecommerce.email.utility;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import com.ecommerce.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SendEmailUtility {

	@Autowired
	ConfigProperties configProp;
	/**
	 * Utility method to send simple HTML email
	 * 
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	public  void sendEmail(String toEmail, String subject, String body) {
		try {
			
			final String fromEmail = "kishintouch@gmail.com"; //requires valid gmail id
			final String password = "cts@oct31"; // correct password for gmail id
			Properties props = new Properties();
			
			props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
			props.put("mail.smtp.port", "587"); //TLS Port
			props.put("mail.smtp.auth", "true"); //enable authentication
			props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
			System.out.println( "value " + configProp.getConfigValue("mail.smtp.host"));
			/*props.put("mail.smtp.host",configProp.getConfigValue("mail.smtp.host")); //SMTP Host
			props.put("mail.smtp.port", configProp.getConfigValue("mail.smtp.port")); //TLS Port
			props.put("mail.smtp.auth", configProp.getConfigValue("mail.smtp.auth")); //enable authentication
			props.put("mail.smtp.starttls.enable", configProp.getConfigValue("mail.smtp.starttls.enable")); //enable STARTTLS */
			
	                //create Authenticator object to pass in Session.getInstance argument
			Authenticator auth = new Authenticator() {
				//override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			};
			Session session = Session.getInstance(props, auth);
			MimeMessage msg = new MimeMessage(session);
			// set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));
			msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));
			msg.setSubject(subject, "UTF-8");
			msg.setText(body, "UTF-8");
			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			
			
			Transport.send(msg);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
