package app.mail.configuration;

import java.util.Properties;

import javax.mail.Session;

public class HotmailConfiguration implements MailerConfiguration {

	private Session session;
	private static final String host = "smtp.live.com";
	
	private HotmailConfiguration(Session session) {
		this.session = session;
	}

	public static MailerConfiguration configureSession(final String username, 
														final String password) {
		Properties props = System.getProperties();
		props.setProperty("mail.transport.protocol", "smtp");
	    props.setProperty("mail.host", host);
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.password", password);
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.auth", "true");
	    return new HotmailConfiguration(Session.getDefaultInstance(props));
	}
	
	public Session getSession() {
		return session;
	}
	
	public String getHost() {
		return host;
	}

}
