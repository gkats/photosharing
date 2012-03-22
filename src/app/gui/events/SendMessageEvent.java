package app.gui.events;

import javax.mail.Message;

public class SendMessageEvent extends FillMessageEvent {

	public SendMessageEvent(Message message) {
		super(message);
	}
}
