package app.mail.configuration;

import javax.mail.Session;

public interface MailerConfiguration {

	public Session getSession();
	public String getHost();
}
