package app.gui.components.scrolling;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.google.inject.Inject;

import app.di.annotations.App;

public class AppPanelScrollPane extends JScrollPane {

	private static final long serialVersionUID = 8083304210179631670L;
	
	@Inject
	public AppPanelScrollPane(@App JPanel appPanel) {
		setViewportView(appPanel);
	}

}
