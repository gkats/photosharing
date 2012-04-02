package app.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import app.gui.events.BrowseImagesEvent;
import app.gui.events.EventBusService;

import com.google.inject.Inject;

public class BrowseImagesAction extends AbstractAction {

	private static final long serialVersionUID = 4650219830823343728L;

	@Inject
	public BrowseImagesAction(String text, Integer mnemonic) {
		super(text, null);
		putValue(MNEMONIC_KEY, mnemonic);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		EventBusService.getEventBus().post(new BrowseImagesEvent());
	}

}
