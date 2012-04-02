package app.di.config;

import javax.swing.JComboBox;

import app.di.annotations.Mail;
import app.gui.components.text.MailAccountComboBox;

import com.google.inject.AbstractModule;

public class ComboBoxesModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(JComboBox.class).annotatedWith(Mail.class).to(MailAccountComboBox.class);
	}

}
