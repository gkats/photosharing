package app.gui.components.buttons;

import java.awt.event.KeyEvent;

import javax.swing.JButton;

import app.gui.actions.BrowseArchiveAction;

public class BrowseArchiveButton extends JButton {

	private static final long serialVersionUID = -3238782003214343436L;

	public BrowseArchiveButton() {
		setText("Browse");
		setMnemonic(KeyEvent.VK_B);
		setAction(new BrowseArchiveAction(getText(), getMnemonic()));
	}
}
