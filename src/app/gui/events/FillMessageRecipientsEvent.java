package app.gui.events;

import javax.mail.Message;

public class FillMessageRecipientsEvent extends FillMessageEvent {

	
	public FillMessageRecipientsEvent(Message message) {
		super(message);
	}
	
}
