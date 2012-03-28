package app.gui.components.menu;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Menu extends JMenu {

	private static final long serialVersionUID = -8569616675560607725L;

	private JMenuItem helpMenuItem;
	
	public Menu() {
		setText("Menu");
		setMnemonic(KeyEvent.VK_M);
		helpMenuItem = new HelpMenuItem();
		add(helpMenuItem);
	}
}
