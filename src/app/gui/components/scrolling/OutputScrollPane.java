package app.gui.components.scrolling;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import app.gui.components.text.OutputArea;

public class OutputScrollPane extends JScrollPane {

	private static final long serialVersionUID = -4558281585861025916L;

	private JTextArea outputArea;
	
	public OutputScrollPane() {
		outputArea = new OutputArea();
		setViewportView(outputArea);
	}
}
