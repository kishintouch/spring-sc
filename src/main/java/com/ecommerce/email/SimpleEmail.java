package com.ecommerce.email;
import java.util.Properties;

import javax.mail.Session;

import com.ecommerce.email.utility.SendEmailUtility;

public class SimpleEmail {
	
	public static void main(String[] args) {
		
	    System.out.println("SimpleEmail Start");
		
	    String smtpHostServer = "smtp.example.com";
	    String emailID = "kishintouch@gmail.com";
	    
	    Properties props = System.getProperties();

	    props.put("mail.smtp.host", smtpHostServer);

	    Session session = Session.getInstance(props, null);
	    
	    //SendEmailUtility.sendEmail(session, emailID,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");
	}

}