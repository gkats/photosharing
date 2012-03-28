package app.gui.components.buttons;

import java.awt.event.KeyEvent;

import javax.swing.JButton;

import app.gui.actions.ResetAction;

public class ResetButton extends JButton {

	private static final long serialVersionUID = 8769683371320010973L;
	
	public ResetButton() {
		setText("Reset");
		setMnemonic(KeyEvent.VK_R);
		setAction(new ResetAction(getText(), getMnemonic()));
	}

}
