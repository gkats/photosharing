package app.gui.components.buttons;

import javax.swing.JButton;

import app.gui.actions.ClearImagesListAction;

public class ClearImagesListButton extends JButton {

	private static final long serialVersionUID = 7015196831472094507L;

	public ClearImagesListButton() {
		setText("Clear");
		setAction(new ClearImagesListAction(getText(), getMnemonic()));
	}
}
