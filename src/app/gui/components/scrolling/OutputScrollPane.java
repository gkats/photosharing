package app.gui.components.scrolling;

import java.io.PrintStream;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import app.di.annotations.Output;
import app.gui.components.text.TextAreaOutputStream;

import com.google.inject.Inject;

public class OutputScrollPane extends JScrollPane {

	private static final long serialVersionUID = -4558281585861025916L;

	private JTextArea outputArea;
	
	@Inject
	public OutputScrollPane(@Output JTextArea outputArea) {
		this.outputArea = outputArea; 
		setViewportView(outputArea);
		
		redirectSysOut();
	}

	private void redirectSysOut() {
		PrintStream con = new PrintStream(new TextAreaOutputStream(outputArea));
		System.setOut(con);
	}
}
