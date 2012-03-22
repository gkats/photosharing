package app.gui.components.scrolling;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import app.gui.events.ClearFieldsEvent;
import app.gui.events.EventBusService;
import app.gui.events.FillMessageRecipientsEvent;
import app.gui.events.SendMessageEvent;
import app.log.Logger;
import app.log.Severity;

import com.google.common.eventbus.Subscribe;

public class RecipientsScrollPane extends JScrollPane {

	private static final long serialVersionUID = -1429643884129821662L;

	private JTextArea recipientsTextArea;
	
	public RecipientsScrollPane() {
		recipientsTextArea = new JTextArea();
		setViewportView(recipientsTextArea);
		EventBusService.getEventBus().register(this);
	}
	
	@Subscribe
	public void createMessage(FillMessageRecipientsEvent e) {
		Message msg = e.getMessage();
		try {
			msg.setRecipients(RecipientType.TO, 
					InternetAddress.parse(recipientsTextArea.getText()));
			EventBusService.getEventBus().post(new SendMessageEvent(msg));
		}
		catch (MessagingException me) {
			Logger.INSTANCE.log(Severity.ERROR, 
					"Could not add recipients to message.");
		}
	}
	
	@Subscribe
	public void clearFields(ClearFieldsEvent e) {
		recipientsTextArea.setText("");
	}
}
