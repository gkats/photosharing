package app.gui.components.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import com.google.inject.Inject;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1319814848479013700L;

	@Inject
	public MenuBar(JMenu menu) {
		this.add(menu);
	}
}
