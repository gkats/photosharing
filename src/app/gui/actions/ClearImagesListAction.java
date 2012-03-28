package app.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import app.gui.events.ClearImagesListEvent;
import app.gui.events.EventBusService;

public class ClearImagesListAction extends AbstractAction {

	private static final long serialVersionUID = -106808788301984826L;

	public ClearImagesListAction(String text, Integer mnemonic) {
		super(text, null);
		putValue(MNEMONIC_KEY, mnemonic);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		EventBusService.getEventBus().post(new ClearImagesListEvent());
	}

}
