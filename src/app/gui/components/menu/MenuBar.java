package app.gui.components.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1319814848479013700L;

	private JMenu menu;
	
	public MenuBar() {
		menu = new Menu();
		this.add(menu);
	}
	
	public JMenu getMenu() {
		return this.menu;
	}
}
