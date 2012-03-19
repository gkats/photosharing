package app.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import app.gui.events.BrowseArchiveEvent;
import app.gui.events.EventBusService;

public class BrowseArchiveAction extends AbstractAction {

	private static final long serialVersionUID = -525367833144538755L;

	public BrowseArchiveAction() {
		super("Browse", null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		EventBusService.getEventBus().post(new BrowseArchiveEvent());
	}

}
