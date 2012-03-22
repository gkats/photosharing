package app.gui.events;

import javax.mail.Message;

public abstract class FillMessageEvent {

	private Message message;
	
	protected FillMessageEvent(Message message) {
		this.message = message;
	}
	
	public Message getMessage() {
		return message;
	}
}
