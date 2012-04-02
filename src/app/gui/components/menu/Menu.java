package app.gui.components.menu;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import app.di.annotations.Help;

import com.google.inject.Inject;

public class Menu extends JMenu {

	private static final long serialVersionUID = -8569616675560607725L;

	@Inject
	public Menu(@Help JMenuItem helpMenuItem) {
		setText("Menu");
		setMnemonic(KeyEvent.VK_M);
		add(helpMenuItem);
	}
}
