package app.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import app.gui.events.BrowseImagesEvent;
import app.gui.events.EventBusService;

public class BrowseImagesAction extends AbstractAction {

	private static final long serialVersionUID = 4650219830823343728L;

	public BrowseImagesAction() {
		super("Add", null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		EventBusService.getEventBus().post(new BrowseImagesEvent());
	}

}
