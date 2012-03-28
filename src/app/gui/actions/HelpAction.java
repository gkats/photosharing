package app.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import app.gui.events.EventBusService;
import app.gui.events.ShowHelpEvent;

public class HelpAction extends AbstractAction {

	private static final long serialVersionUID = -8330750240525791991L;

	public HelpAction() {
		super("Help");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		EventBusService.getEventBus().post(new ShowHelpEvent());
	}

}
