package app.gui.components.scrolling;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RecipientsScrollPane extends JScrollPane {

	private static final long serialVersionUID = -1429643884129821662L;

	private JTextArea recipientsTextArea;
	
	public RecipientsScrollPane() {
		recipientsTextArea = new JTextArea();
		setViewportView(recipientsTextArea);
	}
}
