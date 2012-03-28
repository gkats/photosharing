package app.gui.components.menu;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import app.gui.actions.HelpAction;

public class HelpMenuItem extends JMenuItem {

	private static final long serialVersionUID = 4730560456516151157L;

	public HelpMenuItem() {
		super(new HelpAction());
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 
				InputEvent.CTRL_MASK));
	}
}
