package app.gui.events;

public class CreateMessageEvent {

	private String text;
	
	public CreateMessageEvent(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
}
