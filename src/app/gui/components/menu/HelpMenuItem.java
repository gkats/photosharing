package app.gui.components.menu;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import app.di.annotations.Help;

import com.google.inject.Inject;

public class HelpMenuItem extends JMenuItem {

	private static final long serialVersionUID = 4730560456516151157L;

	@Inject
	public HelpMenuItem(@Help AbstractAction helpAction) {
		super(helpAction);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 
				InputEvent.CTRL_MASK));
	}
}
