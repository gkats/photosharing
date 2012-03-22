package app.mail.configuration;

import java.util.Properties;

import javax.mail.Session;

public class YahooMailConfiguration implements MailerConfiguration {

	private Session session;
	private static final String host = "";
	
	private YahooMailConfiguration(Session session) {
		this.session = session;
	}

	public static MailerConfiguration configureSession(final String username, 
												final String password) {
		
		Properties props = System.getProperties();
		return new YahooMailConfiguration(Session.getDefaultInstance(props));
	}
	
	public String getHost() {
		return host;
	}

	public Session getSession() {
		return session;
	}

}
