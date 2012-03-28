package app.gui.components.text;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class MailAccountComboBox extends JComboBox {

	private static final long serialVersionUID = -7693536641105599062L;

	private final static String[] MAIL_PROVIDERS 
		= new String[] { "Gmail", "Hotmail" };
	
	public MailAccountComboBox() {
		setModel(new DefaultComboBoxModel(MAIL_PROVIDERS));
	}
}
