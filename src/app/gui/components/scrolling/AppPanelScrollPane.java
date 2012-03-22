package app.gui.components.scrolling;

import javax.swing.JScrollPane;

import app.gui.components.panels.AppPanel;

public class AppPanelScrollPane extends JScrollPane {

	private static final long serialVersionUID = 8083304210179631670L;
	
	public AppPanelScrollPane() {
		setViewportView(new AppPanel());
	}

}
