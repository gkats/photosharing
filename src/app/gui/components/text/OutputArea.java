package app.gui.components.text;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

public class OutputArea extends JTextArea {

	private static final long serialVersionUID = 3072496221712058427L;

	public OutputArea() {
		setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
		setEditable(false);
		setLineWrap(true);
	}
}
