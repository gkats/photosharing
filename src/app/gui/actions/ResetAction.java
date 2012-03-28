package app.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import app.gui.events.ClearFieldsEvent;
import app.gui.events.EventBusService;

public class ResetAction extends AbstractAction {

	private static final long serialVersionUID = -3806958738016869080L;

	public ResetAction(String text, Integer mnemonic) {
		super(text, null);
		putValue(MNEMONIC_KEY, mnemonic);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		EventBusService.getEventBus().post(new ClearFieldsEvent());
	}

}
