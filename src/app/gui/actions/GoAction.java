package app.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import app.gui.events.EventBusService;
import app.gui.events.ListImagesEvent;

public class GoAction extends AbstractAction {

	private static final long serialVersionUID = 8171350959705350012L;

	public GoAction(String text, Integer mnemonic) {
		super(text, null);
		putValue(MNEMONIC_KEY, mnemonic);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		EventBusService.getEventBus().post(new ListImagesEvent());
	}

}
