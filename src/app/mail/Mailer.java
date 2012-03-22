package app.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;

import app.mail.configuration.MailerConfiguration;

public class Mailer {

	private MailerConfiguration configuration;
	private Message message;

	public Mailer(MailerConfiguration configuration) {
		this.configuration = configuration;
	}
	
	public void sendMail(final String username, final String password)
		throws MessagingException {
		
		Transport transport = configuration.getSession().getTransport("smtp");
		try {
			transport.connect(configuration.getHost(), username, password);
			transport.sendMessage(message, message.getAllRecipients());
		}
		finally {
			transport.close();
		}
	}
	
	public void setMessage(Message message) {
		this.message = message;
	}
	
}
