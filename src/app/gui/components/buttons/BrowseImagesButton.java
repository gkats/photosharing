package app.gui.components.buttons;

import java.awt.event.KeyEvent;

import javax.swing.JButton;

import app.gui.actions.BrowseImagesAction;

public class BrowseImagesButton extends JButton {

	private static final long serialVersionUID = 7385981425944754285L;

	public BrowseImagesButton() {
		setMnemonic(KeyEvent.VK_A);
		setText("Add");
		setAction(new BrowseImagesAction(getText(), getMnemonic()));
	}
}
