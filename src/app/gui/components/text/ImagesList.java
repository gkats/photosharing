package app.gui.components.text;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;

public class ImagesList extends JList {

	private static final long serialVersionUID = 4967680782479874L;

	public ImagesList() {
		setModel(new DefaultComboBoxModel());
	}
}
