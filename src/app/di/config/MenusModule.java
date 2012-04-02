package app.di.config;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import app.di.annotations.Help;
import app.gui.components.menu.HelpMenuItem;
import app.gui.components.menu.Menu;
import app.gui.components.menu.MenuBar;

import com.google.inject.AbstractModule;

public class MenusModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(JMenuBar.class).to(MenuBar.class);
		bind(JMenu.class).to(Menu.class);
		bind(JMenuItem.class).annotatedWith(Help.class).to(HelpMenuItem.class);
	}

}
